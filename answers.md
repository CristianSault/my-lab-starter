# Answers to Lab Questions

Place here your answers to the reflection questions in the lab instructions.

## Question 1
Why *can* you change the type of the returned **value** in `promptForPlayer` without changing the return **type** in the function signature?
### Answer
Because HumanPlayer IS a Player so it is valid that `promptForPlayer` returns `Player` in the signature but specifically a `HumanPlayer` in the return line of the method.

Later on, the `switch` clause in the method will return other specific **types** of `Player` to be defined. 

## Question 2
Explain why the call to `getNextMove` initially causes an error until you add the abstract method to the `Player` class. Your answer should involve a discussion of static (compile-time) vs dynamic (run-time) types. (HINT: What is the compile-time vs run-time type of the `player` variable in `TicTacToeGame.doNextTurn`?)
### Answer
At compile-time, the `player` variable in `TicTacToeGame.doNextTurn` is a Player; at run-time the `player` variable in it is a `HumanPlayer` which IS a `Player` - therefore it is valid.

So the reason why the call initially causes an error is because the next line in that method calls the `getNextMove` method from `Player` but - at that moment - the method was moved to the `HumanPlayer` subclass and `Player` was not yet defined as an abstract class nor was it given the abstract method signature to `getNextMove`.

## Question 3
Explain in detail how it is possible that neither our main game loop nor our TicTacToeGame class need change at all when adding new Player types to our game.  Your discussion must include an explanation of how the single call to getNextMove in TicTacToeGame.doNextTurn works correctly no matter whose turn it is or which types the players are. Your answer should involve discussion of polymorphism and dynamic method dispatch.
### Answer
Firstly, in this lab `TicTacToeGame` and `Player` - with its respective subclasses - encapsulate more of the general logic behind the game such as `Player` deciding how the turn plays; `TicTacToeGame` containing `Player` variables and `TurnData` records to call, check and update the state of the board independently. In this way, the `Main` class needs just a few lines that can adapt to additional changes made by `Player` and `TicTacToeGame` logic.

Secondly, adding new "Player" types to the game is _automatically_ handled with inheritance since now `Player` is an abstract class that all subsequent new subclasses extend and override the `getNextMove` abstract method while still being treated as a normal `Player` in `TicTacToeGame` and specifically added in the `Console` class in `promptForPlayer`.

In conclusion, this is an example of how _polymorphism_ works; the general "outer layer" classes call the abstract class but get derived classes at run-time that do the same _function_ but with different implementations (different ways of doing it). 