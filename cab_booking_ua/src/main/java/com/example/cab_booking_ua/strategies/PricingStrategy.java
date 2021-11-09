package com.example.cab_booking_ua.strategies;

import com.example.cab_booking_ua.model.Location;

public interface PricingStrategy {
    Double findPrice(final Location fromPoint, final Location toPoint);
}
