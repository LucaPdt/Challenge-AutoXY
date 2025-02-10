package com.lucapdt.challenge.service;

import com.lucapdt.challenge.entity.Automobile;
import com.lucapdt.challenge.exception.AutomobileNotFoundException;
import com.lucapdt.challenge.repository.AutomobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class AutomobileServiceImpl implements AutomobileService{

    @Autowired
    private AutomobileRepository automobileRepository;

    @Override
    public Page<Automobile> findAll(int page, int size) {
        return automobileRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Automobile findById(int id) {
        Optional<Automobile> optionalAutomobile = automobileRepository.findById(id);
        if(optionalAutomobile.isEmpty())
            throw new AutomobileNotFoundException("Non e' stata trovata una automobile per l'id inserito");
        else return optionalAutomobile.get();
    }

    @Override
    public Automobile save(Automobile auto) {
        return automobileRepository.save(auto);
    }

    @Override
    public Automobile update(int id, Automobile auto) {
        if(!automobileRepository.existsById(id))
            throw new AutomobileNotFoundException("Non e' stata trovata una automobile per l'id inserito");

        return automobileRepository.save(auto);
    }
}
