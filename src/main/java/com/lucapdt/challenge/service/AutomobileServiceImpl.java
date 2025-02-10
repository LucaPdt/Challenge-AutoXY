package com.lucapdt.challenge.service;

import com.lucapdt.challenge.entity.Automobile;
import com.lucapdt.challenge.repository.AutomobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class AutomobileServiceImpl implements AutomobileService{

    @Autowired
    private AutomobileRepository automobileRepository;

    @Override
    public Page<Automobile> findAll(int page, int size) {
        return automobileRepository.findAll(PageRequest.of(page, size));
    }
}
