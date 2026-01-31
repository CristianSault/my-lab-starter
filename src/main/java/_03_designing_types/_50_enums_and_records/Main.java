package _03_designing_types._50_enums_and_records;

import java.time.LocalDateTime;
import java.util.List;

// Since enum values are just class variables that are instances of their own type,
// we can do a static import to allow us to refer to them without qualifying with the enum type name.
import static _03_designing_types._50_enums_and_records.Event.Service.*;

public class Main {

    static void main() {
        var event = new Event(
                "Conference",
                LocalDateTime.of(2024, 9, 15, 9, 0),
                LocalDateTime.of(2024, 9, 15, 17, 0),
                List.of(WIFI) // OR if we hadn't done the static import above: .of(Event.Service.WIFI)
        );

        var d = Direction.random();
        var n = Direction.NORTH;
        IO.println("Random direction: %s, opposite of %s is %s".formatted(d, n, n.opposite()));
    }
}
