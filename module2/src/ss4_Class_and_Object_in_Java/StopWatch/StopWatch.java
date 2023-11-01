package ss4_Class_and_Object_in_Java.StopWatch;

import java.time.LocalTime;

public class StopWatch {
    private LocalTime startTime, endTime;

    public StopWatch() {
    }

    public StopWatch(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public long start() {
        return System.currentTimeMillis();
    }

    public long stop() {
        return System.currentTimeMillis();
    }

    public long getElapsedTime(long start, long end) {
        long miliSecond = end - start;
        return miliSecond;
    }

    @Override
    public String toString() {
        return "StopWatch{" +
                "startTime=" + getStartTime() +
                ", endTime=" + getEndTime() +
                '}';
    }
}

