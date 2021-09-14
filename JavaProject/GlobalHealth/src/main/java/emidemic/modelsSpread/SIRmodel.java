package emidemic.modelsSpread;

import emidemic.Population;

public class SIRmodel implements DiseaseSpreadModel {
    public void SIRmodel(double step, Population population, double beta, double gamm, double []dPop, double N) {
        int i;
        double[] dPop1 = new double[3];
        double[] dPop2 = new double[3];
        double[] dPop3 = new double[3];
        double[] dPop4 = new double[3];

        double[] currentPop = new double[3];
        double[] initialPop = new double[3];

    /* Integrates the equations one step, using Runge-Kutta 4
       Note: we work with arrays rather than variables to make the
       coding easier */
        initialPop[0] = population.getCountS();
        initialPop[1] = population.getCountI();
        initialPop[2] = population.getCountR();

        Diff(initialPop, beta, gamm, dPop, N);
        for (i = 0; i < 3; i++) {
            dPop1[i] = dPop[i];
            currentPop[i] = initialPop[i] + step * dPop1[i] / 2;
        }

        Diff(currentPop, beta, gamm, dPop, N);
        for (i = 0; i < 3; i++) {
            dPop2[i] = dPop[i];
            currentPop[i] = initialPop[i] + step * dPop2[i] / 2;
        }

        Diff(currentPop, beta, gamm, dPop, N);
        for (i = 0; i < 3; i++) {
            dPop3[i] = dPop[i];
            currentPop[i] = initialPop[i] + step * dPop3[i];
        }

        Diff(currentPop, beta, gamm, dPop, N);
        for (i = 0; i < 3; i++) {
            dPop4[i] = dPop[i];
            currentPop[i] = initialPop[i] + (dPop1[i] / 6 + dPop2[i] / 3 + dPop3[i] / 3 + dPop4[i] / 6) * step;
        }

        population.setCountS(currentPop[0]);
        population.setCountI(currentPop[1]);
        population.setCountR(currentPop[2]);
    }

    // Initialise the equations and Runge-Kutta integration
    private void Diff(double Pop[], double beta, double gamm, double dPop[], double N) {
        // Set up temporary variables to make the equations look neater
        double tmpS, tmpI;
        tmpS = Pop[0];
        tmpI = Pop[1];

        /* The differential equations */
        dPop[0] = -beta * tmpS / N * tmpI;              // dS/dt
        dPop[1] = beta * tmpS / N * tmpI - gamm * tmpI;   // dI/dt
        dPop[2] = gamm * tmpI;                    // dR/dt
    }
}
