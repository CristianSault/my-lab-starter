import static java.lang.IO.*;
import static java.lang.Math.random;
//  Make an array containing special Strings for later use
String[] AsciiStrings = {
        """
        ════════════════════════════════════════
           _____ _ ____                ______          __\s
          / ___/(_) / /_  __          /_  __/__  _____/ /_
          \\__ \\/ / / / / / /           / / / _ \\/ ___/ __/
         ___/ / / / / /_/ /           / / /  __(__  ) /_ \s
        /____/_/_/_/\\__, /           /_/  \\___/____/\\__/ \s
                   /____/                                 \s
        
        ════════════════════════════════════════""",
        """
        ================================================================
        
           ___                  _   _                 _
          / _ \\ _   _  ___  ___| |_(_) ___  _ __    / |
         | | | | | | |/ _ \\/ __| __| |/ _ \\| '_ \\   | |
         | |_| | |_| |  __/\\__ \\ |_| | (_) | | | |  | |
          \\__\\_\\\\__,_|\\___||___/\\__|_|\\___/|_| |_|  |_|
        
        ================================================================
        """,
        """
        ================================================================
        
           ___                  _   _                 ____
          / _ \\ _   _  ___  ___| |_(_) ___  _ __    |___ \\
         | | | | | | |/ _ \\/ __| __| |/ _ \\| '_ \\     __) |
         | |_| | |_| |  __/\\__ \\ |_| | (_) | | | |   / __/
          \\__\\_\\\\__,_|\\___||___/\\__|_|\\___/|_| |_|  |_____|
        
        ================================================================
        """,
        """
        ================================================================
        
           ___                  _   _                 _____
          / _ \\ _   _  ___  ___| |_(_) ___  _ __    |___ /
         | | | | | | |/ _ \\/ __| __| |/ _ \\| '_ \\     |_ \\
         | |_| | |_| |  __/\\__ \\ |_| | (_) | | | |   ___) |
          \\__\\_\\\\__,_|\\___||___/\\__|_|\\___/|_| |_|  |____/
        
        ================================================================""",
        """
        ================================================================
        
           ___                  _   _                 _  _
          / _ \\ _   _  ___  ___| |_(_) ___  _ __    | || |
         | | | | | | |/ _ \\/ __| __| |/ _ \\| '_ \\   | || |_
         | |_| | |_| |  __/\\__ \\ |_| | (_) | | | |  |__   _|
          \\__\\_\\\\__,_|\\___||___/\\__|_|\\___/|_| |_|     |_|
        
        ================================================================""",
        """
        ================================================================
        
           ___                  _   _                 ____
          / _ \\ _   _  ___  ___| |_(_) ___  _ __    | ___|
         | | | | | | |/ _ \\/ __| __| |/ _ \\| '_ \\   |___ \\
         | |_| | |_| |  __/\\__ \\ |_| | (_) | | | |   ___) |
          \\__\\_\\\\__,_|\\___||___/\\__|_|\\___/|_| |_|  |____/
        
        ================================================================""",
        """
        ================================================================
        
           ___                  _   _                  __
          / _ \\ _   _  ___  ___| |_(_) ___  _ __     / /_
         | | | | | | |/ _ \\/ __| __| |/ _ \\| '_ \\   | '_ \\
         | |_| | |_| |  __/\\__ \\ |_| | (_) | | | |  | (_) |
          \\__\\_\\\\__,_|\\___||___/\\__|_|\\___/|_| |_|   \\___/
        
        ================================================================""",
        """
        ================================================================
        
           ___                  _   _                 _____
          / _ \\ _   _  ___  ___| |_(_) ___  _ __    |___  |
         | | | | | | |/ _ \\/ __| __| |/ _ \\| '_ \\      / /
         | |_| | |_| |  __/\\__ \\ |_| | (_) | | | |    / /
          \\__\\_\\\\__,_|\\___||___/\\__|_|\\___/|_| |_|   /_/
        
        ================================================================""",
        """
        ================================================================
        
           ___                  _   _                  ___
          / _ \\ _   _  ___  ___| |_(_) ___  _ __     ( _ )
         | | | | | | |/ _ \\/ __| __| |/ _ \\| '_ \\    / _ \\
         | |_| | |_| |  __/\\__ \\ |_| | (_) | | | |  | (_) |
          \\__\\_\\\\__,_|\\___||___/\\__|_|\\___/|_| |_|   \\___/
        
        ================================================================""",
        """
        ================================================================
        
           ___                  _   _                  ___
          / _ \\ _   _  ___  ___| |_(_) ___  _ __     / _ \\
         | | | | | | |/ _ \\/ __| __| |/ _ \\| '_ \\   | (_) |
         | |_| | |_| |  __/\\__ \\ |_| | (_) | | | |   \\__, |
          \\__\\_\\\\__,_|\\___||___/\\__|_|\\___/|_| |_|     /_/
        
        ================================================================""",
        """
        ================================================================
        
           ___                  _   _                 _  ___
          / _ \\ _   _  ___  ___| |_(_) ___  _ __    / |/ _ \\
         | | | | | | |/ _ \\/ __| __| |/ _ \\| '_ \\   | | | | |
         | |_| | |_| |  __/\\__ \\ |_| | (_) | | | |  | | |_| |
          \\__\\_\\\\__,_|\\___||___/\\__|_|\\___/|_| |_|  |_|\\___/
        
        ================================================================"""};

/**
 * First util function of the lab. It serves as a "pause" screen in between questions.
 * It simply clears the console screen by printing newlines multiple times
 * and prints another string from a pool of possible strings to later clear again.
 */
void clear() {
    String[] msgPool = {"Did you get it right?", "Are you sure about that?",
            "What if it was actually option C?", "Feeling curious?",
            "I think it was B actually but I might be wrong...", "Did you know about this before?"};
    print("\n".repeat(50));
    println(msgPool[(int)(random()*6)]);
    try {
        wait(5000);
    } catch (InterruptedException e) {
        println("Something went wrong while waiting...");
        throw new RuntimeException(e);
    }
    print("\n".repeat(50));
}

/**
 * Second util function of the lab.
 * It prints a repetitive cycle of the question sequence while also taking user input to determine
 * whether an answer is correct or not.
 *
 * @param cAnswers a counter for correct answers
 * @param icAnswers a counter for incorrect answers
 * @return a byte array with the updated results for each counter
 */
byte[] questionSequence(byte cAnswers, byte icAnswers) {
    println(AsciiStrings[1] + "\n");
    println("What is the divine proportion?");
    var options = new LinkedHashMap<String, String>();
    options.put("A", "The divine proportion is the exact ratio of cheese to pepperoni that makes a pizza truly transcendent.\n" +
            "  \tScientists estimate it to be roughly 3.14 slices per person (though some argue this is actually π in disguise)");
    options.put("B", "An irrational number related to the Fibonacci sequence that is unique both in Mathematics and in nature");
    options.put("C", "The divine proportion is the mathematical constant (approximately 1.618) that represents the ratio of a\n" +
            "  \tcircle's circumference to its radius");
    options.put("D", "The divine proportion is the result of the equation φ = (1 + √5) / 3, which equals approximately 1.618");
    for (Map.Entry<String, String> entry : options.entrySet()) {
        println(entry.getKey() + ":\t" + entry.getValue());
    }
    String usr_in = readln("Select one option. (A/B/C/D)\n");
    if (usr_in.equals("B"))  {cAnswers++;} else {icAnswers++;}
    clear();

    println(AsciiStrings[2] + "\n");
    println("Follow up question. Which is the golden angle?");
    options = new LinkedHashMap<>();
    options.put("A", "123°");
    options.put("B", "224°");
    options.put("C", "222.5°");
    options.put("D", "137.5°");
    for (Map.Entry<String, String> entry : options.entrySet()) {
        println(entry.getKey() + ":\t" + entry.getValue());
    }
    usr_in = readln("Select one option. (A/B/C/D)\n");
    if (usr_in.equals("D"))  {cAnswers++;} else {icAnswers++;}
    clear();

    println(AsciiStrings[3] + "\n");
    println("How do you call a one-sided and a two-sided geometric shape?");
    options = new LinkedHashMap<>();
    options.put("A", "1-gon and 2-gon");
    options.put("B", "A unilateral flatoid and a duolateral surface");
    options.put("C", "Monogon and Digon");
    options.put("D", "A solo-dimensional figure and a bilateral planoid");
    for (Map.Entry<String, String> entry : options.entrySet()) {
        println(entry.getKey() + ":\t" + entry.getValue());
    }
    usr_in = readln("Select one option. (A/B/C/D)\n");
    if (usr_in.equals("A") || usr_in.equals("C"))  {cAnswers++;} else {icAnswers++;}
    clear();

    println(AsciiStrings[4] + "\n");
    println("Where do Monogons and Digons exist?");
    options = new LinkedHashMap<>();
    options.put("A", "Euclidean Geometry");
    options.put("B", "Newtonian Geometry");
    options.put("C", "Spherical Geometry");
    options.put("D", "In the fourth dimension, where they can be visualized but not drawn in our 3D world");
    for (Map.Entry<String, String> entry : options.entrySet()) {
        println(entry.getKey() + ":\t" + entry.getValue());
    }
    usr_in = readln("Select one option. (A/B/C/D)\n");
    if (usr_in.equals("C"))  {cAnswers++;} else {icAnswers++;}
    clear();

    println(AsciiStrings[5] + "\n");
    println("What is theorized to be found at the center of a black hole?");
    options = new LinkedHashMap<>();
    options.put("A", "Singularity");
    options.put("B", "Ringularity");
    options.put("C", "A tiny white hole that spits matter out into a parallel universe");
    options.put("D", "A quantum foam structure where space-time exists in a superposition of states,\n" +
            "  \tallowing information to be preserved");
    for (Map.Entry<String, String> entry : options.entrySet()) {
        println(entry.getKey() + ":\t" + entry.getValue());
    }
    usr_in = readln("Select one option. (A/B/C/D)\n");
    if (usr_in.equals("A") || usr_in.equals("B"))  {cAnswers++;} else {icAnswers++;}
    clear();

    println(AsciiStrings[6] + "\n");
    println("How long does it take for a black hole to vanish?");
    options = new LinkedHashMap<>();
    options.put("A", "Approximately 10-15 billion years, roughly matching the current age of the universe");
    options.put("B", "Trillions upon trillions of years - far exceeding the current age of the universe");
    options.put("C", "Between 1,000 to 1 million years depending on the black hole's initial mass");
    options.put("D", "Black holes never truly vanish - they reach a minimum stable size and persist indefinitely\n" +
            "  \tas Planck-mass remnants");
    for (Map.Entry<String, String> entry : options.entrySet()) {
        println(entry.getKey() + ":\t" + entry.getValue());
    }
    usr_in = readln("Select one option. (A/B/C/D)\n");
    if (usr_in.equals("B"))  {cAnswers++;} else {icAnswers++;}
    clear();

    println(AsciiStrings[7] + "\n");
    println("What makes a black hole \"shrink\" in size?");
    options = new LinkedHashMap<>();
    options.put("A", "Dark energy expansion counteracts the black hole's gravity, causing it to\n" +
            "  \tgradually evaporate from the outside in");
    options.put("B", "The intense gravitational pressure at the center compresses the black hole's\n" +
            "  \tmass, causing it to contract over time");
    options.put("C", "In quantum mechanics, particle-antiparticle pairs constantly pop into existence and annihilate each other in empty space.\n" +
            "  \tNear a black hole's event horizon, one particle can fall in while the other escapes, this process is known as Hawking radiation");
    options.put("D", "As the black hole accretes matter, conservation of angular momentum causes it\n" +
            "  \tto spin faster and flatten, reducing its diameter");
    for (Map.Entry<String, String> entry : options.entrySet()) {
        println(entry.getKey() + ":\t" + entry.getValue());
    }
    usr_in = readln("Select one option. (A/B/C/D)\n");
    if (usr_in.equals("C"))  {cAnswers++;} else {icAnswers++;}
    clear();

    println(AsciiStrings[8] + "\n");
    println("Which animal is able to live in extreme conditions such as extreme cold, extreme heat\n" +
            "and even outer space?");
    options = new LinkedHashMap<>();
    options.put("A", "Cockroache");
    options.put("B", "Brine shrimp");
    options.put("C", "Tardigrade");
    options.put("D", "Antarctic krill");
    for (Map.Entry<String, String> entry : options.entrySet()) {
        println(entry.getKey() + ":\t" + entry.getValue());
    }
    usr_in = readln("Select one option. (A/B/C/D)\n");
    if (usr_in.equals("C"))  {cAnswers++;} else {icAnswers++;}
    clear();

    println(AsciiStrings[9] + "\n");
    println("Which animal is considered to be a living fossil closely related to dinosaurs\n" +
            "that roams the Earth to this day?");
    options = new LinkedHashMap<>();
    options.put("A", "Horseshoe crab");
    options.put("B", "Komodo dragon");
    options.put("C", "Cassowary");
    options.put("D", "Alligator");
    for (Map.Entry<String, String> entry : options.entrySet()) {
        println(entry.getKey() + ":\t" + entry.getValue());
    }
    usr_in = readln("Select one option. (A/B/C/D)\n");
    if (usr_in.equals("C"))  {cAnswers++;} else {icAnswers++;}
    clear();

    println(AsciiStrings[10] + "\n");
    println("What country has the most amount of languages spoken within it?");
    options = new LinkedHashMap<>();
    options.put("A", "China");
    options.put("B", "India");
    options.put("C", "Indonesia");
    options.put("D", "Papua New Guinea");
    for (Map.Entry<String, String> entry : options.entrySet()) {
        println(entry.getKey() + ":\t" + entry.getValue());
    }
    usr_in = readln("Select one option. (A/B/C/D)\n");
    if (usr_in.equals("D"))  {cAnswers++;} else {icAnswers++;}
    clear();

    return new byte[]{cAnswers, icAnswers};
}

/**
 * Final util function of this lab.
 * It prints the final results for the test to the console.
 *
 * @param res a byte array passed by the @questionSequence function.
 */
void testResults(byte[] res){
    try (FileWriter f = new FileWriter("test_results.txt")) {
        f.write("Here are your results for the Silly Test®.\n\n");
        f.write("Correct answers: " + res[0] + "\n");
        f.write("Incorrect answers: " + res[1] + "\n");
        f.write("Verdict: " + res[0] + "/10");
    } catch (IOException io) {
        println("Encountered an exception when writing the file.");
        println(io);
    }
}

void main() {
//  Put everything in a loop to keep trying the test until the user chooses to exit.
    while (true) {
        //  First ask to continue
        String usr_input = readln("Would you like to exit? (Y/N): ");
        if (usr_input.equals("Y")) {break;}
        //  Begin printing the title and initial msg
        println(AsciiStrings[0] + "\n");
        println("Welcome to the Silly Test!\nTry to get as many questions right as you possibly can!\nAre you ready?\n");
        // Begin the questions and keep track of correct answers
        byte correctAnswers = 0;
        byte notCorrectAnswers = 0;
        byte[] results = questionSequence(correctAnswers, notCorrectAnswers);
        // Write results to a file in some carpet
        testResults(results);
    }
}