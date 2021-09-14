import exceptions.IllegalAddressException;
import functionality.ClientController;
import functionality.InsuranceController;
import insuranceСontract.lifeInsurance.AccidentInsurance;
import insuranceСontract.lifeInsurance.TerritorialValidity;
import model.Address;
import model.Client;
import model.Contract;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //there are created tests in the test folder
        try {
            ClientController cc = new ClientController();
            InsuranceController ic = new InsuranceController();

            Address address = new Address("08500", null, "Stare Grunty", "12/a");

            Client client2 = new Client("Peter2", "sPete2r", "098/332", "test2@mail.com", address, null);
            Client client3 = cc.addNewClient("Vlad3", "Chernov3", "098/323", "test3@mail.com", address, null);

            Contract contractTemplate = ic.creatingInsuranceContract(client3, LocalDate.now(), LocalDate.now(), 50, 50);

            AccidentInsurance accidentInsurance = ic.creatingInsuranceContract(contractTemplate,client2,1,
                    1,1, TerritorialValidity.WORD);
            System.out.println(accidentInsurance);
            cc.detailsClient(client3.getId());

            ic.creatingInsuranceContract(contractTemplate,client2,-1,
                    1,1, TerritorialValidity.WORD);


        } catch (Exception e) {

        }
    }
}
