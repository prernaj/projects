package com.example.cab_booking_ua.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.cab_booking_ua.exceptions.NoCabsAvailableException;
import com.example.cab_booking_ua.exceptions.TripNotFoundException;
import com.example.cab_booking_ua.model.Cab;
import com.example.cab_booking_ua.model.Location;
import com.example.cab_booking_ua.model.Rider;
import com.example.cab_booking_ua.model.Trip;
import com.example.cab_booking_ua.strategies.CabMatchingStrategy;
import com.example.cab_booking_ua.strategies.PricingStrategy;

public class TripManager {

    public static final Double MAX_ALLOWED_TRIP_MATCHING_DISTANCE = 10.0;
    private Map<String, List<Trip>> trips = new HashMap<>();

    private CabManager cabManager;
    private RiderManager riderManager;
    private CabMatchingStrategy cabMatchingStrategy;
    private PricingStrategy pricingStrategy;

    public TripManager(CabManager cabManager, RiderManager riderManager, CabMatchingStrategy cabMatchingStrategy, PricingStrategy pricingStrategy) {
        this.cabManager = cabManager;
        this.riderManager = riderManager;
        this.cabMatchingStrategy = cabMatchingStrategy;
        this.pricingStrategy = pricingStrategy;
    }
    
    public void createTrip(final Rider rider, final Location fromPoint, final Location toPoint) {
        final List<Cab> closeByCabs = cabManager.getCabs(fromPoint, MAX_ALLOWED_TRIP_MATCHING_DISTANCE);
        final List<Cab> closeByAvailableCabs = closeByCabs.stream().filter(cab -> cab.getCurrentTrip() == null).collect(Collectors.toList());
        final Cab selectedCab = cabMatchingStrategy.matchCabToRider(rider, closeByAvailableCabs, fromPoint, toPoint).get();
        if (selectedCab == null) {
            throw new NoCabsAvailableException();
        }

        final Double price = pricingStrategy.findPrice(fromPoint, toPoint);
        final Trip newTrip = new Trip(rider, selectedCab, price, fromPoint, toPoint);
        if (!trips.containsKey(rider.getId())) {
            trips.put(rider.getId(), new ArrayList<>());
        }
        trips.get(rider.getId()).add(newTrip);
        selectedCab.setCurrentTrip(newTrip);
    }

    public List<Trip> tripHistory(final Rider rider) {
        return trips.get(rider.getId());
    }
    
    public void endTrip(final Cab cab) {
        if (cab.getCurrentTrip() == null) {
            throw new TripNotFoundException();
        }
        cab.getCurrentTrip().endTrip();
        cab.setCurrentTrip(null);
    }
}
