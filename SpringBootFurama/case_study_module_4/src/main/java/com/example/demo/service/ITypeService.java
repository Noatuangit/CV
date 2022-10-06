package com.example.demo.service;

import java.util.List;

public interface ITypeService<E> {
    List<E> findAll();
}
