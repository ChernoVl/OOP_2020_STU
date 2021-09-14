package sk.example.exam.domain.chassises;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TrackedChassis extends Chassis{
    private long id;
    private String name;
    private double carrying;
    private double rotationSpeed;
    private double maxSpeed;
    private double beltWidth;
}
