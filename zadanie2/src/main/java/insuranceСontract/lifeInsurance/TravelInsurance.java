package insuranceСontract.lifeInsurance;

import exceptions.IllegalBeginEndDateException;
import lombok.*;
import model.Client;
import model.Contract;

import java.time.LocalDate;

/**
 * cestovné poistenie:
 * ○ referenciu na poistenca
 * ○ v rámci EU / mimo EU
 * ○ účel cesty (číselníková hodnota, povolené sú: pracovne, rekreačne, šport, a
 * pod.)
 */

//@Data
@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//LifeInsurance
public class TravelInsurance extends Contract {

    private Client insuredClient;
    private boolean withinEU;
    private TravelPurpose travelPurpose;

    public TravelInsurance(Contract contract, Client insuredClient, boolean withinEU, TravelPurpose travelPurpose) throws IllegalBeginEndDateException {

        super(contract.getClient(), contract.getBeginOfInsurance(), contract.getEndOfInsurance(),
                contract.getInsuranceAmount(), contract.getMonthlyPayment());
        if(travelPurpose == null){
            throw new IllegalArgumentException();
        }
        this.insuredClient = insuredClient;
        this.withinEU = withinEU;
        this.travelPurpose = travelPurpose;
    }
}
