package com.hotel.Hotel_Management_System.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.Hotel_Management_System.model.Bill;
import com.hotel.Hotel_Management_System.model.Booking;
import com.hotel.Hotel_Management_System.repository.BillingRepository;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.time.LocalDate;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    public Bill generateBill(Booking booking) {
        long nights = ChronoUnit.DAYS.between(
            booking.getCheckInDate(),
            booking.getCheckOutDate()
        );
        double total = nights * booking.getRoom().getPricePerNight();
        double tax   = total * 0.18;  // 18% GST
        double grand = total + tax;

        Bill bill = new Bill();
        bill.setBooking(booking);
        bill.setTotalAmount(total);
        bill.setTaxAmount(tax);
        bill.setGrandTotal(grand);
        bill.setPaymentStatus("UNPAID");
        bill.setBillDate(LocalDate.now());

        return billingRepository.save(bill);
    }

    public Bill payBill(Long billId) {
        Bill bill = billingRepository.findById(billId).orElse(null);
        if (bill != null) {
            bill.setPaymentStatus("PAID");
            billingRepository.save(bill);
        }
        return bill;
    }

    public List<Bill> getAllBills() {
        return billingRepository.findAll();
    }

}
