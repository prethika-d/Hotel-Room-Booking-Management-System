package com.hotel.service;

import com.hotel.model.Room;
import com.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingService {

    @Autowired
    private RoomRepository roomRepository;

    @Transactional
    public Room bookRoom(Long roomId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        if (room.isOccupied()) {
            throw new IllegalStateException("Room is already booked!");
        }

        room.setOccupied(true);
        return roomRepository.save(room);
    }

    @Transactional
    public void cancelBooking(Long roomId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));
        room.setOccupied(false);
        roomRepository.save(room);
    }
}