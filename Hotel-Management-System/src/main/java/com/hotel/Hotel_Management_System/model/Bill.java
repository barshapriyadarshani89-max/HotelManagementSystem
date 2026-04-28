package com.hotel.Hotel_Management_System.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "bills")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    private Double totalAmount;
    private Double taxAmount;
    private Double grandTotal;
    private String paymentStatus;   // PAID, UNPAID
    private LocalDate billDate;

}