package com.example.cab_booking_ua.database;

import java.util.HashMap;
import java.util.Map;

import com.example.cab_booking_ua.exceptions.RiderAlreadyExistsException;
import com.example.cab_booking_ua.exceptions.RiderNotFoundException;
import com.example.cab_booking_ua.model.Rider;

/**
 * In memory database for storing riders.
 */
public class RiderManager {
    Map<String, Rider> riders = new HashMap<>();

    public void createRider(final Rider newRider) {
        if (riders.containsKey(newRider.getId())) {
            throw new RiderAlreadyExistsException();
        }
        riders.put(newRider.getId(), newRider);
    }

    public Rider getRider(final String riderId) {
        if (!riders.containsKey(riderId)) {
            throw new RiderNotFoundException();
        }
        return riders.get(riderId);
    }
    
}
