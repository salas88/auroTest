package com.example.test.dao;

import com.example.test.entity.KPAC;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KPACDao extends JpaRepository<KPAC, Integer> {
}
