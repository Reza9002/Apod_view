package com.example.helloSpring.dao;

import com.example.helloSpring.model.Apod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApodDAO extends JpaRepository<Apod, Integer> {



}
