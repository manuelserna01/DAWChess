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
public class Bishop extends Piece {

    public Bishop() {
        super();
        this.letter = 'B';
    }

    public Bishop(int row, int col, PieceType type, boolean alive, String id) {
        super(row, col);
        this.type = type;
        this.alive = alive;
        this.letter = 'B';
        this.setId(id);
    }

    @Override
    public Move[] getMoves(Board board) {
        Move[] m = new Move[20];
        Move[] tempo;
        int c = 0;

        // Abajo derecha
        tempo = this.getDiagonal(board, 1, 1);
        for (int i = 0; i < tempo.length; i++) {
            if (tempo[i] != null) {
                m[c] = tempo[i];
                c++;
            }
        }

        // Abajo izquierda
        tempo = this.getDiagonal(board, 1, -1);
        for (int i = 0; i < tempo.length; i++) {
            if (tempo[i] != null) {
                m[c] = tempo[i];
                c++;
            }
        }
        
        
        // Arriba derecha
        tempo = this.getDiagonal(board, -1, 1);
        for (int i = 0; i < tempo.length; i++) {
            if (tempo[i] != null) {
                m[c] = tempo[i];
                c++;
            }
        }

        // arriba izquierda
        tempo = this.getDiagonal(board, -1, -1);
        for (int i = 0; i < tempo.length; i++) {
            if (tempo[i] != null) {
                m[c] = tempo[i];
                c++;
            }
        }
        return m;
    }

}
