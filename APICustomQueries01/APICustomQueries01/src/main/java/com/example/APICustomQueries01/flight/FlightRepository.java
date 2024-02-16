package com.example.APICustomQueries01.flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@EnableJpaRepositories
@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
    @Query(value = "SELECT * FROM Flight", nativeQuery = true)
    List<Flight> findAllFlights();
}
