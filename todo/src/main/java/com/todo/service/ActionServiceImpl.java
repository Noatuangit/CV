package com.todo.service;

import com.todo.repository.IActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionServiceImpl implements IActionService {
    @Autowired
    IActionRepository repository;
}
