

# Simulation report

By Itamar Caspi and Josef Mammo

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
 In this simulation the PID values were 0.04, 0.0003 and 0.2 accordingly.
 
    currentPidUpdate = pid.update(error, dt, vs);
    
    The PID calculation is returned by the update function and is calculated as such:

    P*error + I*integral + D*derivative 
    
    where error is calculated as VS - DVS (Desired Vertical Speed).
    integral value is the sum of all previous error values.
    the derivative is the current VS - previous VS
    

The returned PID value is then normalized to values between 0 and 1 with the following:

    NN = Math.max(Math.min(lastNN + lastPidUpdate, 1), 0);

Using the NN value we control the engine throughput.

To see the results of the simulation in a graphic manner, let us examine the following graphs:


### VS & DVS

    
   ![VS_DVS](https://user-images.githubusercontent.com/74679553/229605509-f4e2005a-5482-4059-884b-66a332cd2c4a.png)
   
   In this graph we can see the similarities between the spacecraft VS (which is the spacecraft landing speed) and between the DVS which is the landing speed we want the spacecraft to be at.


### NN
![NN_TIME](https://user-images.githubusercontent.com/74679553/229606159-97c89587-2f37-4c8f-880c-69ba5f37e556.png)

NN is the PID value normalized between 0 and 1, which is the deciding factor for the engine throughput.

### Altitude


![ALT](https://user-images.githubusercontent.com/74679553/229606497-3b353941-205a-422c-9e08-ad3e6355f4ed.png)

We can see the descent rate of the spacecraft on the timeline, we can observe that the landing speed slows down before the landing impact to ensure the integrity of Beresheet.

### HS
![HS](https://user-images.githubusercontent.com/74679553/229606864-bc31d4ed-c140-4781-8cc8-7095e920d5c6.png)

In this graph we can see the horizontal speed of the spacecraft. 
The landing plan was for the HS value to start closing in to 0 once altitude of 2km has been reached.










