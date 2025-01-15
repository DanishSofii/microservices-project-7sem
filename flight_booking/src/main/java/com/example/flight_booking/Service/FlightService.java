package com.example.flight_booking.Service;

import com.example.flight_booking.Model.Flight;
import com.example.flight_booking.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight flightDetails) {
        Flight flight = flightRepository.findById(id).orElseThrow();
        flight.setFlightNumber(flightDetails.getFlightNumber());
        flight.setOrigin(flightDetails.getOrigin());
        flight.setDestination(flightDetails.getDestination());
        flight.setCapacity(flightDetails.getCapacity());
        return flightRepository.save(flight);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
}
