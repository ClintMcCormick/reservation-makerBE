package com.mccormick.reservationmaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.util.BsonUtils;

@SpringBootApplication
public class ReservationMakerApplication {

	public static void main(String[] args) { SpringApplication.run(ReservationMakerApplication.class, args); }
}
