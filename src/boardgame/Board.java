package boardgame;

public class Board {
    private int rows;
    private int colunms;
    private Piece[][] pieces;

    public Board(int rows, int colunms) {
        this.rows = rows;
        this.colunms = colunms;
        this.pieces = new Piece[rows][colunms];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColunms() {
        return colunms;
    }

    public void setColunms(int colunms) {
        this.colunms = colunms;
    }

    public Piece piece(int row, int colunm) {
        return pieces[row][colunm];
    }

    public Piece piece(Position position) {
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
}
