# Number Guessing Game — Java 🎯

A fully-featured, console-based **Number Guessing Game** written in Java — demonstrating `while` loops and `if-else` feedback, with difficulty levels, dynamic hints, a session score tracker, and JUnit 5 unit tests.

---

## Project Structure

```
number-guessing-game-java/
├── src/
│   ├── main/java/game/
│   │   ├── Main.java          ← entry point, menus, replay loop
│   │   ├── Game.java          ← core game logic (while + if-else)
│   │   ├── Difficulty.java    ← enum for 4 difficulty levels
│   │   └── ScoreTracker.java  ← session score tracking
│   └── test/java/game/
│       └── GameTest.java      ← JUnit 5 unit tests (18 tests)
├── pom.xml                    ← Maven build file
├── .gitignore
└── README.md
```

---

## Quick Start

### Prerequisites
- Java 17 or newer
- Maven 3.8+  (or just use the manual `javac` commands below)

### Option A — Maven (recommended)

```bash
# Clone
git clone https://github.com/<your-username>/number-guessing-game-java.git
cd number-guessing-game-java

# Compile + run
mvn compile
mvn exec:java -Dexec.mainClass="game.Main"

# Run tests
mvn test

# Build executable JAR
mvn package
java -jar target/number-guessing-game.jar
```

### Option B — Plain javac (no Maven needed)

```bash
# Compile
javac -d out src/main/java/game/*.java

# Run
java -cp out game.Main
```

---

## How to Play

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

## Java Concepts Demonstrated

```java
// while loop — keeps the game going while attempts remain
while (attemptsUsed < maxAttempts) {

    int guess = getValidGuess(hintLow, hintHigh);
    attemptsUsed++;

    // if-else — feedback after every guess
    if (guess < secret) {
        System.out.println("Too low!");
    } else if (guess > secret) {
        System.out.println("Too high!");
    } else {
        System.out.println("Correct!");
        break;   // exit loop early on a win
    }
}
```

| Concept | Where used |
|---|---|
| `while` loop | Main game loop in `Game.java` |
| `if / else if / else` | Guess feedback |
| `break` | Early exit on correct guess |
| `try / catch NumberFormatException` | Input validation |
| `enum` | `Difficulty.java` — 4 levels as a type-safe enum |
| `Random.nextInt()` | Secret number generation |
| OOP — classes | `Game`, `ScoreTracker`, `Difficulty`, `Main` |
| JUnit 5 | `GameTest.java` — 18 unit tests |

---

## Running Tests

```
$ mvn test

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running game.GameTest
Tests run: 18, Failures: 0, Errors: 0, Skipped: 0

BUILD SUCCESS
```

---

## License

MIT — free to use, modify, and distribute.
