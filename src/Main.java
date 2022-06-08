import java.util.Random;
import java.util.Scanner;

public class Main {
    /*1) инициализация переменных.
    2) Приветствие игроков.
    3) Ввод размеров поля.
    4) Рандом выбор кто первым ходит.
    5) Вывод поля для игроков.
    6) Игровой процесс.
    7) Проверка на победу.
    8) Меню если никто не победил. Сделать кноку возвращения на 3 позицию.
    9) Вывод победителя
     */
    public enum Player {
        PlayerOne("Первый игрок"),
        PlayerTwo("Второй игрок"),
        NONE("Тут будет победитель");

        private String value;

        Player(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum FieldCell {
        KREST('X'),
        NULL('0'),
        EMPTY('*');

        private char value;

        FieldCell(char value) {
            this.value = value;
        }

        public char getValue() {
            return value;
        }
    }

    static void welcome() {
        System.out.println("Привет! Эта игра - крестики нолики.");
        System.out.println("Правила: набрать в ряд 3 крестика или 3 нолика для победы.");
    }

    static Player WhoFirst() {
        Random random = new Random();
        Player currentPlayer;
        if (random.nextInt(1000 + 1) > 500) {
            currentPlayer = Player.PlayerOne;
            System.out.println("первым ходит игрок 1 (X - крестик)");
        } else {
            currentPlayer = Player.PlayerTwo;
            System.out.println("первым ходит игрок 2 (0 - нолик)");
        }
        return currentPlayer;
    }

    static void Continue(){
        System.out.println("Для продолжения нажмите <Enter>");
        new Scanner(System.in).nextLine();
    }
    static FieldCell creatureField(int fieldSize) {
        FieldCell[][] gameField;
        gameField = new FieldCell[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                gameField[i][j] = FieldCell.EMPTY;
            }
        }
        return gameField;
    }

    static void Win(int fieldSize, FieldCell gameField) {
        Player winPlayer = Player.NONE;
        System.out.println("win = " + winPlayer.getValue());
        FieldGame(fieldSize, gameField);
    }

    static void FieldGame(int fieldSize, FieldCell gameField) {
        System.out.println("Поле игры");
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                System.out.print(gameField[i][j].getValue());
            }
            System.out.println();
        }
    }

    static Player step(Player Player, int fieldSize, FieldCell gameField, Player currentPlayer) {
            System.out.println(String.format("Ход игрока %d.", Player));

            Scanner scanner = new Scanner(System.in);
            int gorizont, vertikal;
            System.out.print("введите строчку от 1 до 3: ");
            gorizont = scanner.nextInt() - 1;

            System.out.print("введите столбец от 1 до 3: ");
            vertikal = scanner.nextInt() - 1;

            if (gameField[gorizont][vertikal] == FieldCell.EMPTY) {
                gameField[gorizont][vertikal] = FieldCell.KREST;
                if (currentPlayer == Player.PlayerOne) {
                    currentPlayer = Player.PlayerTwo;
                } else {
                    currentPlayer = Player.PlayerOne;
                }

            }
            return;


    public static void main(String[] args) {
        FieldCell[][] gameField;
        int fieldSize = 3;
        boolean playGame = true;
        Player  currentPlayer, winPlayer = Player.NONE;

        welcome();
        currentPlayer = WhoFirst();
        Continue();
        gameField = creatureField(fieldSize);
        while (playGame == true) {
            FieldGame(fieldSize, gameField);
            if (currentPlayer == Player.PlayerOne) {
                step(Player.PlayerOne, fieldSize, gameField, currentPlayer);

            } else if (currentPlayer == Player.PlayerTwo) {
                step(Player.PlayerTwo, fieldSize, gameField, currentPlayer);

            }

            if (gameField[0][0] == FieldCell.KREST && gameField[0][1] == FieldCell.KREST && gameField[0][2] == FieldCell.KREST ||//горизонт 1
                    gameField[1][0] == FieldCell.KREST && gameField[1][1] == FieldCell.KREST && gameField[1][2] == FieldCell.KREST || //горизонт 2
                    gameField[2][0] == FieldCell.KREST && gameField[2][1] == FieldCell.KREST && gameField[2][2] == FieldCell.KREST || //горизонт 3
                    gameField[0][0] == FieldCell.KREST && gameField[1][0] == FieldCell.KREST && gameField[2][0] == FieldCell.KREST ||//вертикаль 1
                    gameField[0][1] == FieldCell.KREST && gameField[1][1] == FieldCell.KREST && gameField[2][1] == FieldCell.KREST || //вертикаль 2
                    gameField[0][2] == FieldCell.KREST && gameField[1][2] == FieldCell.KREST && gameField[2][2] == FieldCell.KREST || //вертикаль 3
                    gameField[0][0] == FieldCell.KREST && gameField[1][1] == FieldCell.KREST && gameField[2][2] == FieldCell.KREST ||//диагональ 1
                    gameField[0][2] == FieldCell.KREST && gameField[1][1] == FieldCell.KREST && gameField[2][0] == FieldCell.KREST) //диагональ 2)
            {
                winPlayer = Player.PlayerOne;
                playGame = false;
            }
            if (gameField[0][0] == FieldCell.NULL && gameField[0][1] == FieldCell.NULL && gameField[0][2] == FieldCell.NULL ||//горизонт 1
                    gameField[1][0] == FieldCell.NULL && gameField[1][1] == FieldCell.NULL && gameField[1][2] == FieldCell.NULL || //горизонт 2
                    gameField[2][0] == FieldCell.NULL && gameField[2][1] == FieldCell.NULL && gameField[2][2] == FieldCell.NULL || //горизонт 3
                    gameField[0][0] == FieldCell.NULL && gameField[1][0] == FieldCell.NULL && gameField[2][0] == FieldCell.NULL ||//вертикаль 1
                    gameField[0][1] == FieldCell.NULL && gameField[1][1] == FieldCell.NULL && gameField[2][1] == FieldCell.NULL || //вертикаль 2
                    gameField[0][2] == FieldCell.NULL && gameField[1][2] == FieldCell.NULL && gameField[2][2] == FieldCell.NULL || //вертикаль 3
                    gameField[0][0] == FieldCell.NULL && gameField[1][1] == FieldCell.NULL && gameField[2][2] == FieldCell.NULL ||//диагональ 1
                    gameField[0][2] == FieldCell.NULL && gameField[1][1] == FieldCell.NULL && gameField[2][0] == FieldCell.NULL)  //диагональ 2
            {
                winPlayer = Player.PlayerTwo;
                playGame = false;
            }
        }
        Win(fieldSize, gameField);
    }
}