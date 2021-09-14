package sk.example.exam.domain.tanks;

import lombok.Data;
import sk.example.exam.domain.componens.Weapon;

@Data
public abstract class Tank extends Weapon {
    private Tower tower;

}
