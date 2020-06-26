# Halma
This is a Java application-agent that can compete with other agents for a game of Halma.

Dated: October 2019.

## Objective
This project aims at building a game playing by innovatively using algorithms and special heuristics to make the best move.

## Highlights
* The moves were predicted using the Minmax algorithm with alpha beta pruning for added efficiency.
* The rules of the game can be found here: <a href="https://www.mastersofgames.com/rules/halma-rules.htm#:~:text=Players%20take%20turns%20to%20move,vacant%20square%20directly%20beyond%20it.">Rules of Halma</a>


## Input format
* Move type - SINGLE/GAME
* Player whose turn it is - BLACK/WHITE
* Time left for current agent
* 16x16 matrix of board with pawns denoted by B/W and . for an empty grid cell.
