import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
public class PicturePanel extends JPanel implements MouseListener, MouseMotionListener{
    private String messageToShow;
    private int msgX, msgY;
    private ArrayList<PictureData> datas;
    private ArrayList<PictureData> imageData = new ArrayList<PictureData>(PictureDataReader.readPictureDataFromFile());
    private ArrayList<BufferedImage> imageList = new ArrayList<BufferedImage>(PictureLoader.loadImagesFromPictureData(imageData));
    private BufferedImage picture = 
    public PicturePanel(){
        messageToShow = "x=0, y=0";
        setPreferredSize(new Dimension(200,200)); /* if this were not in the center 
        section but had to fight for space in the north or south, it would ask 
        the layout manager to make it 200x200 if possible */
        addMouseListener(this);
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
        //try{
        //    BufferedImage img = ImageIO.read(new File("pic1.png"));
        //    g.drawImage(picture,0,0,null);
        //} catch (Exception ex) {
         //   System.out.println("e");
   //}
    }
    // for MouseListener, i need mouseClicked, mousePressed, mouseReleased, mouseEntered, mouseExited
    // for MouseMotionListener, i need mouseMoved and mouseDragged
    public void mouseClicked(MouseEvent e){
        messageToShow = String.format("x=%d, y=%d", e.getX(),e.getY());
        msgX = e.getX();
        msgY = e.getY();
        repaint(); // forces paintComponent to be called
    }
    public void mousePressed(MouseEvent e){

    }
    public void mouseReleased(MouseEvent e){
       
    }
    public void mouseEntered(MouseEvent e){

    }
    public void mouseExited(MouseEvent e){
 
    }
    public void mouseMoved(MouseEvent e){
        messageToShow = String.format("Mouse moved at (%d, %d)", e.getX(),e.getY());
        repaint();
    }
    public void mouseDragged(MouseEvent e){
        messageToShow = String.format("Mouse dragged at (%d, %d)", e.getX(),e.getY());
        repaint();
    }
    public void setPicture(BufferedImage picture){
        this.picture = picture;

        repaint();
    }

}


