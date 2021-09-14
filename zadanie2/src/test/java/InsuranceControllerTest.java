import exceptions.*;
import functionality.ClientController;
import functionality.InsuranceController;
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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class InsuranceControllerTest {
    Address address;

    Client client;
    Client client2;
    Client client3;
    Client client4;

    Contract contractTemplate;

    InsuranceController ic = new InsuranceController();
    ClientController cc = new ClientController();

    @BeforeEach
    void setUp() throws IllegalAddressException, IllegalNameSurnameException, IllegalNatalNumberException, IllegalBeginEndDateException {
        address = new Address("08500", null, "Stare Grunty", "12/a");
        //client = new Client("Vlad", "Chernov", "098/32", "test@mail.com", address, null);
        //client2 = new Client("Peter2", "sPete2r", "098/332", "test2@mail.com", address, null);
        client3 = cc.addNewClient("Vlad3", "Chernov3", "098/323", "test3@mail.com", address, null);
        client4 = cc.addNewClient("Max4", "sMax4", "098/304", "test4@mail.com", address, null);

        contractTemplate = ic.creatingInsuranceContract(client3, LocalDate.now(), LocalDate.now(), 50, 50);
    }

    @Test
    void creatingInsuranceContractTest() {
        System.out.println(contractTemplate);
    }

    @Test
    void Test() {
        LocalDate date1 = LocalDate.parse("2020-06-20");
        System.out.println(date1);
        LocalDate date2 = LocalDate.parse("2020-06-22");
        System.out.println(date2);
        System.out.println(date2.compareTo(date1));
    }

    @Test
    void creatingAccidentInsuranceContractTest() {
        try {
            AccidentInsurance accidentInsurance = ic.creatingInsuranceContract(contractTemplate,client2,1,
                    1,1, TerritorialValidity.WORD);
            System.out.println(accidentInsurance);
             cc.detailsClient(client3.getId());

            ic.creatingInsuranceContract(contractTemplate,client2,-1,
                    1,1, TerritorialValidity.WORD);
        } catch (IllegalBeginEndDateException | IllegalArgumentException e) {
            System.out.println("IllegalArgumentException");
        } catch (IllegalIdException e) {
            e.printStackTrace();
        }

    }
    
    @Test
    void creatingTravelInsuranceContractTest(){
        try {
            TravelInsurance travelInsurance = ic.creatingInsuranceContract(contractTemplate,client2,false,TravelPurpose.SPORT);
            System.out.println(travelInsurance);
            cc.detailsClient(client3.getId());

            ic.creatingInsuranceContract(contractTemplate,client2,false,null);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException");
        } catch (IllegalBeginEndDateException e) {
            e.printStackTrace();
        } catch (IllegalIdException e) {
            e.printStackTrace();
        }
    }

    @Test
    void creatingHomeInsuranceContractTest(){
        try {
            HomeInsurance homeInsurance = ic.creatingInsuranceContract(contractTemplate, PropertyType.FLAT,address,1,1);
            System.out.println(homeInsurance);
            cc.detailsClient(client3.getId());

            ic.creatingInsuranceContract(contractTemplate, PropertyType.FLAT,null,1,1);
        } catch (IllegalAddressException | IllegalBeginEndDateException | IllegalIdException e) {
            System.out.println("IllegalAddressException");
        }
    }

    @Test
    void creatingHouseFlatInsuranceContractTest(){
        try {
            HouseFlatInsurance homeFlInsurance = ic.creatingInsuranceContract(contractTemplate, PropertyType.FLAT,address,1,false);
            System.out.println(homeFlInsurance);
            cc.detailsClient(client3.getId());

            ic.creatingInsuranceContract(contractTemplate, PropertyType.FLAT,null,1,1);
        } catch (IllegalAddressException | IllegalBeginEndDateException | IllegalIdException e) {
            System.out.println("IllegalAddressException");
        }
    }

    @Test
    void test2(){
        try {
            ic.modificationContract(null);
            ic.listAllContract();
            ic.listContracts(1, cc);
        } catch (Exception e) {
            System.out.println("IllegalArgumentException");
        }
    }
}