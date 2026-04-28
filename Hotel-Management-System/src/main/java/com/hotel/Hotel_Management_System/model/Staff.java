package com.hotel.Hotel_Management_System.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "staff")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String role;        // Receptionist, Housekeeping, Manager
    private String email;
    private String phone;
    private Double salary;
    private String status;      // ACTIVE, INACTIVE

}