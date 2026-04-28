package com.hotel.Hotel_Management_System.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "guests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String address;
    private String idProof;     // Aadhar, Passport etc

}

	
	

