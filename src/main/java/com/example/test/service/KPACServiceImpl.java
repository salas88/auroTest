package com.example.test.service;

import com.example.test.dao.KPACDao;
import com.example.test.dao.SetEntityDao;
import com.example.test.entity.KPAC;
import com.example.test.entity.SetEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class KPACServiceImpl implements KPACService{

    @Autowired
    private KPACDao dao;

    @Override
    public List<KPAC> findAll() {
        return dao.findAll();
    }

    @Override
    public Optional<KPAC> findById(int theId) {
        return dao.findById(theId);
    }

    @Override
    public void save(KPAC kpac) {
        dao.save(kpac);
    }

    @Override
    public void delete(int theId) {
        dao.deleteById(theId);
    }
}
