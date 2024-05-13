import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonopolyTest {
    @Mock
    Monopoly player;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize annotated mocks
    }

    @Test
    public void when_die_rolls_are_1_and_2_current_position_should_advance_to_3(){
        // Mocking the behavior of throwDie() method
        when(player.throwDie()).thenReturn(1, 2);

        // Calling advance method and asserting the result
        assertEquals(3, player.advance());
    }

    @Test
    public void when_die_rolls_are_3_and_3_advance_should_be_called_again_and_when_1_and_3_are_rolled_current_position_should_be_updated_to_10(){
        // Mocking the behavior of throwDie() method
        when(player.throwDie()).thenReturn(3, 3, 1, 3);

        // Calling advance method twice and asserting the result
        assertEquals(6, player.advance()); // After the first throw of 3 and 3
        assertEquals(10, player.advance()); // After the second throw of 1 and 3
    }
}
