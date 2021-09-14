package sk.example.exam.domain.tanks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import sk.example.exam.domain.chassises.WheelChassis;
import sk.example.exam.domain.componens.Nationality;

@AllArgsConstructor
//@NoArgsConstructor
@Data
public class LightTank extends Tank {
    private long id;
    private String name;
    private Nationality nationality;
    private double price;
    private WheelChassis wheelChassis;
    private Tower towerSmallCannon;

}
