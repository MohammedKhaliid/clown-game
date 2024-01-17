# Circus of Plates – Game

## Description

Circus of Plates is a single-player game featuring a clown (Mario character) who juggles two stacks of plates (Mushrooms). Colored mushrooms fall in queues, and the player's goal is to catch three consecutive mushrooms of the same color to make them vanish and increase their score.

### Falling Objects
- There are 3 kinds of falling objects: mushrooms, villains, and coins.
- The user earns points for collecting three consecutive mushrooms of the same color.
- Collecting falling coins also rewards the player with number of points.
- Touching falling villains results in a point deduction, with the penalty varying based on the type of villain.

### Difficulty Levels
- The game offers 3 levels of difficulty, each with differences in speed, the number of falling objects, and their types.

### Engine
- The game utilizes an engine (.jar) supporting three types of objects: movable, constant, and user-controlled objects (found in the "lib" directory).

### Design Patterns Used
1. Singleton
2. Factory Method
3. Iterator
4. Strategy
5. Observer

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/mohamedbassem6/clown-game.git
   ```

2. Open the project in your preferred IDE (e.g., IntelliJ, Eclipse).

3. Run the game and enjoy!

## Usage

- Launch the application.
- Choose the difficulty level (Easy, Medium, or Hard) from the window shown after running the program.
- Use ```right arrow``` for moving right and ```left arrow``` for moving left.
- Coins are collected by touching Mario's body.
- Mushrooms are collected by touching the empty plates or the top mushroom on each hand.

## Screenshots

<p float="left">
  <img src="https://github.com/mohamedbassem6/clown-game/assets/59765067/03e5e0a4-991b-4715-898d-735a472f45e4" width="500" />
  <img src="https://github.com/mohamedbassem6/clown-game/assets/59765067/85f5dde2-53f0-4dbe-9c5e-45362679dece" width="500" /> 
</p>
<!-- Add more screenshots as needed -->


## Contributing

Contributions are welcome! If you find any bugs or have suggestions for improvement, please open an issue or submit a pull request.
