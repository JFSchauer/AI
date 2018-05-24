/*
  Board.java
  implements the board for Dobutsu shogi
  the board is represented by an array of pieces.
  a uppercase letter represents the black (first player's) pieces
  a lowercase letter represents the white (second player's) pieces
  E=elephant
  L=lion
  G=giraffe
  C=chick
  H=hen (promoted chick)
  Board also implements moves, and checks if they are legal.
  Board also implements a getState that returns if the game is over.
*/

public class Board
{
  private boolean blackWins = false;
  private boolean whiteWins = false;
  private static int rows = 4;
  private static int cols = 3;
  private Piece[] pieces = new Piece[8];
  private int turn = 0;
  private int player = 0;

  public Board()
  {
    pieces[0] = new Piece('L', 3, 1);
    pieces[1] = new Piece('l', 0, 1);
    pieces[2] = new Piece('E', 3, 0);
    pieces[3] = new Piece('e', 0, 2);
    pieces[4] = new Piece('G', 3, 2);
    pieces[5] = new Piece('g', 0, 0);
    pieces[6] = new Piece('C', 2, 1);
    pieces[7] = new Piece('c', 1, 1);
  }

  public Piece[] getState() {return pieces; }

  public int getResult()
  {
     if(blackWins) return 1;
     if(whiteWins) return -1;
     return 0;
  }

  public void movePiece(int row1, int col1, int row2, int col2) throws InvalidMoveException
  {
     if(row2 >= rows || row2 < 0) throw new InvalidMoveException();
     if(col2 >= cols || col2 < 0) throw new InvalidMoveException();
    

     int i = 0;
     int j = 0;
     for(; i < 8; ++i)
        if(pieces[i].getRow() == row1 && pieces[i].getCol() == col1) break;
     if(i == 8) throw new InvalidMoveException();

     Character name = pieces[i].getName();
     if(this.player == 0 && Character.isLowerCase(name)) throw new InvalidMoveException();
     if(this.player == 1 && Character.isUpperCase(name)) throw new InvalidMoveException();
     
     if(col1 == -1 || col1 == cols)
     {
        this.placePiece(pieces[i], row2, col2);
        return;
     }  

     for(; j < 8; ++j)
       if(pieces[j].getRow() == row2 && pieces[j].getCol() == col2) break;
     if(j != 8)
     {
        if(this.player == 0 && Character.isUpperCase(pieces[j].getName()))
           throw new InvalidMoveException();
        if(this.player == 1 && Character.isLowerCase(pieces[j].getName()))
           throw new InvalidMoveException();
        this.pieces[i].move(row2, col2);
        if(pieces[j].getName() == 'L') whiteWins = true;
        if(pieces[j].getName() == 'l') blackWins = true;
     
        pieces[j].captured();
     }

     if(pieces[0].getRow() == 0 && this.player == 1) blackWins = true;
     if(pieces[1].getRow() == rows - 1 && this.player == 0) whiteWins = true;

     if(j == 8)
     {
       this.pieces[i].move(row2, col2);
     }
     
     this.player = (this.player + 1) % 2;
     this.turn++;
     
     if(pieces[i].getName() == 'c' && row2 == rows - 1) this.pieces[i].promote();
     if(pieces[i].getName() == 'C' && row2 == 0) this.pieces[i].promote();
     return;
  }

  public void placePiece(Piece p, int row, int col) throws InvalidMoveException
  {
      for(int j = 0; j < 8; ++j)
         if(this.pieces[j].getRow() == row && this.pieces[j].getCol() == col)
            throw new InvalidMoveException();
      if(this.player == 0 && Character.isLowerCase(p.getName()))
         throw new InvalidMoveException();
      if(this.player == 1 && Character.isUpperCase(p.getName()))
         throw new InvalidMoveException();
      p.place(row, col);
      this.player = (this.player + 1) % 2;
      this.turn++;
  }

}