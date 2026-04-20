package game;


public enum Difficulty {

    EASY   ("Easy",   20,  8),
    MEDIUM ("Medium", 50,  8),
    HARD   ("Hard",  100, 10),
    EXPERT ("Expert",500, 12);

    private final String name;
    private final int    maxNumber;
    private final int    maxAttempts;

    Difficulty(String name, int maxNumber, int maxAttempts) {
        this.name        = name;
        this.maxNumber   = maxNumber;
        this.maxAttempts = maxAttempts;
    }

    public String getName()       { return name; }
    public int    getMaxNumber()  { return maxNumber; }
    public int    getMaxAttempts(){ return maxAttempts; }
}
