package com.example.cab_booking_ua.strategies;

import com.example.cab_booking_ua.model.Location;

public class DefaultPricingStrategy implements PricingStrategy {

    public static final Double PER_KM_RATE = 10.0;

    
    @Override
    public Double findPrice(final Location fromPoint, final Location toPoint) {
        return fromPoint.distance(toPoint) * PER_KM_RATE;
    }
}
