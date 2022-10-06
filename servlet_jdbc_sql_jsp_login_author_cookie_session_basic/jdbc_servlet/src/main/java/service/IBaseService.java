package service;

import models.person.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IBaseService<E>{
    Map<String, String> save(E e) throws SQLException;

    Map<String, String> update(E e, int id) throws SQLException;

    void removeById(int id);

    List<E> findByName(String name);

    E findById(int id);

    int countAmountFindAll();

    List<E> getList(int offset);

    List<E> getList();

    List<E> getListHaveContract(int offset);
}
