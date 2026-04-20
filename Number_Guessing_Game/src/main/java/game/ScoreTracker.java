package game;


public class ScoreTracker {

    private int played = 0;
    private int won    = 0;

   
    public void record(boolean playerWon) {
        played++;
        if (playerWon) won++;
    }

    
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

    
    public int getPlayed() { return played; }
    public int getWon()    { return won; }
    public int getLost()   { return played - won; }
}
