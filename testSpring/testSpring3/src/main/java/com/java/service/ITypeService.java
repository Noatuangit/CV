package com.java.service;

import java.util.List;

public interface ITypeService<E> {
    List<E> findAll(String status);

    E save(E e);

    E findById(String id);
}
