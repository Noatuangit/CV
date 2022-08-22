package service;

import java.sql.SQLException;
import java.util.List;

public interface DTOType <E>{
    void insertDTO(E e) throws SQLException;

    List<E> getList(String table);

}
