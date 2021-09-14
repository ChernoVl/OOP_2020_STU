package sk.example.exam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import sk.example.exam.domain.cannons.Cannon;
import sk.example.exam.domain.cannons.LargeCannon;
import sk.example.exam.domain.chassises.WheelChassis;
import sk.example.exam.domain.componens.Nationality;
import sk.example.exam.domain.componens.Weapon;

@Data
@AllArgsConstructor
public class Artillery extends Weapon {
    private long id;
    private String name;
    private Nationality nationality;
    private double price;
    private WheelChassis wheelChassis;
    private LargeCannon largeCannon;
}
