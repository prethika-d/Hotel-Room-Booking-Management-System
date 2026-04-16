package com.hotel.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String roomNumber;
    private boolean isOccupied;

    @Version // Prevents double-booking via concurrency control
    private Integer version;
}