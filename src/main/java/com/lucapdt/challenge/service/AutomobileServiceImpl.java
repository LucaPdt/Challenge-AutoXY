package com.lucapdt.challenge.service;

import com.lucapdt.challenge.entity.Automobile;
import org.springframework.data.domain.Page;

import java.util.List;

public class AutomobileServiceImpl implements AutomobileService{

    @Override
    public Page<Automobile> findAll(int page, int size) {
        return null;
    }
}
