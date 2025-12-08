package com.example.helloSpring.view;

import com.example.helloSpring.model.Apod;
import com.example.helloSpring.restclient.RestClient;
import com.example.helloSpring.service.ApodService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;


@Route("/")            //http:localhost:8080
public class MainView extends VerticalLayout {

    @Autowired
    private  ApodService service;
    private Apod currentApod;

    public MainView(ApodService service){
      this.service = service;
      H1 title = new H1("Astronomie Picture of the Day");


        DatePicker datePicker = new DatePicker("Wählen Sie ein Datum: ");
        currentApod = RestClient.createApod(LocalDate.now());   // verhindert eine NullPointerException


        Image image = new Image(currentApod.getUrl() , "Bildbeschreibung");
        image.setWidth("50%");

        TextArea description = new TextArea("Beschreibung");
        description.setWidth("300px");

        HorizontalLayout hz = new HorizontalLayout(image , description);
        hz.setDefaultVerticalComponentAlignment(Alignment.CENTER);


        datePicker.addValueChangeListener(

                e->{
                    currentApod = RestClient.createApod(datePicker.getValue());
                    image.setSrc(currentApod.getUrl());
                    description.setValue(currentApod.getExplanation());
                }
        );


      Button saveButton = new Button("Save");
     saveButton.addClickListener(
              e->{
                  Apod savedApod = service.save(currentApod);
                  if (savedApod != null ){
                      Notification.show("Objekt gespeichert!");

                  }

              });



        add(title, datePicker, hz ,saveButton);
        
    }








}
