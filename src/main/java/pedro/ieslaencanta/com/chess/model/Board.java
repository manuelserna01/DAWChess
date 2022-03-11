/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.chess.model;

import pedro.ieslaencanta.com.chess.model.ChessPiece.Bishop;
import pedro.ieslaencanta.com.chess.model.ChessPiece.King;
import pedro.ieslaencanta.com.chess.model.ChessPiece.Knight;
import pedro.ieslaencanta.com.chess.model.ChessPiece.Pawn;
import pedro.ieslaencanta.com.chess.model.ChessPiece.Piece;
import pedro.ieslaencanta.com.chess.model.ChessPiece.PieceType;
import pedro.ieslaencanta.com.chess.model.ChessPiece.Queen;
import pedro.ieslaencanta.com.chess.model.ChessPiece.Rook;

/**
 *
 * @author Pedro
 */
public class Board {

    private Cell[][] cells;

    public Board() {
        this.reset();
    }

    public void reset() {
        this.cells = new Cell[8][8];
        for (int i = 0; i < this.cells.length; i++) {

            // aquí colocamos las piezas que creemos
            for (int j = 0; j < this.cells[i].length; j++) {
                this.cells[i][j] = new Cell(i, j);
            }
        }

        // Colocamos los peones blancos y negros
        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++) {
                // Printeamos las peones blancos
                this.cells[6][i].setPiece(new Pawn(6, i, PieceType.White, true, ""+2+i));

                // Printeamos los peones negros
                this.cells[1][i].setPiece(new Pawn(1, i, PieceType.Black, true, ""+3+i));
            }
        }
       

        // Colocamos el Bishop
        // Printeamos las Bishop NEGROS
        this.cells[0][2].setPiece(new Bishop(0, 2, PieceType.Black, true, "1"));
        this.cells[0][5].setPiece(new Bishop(0, 5, PieceType.Black, true, "2"));
        // Printeamos los Bishop BLANCOS
        this.cells[7][2].setPiece(new Bishop(7, 2, PieceType.White, true, "3"));
        this.cells[7][5].setPiece(new Bishop(7, 5, PieceType.White, true, "4"));
        
        // Colocamos el King
        // Printeamos las King NEGROS
        this.cells[0][4].setPiece(new King(0, 4, PieceType.Black, true, "5"));
        // Printeamos los King BLANCOS
        this.cells[7][4].setPiece(new King(7, 4, PieceType.White, true, "6"));
        
        // Colocamos el Queen
        // Printeamos las Queen NEGROS
        this.cells[0][3].setPiece(new Queen(0, 3, PieceType.Black, true, "7"));
        // Printeamos los Queen BLANCOS
        this.cells[7][3].setPiece(new Queen(7, 3, PieceType.White, true, "8"));
        
        // Colocamos el Rook
        // Printeamos las Rook NEGROS
        this.cells[0][0].setPiece(new Rook(0, 0, PieceType.Black, true, "9"));
        this.cells[0][7].setPiece(new Rook(0, 7, PieceType.Black, true, "10"));
        // Printeamos los Rook BLANCOS
        this.cells[7][0].setPiece(new Rook(7, 0, PieceType.White, true, "1"));
        this.cells[7][7].setPiece(new Rook(7, 7, PieceType.White, true, "12"));
        
        // Colocamos el Knight
        // Printeamos las Knight NEGROS
        this.cells[0][1].setPiece(new Knight(0, 1, PieceType.Black, true, "13"));
        this.cells[0][6].setPiece(new Knight(0, 6, PieceType.Black, true, "14"));
        // Printeamos los Knight BLANCOS
        this.cells[7][1].setPiece(new Knight(7, 1, PieceType.White, true, "15"));
        this.cells[7][6].setPiece(new Knight(7, 6, PieceType.White, true, "16"));
        

    }

    public Cell getCell(int row, int col) {
        return this.cells[row][col];
    }

    public int getHeight() {
        return this.cells.length;
    }

    public int getWidht() {
        return this.cells[0].length;
    }

    public Move move(int star_row, int star_col, int end_row, int end_col) {
        Piece p = this.cells[star_row][star_col].getPiece();

        Move m = null;
        if (p != null) {
            m = p.move(this, end_row, end_col);
            this.cells[star_row][star_col].setPiece(null);
            this.cells[end_row][end_col].setPiece(p);
        }
        return m;
    }

    @Override
    public String toString() {
        StringBuffer vuelta = new StringBuffer();
        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++) {
                vuelta.append(this.cells[i][j].toString() + " ");
            }
            vuelta.append("\n");
        }
        return vuelta.toString();
    }

}
