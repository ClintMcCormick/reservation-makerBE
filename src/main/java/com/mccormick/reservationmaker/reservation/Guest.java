package com.mccormick.reservationmaker.reservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guest {

    private String name;
    private String email;
    private boolean onEmailList;
}
