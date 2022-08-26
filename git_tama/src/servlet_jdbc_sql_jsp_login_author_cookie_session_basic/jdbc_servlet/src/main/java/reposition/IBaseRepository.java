package reposition;

import java.sql.SQLException;
import java.util.List;

public interface IBaseRepository<E> {
    void save(E e) throws SQLException;

    void update(E e,int id) throws SQLException;

    void removeById(int id);

    List<E> findByName(String name);

    E findById(int id);

    public int countAmountFindAll();

    List<E> getList(int offset,String query);

    List<E> getList();
}
