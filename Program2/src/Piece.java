import java.lang.Math;

public class Piece
{
   private Character name;
   private final int id;
   private int row;
   private int col;
   public Piece(char name, int row, int col)
   {
      this.name = name;
      this.row = row;
      this.col = col;
      switch(name)
      {
         case('C'): this.id = -1; break;
         case('c'): this.id = 0; break;
         case('G'): this.id = 1; break;
         case('g'): this.id = 2; break;
         case('E'): this.id = 3; break;
         case('e'): this.id = 4; break;
         default: this.id = -1; break;
      }
   }
   public void captured()
   {
      if(Character.isUpperCase(this.name))
      {
         this.name = Character.toLowerCase(this.name);
         this.col = -1;
      }
      else
      {
         this.name = Character.toUpperCase(this.name);
         this.col = 3;
      }
      if(this.name == 'h') this.name = 'c';
      if(this.name == 'H') this.name = 'C';
      this.row = this.id;
   }
   public void promote()
   {
      if(this.name == 'c') this.name = 'h';
      else if(this.name == 'C') this.name = 'H';
   }
   public int getRow() {return this.row; }
   public int getCol() {return this.col; }
   public Character getName() {return this.name; }
   public void move(int row, int col) throws InvalidMoveException
   {
      
      if(Math.abs(row - this.row) > 1) throw new InvalidMoveException();
      if(Math.abs(col - this.col) > 1) throw new InvalidMoveException();
      if(this.row == row && this.col == col) throw new InvalidMoveException();
      if(this.row == -1) throw new InvalidMoveException();
      if(this.name == 'C' && (col != this.col || row != this.row - 1)) throw new InvalidMoveException();
      if(this.name == 'c' && (col != this.col || row - 1 != this.row)) throw new InvalidMoveException();
      if(this.name == 'G' && col != this.col && row != this.row) throw new InvalidMoveException();
      if(this.name == 'g' && col != this.col && row != this.row) throw new InvalidMoveException();
      if(this.name == 'E' && (row == this.row || col == this.col)) throw new InvalidMoveException();
      if(this.name == 'e' && (row == this.row || col == this.col)) throw new InvalidMoveException();
      if(this.name == 'H' && (row == this.row + 1) && (col != this.col)) throw new InvalidMoveException();
      if(this.name == 'h' && (row == this.row - 1) && (col != this.col)) throw new InvalidMoveException();
      this.row = row;
      this.col = col;
   }
   public void place(int row, int col) throws InvalidMoveException
   {
      if(this.col != -1 && this.col != 3) throw new InvalidMoveException();
      this.row = row;
      this.col = col;
   }
}