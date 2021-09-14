import exceptions.IllegalAddressException;
import exceptions.IllegalIdException;
import exceptions.IllegalNameSurnameException;
import exceptions.IllegalNatalNumberException;
import functionality.ClientController;
import model.Address;
import model.Client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ClientControllerTest {
    Address address;

    Client client;
    Client client2;
    Client client3;
    Client client4;

    ClientController cc = new ClientController();

    @BeforeEach
    void setUp() throws IllegalAddressException, IllegalNameSurnameException, IllegalNatalNumberException {
        address = new Address("08500", null, "Stare Grunty", "12/a");
        client = new Client("Vlad", "Chernov", "098/32", "test@mail.com", address, null);
        client2 = new Client("Peter2", "sPete2r", "098/332", "test2@mail.com", address, null);
        client3 = cc.addNewClient("Vlad3", "Chernov3", "098/323", "test3@mail.com", address, null);
        client4 = cc.addNewClient("Max4", "sMax4", "098/304", "test4@mail.com", address, null);
    }

    @Test
    void addNewClientByParametersTest() {
        try {
            System.out.println(client3);
            System.out.println(client4);

            //Client client5 = cc.addNewClient(null, "sMax4", "098/304", "test4@mail.com", address, null);
            //Client client5 = cc.addNewClient("Max4", "sMax4", null, "test4@mail.com", address, null);
            Client client5 = cc.addNewClient("Max4", "sMax4", "2342", null, null, null);
        } catch (IllegalNameSurnameException e) {
            System.out.println("IllegalNameSurnameException");
        } catch (IllegalNatalNumberException e) {
            System.out.println("IllegalNatalNumberException");
        } catch (IllegalAddressException e) {
            System.out.println("IllegalAddressException");
        }
    }

    @Test
    void updateClientTest() {
        try {
            client4.setName("NewName");
            cc.updateClient(client4);

            cc.updateClient(client);
        } catch (IllegalIdException e) {
            System.out.println("noExistId");
        }
        cc.listAllClient().forEach(System.out::println);
    }

    @Test
    void listAllClientTest() {
        cc.listAllClient().forEach(System.out::println);
    }

    @Test
    void detailsClientTest() {
        try {
            cc.detailsClient(client3.getId());

            cc.detailsClient(-1);
        } catch (IllegalIdException e) {
            System.out.println("IllegalIdException");
        }
    }
}