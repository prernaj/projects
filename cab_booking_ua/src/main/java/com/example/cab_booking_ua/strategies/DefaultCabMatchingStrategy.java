package com.example.cab_booking_ua.strategies;

import java.util.List;
import java.util.Optional;

import com.example.cab_booking_ua.model.Cab;
import com.example.cab_booking_ua.model.Location;
import com.example.cab_booking_ua.model.Rider;

public class DefaultCabMatchingStrategy implements CabMatchingStrategy {
    @Override
    public Optional<Cab> matchCabToRider(final Rider rider, final List<Cab> candidateCabs, Location fromPoint, Location toPoint) {
        if (candidateCabs.isEmpty()) {
            return null;
        }
        return candidateCabs.stream().filter(cab -> cab.getCurrentTrip() == null).findAny();
    }
}
