package sk.example.exam.domain.cannons;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SmallCannon extends Cannon {
    private long id;
    private String name;
    private int caliber;
    private int cadence;
    private int dispersionAt100m;
    private int magazine;
}
