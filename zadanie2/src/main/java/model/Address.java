package model;

import exceptions.IllegalAddressException;
import lombok.*;

/**
 * ● PSČ,
 * ● názvu obce,
 * ● názvu ulice,
 * ● orientačného čísla domu
 */

@Getter
@Setter
@ToString
//@AllArgsConstructor
//@NoArgsConstructor
public class Address {
    private String postcode;
    private String village;
    private String street;
    private String houseNumber;

    public Address(String postcode, String village, String street, String houseNumber) throws IllegalAddressException {
        if (street == null) {
            throw new IllegalAddressException();
        }
        this.postcode = postcode;
        this.village = village;
        this.street = street;
        this.houseNumber = houseNumber;
    }
}
