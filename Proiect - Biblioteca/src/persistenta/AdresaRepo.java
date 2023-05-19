package persistenta;

import entitati.Adresa;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;

import static persistenta.util.DatabaseConnection.getDatabaseConnection;

public class AdresaRepo implements GenericRepo<Adresa> {
    private final Map<Integer, Adresa> storage = new HashMap<>();
    private static final String EXTRACT_ADDRESS_SQL = "SELECT id, tara, oras, strada, numar FROM adresa";
    private static final String INSERT_ADRESS_SQL = "INSERT INTO adresa (id, tara, oras, strada, numar) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_ADDRESS_SQL = "UPDATE adresa SET id = ?, tara = ?, oras = ?, strada = ?, numar = ? WHERE id = ?";
    private static final String DELETE_ADDRESS_SQL = "DELETE FROM adresa WHERE id = ?";

    private final Connection connection;

    private static volatile AdresaRepo init;

    private AdresaRepo() {
        this.connection = getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EXTRACT_ADDRESS_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tara = resultSet.getString("tara");
                String oras = resultSet.getString("oras");
                String strada = resultSet.getString("strada");
                String nr = resultSet.getString("numar");
                storage.put(id, new Adresa(id, tara, oras, strada, nr));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static AdresaRepo getInit() {
        if (init == null) {
            synchronized (AdresaRepo.class) {
                if (init == null) {
                    init = new AdresaRepo();
                }
            }
        }
        return init;
    }

    @Override
    public Adresa save(Adresa entity) {
        storage.put(entity.getId(), entity);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADRESS_SQL);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getTara());
            preparedStatement.setString(3, entity.getOras());
            preparedStatement.setString(4, entity.getStrada());
            preparedStatement.setString(5, entity.getNr());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return entity;
    }

    @Override
    public List<Adresa> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Set<Adresa> findAllSet() {
        return new HashSet<>(storage.values());
    }

    @Override
    public Optional<Adresa> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public void update(int idx, Adresa entity) {
        storage.put(idx, entity);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ADDRESS_SQL);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getTara());
            preparedStatement.setString(3, entity.getOras());
            preparedStatement.setString(4, entity.getStrada());
            preparedStatement.setString(5, entity.getNr());
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
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ADDRESS_SQL);
            preparedStatement.setInt(1, idx);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
