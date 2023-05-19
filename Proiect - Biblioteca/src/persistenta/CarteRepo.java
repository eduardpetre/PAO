package persistenta;

import entitati.Carte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static persistenta.util.DatabaseConnection.getDatabaseConnection;

public class CarteRepo implements GenericRepo<Carte> {
    private final Map<Integer, Carte> storage = new HashMap<>();
    private static final String EXTRACT_BOOK_SQL = "SELECT id, titlu, autor, editura FROM carte";
    private static final String INSERT_BOOK_SQL = "INSERT INTO carte (id, titlu, autor, editura) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_BOOK_SQL = "UPDATE carte SET id = ?, titlu = ?, autor = ?, editura = ? WHERE id = ?";
    private static final String DELETE_BOOK_SQL = "DELETE FROM carte WHERE id = ?";

    private final Connection connection;

    private static volatile CarteRepo init;

    private CarteRepo() {
        this.connection = getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EXTRACT_BOOK_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titlu = resultSet.getString("titlu");
                String autor = resultSet.getString("autor");
                String editura = resultSet.getString("editura");
                storage.put(id, new Carte(id, titlu, autor, editura));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static CarteRepo getInit() {
        if (init == null) {
            synchronized (CarteRepo.class) {
                if (init == null) {
                    init = new CarteRepo();
                }
            }
        }
        return init;
    }

    @Override
    public Carte save(Carte entity) {
        storage.put(entity.getId(), entity);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_SQL);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getTitlu());
            preparedStatement.setString(3, entity.getAutor());
            preparedStatement.setString(4, entity.getEditura());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return entity;
    }

    @Override
    public List<Carte> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Set<Carte> findAllSet() {
        return new HashSet<>(storage.values());
    }

    @Override
    public Optional<Carte> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public void update(int idx, Carte entity) {
        storage.put(idx, entity);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK_SQL);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getTitlu());
            preparedStatement.setString(3, entity.getAutor());
            preparedStatement.setString(4, entity.getEditura());
            preparedStatement.setInt(5, idx);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int idx) {
        storage.remove(idx);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK_SQL);
            preparedStatement.setInt(1, idx);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
