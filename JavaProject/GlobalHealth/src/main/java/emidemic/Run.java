package emidemic;

import emidemic.simulation.Epidemic;

import java.io.IOException;

public class Run {
    public static void main(String[] args) throws IOException {
        Epidemic epidemic = new Epidemic();
        epidemic.epidemicSimulation();
    }
}
