package com.codegym.service.expenditures;

import com.codegym.model.Expenditures;
import com.codegym.repository.expenditures.IExRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExService implements IExService{
    @Autowired
    private IExRepository exRepository;

    @Override
    public List<Expenditures> findAll() {
        return exRepository.findAll();
    }

    @Override
    public Expenditures findById(Long id) {
        return exRepository.findById(id);
    }

    @Override
    public void save(Expenditures expenditures) {
            exRepository.save(expenditures);
    }

    @Override
    public void remove(Long id) {
            exRepository.remove(id);
    }
}
