package _03_designing_types._20_constructors;

class ConstructorsVsNoConstructors {

    static class Point__NO_CONSTRUCTOR {
        int x;
        int y;
    }

    static class Point__ONE_CONSTRUCTOR {
        int x;
        int y;

        Point__ONE_CONSTRUCTOR(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Point__TWO_CONSTRUCTORS {
        int x;
        int y;

        // Parameterless constructor
        Point__TWO_CONSTRUCTORS() {
            this.x = 0;
            this.y = 0;
        }

        // Constructor with parameters
        Point__TWO_CONSTRUCTORS(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void main() {
        // A parameterless constructor is provided by default
        // We did not define one ourselves, but we can still create instances
        var p1 = new Point__NO_CONSTRUCTOR();
        p1.x = 10;
        p1.y = 20;

        // We defined a constructor, so the default parameterless
        // constructor is not provided
        var p2a = new Point__ONE_CONSTRUCTOR(10, 20);
        // var p2b = new Point__ONE_CONSTRUCTOR(); // This would be a compile-time error

        // We defined both a parameterless constructor and a parameterized one
        // so we can create instances either way
        var p3a = new Point__TWO_CONSTRUCTORS();
        var p3b = new Point__TWO_CONSTRUCTORS(10, 20);
    }
}
