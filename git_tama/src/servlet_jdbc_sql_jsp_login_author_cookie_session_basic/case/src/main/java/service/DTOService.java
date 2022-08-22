package service;

import java.sql.SQLException;
import java.util.List;

public interface DTOService<E> {
    void insertDTO(E e) throws SQLException;

    void updateDTO(E e) throws SQLException;

    void deleteDTO(int id);

    List<E> searchDTOByName(String name);

    E searchDTO (int id);

    List<E> getList(String query, int page);

}
