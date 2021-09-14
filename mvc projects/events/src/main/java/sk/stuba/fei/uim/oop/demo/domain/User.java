package sk.stuba.fei.uim.oop.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private String surname;
    private String email;

    @Override
    public String toString() {
        return surname + ", " + name + " [" + email + "]";
    }
}
