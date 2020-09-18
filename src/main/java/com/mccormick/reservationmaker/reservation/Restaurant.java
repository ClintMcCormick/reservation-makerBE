package com.mccormick.reservationmaker.reservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    private Address address;
    private String name;
    private RestaurantType restaurantType;

    @AllArgsConstructor
    public enum RestaurantType {
        FINE_DINING("fine dining"),
        CASUAL_DINING("casual dining"),
        CONTEMPORARY_CASUAL("contemporary casual"),
        FAMILY_STYLE("family style"),
        FAST_CASUAL("fast casual"),
        FAST_FOOD("fast food");

        private final String value;

        public String value() {
            return value;
        }

        public static Optional<RestaurantType> fromValue(String v) {
            for (RestaurantType c : RestaurantType.values()) {
                if (c.value.equalsIgnoreCase(v)) {
                    return Optional.of(c);
                }
            }
            return Optional.empty();
        }
    }
}
