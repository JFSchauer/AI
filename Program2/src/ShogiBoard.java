/*import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
*/

/*
   Position x, y is 74 + 70*x, 38 + 71*y where 0,0 is top left

*/
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.JLayeredPane;

public class ShogiBoard extends JFrame
{
   private Board sboard;
   private JLayeredPane contentPane;
   private JLabel imageLabel;
   private JLabel lionLabel;
   private JLabel elephantLabel;
   private JLabel giraffeLabel;
   private JLabel chickLabel;
   private JLabel lionLabel2;
   private JLabel elephantLabel2;
   private JLabel giraffeLabel2;
   private JLabel chickLabel2;
   private int buffer1;
   private int buffer2;
   private Piece[] state = new Piece[8];

   public void displayBoard()
   {

      state = sboard.getState();

      lionLabel.setBounds(74 + 70 * (state[0].getCol() + 1), 38 + 71 * (state[0].getRow() + 1), 70, 71);
      lionLabel2.setBounds(74 + 70 * (state[1].getCol() + 1), 38 + 71 * (state[1].getRow() + 1), 70, 71);
      elephantLabel.setBounds(74 + 70 * (state[2].getCol() + 1), 38 + 71 * (state[2].getRow() + 1), 70, 71);
      elephantLabel2.setBounds(74 + 70 * (state[3].getCol() + 1), 38 + 71 * (state[3].getRow() + 1), 70, 71);
      giraffeLabel.setBounds(74 + 70 * (state[4].getCol() + 1), 38 + 71 * (state[4].getRow() + 1), 70, 71);
      giraffeLabel2.setBounds(74 + 70 * (state[5].getCol() + 1), 38 + 71 * (state[5].getRow() + 1), 70, 71);
      chickLabel.setBounds(74 + 70 * (state[6].getCol() + 1), 38 + 71 * (state[6].getRow() + 1), 70, 71);
      chickLabel2.setBounds(74 + 70 * (state[7].getCol() + 1), 38 + 71 * (state[7].getRow() + 1), 70, 71);


/*
      lionLabel.setBounds(215, 323, 70, 71);
      elephantLabel.setBounds(144, 323, 70, 71);
      giraffeLabel.setBounds(285, 323, 70, 71);
      chickLabel.setBounds(215, 252, 70, 71);
      chickLabel2.setBounds(215, 180, 70, 71);
      lionLabel2.setBounds(215, 109, 70, 71);
      elephantLabel2.setBounds(285, 109, 70, 71);
      giraffeLabel2.setBounds(144, 109, 70, 71);
*/
      
      contentPane.add(imageLabel, new Integer(1), 0);
      contentPane.add(lionLabel, new Integer(2), 0);
      contentPane.add(elephantLabel, new Integer(2), 1);
      contentPane.add(giraffeLabel, new Integer(2), 2);
      contentPane.add(chickLabel, new Integer(2), 3);
      contentPane.add(lionLabel2, new Integer(2), 4);
      contentPane.add(chickLabel2, new Integer(2), 5);
      contentPane.add(elephantLabel2, new Integer(2), 6);
      contentPane.add(giraffeLabel2, new Integer(2), 7);


   }

   public ShogiBoard()
   {
      sboard = new Board();
      //JFrame frame = new JFrame("Dobutsu Shogi");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setSize(500,500);
      //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      contentPane = this.getLayeredPane();
      contentPane.setPreferredSize(new Dimension(500, 500));
      imageLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/shogiboard.jpg")));
      lionLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/Lion.png")));
      elephantLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/Elephant.png")));
      giraffeLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/Giraffe.png")));
      chickLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/Chick.png")));
      lionLabel2 = new JLabel(new ImageIcon(getClass().getResource("/resources/Lion2.png")));
      elephantLabel2 = new JLabel(new ImageIcon(getClass().getResource("/resources/Elephant2.png")));
      giraffeLabel2 = new JLabel(new ImageIcon(getClass().getResource("/resources/giraffe2.png")));
      chickLabel2 = new JLabel(new ImageIcon(getClass().getResource("/resources/chick2.png")));
      
      imageLabel.setBounds(0, 0, 500, 500);           

      this.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e)
         {
            int row = e.getX();
            int col = e.getY();
            //int row = Math.round( ( (float) (e.getY() - 38) / 71) - (float) 0.5 );
            //int col = Math.round( ( (float) (e.getX() - 74) / 70) - (float) 0.5 );
            System.out.print(row);
            System.out.print("   ");
            System.out.println(col);
         }
      });




      this.displayBoard();
   }

   public static void main(String[] args)
   {
       ShogiBoard sb = new ShogiBoard();
       sb.setResizable(false);
       sb.setVisible(true);
   }



}