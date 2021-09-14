package insuranceСontract.nonLifeInsurance;

import exceptions.IllegalAddressException;
import exceptions.IllegalBeginEndDateException;
import lombok.*;
import model.Address;
import model.Client;
import model.Contract;

import java.time.LocalDate;

/**
 * poistenie domácnosti
 * ○ typ nehnuteľnosti (číselníková hodnota, povolené hodnoty sú: "Byt", "Rodinný
 * dom - murovaný", "Rodinný dom - drevený")
 * ○ adresa nehnuteľnosti
 * ○ hodnota nehnuteľnosti v eurách
 * ○ hodnota zariadenia domácnosti v eurách
 */

//@Data
@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class HomeInsurance extends Contract {
    private PropertyType propertyType; //typ nehnuteľnosti
    private Address propertyAddress;
    private double propertyAmount;
    private double equipmentAmount; //hodnota zariadenia domácnosti v eurách

    public HomeInsurance(Contract contract,
                         PropertyType propertyType, Address propertyAddress, double propertyAmount, double equipmentAmount) throws IllegalBeginEndDateException, IllegalAddressException {

        super(contract.getClient(), contract.getBeginOfInsurance(), contract.getEndOfInsurance(),
                contract.getInsuranceAmount(), contract.getMonthlyPayment());
        if(propertyType == null || propertyAmount < 0 || equipmentAmount < 0){
            throw new IllegalArgumentException();
        }
        if(propertyAddress == null){
            throw new IllegalAddressException();
        }

        this.propertyType = propertyType;
        this.propertyAddress = propertyAddress;
        this.propertyAmount = propertyAmount;
        this.equipmentAmount = equipmentAmount;
    }
}
