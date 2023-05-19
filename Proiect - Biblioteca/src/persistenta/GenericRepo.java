package persistenta;

import java.util.List;
import java.util.Set;
import java.util.Optional;

public interface GenericRepo<T> {
    List<T> findAll();

    Set<T> findAllSet();

    Optional<T> findById(int id);

    T save(T entity);

    void update(int idx, T entity);

    void delete(int idx);
}
