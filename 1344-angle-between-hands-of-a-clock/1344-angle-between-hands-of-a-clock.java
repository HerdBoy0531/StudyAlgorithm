import java.util.*;

class Solution {
    public double angleClock(int hour, int minutes) {
        // double resAngle = 0;

        // hour %= 12;
        // double angleMin = 0;
        // double angleReMin = 0;

        // double angleHour = minutes / 2;
        // double angleReHour = 30.0 - angleHour;

        // if(minutes/5 > hour) {
        //     angleMin = (minutes/5 - hour) * 30;
        //     angleReMin = 360 - angleMin;
        //     if(angleMin < angleReMin) {
        //         resAngle = (minutes % 5) * 6 - angleHour + angleMin;
        //     } else if(angleMin > angleReMin) {
        //         resAngle = angleHour - (minutes % 5) + angleReMin;
        //     }

        // } else if(minutes/5 < hour){
        //     angleMin = (hour - minutes/5) * 30;
        //     angleReMin = 360 - angleMin;

        //     if(angleMin < angleReMin) {
        //         resAngle = angleHour - (minutes % 5) + angleReMin;
        //     } else if(angleMin > angleReMin) {
        //         resAngle = (minutes % 5) * 6 - angleHour + angleMin;
        //     }
        // } else {
        //     angleMin = (minutes % 5) * 6;
        //     if(angleMin > angleHour) {
        //         resAngle = angleMin - angleHour;
        //     } else {
        //         resAngle = angleHour - angleMin;
        //     }
        // }

        // return resAngle;
        double hourAngle = (hour % 12) * 30 + minutes * 0.5;
        double minuteAngle = minutes * 6;

        double diff = Math.abs(hourAngle - minuteAngle);

        return Math.min(diff, 360 - diff);
    }
}