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
public class Rook extends Piece {

    
    public Rook() {
        super();
        this.letter = 'R';
    }

    /**
     * 
     * @param row asdasdas
     * @param col
     * @param type
     * @param alive
     * @param id 
     */
    public Rook(int row, int col, PieceType type, boolean alive, String id) {
        super(row, col);
        this.type = type;
        this.alive = alive;
        this.letter = 'R';
        this.setId(id);
    }

    /**
     * 
     * @param board se le pasa el tablero
     * @return hace un return de los movimientos
     */
    @Override
    public Move[] getMoves(Board board) {
        
        Move[] m = new Move[20];
        Move[] tempo;
        int c = 0;

        // derecha
        tempo = this.getHorizontalMoves(board, this.p.getRow(), this.p.getCol(), 7);
        for (int i = 0; i < tempo.length; i++) {
            if (tempo[i] != null) {
                m[c] = tempo[i];
                c++;
            }
        }
        
        // izquierda
        tempo = this.getHorizontalMoves(board, this.p.getRow(), this.p.getCol(), -7);
        for (int i = 0; i < tempo.length; i++) {
            if (tempo[i] != null) {
                m[c] = tempo[i];
                c++;
            }
        }

        // arriba
        tempo = this.getVertical(board, this.p.getCol(), this.p.getRow(), 7);
        for (int i = 0; i < tempo.length; i++) {
            if (tempo[i] != null) {
                m[c] = tempo[i];
                c++;
            }
        }
        
        // abajo
        tempo = this.getVertical(board, this.p.getCol(), this.p.getRow(), -7);
        for (int i = 0; i < tempo.length; i++) {
            if (tempo[i] != null) {
                m[c] = tempo[i];
                c++;
            }
        }

        return m;
    }

}
