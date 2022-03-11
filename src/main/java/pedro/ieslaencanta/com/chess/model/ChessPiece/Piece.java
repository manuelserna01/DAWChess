package pedro.ieslaencanta.com.chess.model.ChessPiece;

import pedro.ieslaencanta.com.chess.model.Board;
import pedro.ieslaencanta.com.chess.model.Move;
import pedro.ieslaencanta.com.chess.model.Position;

/**
 *
 * @author Pedro
 */
public abstract class Piece {

    protected Position p;
    protected PieceType type;
    protected boolean alive;
    protected Move moves[];
    protected char letter;
    private String id;

    public Piece() {

    }

    public Piece(int row, int col) {
        this.p = new Position(row, col);
    }

    @Override
    public String toString() {
        return this.getId();
    }

    /**
     * Mueve una pieza a una posición del tablero, la comprobación se realiza en canmove, no aqui
     *
     * @param board
     * @param row
     * @param col
     * @return devuelve un movimiento
     */
    public Move move(Board board, int row, int col) {
        Move move = null;
        move = new Move(this, board.getCell(row, col).getPiece(), new Position(this.p.getRow(), this.p.getCol()), new Position(row, col));
        this.p.setCol(col);
        this.p.setRow(row);

        return move;
    }

    protected Move[] getHorizontalMoves(Board b, int row, int start, int end) {
        Move m[] = new Move[7];
        boolean ocupado = false;
        int c = 0;
        // De arriba a abajo
        if (start < end) {
            for (int i = start; i <= end - 1 && !ocupado; i++) {
                if (i < 7) {
                    if (b.getCell(row, i + 1).getPiece() == null) {
                        // si en la posición no hay ninguna pieza, hace el movimiento y no reemplaza nada
                        m[c] = new Move(this, null,
                                new Position(this.p.getRow(), this.p.getCol()),
                                new Position(this.p.getRow(), this.p.getCol() + (c + 1)));
                        c++;
                    } else {
                        // si hay una pieza en dicha posición, la reemplaza y hace el movimiento
                        ocupado = true;
                        if (b.getCell(row, i + 1).getPiece().getType() != this.type) {
                            m[c] = new Move(this, b.getCell(row, i + 1).getPiece(),
                                    new Position(this.p.getRow(), this.p.getCol()),
                                    new Position(this.p.getRow(), this.p.getCol() + (c + 1)));
                            c++;
                        }
                    }
                }
            }
        }

        // De abajo a arriba
        if (end < start) {
            for (int i = start; i >= end + 1 && !ocupado; i--) {
                if (i > 0) {
                    if (b.getCell(row, i - 1).getPiece() == null) {
                        // si en la posición no hay ninguna pieza, hace el movimiento y no reemplaza nada
                        m[c] = new Move(this, null, new Position(this.p.getRow(), this.p.getCol()), new Position(this.p.getRow(), this.p.getCol() - (c + 1)));
                        c++;
                    } else {
                        ocupado = true;
                        // si hay una pieza en dicha posición, la reemplaza y hace el movimiento
                        if (b.getCell(row, i - 1).getPiece().getType() != this.type) {
                            m[c] = new Move(this, b.getCell(row, i - 1).getPiece(), new Position(this.p.getRow(), this.p.getCol()), new Position(this.p.getRow(), this.p.getCol() - (c + 1)));
                            c++;
                        }
                    }
                }
            }
        }
        return m;
    }

    protected Move[] getVertical(Board b, int col, int start, int end) {

        Move m[] = new Move[7];
        boolean ocupado = false;
        int c = 0;
        if (start < end) {
            for (int i = start; i <= end - 1 && !ocupado; i++) {
                if (i < 7) { // comprobamos que no se salga del campo
                    if (b.getCell(i + 1, col).getPiece() == null) {
                        // Primer movimiento sin matar.
                        m[c] = new Move(this, null,
                                new Position(this.p.getRow(), this.p.getCol()),
                                new Position(this.p.getRow() + (c + 1), this.p.getCol()));
                        c++;

                    } else {
                        // Segundo movimiento sin matar.
                        ocupado = true;
                        if (b.getCell(i + 1, col).getPiece().getType() != this.type) {
                            m[c] = new Move(this, b.getCell(i + 1, col).getPiece(),
                                    new Position(this.p.getRow(), this.p.getCol()),
                                    new Position(this.p.getRow() + (c + 1), this.p.getCol()));
                            c++;

                        }
                    }
                }
            }
        }
        if (end < start) {
            for (int i = start; i >= end + 1 && !ocupado; i--) {
                if (i > 0) { // comprobamos que no se salga del campo
                    if (b.getCell(i - 1, col).getPiece() == null) {
                        // Primer movimiento sin matar.
                        m[c] = new Move(this, null, new Position(this.p.getRow(), this.p.getCol()), new Position(this.p.getRow() - (c + 1), this.p.getCol()));
                        c++;
                    } else {
                        // Segundo movimiento matando.
                        ocupado = true;
                        if (b.getCell(i - 1, col).getPiece().getType() != this.type) {
                            m[c] = new Move(this, b.getCell(i - 1, col).getPiece(), new Position(this.p.getRow(), this.p.getCol()), new Position(this.p.getRow() - (c + 1), this.p.getCol()));
                            c++;
                        }
                    }
                }
            }
        }

        return m;
    }

    /**
     *
     * @param b tablero
     * @param dirx si va hacia la izquierda o derecha
     * @param diry si va hacia arriba o hacia abajo
     * @return movimientos posibles en esa diagonal
     */
    protected Move[] getDiagonal(Board b, int dirx, int diry, int lenght) {
        Move m[] = new Move[7];
        int c = 0;
        boolean ocup = false;
        int actcol = this.getPosition().getCol();
        int actrow = this.getPosition().getRow();
        for (int i = 0; i < lenght && !ocup; i++) {
            switch (dirx) {
                // Arriba
                case -1:
                    switch (diry) {
                        // Izquierda
                        case -1:
                            if (actcol < 7 && actrow > 0) {
                                if (b.getCell(this.p.getRow() - (c + 1), this.p.getCol() + (c + 1)).getPiece() == null && this.letter != 'P') {
                                    m[c] = new Move(this, null, new Position(this.p.getRow(), this.p.getCol()),
                                            new Position(this.p.getRow() - (c + 1), this.p.getCol() + (c + 1)));
                                    c++;
                                    actcol++;
                                    actrow--;
                                } else {
                                    ocup = true;
                                    if (b.getCell(this.p.getRow() - (c + 1), this.p.getCol() + (c + 1)).getPiece() != null && b.getCell(this.p.getRow() - (c + 1), this.p.getCol() + (c + 1)).getPiece().getType() != this.type) {
                                        m[c] = new Move(this, b.getCell(this.p.getRow() - (c + 1), this.p.getCol() + (c + 1)).getPiece(),
                                                new Position(this.p.getRow(), this.p.getCol()),
                                                new Position(this.p.getRow() - (c + 1), this.p.getCol() + (c + 1)));
                                        c++;
                                        actcol++;
                                        actrow--;
                                        ocup = true;
                                    }
                                }
                            }
                            break;
                        // Derecha
                        case 1:
                            if (actcol < 7 && actrow < 7) {
                                if (b.getCell(this.p.getRow() + (c + 1), this.p.getCol() + (c + 1)).getPiece() == null && this.letter != 'P') {
                                    m[c] = new Move(this, null, new Position(this.p.getRow(), this.p.getCol()),
                                            new Position(this.p.getRow() + (c + 1), this.p.getCol() + (c + 1)));
                                    c++;
                                    actcol++;
                                    actrow++;
                                } else {
                                    ocup = true;
                                    if (b.getCell(this.p.getRow() + (c + 1), this.p.getCol() + (c + 1)).getPiece() != null && b.getCell(this.p.getRow() + (c + 1), this.p.getCol() + (c + 1)).getPiece().getType() != this.type) {
                                        m[c] = new Move(this, b.getCell(this.p.getRow() + (c + 1), this.p.getCol() + (c + 1)).getPiece(),
                                                new Position(this.p.getRow(), this.p.getCol()),
                                                new Position(this.p.getRow() + (c + 1), this.p.getCol() + (c + 1)));
                                        c++;
                                        actcol++;
                                        actrow++;
                                        ocup = true;
                                    }
                                }
                            }
                            break;
                    }
                    break;
                // Abajo
                case 1:
                    switch (diry) {
                        // Izquierda
                        case -1:

                            if (actcol > 0 && actrow > 0) {
                                if (b.getCell(this.p.getRow() - (c + 1), this.p.getCol() - (c + 1)).getPiece() == null && this.letter != 'P') {
                                    m[c] = new Move(this, null, new Position(this.p.getRow(), this.p.getCol()),
                                            new Position(this.p.getRow() - (c + 1), this.p.getCol() - (c + 1)));
                                    c++;
                                    actcol--;
                                    actrow--;
                                } else {
                                    ocup = true;
                                    if (b.getCell(this.p.getRow() - (c + 1), this.p.getCol() - (c + 1)).getPiece() != null && b.getCell(this.p.getRow() - (c + 1), this.p.getCol() - (c + 1)).getPiece().getType() != this.type) {
                                        m[c] = new Move(this, b.getCell(this.p.getRow() - (c + 1), this.p.getCol() - (c + 1)).getPiece(),
                                                new Position(this.p.getRow(), this.p.getCol()),
                                                new Position(this.p.getRow() - (c + 1), this.p.getCol() - (c + 1)));
                                        c++;
                                        actcol--;
                                        actrow--;
                                        ocup = true;
                                    }
                                }
                            }
                            break;
                        // Derecha
                        case 1:
                            if (actcol > 0 && actrow < 7) {
                                if (b.getCell(this.p.getRow() + (c + 1), this.p.getCol() - (c + 1)).getPiece() == null && this.letter != 'P') {
                                    m[c] = new Move(this, null, new Position(this.p.getRow(), this.p.getCol()),
                                            new Position(this.p.getRow() + (c + 1), this.p.getCol() - (c + 1)));
                                    c++;
                                    actcol--;
                                    actrow++;
                                } else {
                                    ocup = true;
                                    if (b.getCell(this.p.getRow() + (c + 1), this.p.getCol() - (c + 1)).getPiece() != null && b.getCell(this.p.getRow() + (c + 1), this.p.getCol() - (c + 1)).getPiece().getType() != this.type) {
                                        m[c] = new Move(this, b.getCell(this.p.getRow() + (c + 1), this.p.getCol() - (c + 1)).getPiece(),
                                                new Position(this.p.getRow(), this.p.getCol()),
                                                new Position(this.p.getRow() + (c + 1), this.p.getCol() - (c + 1)));
                                        c++;
                                        actcol--;
                                        actrow++;
                                        ocup = true;
                                    }
                                }
                            }
                            break;
                    }
                    break;
            }
        }
        return m;
    }

    /**
     *
     * @param b tablero
     * @param dirx direccion de la diagonal enel eje x -1 izquierda, 1 derecha
     * @param diry direccionde la diagonal en el eje y -1 arriba, 1 abajo
     * @param lenght longitud máxima
     * @return
     */
    protected Move[] getDiagonal(Board b, int dirx, int diry) {
        return getDiagonal(b, dirx, diry, b.getHeight());
    }

    public boolean canmove(Board board, int row, int col) {
        boolean vuelta = false;

        return vuelta;
    }

    public Move[] getCalculatedMoves() {
        return this.moves;
    }

    public abstract Move[] getMoves(Board board);

    /**
     * @return the letter
     */
    public char getLetter() {
        return letter;
    }

    /**
     * @param letter the letter to set
     */
    public void setLetter(char letter) {
        this.letter = letter;
    }

    /**
     * @return the p
     */
    public Position getPosition() {
        return p;
    }

    /**
     * @return the type
     */
    public PieceType getType() {
        return type;
    }

    /**
     * @return the alive
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * @param p the p to set
     */
    public void setPosition(Position p) {
        this.p = p;
    }

    /**
     * @param type the type to set
     */
    public void setType(PieceType type) {
        this.type = type;
    }

    /**
     * @param alive the alive to set
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = this.letter + ((this.getType() == PieceType.White) ? "W" : "B") + id;
    }

}
