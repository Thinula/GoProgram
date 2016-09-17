import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Board implements MouseListener
{
    // NEED TO FIX: MOUSE LISTENER
    private int move,mouseX,mouseY;
    private char[][] board;

    public Board()
    {
        move = 0;
        mouseX = 0;
        mouseY = 0;
        board = new char[19][19]; // size of go board
        // read board from bottom left towards top right

        for (int i = 0; i < 19; i++)
        {
            for (int j = 0; j < 19; j++)
                board[i][j] = ' ';
        }

        board[3][3] = 'S';
        board[3][10] = 'S';
        board[3][15] = 'S';
        board[10][3] = 'S';
        board[10][10] = 'S';
        board[10][15] = 'S';
        board[15][3] = 'S';
        board[15][10] = 'S';
        board[15][15] = 'S';

        //addMouseListener(this);
    }

    public int getMove()
    {
        return move;
    }

    public void setMove(int m)
    {
        move = m;
    }

    public int getMouseX()
    {
        return mouseX;
    }
    
    public void setMouseX(int x)
    {
        mouseX = x;
    }

    public int getMouseY()
    {
        return mouseY;
    }
    
    public void setMouseY(int y)
    {
        mouseY = y;
    }

    public void setChar(int x, int y, char c)
    {
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length)
        {
            board[x][y] = c;
        }
    }

    // game algorithms
    public void Capture ()
    {

    }

    public void mouseClicked (MouseEvent b)
    {
        //         while (move != -1)
        //         {
        //             mouseX = b.getX ();
        //             mouseY = b.getY ();
        //             System.out.println(mouseX);
        //             System.out.println(mouseY);
        //             if (move % 2 == 0)
        //                 board[mouseX%19][mouseY%19] = 'B';
        //             else
        //                 board[mouseX%19][mouseY%19] = 'W';
        //             move ++;
        //         }
        // move++;
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

    public void paint(Graphics g)
    {
        // setting bounds for the grid
        int lbound = 25;
        int rbound = 385;
        int ubound = 100;
        int dbound = 460;
        int increm = (rbound - lbound)/18;
        int rad = 3;

        // creating the colour of the go board
        Color brown = new Color (150,110,50);
        g.setColor(brown);
        g.fillRect (lbound,ubound,rbound-lbound,dbound-ubound);

        // creating the grid
        g.setColor (Color.black);

        for (int i = lbound; i <= rbound; i += increm)
            g.drawLine (i,dbound,i,ubound);

        for (int j = ubound; j <= dbound; j += increm)
            g.drawLine (lbound,j,rbound,j);

        for (int k = lbound+3*increm; k <= rbound-3*increm; k += 6*increm)
        {
            for (int l = ubound+3*increm; l <= dbound-3*increm; l += 6*increm)
                g.fillOval (k-rad,l-rad,2*rad,2*rad);
        }

        if (move % 2 == 1)
        {
            g.setColor (Color.black);
            g.drawOval (mouseX-1,mouseY-1,5,6);
        }
        else 
        {
            g.setColor (Color.white);
            g.drawOval (mouseX-1,mouseY-1,2,2);
        }
    }
} 
