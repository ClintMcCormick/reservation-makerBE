package com.mccormick.reservationmaker.repository;

import com.mccormick.reservationmaker.reservation.Address;
import com.mccormick.reservationmaker.reservation.Guest;
import com.mccormick.reservationmaker.reservation.Reservation;
import com.mccormick.reservationmaker.reservation.Restaurant;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReservationSeedData implements CommandLineRunner {

    private ReservationRepository reservationRepository;

    public ReservationSeedData(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<String> notes = List.of("Gluten Allergy");

        Reservation res1 = new Reservation("res1", new Guest("William McCormick", "wm@gmail.com", true),
                new Restaurant(new Address("123 street", null, "Charlotte", "NC", "28203"),
                        "Bob's Bistro", Restaurant.RestaurantType.FINE_DINING), 4, "08/18/2020", notes );

        Reservation res2 = new Reservation("res2", new Guest("Cara Wilson", "cm@gmail.com", false),
                new Restaurant(new Address("321 street", null, "Charlotte", "NC", "28209"),
                        "McBurger", Restaurant.RestaurantType.FAMILY_STYLE), 6, "08/18/2020", notes );

        Reservation res3 = new Reservation("res3", new Guest("Willy Wills", "ww@gmail.com", true),
                new Restaurant(new Address("555 street", null, "Charlotte", "NC", "28208"),
                        "Skillet", Restaurant.RestaurantType.CONTEMPORARY_CASUAL), 1, "08/18/2020", notes );

        // drop all reservations
        this.reservationRepository.deleteAll();

        // add reservations
        List<Reservation> reservations = List.of(res1, res2, res3);

        this.reservationRepository.saveAll(reservations);
    }
}
