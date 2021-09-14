package sk.example.exam.domain.chassises;


import lombok.Data;
import sk.example.exam.domain.componens.Item;

@Data
public abstract class Chassis extends Item {
    private double carrying;
    private double rotationSpeed;
    private double maxSpeed;
}
