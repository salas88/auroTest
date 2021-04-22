package com.example.test.service;

import com.example.test.entity.KPAC;
import com.example.test.entity.SetEntity;

import java.util.List;
import java.util.Optional;

public interface SetEntityService {
    List<SetEntity> findAll();
    Optional<SetEntity> findById(int theId);
    void save(SetEntity setEntity);
    void delete(int theId);
}
