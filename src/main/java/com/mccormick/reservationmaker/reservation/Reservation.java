package com.mccormick.reservationmaker.reservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    private Guest guest;
    private Restaurant restaurant;
    private int numPeople;
    private DateTimeFormat dateTime;
    private List<String> notes;

}
