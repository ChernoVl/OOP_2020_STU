package sk.example.exam.domain.cannons;

import lombok.Data;
import sk.example.exam.domain.componens.Item;

@Data
public abstract class Cannon extends Item {
    private int caliber;
    private int cadence;
    private int dispersionAt100m;
}
