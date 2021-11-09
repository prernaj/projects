package com.example.cab_booking_ua.controllers;

import java.util.List;

import com.example.cab_booking_ua.database.RiderManager;
import com.example.cab_booking_ua.database.TripManager;
import com.example.cab_booking_ua.model.Location;
import com.example.cab_booking_ua.model.Rider;
import com.example.cab_booking_ua.model.Trip;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 */
@RestController
public class RiderController {
    private RiderManager riderManager;
    private TripManager tripManager;

    public RiderController(RiderManager riderManager, TripManager tripManager) {
        this.riderManager = riderManager;
        this.tripManager = tripManager;
    }

    /**
     * Register a rider
     */
    @RequestMapping(value="/regster/rider", method=RequestMethod.POST)
    public ResponseEntity registerRider(final String riderId, final String riderName) {
        riderManager.createRider(new Rider(riderId, riderName));
        return ResponseEntity.ok("");
    }

    /**
     * Book a cab
     */
    @RequestMapping(value="/book", method=RequestMethod.POST)
    public ResponseEntity book(final String riderId, final Double sourceX, final Double sourceY, final Double destX, final Double destY) {
        tripManager.createTrip(riderManager.getRider(riderId), new Location(sourceX, sourceY), new Location(destX, destY));
        return ResponseEntity.ok("");
    }


    /**
     * Fetch booking history of a rider
     */
    @RequestMapping(value="/book", method=RequestMethod.GET)
    public ResponseEntity fetchHistory(final String riderId) {
        List<Trip> trips = tripManager.tripHistory(riderManager.getRider(riderId));
        return ResponseEntity.ok(trips);
    }
}
