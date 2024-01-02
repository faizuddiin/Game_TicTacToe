import java.util.Scanner;

// Interface untuk game
interface Playable {
    void startGame();
    void displayBoard();
    boolean makeMove(int row, int col, Player player);
    boolean isGameOver();
}