

# Simulation rundown

The simulation file package includes the following files:


    Bereshit_101.java
    Moon.java
    PID.java
    MainView.java

To run the simulation program run the Bereshit_101.java file and the landing simulation parameters will pop on a UI window.


![beresheet](https://user-images.githubusercontent.com/74679553/229558775-62a9e1d2-2850-4db0-9397-e56ebafba42f.png)

The required parameters of the aircraft that represent a landing should be:

    Vertical speed (VS) lower than 2.5m/s;
    Horisontal speed (HS) of 2.5m/s;
    Angle of the aircraft (Ang(deg)) of 0;
    Altitude (Alt) converging to 0;


The goal of the simulation is to land the Bereshit aircraft with a smooth landing curve and as much fuel as possible. When the aircraft's altitude is closing on 2000m, the Vertical Speed (VS) should gradually slow down until it reaches a value of 0, so to have a controlled vertical landing.

The algorithm used to control the gas output which controls the airctaft's descent is PID.



