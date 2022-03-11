/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.chess.model.ChessPiece;

import pedro.ieslaencanta.com.chess.model.Board;
import pedro.ieslaencanta.com.chess.model.Move;

/**
 *
 * @author Manuel
 */

public class Pawn extends Piece {

    public Pawn() {
        super();
        this.letter = 'P';
    }

    public Pawn(int row, int col, PieceType type, boolean alive, String id) {
        super(row, col);
        this.type = type;
        this.alive = alive;
        this.letter = 'P';
        this.setId(id);
    }

    @Override
    public Move[] getMoves(Board board) {
        Move[] m = new Move[3];

        if (this.getType() == PieceType.White) {
            // Si está en la fila 6, se realizan los dos movimientos, sino, no.
            if (this.getPosition().getRow() == 6) {
                m = this.getVertical(board, this.p.getCol(), this.p.getRow(), this.p.getRow() - 2);
            } else {
                m = this.getVertical(board, this.p.getCol(), this.p.getRow(), this.p.getRow() - 1);
            }
        } else if (this.getType() == PieceType.Black) {
            if (this.getPosition().getRow() == 1) {
                m = this.getVertical(board, this.p.getCol(), this.p.getRow(), this.p.getRow() + 2);
            } else {
                m = this.getVertical(board, this.p.getCol(), this.p.getRow(), this.p.getRow() + 1);
            }
        }
        return m;
    }

}
