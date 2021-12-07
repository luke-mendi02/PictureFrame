import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
public class PicturePanel extends JPanel implements MouseListener, MouseMotionListener {
    private String messageToShow;
    private int msgX, msgY;
    private ArrayList<PictureData> datas;
    public PicturePanel(){
        messageToShow = "Welcome";
        setPreferredSize(new Dimension(200,200)); /* if this were not in the center 
        section but had to fight for space in the north or south, it would ask 
        the layout manager to make it 200x200 if possible */
        addMouseListener(this);
        addMouseMotionListener(this);
        msgX = 10;
        msgY = 20;
        datas = new ArrayList<PictureData>();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(messageToShow,msgX,msgY);
        for (PictureData data: datas) {
            g.fillOval(data.getXPos(), data.getYPos(), data.getRadius(), data.getRadius());
        }
        g.drawString(messageToShow,msgX,msgY);
    }
    // for MouseListener, i need mouseClicked, mousePressed, mouseReleased, mouseEntered, mouseExited
    // for MouseMotionListener, i need mouseMoved and mouseDragged
    public void mouseClicked(MouseEvent e){
        messageToShow = String.format("Mouse clicked at (%d, %d)", e.getX(),e.getY());
        msgX = e.getX();
        msgY = e.getY();
        repaint(); // forces paintComponent to be called
    }
    public void mousePressed(MouseEvent e){
        messageToShow = String.format("Mouse pressed at (%d, %d)", e.getX(),e.getY());
        repaint();
    }
    public void mouseReleased(MouseEvent e){
        messageToShow = String.format("Mouse released at (%d, %d)", e.getX(),e.getY());
        repaint();
    }
    public void mouseEntered(MouseEvent e){
        messageToShow = String.format("Mouse entered at (%d, %d)", e.getX(),e.getY());
        repaint();
    }
    public void mouseExited(MouseEvent e){
        messageToShow = String.format("Mouse exited at (%d, %d)", e.getX(),e.getY());
        repaint();
    }
    public void mouseMoved(MouseEvent e){
        messageToShow = String.format("Mouse moved at (%d, %d)", e.getX(),e.getY());
        repaint();
    }
    public void mouseDragged(MouseEvent e){
        messageToShow = String.format("Mouse dragged at (%d, %d)", e.getX(),e.getY());
        PictureData data = new PictureData(e.getX(), e.getY(), 10);
        datas.add(data);
        repaint();
    }
}


