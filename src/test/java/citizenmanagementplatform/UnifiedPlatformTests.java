package citizenmanagementplatform;

import exceptions.ConnectException;
import exceptions.IncompleteFormException;
import exceptions.IncorrectVerificationException;
import org.junit.jupiter.api.Test;

public class UnifiedPlatformTests {
    @Test
    void testEnterForm() throws IncompleteFormException, IncorrectVerificationException, ConnectException {
        // Create an instance of the UnifiedPlatform class
        UnifiedPlatform platform = new UnifiedPlatform();

        // Create mock objects for the Citizen and Goal parameters
        Citizen mockCitizen = new Citizen();
        Goal mockGoal = Goal.WORKWITHMINORS;

        // Call the enterForm method with the mock objects as parameters
        platform.enterForm(mockCitizen, mockGoal);

        // Assert that the citizen and goal fields in the platform object are set to the mock objects
        assertEquals(mockCitizen, platform.citizen);
        assertEquals(mockGoal, platform.goal);
    }
}
