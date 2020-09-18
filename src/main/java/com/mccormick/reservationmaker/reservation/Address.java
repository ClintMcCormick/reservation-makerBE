package com.mccormick.reservationmaker.reservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String line1;
    private String line2;
    private String city;
    private String state;
    private String zip;
}
