package emidemic;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Population {
    private double countS;
    private double countI;
    private double countR;

    public Population(double countSusceptible, double countInfected, double countResistant) {
        setCountS(countSusceptible);
        setCountI(countInfected);
        setCountR(countResistant);
    }

    public void setCountS(double countS) {
        if (countS <= 0) {
            throw new IllegalArgumentException("ERROR: Initial level of susceptibles (" +
                    countS + ") is less than or equal to zero");
        }
        this.countS = countS;
    }

    public void setCountI(double countI) {
        if (countI <= 0) {
            throw new IllegalArgumentException("ERROR: Initial level of susceptibles (" +
                    countI + ") is less than or equal to zero");
        }
        this.countI = countI;
    }

    @Override
    public String toString() {
        return "Pop{ " +
                "countS=" + countS +
                ", countI=" + countI +
                ", countR=" + countR +
                " }";
    }
}
