package com.srchicharron.dancingqueen.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Utils {
    public String fecha(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public String jsonFormatter(Object object){
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return jsonString;
    }

    public String ageCalculator(String birth){
        String edad="";
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(birth, formatter);
        // Get the birth date as LocalDate
        LocalDate birthDate = dateTime.toLocalDate();

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Calculate the age
        Period age = Period.between(birthDate, currentDate);

        // Extract and print the age in years
        edad=age.getYears()+"."+age.getMonths();
        return edad;
    }
}
