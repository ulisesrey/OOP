package edu.uoc.pac1;

public class PAC1Ex2 {

    private static final double LEVEL_MULTIPLIER = 4.5;
    private static final double[] DIFFICULTY_MULTIPLIER = {1.0, 1.5, 2.5, 5.0};
    private static final int GOLD_BASE = 100;
    public static String ERR_LEVEL = "[ERROR] Invalid level";

    public static boolean isValidLevel(byte level) {
        return level > 0 && level < 100;
    }

    public static boolean isValidDifficulty(byte difficulty) {
        return difficulty >= 0 && difficulty <= 4;
    }


    public static double getMultiplierByDifficulty(byte difficulty) {
        // Multiply difficulty variable by the corresponding variable in DIFICULTY_MULTIPLIER array
        return DIFFICULTY_MULTIPLIER[difficulty-1];
    }

    public static double calculateGold(byte level, byte difficulty) {
        // Add Goldbase and multiply it by the level and the difficulty multiplier
        return GOLD_BASE + level * LEVEL_MULTIPLIER * getMultiplierByDifficulty(difficulty);
    }

    public static void getAchievementsGold(byte level, byte[] difficulties) {
        // Return the sum of the gold for each difficulty
        double totalGold = 0;
        int invalidDifficulties = 0;

        // Return error if level is 0
        if (!isValidLevel(level)) {
            System.out.println(ERR_LEVEL);
            return;
        }

        for (byte difficulty : difficulties) {
            if (isValidDifficulty(difficulty)) {
                totalGold += calculateGold(level, difficulty);
            } else {
                invalidDifficulties++;
            }
        }
        // print the sum of the gold and the number of invalid difficulties
        System.out.println("You have obtained a total of " + totalGold + " gold from " + difficulties.length + " achievements.");
        // print the number of invalid difficulties
        System.out.println(invalidDifficulties + " achievements with invalid difficulties have been detected.");
    }

}
