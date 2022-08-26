package service;

import models.type.TypeCustomer;

import java.util.List;

public interface ITypeService<E> {
    List<E> getList();
}
