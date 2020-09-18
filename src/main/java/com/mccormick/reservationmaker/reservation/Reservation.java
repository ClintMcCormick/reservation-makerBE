package com.mccormick.reservationmaker.reservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Reservations")
public class Reservation {

    @Id
    private String resId;

    private Guest guest;
    private Restaurant restaurant;
    private int numPeople;
    private String dateTime;
    private List<String> notes;
}