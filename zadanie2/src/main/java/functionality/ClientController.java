package functionality;

import exceptions.IllegalAddressException;
import exceptions.IllegalIdException;
import exceptions.IllegalNameSurnameException;
import exceptions.IllegalNatalNumberException;
import lombok.Data;
import model.Address;
import model.Client;

import java.util.*;

/**
 * ● Správa používateľov:
 * <p>
 * ○ Pridanie nového používateľa
 * ○ Úprava existujúceho používateľa
 * ○ Vylistovanie všetkých používateľov v systéme
 * ○ Vypísanie detailu konkrétneho používateľa (podla unikátneho číselného
 * identifikátora)
 */

@Data
public class ClientController {
    private Map<Long,Client> clients = new HashMap<>();

    public Client addNewClient(String name, String surname,
                             String natalNumber, String email,
                             Address permanentAddress, Address correspondenceAddress) throws IllegalNameSurnameException, IllegalNatalNumberException, IllegalAddressException {

        Client client = new Client(name, surname, natalNumber, email, permanentAddress, correspondenceAddress);

        clients.put(client.getId(), client);

        return client;
    }


    public void updateClient(Client client) throws IllegalIdException {
        if(!clients.containsKey(client.getId())){
            throw new IllegalIdException();
        }
        clients.put(client.getId(), client);
    }

    public List<Client> listAllClient() {
        return new ArrayList<>(clients.values());
    }

    public void detailsClient(long id) throws IllegalIdException {
        if(!clients.containsKey(id)){
            throw new IllegalIdException();
        }
        Client client = clients.get(id);
        System.out.println("Client{" +
                "id=" + id +
                ", name='" + client.getName() + '\'' +
                ", surname='" + client.getSurname() + '\'' +
                ", natalNumber='" + client.getNatalNumber() + '\'' +
                ", email='" + client.getEmail() + '\'' +
                ", permanentAddress=" + client.getPermanentAddress() +
                ", correspondenceAddress=" + client.getCorrespondenceAddress() +
                ", contracts=" + client.getContracts() +
                '}');
        //FIXME вивод ліста client.getContracts()
    }
}
