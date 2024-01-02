import java.util.Scanner;
public class TicTacToe implements Playable {
    private char[][] board;
    private Player currentPlayer;
    private Player player1;
    private Player player2;

    // Konstruktor untuk inisialisasi objek TicTacToe
    public TicTacToe(String player1Name, String player2Name) {
        board = new char[3][3];
        player1 = new PlayerImpl(player1Name, 'X');
        player2 = new PlayerImpl(player2Name, 'O');
        currentPlayer = player1;
        initializeBoard();
    }

    private void initializeBoard() {
        // Inisialisasi papan permainan
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Implementasi metode dari antarmuka Playable
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (!isGameOver()) {
            displayBoard();
            System.out.println("Giliran " + currentPlayer.getName() + " (" + currentPlayer.getSymbol() + ")");
            System.out.print("Masukkan baris (0-2): ");
            int row = scanner.nextInt();
            System.out.print("Masukkan kolom (0-2): ");
            int col = scanner.nextInt();

            if (makeMove(row, col, currentPlayer)) {
                if (checkWin()) {
                    displayBoard();
                    System.out.println(currentPlayer.getName() + " menang!");
                    break;
                } else if (isBoardFull()) {
                    displayBoard();
                    System.out.println("Permainan seri!");
                    break;
                } else {
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;
                }
            } else {
                System.out.println("Langkah tidak valid. Coba lagi.");
            }
        }
        scanner.close();
    }

    public void displayBoard() {
        // Menampilkan papan permainan ke layar
        System.out.println("Papan Saat Ini:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean makeMove(int row, int col, Player player) {
        // Melakukan langkah pemain pada posisi tertentu di papan permainan
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
            board[row][col] = player.getSymbol();
            return true;
        } else {
            return false;
        }
    }

    public boolean isGameOver() {
        // Memeriksa apakah permainan telah berakhir
        return checkWin() || isBoardFull();
    }

    private boolean checkWin() {
        // Implementasikan logika pemeriksaan kemenangan di sini
        for (int i = 0; i < 3; i++) {
            // Check baris
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return true;
            }
            // Check kolom
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                return true;
            }
        }
        // Check diagonal
        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') ||
            (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-')) {
            return true;
        }
        return false;
    }

    private boolean isBoardFull() {
        // Memeriksa apakah papan permainan sudah penuh
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Metode main sebagai titik awal eksekusi program
        TicTacToe game = new TicTacToe("Pemain1", "Pemain2");
        game.startGame();
    }
}

// Implementasi kelas Player yang mewarisi dari kelas Player abstrak
class PlayerImpl extends Player {
    public PlayerImpl(String name, char symbol) {
        super(name, symbol);
    }

    
}