package insuranceСontract.nonLifeInsurance;

import exceptions.IllegalAddressException;
import exceptions.IllegalBeginEndDateException;
import lombok.*;
import model.Address;
import model.Client;
import model.Contract;

import java.time.LocalDate;

/**
 * poistenie domu a bytu
 * ○ typ nehnuteľnosti (číselníková hodnota, povolené hodnoty sú: "Byt", "Rodinný
 * dom - murovaný", "Rodinný dom - drevený")
 * ○ adresa nehnuteľnosti
 * ○ hodnota nehnuteľnosti v eurách
 * ○ pripoistenie garáže (áno / nie)
 */

//@Data
@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class HouseFlatInsurance extends Contract {
    private PropertyType propertyType;
    private Address propertyAddress;
    private double propertyAmount;
    private boolean garageInsurance;

    public HouseFlatInsurance(Contract contract, PropertyType propertyType, Address propertyAddress, double propertyAmount, boolean garageInsurance) throws IllegalBeginEndDateException, IllegalAddressException {
        super(contract.getClient(), contract.getBeginOfInsurance(), contract.getEndOfInsurance(),
                contract.getInsuranceAmount(), contract.getMonthlyPayment());
        if(propertyType == null || propertyAmount < 0){
            throw new IllegalArgumentException();
        }
        if(propertyAddress == null){
            throw new IllegalAddressException();
        }

        this.propertyType = propertyType;
        this.propertyAddress = propertyAddress;
        this.propertyAmount = propertyAmount;
        this.garageInsurance = garageInsurance;
    }
}
