package servlets;

public class Times
{
    public String timerName;
    public long totalTime;
    public long weightedAverage;
    public long lastRunTime;
    public long numAccesses;
    public int numPending;

    public static final long NUM_WEIGHTS = 20;

    public Times(String aTimerName)
    {
        timerName = aTimerName;
    }

    public void addTime(long time)
    {
        numAccesses++;
        lastRunTime = time;
        totalTime += time;
        long weight = NUM_WEIGHTS;

        if (numAccesses < NUM_WEIGHTS) weight = numAccesses;

        if (weight > 0)
        {
            weightedAverage = (weightedAverage * (weight-1) +
                    time) / weight;
        }
    }

    public synchronized void begin()
    {
        numPending++;
    }

    public synchronized void end()
    {
        numPending--;
    }

    public String getTimerName() { return timerName; }
    public long getTotalTime() { return totalTime; }
    public long getWeightedAverage() { return weightedAverage; }
    public long getNumAccesses() { return numAccesses; }
    public long getNumPending() { return numPending; }

    /** Return average time converted into seconds */
    public double getAverageTimeSec() {
        return ((double) totalTime) / (1000.0 * (double) numAccesses); }

    /** Return weighted average in seconds */
    public double getWeightedAverageSec() {
        return ((double) weightedAverage) / 1000.0;
    }
  
}

