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



## License

Do whatever you want with this. MIT license.
