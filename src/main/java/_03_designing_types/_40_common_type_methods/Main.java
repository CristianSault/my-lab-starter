package _03_designing_types._40_common_type_methods;

import java.time.LocalDateTime;

public class Main {
    static void main() {

        var e = new Event("Hackathon",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(8)
        );

        var e2 = new Event("Hackathon",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(8)
        );

        if ( e.equals(e2) ) {

        }

        IO.println("KSDJFKS DFKJS DKSDFKS FDJSFD" + e);
    }
}
