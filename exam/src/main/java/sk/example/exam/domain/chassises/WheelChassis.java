package sk.example.exam.domain.chassises;

import lombok.AllArgsConstructor;
import lombok.Data;
import sk.example.exam.domain.componens.Item;

@Data
@AllArgsConstructor
public class WheelChassis extends Chassis {
        private long id;
        private String name;
        private double carrying;
        private double rotationSpeed;
        private double maxSpeed;
        private double countWheels;
}
