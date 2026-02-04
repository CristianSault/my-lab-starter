package _03_designing_types._40_common_type_methods;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Event {

    private String title;
    private LocalDateTime start;
    private LocalDateTime end;

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

    // COPY CONSTRUCTOR
    // This is a common method that creates a new instance by copying an existing one
    /**
     * Creates a copy of the given Event
     * @param other The Event to copy
     */
    public Event(Event other) {
        this.title = other.title;
        this.start = other.start;
        this.end = other.end;
    }

    /**
     * @return the duration of the event
     */
    public Duration duration() {
        return Duration.between(this.start, this.end);
    }

    // GETTERS AND SETTERS
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    // The equals method is used to compare two objects for equality
    // Note that the parameter is of type Object (NOT Event--if it was, we couldn't compare with objects of other types)
    public boolean equals(Object other) {
        // First check if the object is null, or of a different type
        // If it is, they can't be equal
        if (other == null || getClass() != other.getClass()) return false;

        // Now we know 'other' is an Event, so we can safely cast it
        Event otherEvent = (Event) other;
        // Now that we have a true Event object, we can compare the relevant fields for equality
        // (We have access ot the private fields of otherEvent because we are inside the Event class)
        return title.equals(otherEvent.title) && start.equals(otherEvent.start) && end.equals(otherEvent.end);
    }

    public int hashCode() {
        return Objects.hash(title, start, end);
    }

    // The toString method is used to provide a string representation of the object
    // Java automatically calls this method when you try to print the object
    public String toString() {
        return "Event: %s, starts at %s and ends at %s".formatted(title, start, end);
    }
}


