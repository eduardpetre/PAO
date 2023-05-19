package persistenta;

import entitati.Carte;
import entitati.Cititor;
import entitati.Imprumut;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static persistenta.util.DatabaseConnection.getDatabaseConnection;

public class ImprumutRepo implements GenericRepo<Imprumut> {
    private final Map<Integer, Imprumut> storage = new HashMap<>();
    private static final String EXTRACT_BORROW_SQL = "SELECT id, carte, cititor FROM imprumut";
    private static final String INSERT_BORROW_SQL = "INSERT INTO imprumut (id, carte, cititor) VALUES (?, ?, ?)";
    private static final String UPDATE_BORROW_SQL = "UPDATE imprumut SET id = ?, carte = ?, cititor = ? WHERE id = ?";
    private static final String DELETE_BORROW_SQL = "DELETE FROM imprumut WHERE id = ?";

    private final Connection connection;

    private static volatile ImprumutRepo init;

    private ImprumutRepo() {
        this.connection = getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EXTRACT_BORROW_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nume = resultSet.getString("nume");
                String inputCarte = resultSet.getString("carte");

                Pattern pattern = Pattern.compile("'([^']+)'|(\\d+)");
                Matcher matcher = pattern.matcher(inputCarte);
                List<String> paramCarte = new ArrayList<>();
                while (matcher.find()) {
                    if (matcher.group(1) != null) {
                        paramCarte.add(matcher.group(1));
                    } else {
                        paramCarte.add(matcher.group(2));
                    }
                }
                Carte carte = new Carte(Integer.parseInt(paramCarte.get(0)), paramCarte.get(1), paramCarte.get(2), paramCarte.get(3));

                String inputCititor = resultSet.getString("cititor");
                List<String> paramCititor = new ArrayList<>();

                matcher.reset();
                matcher = pattern.matcher(inputCititor);
                while (matcher.find()) {
                    if (matcher.group(1) != null) {
                        paramCititor.add(matcher.group(1));
                    } else {
                        paramCititor.add(matcher.group(2));
                    }
                }
                Cititor cititor = new Cititor(Integer.parseInt(paramCititor.get(0)), paramCititor.get(1), paramCititor.get(2), paramCititor.get(3), Boolean.parseBoolean(paramCititor.get(4)));
                storage.put(id, new Imprumut(carte, cititor));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ImprumutRepo getInit() {
        if (init == null) {
            synchronized (ImprumutRepo.class) {
                if (init == null) {
                    init = new ImprumutRepo();
                }
            }
        }
        return init;
    }

    @Override
    public Imprumut save(Imprumut entity) {
        storage.put(entity.getId(), entity);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BORROW_SQL);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getCarte().toString());
            preparedStatement.setString(3, entity.getCititor().toString());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return entity;
    }

    @Override
    public List<Imprumut> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Set<Imprumut> findAllSet() {
        return new HashSet<>(storage.values());
    }

    @Override
    public Optional<Imprumut> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public void update(int idx, Imprumut entity) {
        storage.put(idx, entity);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BORROW_SQL);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getCarte().toString());
            preparedStatement.setString(3, entity.getCititor().toString());
            preparedStatement.setInt(4, idx);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int idx) {
        storage.remove(idx);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BORROW_SQL);
            preparedStatement.setInt(1, idx);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
