package game;

/**
 * ScoreTracker
 * ============
 * Tracks wins and losses across multiple rounds in a session.
 */
public class ScoreTracker {

    private int played = 0;
    private int won    = 0;

    /**
     * Record the result of one completed round.
     *
     * @param playerWon true if the player guessed the number, false otherwise.
     */
    public void record(boolean playerWon) {
        played++;
        if (playerWon) won++;
    }

    /**
     * Print a formatted score summary to stdout.
     */
    public void display() {
        int lost = played - won;
        int rate = (played == 0) ? 0 : (int) Math.round((double) won / played * 100);

        System.out.println("\n" + "-".repeat(30));
        System.out.println("  SESSION SCORES");
        System.out.println("-".repeat(30));
        System.out.printf("  Played : %d%n", played);
        System.out.printf("  Won    : %d%n", won);
        System.out.printf("  Lost   : %d%n", lost);
        System.out.printf("  Win %%  : %d%%%n", rate);
        System.out.println("-".repeat(30));
    }

    // Getters — used by tests
    public int getPlayed() { return played; }
    public int getWon()    { return won; }
    public int getLost()   { return played - won; }
}
