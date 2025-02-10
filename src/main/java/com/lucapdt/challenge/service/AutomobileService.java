package com.lucapdt.challenge.service;

import com.lucapdt.challenge.entity.Automobile;
import org.springframework.data.domain.Page;

public interface AutomobileService {

    Page<Automobile> findAll(int page, int size);
}
