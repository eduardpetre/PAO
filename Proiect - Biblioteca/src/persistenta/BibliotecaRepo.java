package persistenta;

import entitati.Adresa;
import entitati.Carte;
import entitati.Biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static persistenta.util.DatabaseConnection.getDatabaseConnection;

public class BibliotecaRepo implements GenericRepo<Biblioteca> {
    private final Map<Integer, Biblioteca> storage = new HashMap<>();
    private static final String EXTRACT_LIBRARY_SQL = "SELECT id, nume, adresa, carti FROM biblioteca";
    private static final String INSERT_LIBRARY_SQL = "INSERT INTO biblioteca (id, nume, adresa, carti) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_LIBRARY_SQL = "UPDATE biblioteca SET id = ?, nume = ?, adresa = ?, carti = ? WHERE id = ?";
    private static final String DELETE_LIBRARY_SQL = "DELETE FROM biblioteca WHERE id = ?";

    private final Connection connection;

    private static volatile BibliotecaRepo init;

    private BibliotecaRepo() {
        this.connection = getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EXTRACT_LIBRARY_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nume = resultSet.getString("nume");
                String inputAdresa = resultSet.getString("adresa");

                // Define the regular expression pattern to match values
                Pattern pattern = Pattern.compile("'([^']+)'|(\\d+)");

                // Create a Matcher object and apply the pattern to the input string
                Matcher matcher = pattern.matcher(inputAdresa);

                // Iterate over the matches and print the values
                List<String> paramAdresa = new ArrayList<>();
                while (matcher.find()) {
                    if (matcher.group(1) != null) {
                        paramAdresa.add(matcher.group(1));
                    } else {
                        paramAdresa.add(matcher.group(2));
                    }
                }

                Adresa adresa = new Adresa(Integer.parseInt(paramAdresa.get(0)), paramAdresa.get(1), paramAdresa.get(2), paramAdresa.get(3), paramAdresa.get(4));

                String inputCarti = resultSet.getString("carti");
                List<String> paramCarte = new ArrayList<>();
                List<Carte> carti = new ArrayList<>();
                Carte carte = new Carte();

                int step = 0;
                matcher.reset();
                matcher = pattern.matcher(inputCarti);
                while (matcher.find()) {
                    if (matcher.group(1) != null) {
                        paramCarte.add(matcher.group(1));
//                        System.out.println(matcher.group(1));
                    } else {
                        paramCarte.add(matcher.group(2));
//                        System.out.println(matcher.group(2));
                    }

                    step += 1;
                    if (step == 4) {
                        carte = new Carte(Integer.parseInt(paramCarte.get(0)), paramCarte.get(1), paramCarte.get(2), paramCarte.get(3));
                        carti.add(carte);
                        step = 0;
                        paramCarte.clear();
                    }
                }

                storage.put(id, new Biblioteca(id, nume, adresa, carti));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static BibliotecaRepo getInit() {
        if (init == null) {
            synchronized (BibliotecaRepo.class) {
                if (init == null) {
                    init = new BibliotecaRepo();
                }
            }
        }
        return init;
    }

    @Override
    public Biblioteca save(Biblioteca entity) {
        storage.put(entity.getId(), entity);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LIBRARY_SQL);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getNume());
            preparedStatement.setString(3, entity.getAdresa().toString());
            preparedStatement.setString(4, entity.getCarti().toString());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return entity;
    }

    @Override
    public List<Biblioteca> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Set<Biblioteca> findAllSet() {
        return new HashSet<>(storage.values());
    }

    @Override
    public Optional<Biblioteca> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public void update(int idx, Biblioteca entity) {
        storage.put(idx, entity);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LIBRARY_SQL);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getNume());
            preparedStatement.setString(3, entity.getAdresa().toString());
            preparedStatement.setString(4, entity.getCarti().toString());
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
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LIBRARY_SQL);
            preparedStatement.setInt(1, idx);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
