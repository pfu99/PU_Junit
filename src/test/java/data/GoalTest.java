package data;

import exceptions.BadFormatGoalException;
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
    public void equalsDiffTest() throws BadFormatGoalException {
        Goal goal1 = new Goal("Get a job");
        Goal goal2 = new Goal("Get a job");
        assertEquals(goal1, goal2);
    }

    @Test
    public void equalsSameTest() throws BadFormatGoalException {
        Goal goal1 = new Goal("Get a job");
        assertEquals(goal1, goal1);
    }

    @Test
    public void notEqualsTest() throws BadFormatGoalException {
        Goal goal1 = new Goal("Get a job");
        Goal goal2 = new Goal("Find a partner");
        assertNotEquals(goal1, goal2);
    }
}
