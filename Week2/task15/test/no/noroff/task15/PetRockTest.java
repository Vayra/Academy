package no.noroff.task15;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

class PetRockTest {
    PetRock rocky;

    @BeforeEach
    public void setUp() {
       rocky = new PetRock("Rocky");
    }

    @Test
    void getName() {
        assertEquals("Rocky",rocky.getName());
    }

    @Test
    void testUnhappyToStart() {
        assertFalse(rocky.isHappy());
    }

    @Test
    void testHappyAfterPlay() {
        rocky.playWithRock();
        assertTrue(rocky.isHappy());
    }

    @Disabled("Ignore this test")
    @Test
    void happyFail() {
        assertThrows(IllegalStateException.class,
                () -> rocky.printHappyMessage(),
                "Expected printHappyMessage() to throw IllegalStateException, but it didn't");

    }
    @Test
    void happyPass() {
        rocky.playWithRock();
        String msg = rocky.printHappyMessage();
        assertEquals("I'm happy!", msg);
    }

    @Test
    void testFavNum() {
        assertEquals(42, rocky.getFavNumber());
    }

    @Test
    void emptyNameFail() {
        assertThrows(IllegalArgumentException.class,
                () -> new PetRock(""),
                "Expected IllegalArgumentException");

    }

    @Test
    void waitForHappyTimeout() {
        assertTimeoutPreemptively(ofSeconds(1),
                () -> rocky.waitTillHappy(),
                () -> "Assertion failed");
    }
}

