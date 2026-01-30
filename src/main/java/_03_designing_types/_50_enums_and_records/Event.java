package _03_designing_types._50_enums_and_records;

import java.time.LocalDateTime;
import java.util.List;

// Since an event is primarily a data carrier, we can use a record to represent it
public record Event(
        // Record components automatically create private final fields, a constructor, and accessor methods
        String title,
        LocalDateTime start,
        LocalDateTime end,
        List<Service> services
) {
    // No need to manually define constructors or accessor methods in here!

    // But we can still define additional methods if needed

    // Here, we're nesting an enum type inside the record (accessible via Event.Service.XXX)
    static public enum Service {
        WIFI, CATERING, DECORATION, ENTERTAINMENT, SECURITY
    }

    /**
     * @return the duration of the event in minutes
     */
    public long durationInMinutes() {
        return java.time.Duration.between(this.start, this.end).toMinutes();
    }
}
