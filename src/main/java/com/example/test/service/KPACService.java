package com.example.test.service;

import com.example.test.entity.KPAC;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface KPACService {

    List<KPAC> findAll();
    Optional<KPAC> findById(int theId);
    void save(KPAC kpac);
    void delete(int theId);
    Page<KPAC> listAll(int pageNum, String sortField, String sortDir);
}
