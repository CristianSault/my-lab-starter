package _03_designing_types._10_basics;

import java.time.LocalDateTime;

public class Main {

    static void main() {
        var e = new Event("Hackathon",
                LocalDateTime.of(2023, 10, 1, 10, 0),
                LocalDateTime.of(2023, 10, 1, 18, 0)
        );

        IO.println("The %s event will be %s hours long".formatted(e.title, e.duration().toHours()));
    }
}
