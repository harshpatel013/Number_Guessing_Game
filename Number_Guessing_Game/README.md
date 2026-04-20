# Number Guessing Game 🎯
### Java Mini Project | DSA / Programming Lab Assignment

Hey! This is a simple number guessing game built in Java. The computer picks a random number and you have to guess it. After each guess it tells you if you went too high or too low. That's basically it.

I built this to practice `while` loops and `if-else` statements — which are honestly the two things that show up in every Java program ever.

---

## What does the game do?

- Picks a random secret number
- Gives you a limited number of chances to guess it
- After each wrong guess → tells you "too high" or "too low"
- Narrows the hint range as you guess (so it actually helps you)
- Tracks your score across multiple rounds
- Has 4 difficulty levels if you want a challenge

---

## Files in this project

```
number-guessing-game-java/
├── src/
│   ├── main/java/game/
│   │   ├── Main.java          ← start here, this runs everything
│   │   ├── Game.java          ← the actual game logic lives here
│   │   ├── Difficulty.java    ← easy / medium / hard / expert settings
│   │   └── ScoreTracker.java  ← keeps track of wins and losses
│   └── test/java/game/
│       └── GameTest.java      ← tests (18 of them, all pass)
├── pom.xml                    ← Maven config (ignore if not using Maven)
├── .gitignore
└── README.md                  ← you are here
```

---

## How to run it

### The simple way (just javac, no Maven needed)

Make sure Java is installed first. Open your terminal and type:

```bash
java --version
```

If you see a version number, you're good. If not, download Java from [adoptium.net](https://adoptium.net) and install it.

Then:

```bash
# Step 1 — go into the project folder
cd number-guessing-game-java

# Step 2 — make a folder for the compiled files
mkdir out

# Step 3 — compile
javac -d out src/main/java/game/*.java

# Step 4 — run!
java -cp out game.Main
```

That's it. The game starts in your terminal.

### If you're using IntelliJ IDEA

1. Open IntelliJ → click **Open** → select this folder
2. Wait for it to finish loading (takes like 10 seconds)
3. Open `Main.java`
4. Click the green play button ▶ next to `public static void main`
5. Game runs in the bottom panel

### If you're using VS Code

1. Install the **"Extension Pack for Java"** from the extensions sidebar
2. Open this folder in VS Code
3. Open `Main.java`
4. Click **Run** that appears just above the `main` method

---

## Sample output

```
==================================================
       NUMBER GUESSING GAME
==================================================

Choose difficulty:
  [1] Easy     (1–20,  8 attempts)
  [2] Medium   (1–50,  8 attempts)
  [3] Hard     (1–100, 10 attempts)
  [4] Expert   (1–500, 12 attempts)

Enter choice (1-4): 1

  ► A secret number has been chosen between 1 and 20.
  ► You have 8 attempts. Good luck!

  Attempts left: ████████  (8/8  100%)

Your guess (1–20): 10
  ↑  Too low!  Try between 11 and 20.

  Attempts left: ███████░  (7/8  87%)

Your guess (11–20): 15
  ↓  Too high! Try between 11 and 14.

  Attempts left: ██████░░  (6/8  75%)

Your guess (11–14): 13
  ★  Correct! The number was 13.
     You guessed it in 3 attempt(s).
```

---

## Java concepts used in this project

This project was made specifically to practice these topics:

**`while` loop** — the game keeps running as long as you have attempts left. The moment you guess correctly or run out of chances, the loop stops.

```java
while (attemptsUsed < maxAttempts) {
    // ask for a guess, check it, repeat
}
```

**`if / else if / else`** — checks your guess and prints the right message:

```java
if (guess < secret) {
    System.out.println("Too low!");
} else if (guess > secret) {
    System.out.println("Too high!");
} else {
    System.out.println("Correct!");
    break;  // stop the loop early
}
```

**`break`** — exits the loop the moment you win, so it doesn't keep asking for guesses.

**`try / catch`** — handles it gracefully if you type "abc" instead of a number. Doesn't crash, just asks again.

**`enum`** — `Difficulty.java` uses an enum to store the four difficulty settings cleanly instead of scattering numbers everywhere.

**Classes** — the code is split into 4 classes. Each one does one thing. `Game` plays the game, `ScoreTracker` tracks scores, etc.

---

## Common errors and fixes

**`javac: command not found`**
→ Java isn't installed. Download from [adoptium.net](https://adoptium.net)

**`error: file not found`**
→ Make sure you're inside the `number-guessing-game-java` folder when you run the commands

**`could not find or load main class game.Main`**
→ You probably skipped the `mkdir out` step or the compile step. Run all 4 steps in order.

**Game compiles but shows weird characters instead of █**
→ Your terminal doesn't support UTF-8. On Windows, run `chcp 65001` before starting the game.

---

## License

Do whatever you want with this. MIT license.
