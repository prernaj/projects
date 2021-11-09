package com.example.cab_booking_ua;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.cab_booking_ua.controllers.CabController;
import com.example.cab_booking_ua.controllers.RiderController;
import com.example.cab_booking_ua.database.CabManager;
import com.example.cab_booking_ua.database.RiderManager;
import com.example.cab_booking_ua.database.TripManager;
import com.example.cab_booking_ua.exceptions.CabAlreadyExistsException;
import com.example.cab_booking_ua.exceptions.CabNotFoundException;
import com.example.cab_booking_ua.exceptions.NoCabsAvailableException;
import com.example.cab_booking_ua.exceptions.RiderAlreadyExistsException;
import com.example.cab_booking_ua.exceptions.RiderNotFoundException;
import com.example.cab_booking_ua.strategies.CabMatchingStrategy;
import com.example.cab_booking_ua.strategies.DefaultPricingStrategy;
import com.example.cab_booking_ua.strategies.PricingStrategy;
import com.example.cab_booking_ua.strategies.DefaultCabMatchingStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RunnerTest {
  CabController cabController;
  RiderController riderController;

  @BeforeEach
  void setUp() {
    CabManager cabManager = new CabManager();
    RiderManager riderManager = new RiderManager();

    CabMatchingStrategy cabMatchingStrategy = new DefaultCabMatchingStrategy();
    PricingStrategy pricingStrategy = new DefaultPricingStrategy();

    TripManager tripManager = new TripManager(cabManager, riderManager, cabMatchingStrategy, pricingStrategy);

    cabController = new CabController(cabManager, tripManager);
    riderController = new RiderController(riderManager, tripManager);
  }

  @Test
  void testCabBookingFlow() {

    String r1 = "r1";
    riderController.registerRider(r1, "ud");
    String r2 = "r2";
    riderController.registerRider(r2, "du");
    String r3 = "r3";
    riderController.registerRider(r3, "rider3");
    String r4 = "r4";
    riderController.registerRider(r4, "rider4");

    String c1 = "c1";
    cabController.registerCab(c1, "driver1");
    String c2 = "c2";
    cabController.registerCab(c2, "driver2");
    String c3 = "c3";
    cabController.registerCab(c3, "driver3");
    String c4 = "c4";
    cabController.registerCab(c4, "driver4");
    String c5 = "c5";
    cabController.registerCab(c5, "driver5");

    cabController.updateCabLocation(c1, 1.0, 1.0);
    cabController.updateCabLocation(c2, 2.0, 2.0); //na
    cabController.updateCabLocation(c3, 100.0, 100.0);
    cabController.updateCabLocation(c4, 110.0, 110.0); //na
    cabController.updateCabLocation(c5, 4.0, 4.0);

    cabController.updateCabAvailability(c2, false);
    cabController.updateCabAvailability(c4, false);

    riderController.book(r1, 0.0, 0.0, 500.0, 500.0);
    riderController.book(r2, 0.0, 0.0, 500.0, 500.0);

    System.out.println("\n### Printing current trips for r1 and r2");
    System.out.println(riderController.fetchHistory(r1).getBody());
    System.out.println(riderController.fetchHistory(r2).getBody());

    cabController.updateCabLocation(c5, 50.0, 50.0);

    System.out.println("\n### Printing current trips for r1 and r2");
    System.out.println(riderController.fetchHistory(r1).getBody());
    System.out.println(riderController.fetchHistory(r2).getBody());

    cabController.endTrip(c5);

    System.out.println("\n### Printing current trips for r1 and r2");
    System.out.println(riderController.fetchHistory(r1).getBody());
    System.out.println(riderController.fetchHistory(r2).getBody());


    //assertThrows(NoCabsAvailableException.class, () -> { riderController.book(r3, 0.0, 0.0, 500.0, 500.0); });

    riderController.book(r4, 48.0, 48.0, 500.0, 500.0);
    System.out.println("\n### Printing current trips for r1, r2 and r4");
    System.out.println(riderController.fetchHistory(r1).getBody());
    System.out.println(riderController.fetchHistory(r2).getBody());
    System.out.println(riderController.fetchHistory(r4).getBody());

    assertThrows(RiderNotFoundException.class, () -> {
      riderController.book("abcd", 0.0, 0.0, 500.0, 500.0);
    });

    assertThrows(RiderAlreadyExistsException.class, () -> {
      riderController.registerRider("r1", "shjgf");
    });

    assertThrows(CabAlreadyExistsException.class, () -> {
      cabController.registerCab("c1", "skjhsfkj");
    });

    assertThrows(CabNotFoundException.class, () -> {
      cabController.updateCabLocation("shss", 110.0, 110.0);
    });

    assertThrows(CabNotFoundException.class, () -> {
      cabController.updateCabAvailability("shss", false);
    });
  }
}
