package boardgame;

public class Board {
    private int rows;
    private int colunms;
    private Piece[][] pieces;

    public Board(int rows, int colunms) {
        if (rows < 1 || colunms < 1) {
            throw new BoardException("Erro ao criar o tabuleiro: é necessário ter pelo menos 1 linha e 1 coluna.");
        }
        this.rows = rows;
        this.colunms = colunms;
        this.pieces = new Piece[rows][colunms];
    }

    public int getRows() {
        return rows;
    }

    public int getColunms() {
        return colunms;
    }

    public Piece piece(int row, int colunm) {
        if (!positionExists(row, colunm)){
            throw new BoardException("Posição não existe no tabuleiro.");
        }
        return pieces[row][colunm];
    }

    public Piece piece(Position position) {
        if (!positionExists(position)){
            throw new BoardException("Posição não existe no tabuleiro.");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if (theresIsAPiece(position)) {
            throw new BoardException("Já existe uma peça nessa posição.");
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    private boolean positionExists(int row, int colunm) {
        return row >= 0 && row < rows && colunm >= 0 && colunm < colunms;
    }

    public boolean theresIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Erro ao mover a peça, posição não existe.");
        }
        return piece(position) != null;
    }
}
