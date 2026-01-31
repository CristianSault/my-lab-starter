package _03_designing_types._20_constructors;

import java.time.Duration;
import java.time.LocalDateTime;

class Main {

    static void main() {

        // The compiler infers which constructor to call based on the arguments we provide
        var e1 = new Event("Hackathon",
                LocalDateTime.of(2023, 10, 1, 10, 0),
                LocalDateTime.of(2023, 10, 1, 18, 0)
        );

        IO.println(e1.title);

        var e2 = new Event("Conference",
                LocalDateTime.of(2024, 9, 15, 9, 0),
                Duration.ofHours(1)
        );
    }
}
