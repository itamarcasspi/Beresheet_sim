

# Simulation rundown

The simulation file package includes the following files:


    Bereshit_101.java
    Moon.java
    PID.java
    MainView.java


To run the simulation program run the Bereshit_101.java file and the landing simulation parameters will pop on a UI window.

![newbereshit](https://user-images.githubusercontent.com/74679553/229559163-40691f9e-4e9b-4138-80bc-56e5f1886bae.png)

The parameters of the aircraft that represent a landing (which are marked in blue at the bottom) should be:

    Vertical speed (VS) lower than 2.5m/s;
    Horisontal speed (HS) of 2.5m/s;
    Angle of the aircraft (Ang(deg)) of 0;
    Altitude (Alt) converging to 0;


The goal of the simulation is to land the Bereshit aircraft with a smooth landing curve and as much fuel as possible. When the aircraft's altitude is closing on 2000m, the Vertical Speed (VS) should gradually slow down until it reaches a value of 0, so to have a controlled vertical landing.

The algorithm used to control the gas output which controls the airctaft's descent is PID.
The PID controller is initialized using the PID class using the following constructor:

    PID pid = new PID(P, I, D);
    
    where P, I and D are the proportional , integral and derivative correction terms.
   
 At every iteration (dt, which represents the time in our simulation) we update the controller with our desired VS and the error value.
 
    currentPidUpdate = pid.update(error, dt, vs);
    
    The PID calculation is returned by the update function and is calculated as such:

    P*error + I*integral + D*derivative 
    
    where error is calculated as VS - DVS (Desired Vertical Speed).
    integral value is the sum of all previous error values.
    the derivative is the current VS - previous VS
    

The returned PID value is then normalized to values between 0 and 1 with the following:

    NN = Math.max(Math.min(lastNN + lastPidUpdate, 1), 0);

Using the NN value we control the engine throughput.



    
   



