package _03_designing_types._30_access_modifiers;

import java.time.Duration;
import java.time.LocalDateTime;

// public here makes this class accessible from any other package
public class Event {

    // PRIVATE instance variables
    private String title;
    private LocalDateTime start;
    private LocalDateTime end;

    // PUBLIC constructors so that any other code can create Event objects
    public Event() {
        this.title = "Default";
        this.start = LocalDateTime.now();
        this.end = this.start.plusHours(1);
    }

    public Event(String title, LocalDateTime start, LocalDateTime end) {
        this.title = title;
        this.start = start;
        this.end = end;
    }

    // PUBLIC instance methods

    /**
     * @return the duration of the event
     */
    public Duration duration() {
        return Duration.between(this.start, this.end);
    }

    // PRIVATE method, only accessible within this class
    // This is a bit contrived but serves to illustrate access modifiers
    /**
     * Prints event info to the console for debugging purposes
     */
    private void showInfo() {
        IO.println("Event: %s, Start: %s, End: %s".formatted(title, start, end));
    }
}


