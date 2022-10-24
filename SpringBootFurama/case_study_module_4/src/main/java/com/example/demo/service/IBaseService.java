package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IBaseService<E> {
    Page<E> findAllByName(String keyword, Pageable pageable);

    Optional<E> findById(Integer id);

    void save(E e);

    void updateById(Integer id_delete);

    void updateMoneyById( Integer id);

}
