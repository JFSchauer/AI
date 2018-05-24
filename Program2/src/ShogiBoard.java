
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
   private JLabel roosterLabel;
   private JLabel roosterLabel2;
   private int[] buffer = new int[2];
   private Piece[] state = new Piece[8];
   
   @Override
   public void paint(Graphics g)
   {
      super.paint(g);
      state = sboard.getState();

      for(int i = 0; i < 8; ++i)
      {
         if(Character.isLowerCase(state[i].getName()))
         {
            g.setColor(Color.WHITE);
            g.drawRect(74 + 70 * (state[i].getCol() + 1), 20 + 38 + 71 * (state[i].getRow() + 1), 70, 71);
            g.drawRect(74 + 70 * (state[i].getCol() + 1) + 1, 20 + 38 + 71 * (state[i].getRow() + 1) + 1, 68, 69);
            g.drawRect(74 + 70 * (state[i].getCol() + 1) + 2, 20 + 38 + 71 * (state[i].getRow() + 1) + 2, 66, 68); 
         }
         else
         {
            g.setColor(Color.BLACK);
            g.drawRect(74 + 70 * (state[i].getCol() + 1), 20 + 38 + 71 * (state[i].getRow() + 1), 70, 71);
            g.drawRect(74 + 70 * (state[i].getCol() + 1) + 1, 20 + 38 + 71 * (state[i].getRow() + 1) + 1, 68, 69);
            g.drawRect(74 + 70 * (state[i].getCol() + 1) + 2, 20 + 38 + 71 * (state[i].getRow() + 1) + 2, 66, 68); 
         }
      }


      lionLabel.setBounds(74 + 70 * (state[0].getCol() + 1), 38 + 71 * (state[0].getRow() + 1), 68, 69);
      lionLabel2.setBounds(74 + 70 * (state[1].getCol() + 1), 38 + 71 * (state[1].getRow() + 1), 68, 69);
      elephantLabel.setBounds(74 + 70 * (state[2].getCol() + 1), 38 + 71 * (state[2].getRow() + 1), 68, 69);
      elephantLabel2.setBounds(74 + 70 * (state[3].getCol() + 1), 38 + 71 * (state[3].getRow() + 1), 68, 69);
      giraffeLabel.setBounds(74 + 70 * (state[4].getCol() + 1), 38 + 71 * (state[4].getRow() + 1), 68, 69);
      giraffeLabel2.setBounds(74 + 70 * (state[5].getCol() + 1), 38 + 71 * (state[5].getRow() + 1), 68, 69);
      if(state[6].getName() == 'C' || state[6].getName() == 'c')
      {
         contentPane.remove(chickLabel);
         contentPane.add(chickLabel);
         contentPane.remove(roosterLabel);
         contentPane.revalidate();
         chickLabel.setBounds(74 + 70 * (state[6].getCol() + 1), 38 + 71 * (state[6].getRow() + 1), 68, 69);
      }
      else
      {
         contentPane.remove(roosterLabel);
         contentPane.add(roosterLabel);
         contentPane.remove(chickLabel);
         roosterLabel.setBounds(74 + 70 * (state[6].getCol() + 1), 38 + 71 * (state[6].getRow() + 1), 68, 69);
      }
      if(state[7].getName() == 'C' || state[7].getName() == 'c') 
      {
         contentPane.remove(roosterLabel2);
         contentPane.remove(chickLabel2);
         contentPane.add(chickLabel2);
         chickLabel2.setBounds(74 + 70 * (state[7].getCol() + 1), 38 + 71 * (state[7].getRow() + 1), 68, 69);
      }
      else
      {
         contentPane.remove(chickLabel2);
         contentPane.remove(roosterLabel2);
         contentPane.add(roosterLabel2);
         roosterLabel2.setBounds(74 + 70 * (state[7].getCol() + 1), 38 + 71 * (state[7].getRow() + 1), 68, 69);
      }
      
      
      
   }

   public ShogiBoard()
   {
      sboard = new Board();
      buffer[0] = buffer[1] = -2;
      
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setSize(500,500);
      
      contentPane = this.getLayeredPane();
      contentPane.setPreferredSize(new Dimension(500, 500));
      imageLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/shogiboard.jpg")));
      lionLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/Lion.png")));
      elephantLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/Elephant.png")));
      giraffeLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/Giraffe.png")));
      chickLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/Chick.png")));
      lionLabel2 = new JLabel(new ImageIcon(getClass().getResource("/resources/Lion.png")));
      elephantLabel2 = new JLabel(new ImageIcon(getClass().getResource("/resources/Elephant.png")));
      giraffeLabel2 = new JLabel(new ImageIcon(getClass().getResource("/resources/giraffe.png")));
      chickLabel2 = new JLabel(new ImageIcon(getClass().getResource("/resources/chick.png")));
      roosterLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/rooster.png")));
      roosterLabel2 = new JLabel(new ImageIcon(getClass().getResource("/resources/rooster.png")));
      
      imageLabel.setBounds(0, 0, 500, 500);
      lionLabel.setBounds(215, 323, 68, 69);
      elephantLabel.setBounds(144, 323, 68, 69);
      giraffeLabel.setBounds(285, 323, 68, 69);
      chickLabel.setBounds(215, 252, 68, 69);
      chickLabel2.setBounds(215, 180, 68, 69);
      lionLabel2.setBounds(215, 109, 68, 69);
      elephantLabel2.setBounds(285, 109, 68, 69);
      giraffeLabel2.setBounds(144, 109, 68, 69);
      roosterLabel.setBounds(500, 500, 1, 1);
      roosterLabel2.setBounds(500, 500, 1, 1);

      

      this.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e)
         {
            //int row = e.getY();
            //int col = e.getX();
            int row = Math.round( ( (float) (e.getY() - 62) / 71) - (float) 0.5 );
            int col = Math.round( ( (float) (e.getX() - 74) / 70) - (float) 0.5 );
            System.out.print(row);
            System.out.print("   ");
            System.out.println(col);
            if(buffer[0] == -2)
            {
               buffer[0] = row;
               buffer[1] = col;
            }
            else
            {
               try
               {
                  sboard.movePiece(buffer[0] - 1, buffer[1] - 1 , row - 1, col - 1);
               }
               catch(InvalidMoveException ime)
               {
                  System.out.println("Invalid move.");
               }
               if(sboard.getResult() == 1)
                  System.out.println("Black Won!");
               if(sboard.getResult() == -1)
                  System.out.println("White Won!");
               buffer[0] = buffer[1] = -2;
            }
            repaint();
            repaint();
         }
      });

      contentPane.add(imageLabel, new Integer(0), 0);
      contentPane.add(lionLabel, new Integer(1), 0);
      contentPane.add(elephantLabel, new Integer(1), 1);
      contentPane.add(giraffeLabel, new Integer(1), 2);
      contentPane.add(chickLabel, new Integer(1), 3);
      contentPane.add(lionLabel2, new Integer(1), 4);
      contentPane.add(chickLabel2, new Integer(1), 6);
      contentPane.add(elephantLabel2, new Integer(1), 6);
      contentPane.add(giraffeLabel2, new Integer(1), 7);
      contentPane.add(roosterLabel, new Integer(1), 8);
      contentPane.add(roosterLabel2, new Integer(1), 9);
   }

   public static void main(String[] args)
   {
       ShogiBoard sb = new ShogiBoard();
       sb.setResizable(false);
       sb.setVisible(true);
   }
}

