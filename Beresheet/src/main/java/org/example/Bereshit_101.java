package org.example;


import java.util.Vector;


import static org.example.Bereshit.*;

/**
 * This class represents the basic flight controller of the Bereshit spacecraft.
 *
 * @author ben-moshe
 */
public class Bereshit_101 {
    public static final double MAX_I = 100;
    public static String[] header = {"Time", "Gacc", "Engine Force", "Eng acc", "Hacc", "Vacc", "Fuel", "NN", "Ang(deg)", "Ang(rag)", "HS", "VS", "DVS", "P", "D(delta VS)", "I", "PID", "Alt"};
    static boolean firstTime = true;

    public static double accMax(double weight) {
        return acc(weight, true, 8);
    }

    public static double acc(double weight, boolean main, int seconds) {
        double t = 0;
        if (main) {
            t += MAIN_ENG_F;
        }
        t += seconds * SECOND_ENG_F;
        double ans = t / weight;
        return ans;
    }

    // 14095, 955.5, 24.8, 2.0
    public static void main(String[] args) {
        System.out.println("Simulating Bereshit's Landing:");

        double vs = 25.5327623529411;
        double hs = 932;
        double gacc;
        double NN = Math.random();
        double fuel = 121; //
        double engineForce = TOTAL_THRUST * NN;
        double engineAcceleration;
        double ang = 60; // zero is vertical (as in landing)
        double alt = 13748; // 2:25:40 (as in the simulation) // https://www.youtube.com/watch?v=JJ0VfRL9AMs
        double time = 0;
        double dt = 1; // sec
        double acc = 0; // Acceleration rate (m/s^2)
        double weight = WEIGHT_EMP + fuel;
        double ang_rad;
        double h_acc;
        double v_acc;
        Bereshit bereshit = new Bereshit(hs, vs, alt, ang, weight, fuel);
        Vector<Object[]> data = new Vector<>();
        System.out.println("time, vs, hs, dist, alt, ang,weight,acc");

        double P = 0.04;
        double I = 0.0003;
        double D = 0.2;
        double currentPidUpdate = 0.7;
        double lastPidUpdate;
        PID pid = new PID(P, I, D);
        // ***** main simulation loop ******

        while (alt > 0) {
            double dvs = getDVS(alt);
            double error = vs - dvs;
            if (firstTime) {
                currentPidUpdate = pid.update(error, dt, vs);
                NN = 0.7;
            } else {
                lastPidUpdate = currentPidUpdate;
                currentPidUpdate = pid.update(error, dt, vs);
                double lastNN = NN;
                NN = Math.max(Math.min(lastNN + lastPidUpdate, 1), 0);
            }


            // over 2 km above the ground
            // lower than 2 km - horizontal speed should be close to zero
            if (alt < 1500) {
                if(alt>1000 && ang >40)
                {
                    ang -= 0.5;
                }
                else if (alt > 700 && ang > 1.5) {
                    ang -= 1.3;
                } // rotate to vertical position.
                else if (ang > 0.4)
                {
                    ang -= 0.4;

                } else {
                    ang = 0;
                }
                // brake slowly, a proper PID controller here is needed!
                if (hs < 2) {
                    hs = 0;
                }
            }
            // main computations
            engineForce = TOTAL_THRUST * NN;
            engineAcceleration = engineForce / (WEIGHT_EMP + fuel);
            ang_rad = Math.toRadians(ang);
            h_acc = Math.sin(ang_rad) * engineAcceleration;
            v_acc = Math.cos(ang_rad) * engineAcceleration;
            gacc = Moon.getAcc(hs);

            time += dt;
            double dw = dt * ALL_BURN * NN;
            if (fuel > 0) {
                fuel -= dw;
                weight = WEIGHT_EMP + fuel;
                acc = NN * accMax(weight);
            } else { // ran out of fuel
                acc = 0;
            }

//            v_acc -= gacc;
            if (hs > 0 && !firstTime) {
                hs = hs - h_acc;
            }
            vs = vs + gacc - v_acc;
            alt -= dt * vs;
            Object[] obj = new Object[]{time, gacc, engineForce, engineAcceleration, h_acc, v_acc, fuel, NN, ang, ang_rad, hs, vs, getDVS(alt), pid.getProposal(), pid.getDerivative(), pid.getIntegral(), pid.getControlOut(), alt};
            data.add(obj);
            firstTime = false;

        }
        System.out.println("Fuel: " + fuel);
        MainView mainView = new MainView(header, data);
        mainView.setVisible(true);

    }


    public static double getDVS(double alt) {
        if (alt > 6000) return 30;
        if (alt > 1000) return 24;
        if (alt > 750) return 12;
        if (alt > 40) return 6;
        if (alt > 15) return 2;
        return 1;
    }
}
