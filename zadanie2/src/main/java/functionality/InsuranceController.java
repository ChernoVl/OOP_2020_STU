package functionality;

import exceptions.IllegalAddressException;
import exceptions.IllegalBeginEndDateException;
import insuranceСontract.lifeInsurance.AccidentInsurance;
import insuranceСontract.lifeInsurance.TerritorialValidity;
import insuranceСontract.lifeInsurance.TravelInsurance;
import insuranceСontract.lifeInsurance.TravelPurpose;
import insuranceСontract.nonLifeInsurance.HomeInsurance;
import insuranceСontract.nonLifeInsurance.HouseFlatInsurance;
import insuranceСontract.nonLifeInsurance.PropertyType;
import model.Address;
import model.Client;
import model.Contract;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ● Správa poistných zmlúv:
 * <p>
 * ○ Založenie poistnej zmluvy používateľovi
 * ○ Úprava existujúcej zmluvy
 * ○ Vylistovanie všetkých poistných zmlúv
 * ○ Vylistovanie poistných zmlúv pre daného poisťovateľa (podľa unikátneho
 * číselného identifikátora používateľa) - vylistuje len zmluvy, kde je daný
 * používateľ poisťovateľom!
 */
public class InsuranceController {

    Map<Long, Contract> insurances = new HashMap<>();

    public Contract creatingInsuranceContract(Client client, LocalDate beginOfInsurance, LocalDate endOfInsurance,
                                              double insuranceAmount, double monthlyPayment) throws IllegalBeginEndDateException {

        Contract contract = new Contract(
                client,
                beginOfInsurance,
                endOfInsurance,
                insuranceAmount,
                monthlyPayment);
        return contract;
    }

    //life insurance
    public AccidentInsurance creatingInsuranceContract(Contract contract,
                                                       Client insuredClient,
                                                       double totalInjury,
                                                       double death,
                                                       double compensationDaily,
                                                       TerritorialValidity terrValid) throws IllegalBeginEndDateException {

        AccidentInsurance accInc = new AccidentInsurance(
                contract,
                insuredClient,
                totalInjury,
                death,
                compensationDaily,
                terrValid);

        contract.getClient().addContract(accInc);
        insurances.put(accInc.getId(), accInc);
        return accInc;
    }

    public TravelInsurance creatingInsuranceContract(Contract contract,
                                                     Client insuredClient,

                                                     boolean withinEU,
                                                     TravelPurpose travelPurpose) throws IllegalBeginEndDateException {

        TravelInsurance trInc = new TravelInsurance(
                contract,

                insuredClient,
                withinEU,
                travelPurpose);

        contract.getClient().addContract(trInc);
        insurances.put(trInc.getId(), trInc);
        return trInc;
    }

    //non-life insurance
    public HomeInsurance creatingInsuranceContract(Contract contract,
                                                   PropertyType propertyType, Address propertyAddress,
                                                   double propertyAmount, double equipmentAmount) throws IllegalBeginEndDateException, IllegalAddressException {

        HomeInsurance hInc = new HomeInsurance(
                contract,
                propertyType,
                propertyAddress,
                propertyAmount,
                equipmentAmount);

        contract.getClient().addContract(hInc); //FIXME використовую поліморфізм
        insurances.put(hInc.getId(), hInc);
        return hInc;
    }

    public HouseFlatInsurance creatingInsuranceContract(Contract contract,
                                                        PropertyType propertyType, Address propertyAddress,
                                                        double propertyAmount, boolean garageInsurance) throws IllegalBeginEndDateException, IllegalAddressException {

        HouseFlatInsurance accInc = new HouseFlatInsurance(
                contract,

                propertyType,
                propertyAddress,
                propertyAmount,
                garageInsurance);

        contract.getClient().addContract(accInc);
        insurances.put(accInc.getId(), accInc);
        return accInc;
    }

    public void modificationContract(Contract contract) {
        if(contract == null){
            throw new IllegalArgumentException();
        }
        insurances.put(contract.getId(), contract);
    }

    public List<Contract> listAllContract() {
        return new ArrayList<>(insurances.values());
    }

    public void listContracts(long idClient, ClientController cc) {
        System.out.println(cc.getClients().get(idClient));
    }
}
