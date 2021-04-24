package com.example.test.service;

import com.example.test.entity.KPAC;
import com.example.test.entity.SetEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface SetEntityService {
    List<SetEntity> findAll();
    Optional<SetEntity> findById(int theId);
    void save(SetEntity setEntity);
    void delete(int theId);
    Page<SetEntity> listAll(int pageNum, String sortField, String sortDir);
}
