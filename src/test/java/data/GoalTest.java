package data;

import exceptions.BadFormatGoalException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoalTest {

    @Test
    public void nullGoal() {
        Throwable ex =
                assertThrows(
                        NullPointerException.class,
                        () -> {
                            new Goal(null);
                        });
        assertEquals("Goal code is null.", ex.getMessage());
    }

    @Test
    @DisplayName("Equals on different reference with same values")
    public void equalsDiffTest() throws BadFormatGoalException {
        Goal goal1 = new Goal("Get a job");
        Goal goal2 = new Goal("Get a job");
        assertTrue(goal1.equals(goal2));
    }

    @Test
    @DisplayName("Equals on same reference")
    public void equalsSameTest() throws BadFormatGoalException {
        Goal goal1 = new Goal("Get a job");
        assertTrue(goal1.equals(goal1));
    }

    @Test
    @DisplayName("Equals on different reference with different values")
    public void notEqualsTest() throws BadFormatGoalException {
        Goal goal1 = new Goal("Get a job");
        Goal goal2 = new Goal("Find a partner");
        assertFalse(goal1.equals(goal2));
    }
}