package com.example.test.service;

import com.example.test.dao.KPACDao;
import com.example.test.dao.SetEntityDao;
import com.example.test.entity.KPAC;
import com.example.test.entity.SetEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
        public Page<KPAC> listAll(int pageNum,String sortField, String sortDir) {
        int pageSize = 10;

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending());

        return dao.findAll(pageable);
    }
}
