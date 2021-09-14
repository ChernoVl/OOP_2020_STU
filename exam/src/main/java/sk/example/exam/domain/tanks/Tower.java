package sk.example.exam.domain.tanks;

import lombok.AllArgsConstructor;
import lombok.Data;
import sk.example.exam.domain.cannons.Cannon;

@Data
@AllArgsConstructor
public class Tower {
    private long id;
    private String name;
    private double rotationSpeed;
    private double oversight;
    private Cannon cannon;
}
