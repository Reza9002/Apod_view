package com.example.helloSpring.service;

import com.example.helloSpring.dao.ApodDAO;
import com.example.helloSpring.model.Apod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApodService {

    @Autowired
   private ApodDAO apodDAO ;


   public Apod save(Apod apod){
        return apodDAO.save(apod);
    }









}
