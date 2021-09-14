package sk.example.exam.domain.componens;

import lombok.Data;
import sk.example.exam.domain.chassises.WheelChassis;

@Data
public abstract class Weapon extends Item {
    private Nationality nationality;
    private double price;
    private WheelChassis wheelChassis;
}
