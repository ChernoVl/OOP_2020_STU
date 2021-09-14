package model;

import exceptions.IllegalAddressException;
import exceptions.IllegalNameSurnameException;
import exceptions.IllegalNatalNumberException;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * unikátny číselný identifikátor (ID),
 * ● meno,
 * ● priezvisko,
 * ● rodné číslo,
 * ● e-mail,
 * ● adresa trvalého pobytu,
 * ● korešpondenčná adresa,
 * ● zoznam zmlúv (zmluvy uzatvorené používateľom)
 */

//@Data
@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class Client {
    private long id;
    private String name;
    private String surname;
    private String natalNumber;
    private String email;
    private Address permanentAddress;
    private Address correspondenceAddress;
    private List<Contract> contracts;

    public Client(String name, String surname, String natalNumber, String email, Address permanentAddress, Address correspondenceAddress) throws IllegalNameSurnameException, IllegalNatalNumberException, IllegalAddressException {
        if (name == null || surname == null) {
            throw new IllegalNameSurnameException();
        }
        if (natalNumber == null) {
            throw new IllegalNatalNumberException();
        }
        if (permanentAddress == null) {
            throw new IllegalAddressException();
        }
        if (correspondenceAddress == null) {
            correspondenceAddress = permanentAddress;
        }

        this.id = Math.abs(UUID.randomUUID().getLeastSignificantBits());
        this.name = name;
        this.surname = surname;
        this.natalNumber = natalNumber;
        this.email = email;
        this.permanentAddress = permanentAddress;
        this.correspondenceAddress = correspondenceAddress;
    }

    public void addContract(Contract contract) {
        if(contracts == null){
            contracts = new ArrayList<>();
        }
        contracts.add(contract);
        //FIXME
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
