package edu.uoc.pac1;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class PAC1Ex2Test {

    private ByteArrayOutputStream outContent;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testIsValidLevel() {
        assertFalse(PAC1Ex2.isValidLevel((byte) 0));
        assertFalse(PAC1Ex2.isValidLevel((byte) 100));
        assertFalse(PAC1Ex2.isValidLevel((byte) -1));
        assertTrue(PAC1Ex2.isValidLevel((byte) 50));
        assertTrue(PAC1Ex2.isValidLevel((byte) 99));
        assertTrue(PAC1Ex2.isValidLevel((byte) 1));
    }

    @Test
    public void testIsValidDifficulty() {
        assertFalse(PAC1Ex2.isValidDifficulty((byte) 0));
        assertFalse(PAC1Ex2.isValidDifficulty((byte) 5));
        assertFalse(PAC1Ex2.isValidDifficulty((byte) -1));
        assertTrue(PAC1Ex2.isValidDifficulty((byte) 1));
        assertTrue(PAC1Ex2.isValidDifficulty((byte) 4));
        assertTrue(PAC1Ex2.isValidDifficulty((byte) 2));
    }

    @Test
    public void testGetMultiplierByDifficulty() {
        assertEquals(1.0, PAC1Ex2.getMultiplierByDifficulty((byte) 1));
        assertEquals(1.5, PAC1Ex2.getMultiplierByDifficulty((byte) 2));
        assertEquals(2.5, PAC1Ex2.getMultiplierByDifficulty((byte) 3));
        assertEquals(5.0, PAC1Ex2.getMultiplierByDifficulty((byte) 4));
    }

    @Test
    public void testCalculateGold() {
        assertEquals(104.5, PAC1Ex2.calculateGold((byte) 1, (byte) 1));
        assertEquals(235.0, PAC1Ex2.calculateGold((byte) 30, (byte) 1));
        assertEquals(437.5, PAC1Ex2.calculateGold((byte) 50, (byte) 2));
        assertEquals(943.75, PAC1Ex2.calculateGold((byte) 75, (byte) 3));
        assertEquals(1900.0, PAC1Ex2.calculateGold((byte) 80, (byte) 4));
        assertEquals(2327.5, PAC1Ex2.calculateGold((byte) 99, (byte) 4));
    }

    @Test
    public void testGetAchievementsGold() {
        PAC1Ex2.getAchievementsGold((byte) 0, new byte[]{1, 2, 3, 4});
        assertEquals(PAC1Ex2.ERR_LEVEL + System.lineSeparator(), outContent.toString());

        outContent.reset();

        PAC1Ex2.getAchievementsGold((byte) 1, new byte[]{1, 2, 3, 4});
        assertEquals("You have obtained a total of 445.0 gold from 4 achievements." + System.lineSeparator() + "0 achievements with invalid difficulties have been detected." + System.lineSeparator(), outContent.toString());

        outContent.reset();

        PAC1Ex2.getAchievementsGold((byte) 30, new byte[]{4, 4, 3, 4});
        assertEquals("You have obtained a total of 2762.5 gold from 4 achievements." + System.lineSeparator() + "0 achievements with invalid difficulties have been detected." + System.lineSeparator(), outContent.toString());

        outContent.reset();

        PAC1Ex2.getAchievementsGold((byte) 50, new byte[]{1, 2, 3, 4, 5});
        assertEquals("You have obtained a total of 2650.0 gold from 4 achievements." + System.lineSeparator() + "1 achievements with invalid difficulties have been detected." + System.lineSeparator(), outContent.toString());

        outContent.reset();

        PAC1Ex2.getAchievementsGold((byte) 75, new byte[]{1, 1, 3, 3, 4, 4, 1, 2, 3});
        assertEquals("You have obtained a total of 8325.0 gold from 9 achievements." + System.lineSeparator() + "0 achievements with invalid difficulties have been detected." + System.lineSeparator(), outContent.toString());

        outContent.reset();

        PAC1Ex2.getAchievementsGold((byte) 99, new byte[]{1, 1, 3, -1, 3, 4, 5, 4, 1, 6, 2, 3, 8});
        assertEquals("You have obtained a total of 10701.0 gold from 9 achievements." + System.lineSeparator() + "4 achievements with invalid difficulties have been detected." + System.lineSeparator(), outContent.toString());
    }

}
