package persistenta;

import entitati.Cititor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static persistenta.util.DatabaseConnection.getDatabaseConnection;

public class CititorRepo implements GenericRepo<Cititor> {
    private final Map<Integer, Cititor> storage = new HashMap<>();

    private static final String EXTRACT_READER_SQL = "SELECT id, nume, email, telefon, elev FROM cititor";
    private static final String INSERT_READER_SQL = "INSERT INTO cititor (id, nume, email, telefon, elev) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_READER_SQL = "UPDATE cititor SET id = ?, nume = ?, email = ?, telefon = ?, elev = ? WHERE id = ?";
    private static final String DELETE_READER_SQL = "DELETE FROM cititor WHERE id = ?";
    private final Connection connection;

    private static volatile CititorRepo init;

    private CititorRepo() {
        this.connection = getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EXTRACT_READER_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nume = resultSet.getString("nume");
                String email = resultSet.getString("email");
                String telefon = resultSet.getString("telefon");
                boolean elev = resultSet.getBoolean("elev");
                storage.put(id, new Cititor(id, nume, email, telefon, elev));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static CititorRepo getInit() {
        if (init == null) {
            synchronized (CititorRepo.class) {
                if (init == null) {
                    init = new CititorRepo();
                }
            }
        }
        return init;
    }

    @Override
    public Cititor save(Cititor entity) {
        storage.put(entity.getId(), entity);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_READER_SQL);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getNume());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setString(4, entity.getTelefon());
            preparedStatement.setBoolean(5, entity.isElev());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return entity;
    }

    @Override
    public List<Cititor> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Set<Cititor> findAllSet() {
        return new HashSet<>(storage.values());
    }

    @Override
    public Optional<Cititor> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public void update(int idx, Cititor entity) {
        storage.put(idx, entity);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_READER_SQL);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getNume());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setString(4, entity.getTelefon());
            preparedStatement.setBoolean(5, entity.isElev());
            preparedStatement.setInt(6, idx);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int idx) {
        storage.remove(idx);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_READER_SQL);
            preparedStatement.setInt(1, idx);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
