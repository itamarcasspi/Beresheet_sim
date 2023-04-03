# Report Of Bereshit Landing
## In the following report we will see the failures according to critical time points, when everything starts with this representative landing process through tables.



| Altitude | Vertical Speed | Horizontal Speed |  Fuel  |
| -------- | -------------- | ---------------- | -------| 
| 24,176            | 31.2         | 1658.2        | 122.06  |       

This point in time is a point where we start the landing process, which is quite a complex process and also the time when most of the problems started to appear.

At this time, all the engines are working as they should, and there is also a navigation control software on board the spacecraft that uses starlight so that the spacecraft will know its position in space.
***


| Altitude | Vertical Speed | Horizontal Speed |  Fuel  |
| -------- | -------------- | ---------------- | -------| 
| 13,723            | 24.8         | 930.4        | 121.06  |

 At this stage, the IMU2 of the spacecraft, the IMU2 itself is a device that measures the direction, speed and acceleration of the spacecraft, one of the controllers that was on the spacecraft is responsible for managing the data that the IMU itself produces and making sure that they are accurate. This controller usually includes sensors Such as gyroscopes, accelerometers and magnetometers, which provide data on the spacecraft's direction and movement, and then process this data and use it to know the spacecraft's position and speed relative to the environment it is in.

Overall, this controller plays a critical role in the success of spacecraft missions by providing accurate and reliable data on the spacecraft's direction and movement. When this happens during the landing phase, when the need for the controller is increased and there is no system to back up the controller, it can cause a serious problem. Even to failures.
***


| Altitude | Vertical Speed | Horizontal Speed | Fuel   |
| -------- | -------------- | ---------------- | ------ |
| 13,350   | 24.8           | 901.7            | 118.06 |

 At this stage there was an attempt to turn on the same IMU2 again, which caused a failure after turning on the IMU1, the second accelerometer that was in the spacecraft. Because only one of the IMUs stopped working, the transfer of information from the accelerometer was stopped. And for less than a second the computer did not receive acceleration data.

***
| Altitude | Vertical Speed | Horizontal Speed | Fuel   |
| -------- | -------------- | ---------------- | ------ |
| 10,997   | 47.9           | 880,2            | 105.06 |

At this point it appears that the vertical velocity is starting to increase faster than expected, indicating that the main engine has probably shut down.

***

| Altitude | Vertical Speed | Horizontal Speed | Fuel  |
| -------- | -------------- | ---------------- | ----- |
| 7079     | 89.3           | 911.9            | 93.06 |

At this stage, according to the data, the vertical speed increased and the horizontal speed increased right from the previous time point, which definitely indicates that the main engine is shut down, and the spacecraft are losing altitude quickly.

***

| Altitude | Vertical Speed | Horizontal Speed | Fuel |
| -------- | -------------- | ---------------- | ---- |
| 5012     | 104.4          | 923.9            | 89.6 |

At this point, the system was rebooted to try to restart the main engine, the spacecraft is at an altitude of 5 kilometers above the moon surface, the spacecraft velocity is really high, and there is  nothing that can stop it.

***

| Altitude | Vertical Speed | Horizontal Speed | Fuel  |
| -------- | -------------- | ---------------- | ----- |
| 678      | 130.1          | 948.9            | 77.06 |

The main engine is back on. But because the height from the surface of the moon was too low relative to the speed of the spacecraft then a crash was inevitable.

***

| Altitude | Vertical Speed | Horizontal Speed | Fuel  |
| -------- | -------------- | ---------------- | ----- |
| 149      | 134.1          | 946.7            | 76.06 |

This is the last stage in which the spaceship was able to get information out right before the crash. You can see that the engine started working again because the horizontal speed decreased slightly, but it was too late.



***

# In conclusion 

The crashing of this spacecraft was a combination of human failures and technical failures and the main factors are:

1. Communication failure: During the landing, the spacecraft communication system malfunctioned.
2. Navigation error:  The spacecraft's navigation system failed to detect its increasing speed and altitude, that's cause lost the spacecraft orientation.
3. Lack of redundancy:  Because this project was budged with only 100 million dollars which is low budged for space missions, there was no backup computer, and any seconds counts in this terms, and the engine had a single point of failure.

Although, trying to land Bereshit on the moon is achievement, only by trying to do that and we almost made it.

We are really optimistic about the next try of space-IL to land Bereshit-2 on the moon.



Main Sources: 

* https://www.youtube.com/watch?v=HMdUcchBYRA&t=1612s
* https://davidson.weizmann.ac.il/online/sciencepanorama/%D7%92%D7%99%D7%9C%D7%95%D7%99%D7%99%D7%9D-%D7%97%D7%93%D7%A9%D7%99%D7%9D-%D7%A2%D7%9C-%D7%91%D7%A8%D7%90%D7%A9%D7%99%D7%AA



