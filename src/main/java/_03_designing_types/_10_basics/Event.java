package _03_designing_types._10_basics;

import java.time.Duration;
import java.time.LocalDateTime;

class Event {

    // Instance variables
    String title;
    LocalDateTime start;
    LocalDateTime end;

    // Constructor
    Event(String title, LocalDateTime start, LocalDateTime end) {
        this.title = title;
        this.start = start;
        this.end = end;
    }

    // Instance methods

    /**
     * @return the duration of the event
     */
    Duration duration() {
        return Duration.between(start, end);
    }
}


