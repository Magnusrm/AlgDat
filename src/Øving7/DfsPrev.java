package Øving7;

public class DfsPrev extends Prev{
    int foundTime, doneTime;
    static int time;
    static void nullTime() {
        time = 0;
    }
    static int readTime() {
        return time++;
    }
}
