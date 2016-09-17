import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GoProgram extends JFrame implements MouseListener
{
    private Board board;

    public GoProgram()
    {
        board = new Board();
        Color green = new Color (0,50,0);      

        JPanel content = new JPanel();
        DrawArea screen = new DrawArea (700, 500);
        screen.addMouseListener(this);
        content.add(screen);

        setContentPane(content);
        pack();
        setTitle ("Go Server");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    class DrawArea extends JPanel
    {
        public DrawArea (int width, int height)
        {
            this.setPreferredSize (new Dimension (width, height)); // size
        }

        public void paintComponent (Graphics g)
        {
            board.paint (g);
        }
    }

    public void mouseClicked (MouseEvent b)
    {
        int x,y;
        int move = board.getMove();
        while (move != -1)
        {
            x = b.getX();
            y = b.getY();
            System.out.println(x + " " + y + " " + move);

            if (move % 2 == 0)
                board.setChar(x%19,y%19,'B');
            else
                board.setChar(x%19,y%19,'W');
            move++;
            board.setMove(move);
            board.setMouseX(x);
            board.setMouseY(y);
            repaint();
        }
    }

    public void mousePressed (MouseEvent a)
    {
    }

    public void mouseEntered (MouseEvent c)
    {
    }

    public void mouseExited (MouseEvent d)
    {
    }

    public void mouseReleased (MouseEvent e)
    {
    }

    public static void main (String[] args)
    {
        GoProgram go = new GoProgram();
        go.setVisible(true);
    }   
} 
