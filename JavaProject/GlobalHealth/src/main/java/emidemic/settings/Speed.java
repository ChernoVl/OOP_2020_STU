package emidemic.settings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Speed {
    private int speed;

    public void setSpeed(int speed) {
        if (speed < 0) {
            throw new IllegalArgumentException("Error: you can not set negative millisecond (" + speed + ')');
        }
        this.speed = speed;
    }
}
