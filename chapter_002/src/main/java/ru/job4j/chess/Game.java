package ru.job4j.chess;

/**
 * Class Game let user play chess in pseudo graphic.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 12.12.2017
 */
public class Game {
    static final String BLACK = "▓";
    static final String WHITE = "░";

    static final String EXIT = "exit";
    private Board board = new Board();
    private Input input = new Input();

    /**
     * Start new chess game.
     */
    public void start() {
        try {
            board.addFigure(new Rook(new Cell(0, 0)));
            board.addFigure(new Knight(new Cell(0, 1)));
            board.addFigure(new Bishop(new Cell(0, 2)));
            board.addFigure(new Queen(new Cell(0, 3)));
            board.addFigure(new King(new Cell(0, 4)));
            board.addFigure(new Pawn(new Cell(1, 4)));
            do {
                print();
                String answer = input.ask("Insert your move in format \"e2 e4\" (or \"exit\" to finish game):");
                if (EXIT.equals(answer)) {
                    break;
                }

                try {
                    move(answer);
                } catch (FigureNotFoundException e) {
                    System.out.println("There is no figure on the cell!");
                } catch (OccupiedWayException e) {
                    System.out.println("There is a figure on the way!");
                } catch (ImpossibleMoveException e) {
                    System.out.println("The move you try to make is impossible for the figure!");
                }
            } while (true);
        } catch (ImpossibleMoveException e) {
            System.out.println("Something goes wrong! Check your bad code!");
        }
    }

    /**
     * Print the board with figures.
     */
    private void print() {
        for (int i = 0; i < Board.WIDTH; i++) {
            System.out.print(" " + (char) ('a' + i));
        }
        System.out.println();
        for (int i = 0; i < Board.HEIGHT; i++) {
            System.out.print((i + 1) + " ");
            int even = i % 2;
            for (int j = 0; j < Board.WIDTH; j++) {
                try {
                    Figure figure = board.take(new Cell(i, j));
                    System.out.print(getImage(figure));
                } catch (FigureNotFoundException e) {
                    System.out.print(j % 2 == even ? BLACK : WHITE);
                }
            }
            System.out.println();
        }
    }

    /**
     * Return figure image.
     *
     * @param figure chess figure
     * @return image
     */
    private char getImage(Figure figure) {
        char image;
        if (figure instanceof Pawn) {
            image = '♙';
        } else if (figure instanceof Rook) {
            image = '♖';
        } else if (figure instanceof Knight) {
            image = '♘';
        } else if (figure instanceof Bishop) {
            image = '♗';
        } else if (figure instanceof Queen) {
            image = '♕';
        } else if (figure instanceof King) {
            image = '♔';
        } else {
            throw new IllegalArgumentException();
        }
        return image;
    }

    /**
     * Make move on the board if it is possible.
     *
     * @param move user move
     * @throws ImpossibleMoveException when command break the rules
     * @throws OccupiedWayException    when try to use the way which occupied by another figure
     * @throws FigureNotFoundException when try to take a figure from the empty cell
     */
    private void move(String move) throws ImpossibleMoveException {
        try {
            Cell source = new Cell(convert(move.charAt(1)), convert(move.charAt(0)));
            Cell dest = new Cell(convert(move.charAt(4)), convert(move.charAt(3)));
            board.move(source, dest);
        } catch (IllegalArgumentException e) {
            throw new ImpossibleMoveException();
        }
    }

    /**
     * Convert char symbols to indexes of the board cells.
     *
     * @param symbol some char
     * @return appropriate board index
     * @throws IllegalArgumentException if symbol doesn't convert
     */
    private int convert(char symbol) {
        for (int i = 0; i < Board.WIDTH; i++) {
            if (symbol == (char) ('a' + i) || symbol == (char) ('1' + i)) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
        System.exit(0);
    }
}
