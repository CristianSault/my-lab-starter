package _03_designing_types._50_enums_and_records;

public enum Direction {

    NORTH, EAST, SOUTH, WEST; // The semicolon here is necessary only if you add other members to the enum type.

    // You can also add other members to an enum type as usual!
    // NOTE: if you do, the enum values must be defined first, before any other members,
    //       AND they must be terminated with a semicolon (;)

    /**
     * @return the opposite direction
     */
    public Direction opposite() {
        return switch (this) {
            case NORTH -> SOUTH;
            case EAST -> WEST;
            case SOUTH -> NORTH;
            case WEST -> EAST;
        };
    }

    // Class (static) members can work too...
    public static Direction random() {
        // FYI, the values() method is automatically provided for all enum types
        // It returns an array of all enum values in the order they were defined
        var values = values();
        var index = (int) (Math.random() * values.length);
        return values[index];
    }
}
