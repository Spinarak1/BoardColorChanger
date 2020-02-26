import javax.swing.*;
import java.awt.*;

public class CheckerBoard extends JComponent {
    private int cellSize = 50;
    private Color c1 = Color.black;
    private Color c2 = Color.white;
    @Override
    public void paintComponent(Graphics g){
        g.setColor(c1);
        g.fillRect(0,0 ,getWidth(), getHeight());
        int x = 0;
        int y = 0;
        int licznikY = 0;
        g.setColor(c2);
        while(y<getHeight()) {
            if(licznikY % 2 == 0)
                x = 0;
            else
                x = cellSize;
            while (x < getWidth()) {
                g.fillRect(x, y, cellSize, cellSize);
                x = x + 2*cellSize;
            }
            licznikY++;
            y = y+cellSize;
        }
    }

    public int getCellSize() {
        return cellSize;
    }

    public Color getC1() {
        return c1;
    }

    public Color getC2() {
        return c2;
    }

    public void setCellSize(int n){
        cellSize = n;
        repaint();
    }
    public void setColor1(Color color){
        c1 = color;
    }
    public void setColor2(Color color){
        c2 = color;
    }
}
//narysowac szachownice(dokonczyc)
//1 z matur