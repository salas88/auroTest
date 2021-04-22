package com.example.test.dao;

import com.example.test.entity.SetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SetEntityDao extends JpaRepository<SetEntity,Integer> {
}
