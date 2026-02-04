package _03_designing_types._50_enums_and_records;

import java.text.ParseException;

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

    /**
     * Parses a string into a Direction value.
     * @param directionString The string to parse
     * @return The Direction value corresponding to the given string
     * @throws ParseException If the given string is not a valid representation for a Direction
     */
    public static Direction parse(String directionString) throws ParseException {
        return switch(directionString.toLowerCase()) {
            case "n", "north" -> NORTH;
            case "e", "east" -> EAST;
            case "s", "south" -> SOUTH;
            case "w", "west" -> WEST;
            default -> throw new ParseException("'%s' is not a valid direction string".formatted(directionString), 0);
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
