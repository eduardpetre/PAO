package persistenta;

import entitati.Angajat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static persistenta.util.DatabaseConnection.getDatabaseConnection;

public class AngajatRepo implements GenericRepo<Angajat> {
    private final Map<Integer, Angajat> storage = new HashMap<>();
    private static final String EXTRACT_EMPLOYEE_SQL = "SELECT id, nume, email, telefon, dataAngajarii, pozitie FROM angajat";
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO angajat (id, nume, email, telefon, dataAngajarii, pozitie) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_EMPLOYEE_SQL = "UPDATE angajat SET id = ?, nume = ?, email = ?, telefon = ?, dataAngajarii = ?, pozitie = ? WHERE id = ?";
    private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM angajat WHERE id = ?";
    private final Connection connection;

    private static volatile AngajatRepo init;

    private AngajatRepo() {
        this.connection = getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EXTRACT_EMPLOYEE_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nume = resultSet.getString("nume");
                String email = resultSet.getString("email");
                String telefon = resultSet.getString("telefon");
                String dataAngajarii = resultSet.getString("dataAngajarii");
                String pozitie = resultSet.getString("pozitie");
                storage.put(id, new Angajat(id, nume, email, telefon, dataAngajarii, pozitie));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static AngajatRepo getInit() {
        if (init == null) {
            synchronized (AngajatRepo.class) {
                if (init == null) {
                    init = new AngajatRepo();
                }
            }
        }
        return init;
    }

    @Override
    public Angajat save(Angajat entity) {
        storage.put(entity.getId(), entity);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getNume());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setString(4, entity.getTelefon());
            preparedStatement.setString(5, entity.getDataAngajarii());
            preparedStatement.setString(6, entity.getPozitie());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return entity;
    }

    @Override
    public List<Angajat> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Set<Angajat> findAllSet() {
        return new HashSet<>(storage.values());
    }

    @Override
    public Optional<Angajat> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public void update(int idx, Angajat entity) {
        storage.put(idx, entity);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getNume());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setString(4, entity.getTelefon());
            preparedStatement.setString(5, entity.getDataAngajarii());
            preparedStatement.setString(6, entity.getPozitie());
            preparedStatement.setInt(7, idx);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int idx) {
        storage.remove(idx);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);
            preparedStatement.setInt(1, idx);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
