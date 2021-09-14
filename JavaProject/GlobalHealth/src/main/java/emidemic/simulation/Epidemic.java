package emidemic.simulation;

import emidemic.Population;
import emidemic.modelsSpread.SIRmodel;
import emidemic.settings.Speed;
import emidemic.viruses.SomeVirus;
import emidemic.viruses.Virus;

import java.util.Scanner;

public class Epidemic {
    final double MAXTIME = 150;

    Population population;
    Virus virus;
    double nOfPop;
    double beta;    //интенсивность заражения
    double gamm;    //интенсивность выздоравливония например 1/14

    double step;
    double Every;
    final double EPS3 = 1e-3;
    final double EPS2 = 1e-2;
    Speed speed;

    private void setup() {
        Scanner scanner = new Scanner(System.in);
        virus = new SomeVirus();
        speed = new Speed();

        System.out.print("Enter the number of population: ");
        nOfPop = scanner.nextDouble();

        System.out.print("Enter the number of infected: ");
        double inf = scanner.nextDouble();

        population = new Population(nOfPop - inf, inf, 0);

        //FIXME scanner initialization
        // поставить проверку на бету, гаму, на час, S0 + I0 > 1, (beta < gamm)
        // Checks(beta, gamm, S0, I0);
        gamm = 1.0 / virus.getCurability();
        beta = 1;

        System.out.print("Enter the simulation speed in milliseconds: ");
        speed.setSpeed(scanner.nextInt());

//        population = new Population(9.9, 0.1, 0);
//        virus = new SomeVirus();
//
//        gamm = 1.0 / virus.getCurability();
//        beta = 1;
//
//        nOfPop = population.getCountS() + population.getCountI() + population.getCountR();

        /* Find a suitable time-scale for outputs */
        step = 0.01 / ((beta + gamm) * population.getCountS());
        Every = Math.pow(10, Math.floor(Math.log10((1.0 / ((beta + gamm) * population.getCountS())))));
        while (MAXTIME / Every > 10000) {
            Every *= 10.0;
        }
        System.out.println("Using a time step of " + step + " and outputing data every " + Every + "\n\n");
    }

    public void epidemicSimulation() {
        setup();
        SIRmodel sirModel = new SIRmodel();
        System.out.println("beta = " + beta +
                "\ngamma = " + gamm +
                "\nInitial S = " + population.getCountS() +
                "\nInitial I = " + population.getCountI() +
                "\nRuns until time - " + MAXTIME +
                "\nCount Pop = " + nOfPop);

        /* The main iteration routine */
        double t = 0;
        System.out.println(t + "\t" + population.toString());
        do {
            sleep(speed.getSpeed());
            t += step;
            double[] dPop = new double[3];
            sirModel.SIRmodel(step, population, beta, gamm, dPop, nOfPop);
            /* If time has moved on sufficiently, output the current data */
            if (Math.floor(t / Every) > Math.floor((t - step) / Every)) {
                System.out.println("Time:" + t + "\t" + population.toString());
            }
        } while (population.getCountI() - EPS3 > 0 && population.getCountR() + EPS2 < nOfPop && t < MAXTIME);

        if(population.getCountR() + EPS2 >= nOfPop){
            System.out.println("Congratulations!!! Your population has survived");
        }else if(t >= MAXTIME){
            System.out.println("Your data exceeded the maximum stimulation time");
        }
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
