package reposition;

import models.type.TypeCustomer;

import java.util.List;

public interface ITypeRepository<E> {
    List<E> getList();
}
