package reposition;

import models.professional.ContractDetail;

import java.util.List;

public interface IContractDetailsRepository<E> {
    List<E> getList();

    void insertDetail(E e);

    List<E> searchListContractDetailById(int id);
}
