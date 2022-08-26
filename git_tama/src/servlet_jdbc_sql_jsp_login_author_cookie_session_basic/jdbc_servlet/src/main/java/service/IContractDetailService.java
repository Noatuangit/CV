package service;

import java.util.List;

public interface IContractDetailService<E> {
    List<E> getList();

    void insertDetail(E e);

    List<E> searchListContractDetailById(int id);

}
