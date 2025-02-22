# Battleships

A console version of Battleships, a strategy guessing game for two players.

## How to play Battleships
### Players
- 2
### Goal
- Sink all of your opponent's ships
### Rules
- Take turns firing shots by calling out grid coordinates
- It will be hit or miss based on the fact if an enemy ship is on that cell or not
- Hit will be marked with 'x' on your board
- Miss will be marked with 'o' on your board
- If a ship sank you will be notified
## Basic Gameplay
Players take turns firing shots (by calling out a grid coordinate) to attempt to hit the opponent's enemy ships.

On your turn, call out a letter and a number that identifies a row and column on your target grid. The program will show "miss" if there is no ship there, or "hit" if you have correctly guessed a space that is occupied by an enemy ship.

The program will mark each of your shots or attempts to fire on the enemy using your target grid (this will be shown for you every time you should aim), using 'o' to document your misses and 'x' to register your hits. As the game proceeds, the 'x'-s will gradually identify the size and location of your opponent's ships.

After you've taken your turn, it's your opponent's turn to fire shots at you. When one of your ships has every part hit, the program will announce to your opponent that your ship is sunk. In classic play, the phrase is "You sunk my battleship!"

The first player to sink all five of their opponent's ships wins the game.