package insuranceСontract.lifeInsurance;

import exceptions.IllegalBeginEndDateException;
import lombok.*;
import model.Client;
import model.Contract;

import java.time.LocalDate;

/**
 * úrazové poistenie
 * ○ referenciu na poistenca
 * ○ trvalé následky úrazu (poistná suma v eurách)
 * ○ Smrť v dôsledku úrazu (poistná suma v eurách)
 * ○ Denné odškodné za hospitalizáciu (poistná suma v eurách)
 * ○ Územná platnosť (číselníková hodnota, povolené hodnoty sú: “Slovensko”,
 * “Svet”, “Svet + Slovensko”)
 */

//@Data
@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class AccidentInsurance extends Contract {

    private Client insuredClient;
    private double totalInjury;
    private double death;
    private double compensationDaily;
    private TerritorialValidity terrValid;

    public AccidentInsurance(Contract contract, Client insuredClient, double totalInjury,
                             double death, double compensationDaily, TerritorialValidity terrValid) throws IllegalBeginEndDateException {
        super(contract.getClient(), contract.getBeginOfInsurance(), contract.getEndOfInsurance(),
                contract.getInsuranceAmount(), contract.getMonthlyPayment());

        if(totalInjury < 0 || compensationDaily < 0 || death < 0 || terrValid == null){
            throw new IllegalArgumentException();
        }

        this.insuredClient = insuredClient;
        this.totalInjury = totalInjury;
        this.death = death;
        this.compensationDaily = compensationDaily;
        this.terrValid = terrValid;
    }
}
