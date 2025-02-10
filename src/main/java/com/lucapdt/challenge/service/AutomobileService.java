package com.lucapdt.challenge.service;

import com.lucapdt.challenge.entity.Automobile;
import org.springframework.data.domain.Page;

public interface AutomobileService {

    Page<Automobile> findAll(int page, int size);

    Automobile findById(int id);

    Automobile save(Automobile auto);

    Automobile update(int id, Automobile auto);
}
