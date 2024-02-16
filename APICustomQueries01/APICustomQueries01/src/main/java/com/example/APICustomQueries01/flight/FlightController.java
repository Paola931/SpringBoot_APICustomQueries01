package com.example.APICustomQueries01.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @PostMapping("/provision")
    public void flightsProvision() {
        flightService.generateRandomFlights();
    }

    @GetMapping("/getAll")
    public List<Flight> getAllFlights(){
        return flightService.findAllFlights();
    }
}
