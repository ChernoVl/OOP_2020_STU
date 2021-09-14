package model;

import exceptions.IllegalBeginEndDateException;
import lombok.*;
import model.Client;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Systém eviduje dva typy zmlúv: životné poistenie a neživotné poistenie. Každá zmluva má
 * priradené:
 * ● unikátne číslo zmluvy (ID),
 * ● dátum vzniku,
 * ● referenciu na poisťovateľa (používateľ ktorý zmluvu uzavrel),
 * ● dátum začiatku a konca poistenia,
 * ● výšku poistného plnenia (suma, na ktorú sa poisťuje),
 * ● výšku mesačnej splátky.
 */

//@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
    private long id;
    private LocalDate created;
    private Client client;
    private LocalDate beginOfInsurance;
    private LocalDate endOfInsurance;
    private double insuranceAmount;
    private double monthlyPayment;

    public Contract(Client client, LocalDate beginOfInsurance, LocalDate endOfInsurance, double insuranceAmount, double monthlyPayment) throws IllegalBeginEndDateException {
        if (endOfInsurance.compareTo(beginOfInsurance) < 0) {
            throw new IllegalBeginEndDateException();
        }
        if (insuranceAmount < 0 || monthlyPayment < 0) {
            throw new IllegalArgumentException();
        }

        this.id = Math.abs(UUID.randomUUID().getLeastSignificantBits());
        this.created = LocalDate.now();
        this.client = client;
        this.beginOfInsurance = beginOfInsurance;
        this.endOfInsurance = endOfInsurance;
        this.insuranceAmount = insuranceAmount;
        this.monthlyPayment = monthlyPayment;
    }

}
