package _03_designing_types._20_constructors;

import java.time.Duration;
import java.time.LocalDateTime;

class Event {

    String title;
    LocalDateTime start;
    LocalDateTime end;

    /**
     * Default constructor
     * @param title The title of the event
     * @param start The event start time
     * @param end The event end time
     */
    Event(String title, LocalDateTime start, LocalDateTime end) {
        this.title = title;
        this.start = start;
        this.end = end;
    }

    /**
     * Creates an event based on a start time and duration
     * @param title The title of the event
     * @param start The event start time
     * @param duration The duration of the event
     */
    Event(String title, LocalDateTime start, Duration duration) {
        this.title = title;
        this.start = start;
        this.end = start.plus(duration);
    }


    /**
     * @return the duration of the event
     */
    Duration duration() {
        return Duration.between(start, end);
    }

    Event copy() {
        return new Event(this.title, this.start, this.end);
    }
}


