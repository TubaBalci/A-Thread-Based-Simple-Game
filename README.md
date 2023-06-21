
Sliding Monsters Game
The Sliding Monsters Game is a simple Java program that simulates a game where a player controls a green square and tries to avoid blue squares (monsters) that slide across the screen. The objective is to survive as long as possible without being caught by a monster.

How to Play
Use the following keys to control the green square:

A: Move left
D: Move right
W: Move up
S: Move down
The green square starts at coordinates (240, 240) in a 500x500 window.

Blue squares (monsters) move towards the green square in a sliding motion.

If a monster comes within 20 pixels of the green square, it will try to chase and catch it.

The player must navigate the green square to avoid being caught by the monsters.

The game continues until the green square is caught by a monster.

Instructions
Clone the repository:

bash
Copy code
git clone https://github.com/your-username/sliding-monsters-game.git
Open the project in your preferred Java development environment.

Compile and run the Main class to start the game.

Use the keys mentioned above to control the green square and try to survive as long as possible.

Gameplay Features
The game window is a 500x500 screen.
The green square represents the player and can be controlled using the keys.
Blue squares represent the monsters that slide across the screen.
The monsters attempt to chase and catch the green square if it comes within a certain range.
The game continues until the green square is caught by a monster.
Notes
The number of monsters is determined by the command-line argument passed to the program.
The sliding motion and chasing behavior of the monsters are implemented using multithreading.
The game uses basic Java AWT for graphics and event handling.
Dependencies
Java 8 or later
Credits
This game is created by Tuba Balcı and is based on a simple sliding monsters concept.

Feel free to modify and improve the game according to your preferences. Enjoy playing!
