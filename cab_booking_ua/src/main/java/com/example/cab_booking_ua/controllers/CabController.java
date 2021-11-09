package com.example.cab_booking_ua.controllers;

import com.example.cab_booking_ua.database.CabManager;
import com.example.cab_booking_ua.database.TripManager;
import com.example.cab_booking_ua.model.Cab;
import com.example.cab_booking_ua.model.Location;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Responsible for handling request for a cab
 */
@RestController
public class CabController {
    private CabManager cabManager;
    private TripManager tripManager;

    public CabController(CabManager cabManager, TripManager tripManager) {
        this.cabManager = cabManager;
        this.tripManager = tripManager; 
    }

    /**
     * Register a cab
     */
    @RequestMapping(value="/register/cab", method=RequestMethod.POST)
    public ResponseEntity registerCab(final String cabId, final String driverName) {
        cabManager.createCab(new Cab(cabId, driverName));
        return ResponseEntity.ok("");
    }

    /**
     * Update cab location
     */
    @RequestMapping(value="/update/cab/location", method=RequestMethod.POST)
    public ResponseEntity updateCabLocation(final String cabId, final Double newX, final Double newY) {
        cabManager.updateCabLocation(cabId, new Location(newX, newY));
        return ResponseEntity.ok("");
    }

    /**
     * Driver wants to switch on/off the device
     */
    @RequestMapping(value="/update/cab/availability", method=RequestMethod.POST)
    public ResponseEntity updateCabAvailability(@RequestParam String cabId, final Boolean newAvailability) {
        cabManager.updateCabAvailability(cabId, newAvailability);
        return ResponseEntity.ok("");
    }

    /**
     * Driver wants to end the trip
     */
    @RequestMapping(value="/update/cab/end/trip", method=RequestMethod.POST)
    public ResponseEntity endTrip(final String cabId) {
        tripManager.endTrip(cabManager.getCab(cabId));
        return ResponseEntity.ok("");
    }
    
}
