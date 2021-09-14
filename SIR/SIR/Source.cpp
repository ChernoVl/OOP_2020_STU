/* ****************************************************************

This is the C version of program 2.1 from page 19 of
"Modeling Infectious Disease in humans and animals"
by Keeling & Rohani.

It is the simple SIR epidemic without births or deaths.

This code is written to be simple, transparent and readily compiled.
Far more elegant and efficient code can be written.

This code can be compiled using gnu or intel C compilers:
icc -o Program_2_1  Program_2_1.c  -lm
g++ -o Program_2_1  Program_2_1.c  -lm

If you have any difficulties, we suggest you set DEBUG to 1 or -1

******************************************************************/

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

// Set DEBUG to 1 to output some debugging information
// Set DEBUG to -1 to output more debugging information
#define DEBUG -1
#define MAXTIME 70

void Runge_Kutta(double step, double& S, double& I, double& R, double beta, double gamm, double *dPop, double N);
void Perform_Checks(double beta, double gamm, double S0, double I0);
void Output_Data(double t, double S, double I, double R);

int main(){
    double N = 10.;

    // Set up basic parameters
    //beta - интенсивность заражени€
    double beta = 520.0 / 365.0; //1.424657534246575

    //gamm - интенсивность выздоравливони€ 1/14
    double gamm = 1.0 / 7.0;     //0.1428571428571429

    double S0 = 1.0 - 1e-6;
    double I0 = 1e-6;

    // Set up variables and rates of change
    double S, I, R;
    double dPop[3];

     /* Check all parameters are OK & set up intitial conditions */
    /*ѕроверьте все параметры в пор€дке и установите начальные услови€*/
    printf("beta=%g\ngamma=%g\nInitial S=%g\nInitial I=%g\nRuns until time %g\n", beta, gamm, S0, I0, MAXTIME);
    Perform_Checks(beta, gamm, S0, I0);
    /*S = S0; 
    I = I0; 
    R = 1 - S - I;*/
    S = N - 0.1;
    I = 0.1;
    R = 0;
    printf("sum = %g\n\n", S + I + R);
//
    /* Find a suitable time-scale for outputs */
    double step = 0.01 / ((beta + gamm) * S0);
    double Every = pow(10, floor(log10((1.0 / ((beta + gamm) * S0)))));
    while (MAXTIME / Every > 10000)    {
        Every *= 10.0;
    }
    printf("Using a time step of %g and outputing data every %g\n\n", step, Every);
//

    /* The main iteration routine */
    double t = 0;
    Output_Data(t, S, I, R); // t S I R

    do{
        Runge_Kutta(step, S, I, R, beta, gamm, dPop, N);
        t += step;
        /* If time has moved on sufficiently, output the current data */
        if (floor(t / Every) > floor((t - step) / Every)){
            Output_Data(t, S, I, R);
        }
    } while (t < MAXTIME);

    Output_Data(t, S, I, R);
    return 0;
}

void Perform_Checks(double beta, double gamm, double S0, double I0){
    if (S0 <= 0) { 
        printf("ERROR: Initial level of susceptibles (%g) is less than or equal to zero\n", S0); 
        exit(1); 
    }
    if (I0 <= 0) { 
        printf("ERROR: Initial level of infecteds (%g) is less than or equal to zero\n", I0); 
        exit(1); 
    }
    if (beta <= 0) { 
        printf("ERROR: Transmission rate beta (%g) is less than or equal to zero\n", beta);
        exit(1); 
    }
    if (gamm <= 0) { 
        printf("ERROR: Recovery rate gamma (%g) is less than or equal to zero\n", gamm); 
        exit(1); 
    }
    if (MAXTIME <= 0) { 
        printf("ERROR: Maximum run time (%g) is less than or equal to zero\n", MAXTIME); 
        exit(1); 
    }
    if (S0 + I0 > 1) { 
        printf("WARNING: Initial level of susceptibles+infecteds (%g+%g=%g) is greater than one\n", S0, I0, S0 + I0); 
    }
    if (beta < gamm) { 
        printf("WARNING: Basic reproductive ratio (R_0=%g) is less than one\n", beta / gamm); 
    }
}

void Output_Data(double t, double S, double I, double R) {
    printf("t=%g \t S=%g I=%g R=%g\n", t, S, I, R);
}

// Initialise the equations and Runge-Kutta integration
void Diff(double Pop[3], double beta, double gamm, double *dPop, double N)
{
    // Set up temporary variables to make the equations look neater
    double tmpS, tmpI;
    tmpS = Pop[0]; 
    tmpI = Pop[1];

    /* The differential equations */
    dPop[0] = -beta * tmpS/N * tmpI;              // dS/dt
    dPop[1] = beta * tmpS/N * tmpI - gamm * tmpI;   // dI/dt
    dPop[2] = gamm * tmpI;                    // dR/dt
}

void Runge_Kutta(double step, double &S, double &I, double &R, double beta, double gamm, double *dPop, double N){
    int i;
    double dPop1[3], dPop2[3], dPop3[3], dPop4[3];
    double tmpPop[3], initialPop[3];
    /* Integrates the equations one step, using Runge-Kutta 4
       Note: we work with arrays rather than variables to make the
       coding easier */
    initialPop[0] = S;
    initialPop[1] = I; 
    initialPop[2] = R;

    Diff(initialPop, beta, gamm, dPop, N);
    for (i = 0; i < 3; i++)    {
        dPop1[i] = dPop[i];
        tmpPop[i] = initialPop[i] + step * dPop1[i] / 2;
    }

    Diff(tmpPop, beta, gamm, dPop, N);
    for (i = 0; i < 3; i++)    {
        dPop2[i] = dPop[i];
        tmpPop[i] = initialPop[i] + step * dPop2[i] / 2;
    }

    Diff(tmpPop, beta, gamm, dPop, N);
    for (i = 0; i < 3; i++)    {
        dPop3[i] = dPop[i];
        tmpPop[i] = initialPop[i] + step * dPop3[i];
    }

    Diff(tmpPop, beta, gamm, dPop, N);
    for (i = 0; i < 3; i++)    {
        dPop4[i] = dPop[i];
        tmpPop[i] = initialPop[i] + (dPop1[i] / 6 + dPop2[i] / 3 + dPop3[i] / 3 + dPop4[i] / 6) * step;
    }

    S = tmpPop[0]; 
    I = tmpPop[1]; 
    R = tmpPop[2];
}