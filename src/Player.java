abstract class Player {
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    // Getter untuk mendapatkan nama pemain
    public String getName() {
        return name;
    }

    // Getter untuk mendapatkan simbol pemain
    public char getSymbol() {
        return symbol;
    }

    // Setter untuk memperbarui nama pemain
    public void setName(String name) {
        this.name = name;
    }

    // Setter untuk memperbarui simbol pemain
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}