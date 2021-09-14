package sk.example.exam.domain.tanks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import sk.example.exam.domain.chassises.TrackedChassis;
import sk.example.exam.domain.chassises.WheelChassis;
import sk.example.exam.domain.componens.Nationality;

@Data
@AllArgsConstructor
public class HeavyTank extends Tank {
    private long id;
    private String name;
    private Nationality nationality;
    private double price;
    private TrackedChassis trackedChassis;
    private Tower towerLargeCannon;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TrackedChassis getTrackedChassis() {
        return trackedChassis;
    }

    public void setTrackedChassis(TrackedChassis trackedChassis) {
        this.trackedChassis = trackedChassis;
    }

    public Tower getTowerLargeCannon() {
        return towerLargeCannon;
    }

    public void setTowerLargeCannon(Tower towerLargeCannon) {
        this.towerLargeCannon = towerLargeCannon;
    }
}
