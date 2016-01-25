/*
 * Copyright (c) 2016 Kyle Laker
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

/**
 * Simple timer most useful for checking how long a series of statements takes
 * to execute.
 *
 * @author Kyle Laker
 * @version 20160124
 */
public class Timer {
    private long startTime;
    private long endTime;

    private boolean hasBeenStarted;
    private boolean hasBeenEnded;

    /** Start the timer */
    public void start() {
        this.startTime = System.currentTimeMillis();
        this.hasBeenStarted = true;
    }

    /** End the timer */
    public void end() {
        this.endTime = System.currentTimeMillis();
        this.hasBeenEnded = true;
    }

    /**
     * Provides the current duration of the timer.
     *
     * @return Difference of current time and start time if the timer has been
     * started but not ended, difference of end time and start time if timer has
     * been started and ended, 0 otherwise
     */
    public long currentDuration() {
        if (hasBeenStarted && hasBeenEnded) return totalDuration();
        if (hasBeenStarted) return System.currentTimeMillis() - startTime;
        return 0L;
    }

    /**
     * Provides the duration from calling of start() to end().
     *
     * @return If the timer has been started and ended, provides the duration
     * from when the timer was started to when the timer was ended; otherwise
     * provides the current duration
     */
    public long totalDuration() {
        return (hasBeenStarted && hasBeenEnded)
            ? endTime - startTime
            : currentDuration();
    }

    /**
     * Provides a String of the form "Execution took XXXms to complete." where
     * XXX is the total duration of the timer.
     *
     * @return A String of the form "Execution took XXXms to complete." where
     * XXX is the total duration of the timer
     */
    @Override
    public String toString() {
        return "Execution took " + totalDuration() + "ms to complete.";
    }
}
