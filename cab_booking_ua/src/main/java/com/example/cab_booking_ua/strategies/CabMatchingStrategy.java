package com.example.cab_booking_ua.strategies;

import java.util.List;
import java.util.Optional;

import com.example.cab_booking_ua.model.Cab;
import com.example.cab_booking_ua.model.Location;
import com.example.cab_booking_ua.model.Rider;

public interface CabMatchingStrategy {
    Optional<Cab> matchCabToRider(final Rider rider, final List<Cab> candidateCab, final Location fromPoint, final Location toPoint);
}
