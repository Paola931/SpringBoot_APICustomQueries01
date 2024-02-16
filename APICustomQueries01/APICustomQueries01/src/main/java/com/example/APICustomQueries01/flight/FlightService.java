package com.example.APICustomQueries01.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FlightService {
    @Autowired
    private FlightRepository repository;

    private String generateRandomString() {
        Random random = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            char randomChar = alphabet.charAt(random.nextInt(alphabet.length()));
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }
    public void generateRandomFlights() {
        List<Flight> flightList = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= 50; i++) {
            Flight randomFlight = new Flight();
            randomFlight.setDescription("Flight " + i);
            randomFlight.setFromAirport(generateRandomString());
            randomFlight.setToAirport(generateRandomString());
            randomFlight.setStatus(Status.ONTIME);
            flightList.add(randomFlight);
        }
        repository.saveAll(flightList);
    }
    public List<Flight> findAllFlights(){
      return repository.findAll();
    }
}
