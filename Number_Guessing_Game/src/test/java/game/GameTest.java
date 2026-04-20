package game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Unit Tests — Number Guessing Game
 * ===================================
 * Run with Maven:  mvn test
 * Run with Gradle: gradle test
 */
class GameTest {

    // ── Difficulty tests ─────────────────────────────────────────────────────
    @Test
    void testAllDifficultiesExist() {
        assertEquals(4, Difficulty.values().length);
    }

    @Test
    void testDifficultyRangesArePositive() {
        for (Difficulty d : Difficulty.values()) {
            assertTrue(d.getMaxNumber()   > 0, d.getName() + " maxNumber must be > 0");
            assertTrue(d.getMaxAttempts() > 0, d.getName() + " maxAttempts must be > 0");
        }
    }

    @Test
    void testEasyDifficulty() {
        Difficulty easy = Difficulty.EASY;
        assertEquals("Easy", easy.getName());
        assertEquals(20,     easy.getMaxNumber());
        assertEquals(8,      easy.getMaxAttempts());
    }

    @Test
    void testExpertDifficulty() {
        Difficulty expert = Difficulty.EXPERT;
        assertEquals("Expert", expert.getName());
        assertEquals(500,      expert.getMaxNumber());
        assertEquals(12,       expert.getMaxAttempts());
    }

    // ── ScoreTracker tests ───────────────────────────────────────────────────
    @Test
    void testInitialScoresAreZero() {
        ScoreTracker st = new ScoreTracker();
        assertEquals(0, st.getPlayed());
        assertEquals(0, st.getWon());
        assertEquals(0, st.getLost());
    }

    @Test
    void testRecordWin() {
        ScoreTracker st = new ScoreTracker();
        st.record(true);
        assertEquals(1, st.getPlayed());
        assertEquals(1, st.getWon());
        assertEquals(0, st.getLost());
    }

    @Test
    void testRecordLoss() {
        ScoreTracker st = new ScoreTracker();
        st.record(false);
        assertEquals(1, st.getPlayed());
        assertEquals(0, st.getWon());
        assertEquals(1, st.getLost());
    }

    @Test
    void testMultipleRounds() {
        ScoreTracker st = new ScoreTracker();
        st.record(true);
        st.record(true);
        st.record(false);
        assertEquals(3, st.getPlayed());
        assertEquals(2, st.getWon());
        assertEquals(1, st.getLost());
    }

    // ── Game.getValidGuess tests ─────────────────────────────────────────────
    /**
     * Helper: creates a Game whose Scanner reads from the given string.
     */
    private Game gameWithInput(String input) {
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        return new Game(Difficulty.EASY, sc);
    }

    @Test
    void testValidGuessWithinRange() {
        Game game = gameWithInput("10\n");
        assertEquals(10, game.getValidGuess(1, 20));
    }

    @Test
    void testBoundaryLow() {
        Game game = gameWithInput("1\n");
        assertEquals(1, game.getValidGuess(1, 20));
    }

    @Test
    void testBoundaryHigh() {
        Game game = gameWithInput("20\n");
        assertEquals(20, game.getValidGuess(1, 20));
    }

    @Test
    void testNonIntegerThenValid() {
        // "abc" is rejected, then "7" is accepted
        Game game = gameWithInput("abc\n7\n");
        assertEquals(7, game.getValidGuess(1, 20));
    }

    @Test
    void testOutOfRangeThenValid() {
        // "0" is out of range, "21" is out of range, then "15" is accepted
        Game game = gameWithInput("0\n21\n15\n");
        assertEquals(15, game.getValidGuess(1, 20));
    }

    // ── Game.displayProgressBar tests ────────────────────────────────────────
    @Test
    void testProgressBarFullAtStart() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Game game = gameWithInput("");
        game.displayProgressBar(0, 5);

        System.setOut(System.out);
        String result = out.toString();
        assertTrue(result.contains("100%"), "Progress bar should show 100% at start");
    }

    @Test
    void testProgressBarEmptyAtEnd() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Game game = gameWithInput("");
        game.displayProgressBar(5, 5);

        System.setOut(System.out);
        String result = out.toString();
        assertTrue(result.contains("0%"), "Progress bar should show 0% when all attempts used");
    }
}
