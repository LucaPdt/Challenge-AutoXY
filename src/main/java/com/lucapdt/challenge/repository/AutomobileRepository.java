package com.lucapdt.challenge.repository;

import com.lucapdt.challenge.entity.Automobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomobileRepository extends JpaRepository<Automobile, Integer> {

}
