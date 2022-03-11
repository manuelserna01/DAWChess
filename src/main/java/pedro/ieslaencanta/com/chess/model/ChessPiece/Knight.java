/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.chess.model.ChessPiece;

import pedro.ieslaencanta.com.chess.model.Board;
import pedro.ieslaencanta.com.chess.model.Move;
import pedro.ieslaencanta.com.chess.model.Position;

/**
 *
 * @author Manuel
 */
public class Knight extends Piece {

    public Knight() {
        super();
        this.letter = 'N';
    }

    public Knight(int row, int col, PieceType type, boolean alive, String id) {
        super(row, col);
        this.type = type;
        this.alive = alive;
        this.letter = 'N';
        this.setId(id);
    }

    @Override
    public Move[] getMoves(Board board) {
        Move[] m = new Move[30];

        // ARRIBA
        // Arriba a la izquierda 1
        try {
            if (board.getCell(this.p.getRow() - 2, this.p.getCol() - 1).getPiece() == null) {
                m[0] = new Move(this, null, new Position(this.p.getRow(), this.p.getCol()), new Position(this.p.getRow() - 2, this.p.getCol() - 1));
            } else if (board.getCell(this.p.getRow() - 2, this.p.getCol() - 1).getPiece() != null
                    && board.getCell(this.p.getRow() - 2, this.p.getCol() - 1).getPiece().getType() != this.type) {
                m[1] = new Move(this, board.getCell(this.p.getRow() - 2, this.p.getCol() - 1).getPiece(), new Position(this.p.getRow(), this.p.getCol()), new Position(this.p.getRow() - 2, this.p.getCol() - 1));
            }
        } catch (Exception e) {
            //System.out.println(e.getMessage());
        }

        try {
            // Arriba a la izquierda 2
            if (board.getCell(this.p.getRow() - 1, this.p.getCol() - 2).getPiece() == null) {
                m[2] = new Move(this, null, new Position(this.p.getRow(), this.p.getCol()), new Position(this.p.getRow() - 1, this.p.getCol() - 2));
            } else if (board.getCell(this.p.getRow() - 1, this.p.getCol() - 2).getPiece() != null
                    && board.getCell(this.p.getRow() - 1, this.p.getCol() - 2).getPiece().getType() != this.type) {
                m[3] = new Move(this, board.getCell(this.p.getRow() - 1, this.p.getCol() - 2).getPiece(), new Position(this.p.getRow(), this.p.getCol()), new Position(this.p.getRow() - 1, this.p.getCol() - 2));
            }
        } catch (Exception e) {
            //System.out.println(e.getMessage());
        }

        try {
            // Arriba a la derecha 1
            if (board.getCell(this.p.getRow() - 2, this.p.getCol() + 1).getPiece() == null) {
                m[4] = new Move(this, null, new Position(this.p.getRow(), this.p.getCol()), new Position(this.p.getRow() - 2, this.p.getCol() + 1));
            } else if (board.getCell(this.p.getRow() - 2, this.p.getCol() + 1).getPiece() != null
                    && board.getCell(this.p.getRow() - 2, this.p.getCol() + 1).getPiece().getType() != this.type) {
                m[5] = new Move(this, board.getCell(this.p.getRow() - 2, this.p.getCol() + 1).getPiece(), new Position(this.p.getRow(), this.p.getCol()), new Position(this.p.getRow() - 2, this.p.getCol() + 1));
            }
        } catch (Exception e) {
            //System.out.println(e.getMessage());
        }

        try {
            // Arriba a la derecha 2
            if (board.getCell(this.p.getRow() - 1, this.p.getCol() + 2).getPiece() == null) {
                m[6] = new Move(this, null, new Position(this.p.getRow(), this.p.getCol()), new Position(this.p.getRow() - 1, this.p.getCol() + 2));
            } else if (board.getCell(this.p.getRow() - 1, this.p.getCol() + 2).getPiece() != null
                    && board.getCell(this.p.getRow() - 1, this.p.getCol() + 2).getPiece().getType() != this.type) {
                m[7] = new Move(this, board.getCell(this.p.getRow() - 1, this.p.getCol() + 2).getPiece(), new Position(this.p.getRow(), this.p.getCol()), new Position(this.p.getRow() - 1, this.p.getCol() + 2));
            }
        } catch (Exception e) {
            //System.out.println(e.getMessage());
        }

        try {
            // ABAJO
            // Abajo a la izquierda 1
            if (board.getCell(this.p.getRow() + 2, this.p.getCol() - 1).getPiece() == null) {
                m[8] = new Move(this, null, new Position(this.p.getRow(), this.p.getCol()), new Position(this.p.getRow() + 2, this.p.getCol() - 1));
            } else if (board.getCell(this.p.getRow() + 2, this.p.getCol() - 1).getPiece() != null
                    && board.getCell(this.p.getRow() + 2, this.p.getCol() - 1).getPiece().getType() != this.type) {
                m[9] = new Move(this, board.getCell(this.p.getRow() + 2, this.p.getCol() - 1).getPiece(), new Position(this.p.getRow(), this.p.getCol()), new Position(this.p.getRow() + 2, this.p.getCol() - 1));
            }
        } catch (Exception e) {
            //System.out.println(e.getMessage());
        }

        try {
            // ABAJO
            // Abajo a la izquierda 2
            if (board.getCell(this.p.getRow() + 1, this.p.getCol() - 2).getPiece() == null) {
                m[10] = new Move(this, null, new Position(this.p.getRow(), this.p.getCol()), new Position(this.p.getRow() + 1, this.p.getCol() - 2));
            } else if (board.getCell(this.p.getRow() + 1, this.p.getCol() - 2).getPiece() != null
                    && board.getCell(this.p.getRow() + 1, this.p.getCol() - 2).getPiece().getType() != this.type) {
                m[11] = new Move(this, board.getCell(this.p.getRow() + 1, this.p.getCol() - 2).getPiece(), new Position(this.p.getRow(), this.p.getCol()), new Position(this.p.getRow() + 1, this.p.getCol() - 2));
            }
        } catch (Exception e) {
            //System.out.println(e.getMessage());
        }

        try {
            // ABAJO
            // Abajo a la derecha 1
            if (board.getCell(this.p.getRow() + 2, this.p.getCol() + 1).getPiece() == null) {
                m[12] = new Move(this, null, new Position(this.p.getRow(), this.p.getCol()), new Position(this.p.getRow() + 2, this.p.getCol() + 1));
            } else if (board.getCell(this.p.getRow() + 2, this.p.getCol() + 1).getPiece() != null
                    && board.getCell(this.p.getRow() + 2, this.p.getCol() + 1).getPiece().getType() != this.type) {
                m[13] = new Move(this, board.getCell(this.p.getRow() + 2, this.p.getCol() + 1).getPiece(), new Position(this.p.getRow(), this.p.getCol()), new Position(this.p.getRow() + 2, this.p.getCol() + 1));
            }
        } catch (Exception e) {
            //System.out.println(e.getMessage());
        }

        try {
            // Abajo a la derecha 2
            if (board.getCell(this.p.getRow() + 1, this.p.getCol() + 2).getPiece() == null) {
                m[14] = new Move(this, null, new Position(this.p.getRow(), this.p.getCol()), new Position(this.p.getRow() + 1, this.p.getCol() + 2));
            } else if (board.getCell(this.p.getRow() + 1, this.p.getCol() + 2).getPiece() != null
                    && board.getCell(this.p.getRow() + 1, this.p.getCol() + 2).getPiece().getType() != this.type) {
                m[15] = new Move(this, board.getCell(this.p.getRow() + 1, this.p.getCol() + 2).getPiece(), new Position(this.p.getRow(), this.p.getCol()), new Position(this.p.getRow() + 1, this.p.getCol() + 2));
            }
        } catch (Exception e) {
            //System.out.println(e.getMessage());
        }

        return m;
    }

}
