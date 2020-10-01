package com.mccormick.reservationmaker.controllers;

import com.mccormick.reservationmaker.repository.ReservationRepository;
import com.mccormick.reservationmaker.reservation.Reservation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping("/all")
    public List<Reservation> getAllReservations(){
        return  this.reservationRepository.findAll();
    }

    @GetMapping("/{resId}")
    public Reservation getReservationById(@PathVariable("resId") String resId){

        List<Reservation> reservations = this.reservationRepository.findAll();

        Reservation reservation = reservations.stream()
                .filter(r -> r.getResId().equals(resId)).findAny().orElse(null);

       return reservation;
    }

    @PutMapping
    public void addReservation(@RequestBody Reservation reservation){
        reservation.setResId(UUID.randomUUID().toString());
        this.reservationRepository.insert(reservation);
    }

    @PostMapping
    public void updateReservation(@RequestBody Reservation reservation){
        this.reservationRepository.save(reservation);
    }

    @DeleteMapping("/{resId}")
    public void deleteReservation(@PathVariable("resId") String resId){

        List<Reservation> reservations = this.reservationRepository.findAll();

        Reservation reservation = reservations.stream()
                .filter(r -> r.getResId().equals(resId)).findAny().orElse(null);

        this.reservationRepository.delete(reservation);
    }
}
