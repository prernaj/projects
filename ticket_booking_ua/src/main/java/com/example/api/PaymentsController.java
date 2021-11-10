package com.example.api;

import com.example.services.BookingService;
import com.example.services.PaymentsService;

public class PaymentsController {
    private final PaymentsService paymentsService;
    private final BookingService bookingService;

    public PaymentsController(PaymentsService paymentsService, BookingService bookingService) {
        this.paymentsService = paymentsService;
        this.bookingService = bookingService;
    }

    public void paymentFailed(String bookingId, String userId) {
        paymentsService.processPaymentFailure(bookingService.getBooking(bookingId), userId);
    }

    public void paymentSuccess(String bookingId, String userId) {
        bookingService.confirmBooking(bookingService.getBooking(bookingId), userId);
    }
}
