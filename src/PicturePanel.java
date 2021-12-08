import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PicturePanel extends JPanel implements MouseListener, MouseMotionListener{
    private String messageToShow;
    private int msgX, msgY;
    private ArrayList<PictureData> datas;
    private ArrayList<PictureData> imageData = new ArrayList<PictureData>(PictureDataReader.readPictureDataFromFile());
    private ArrayList<BufferedImage> imageList = new ArrayList<BufferedImage>(PictureLoader.loadImagesFromPictureData(imageData));
    private BufferedImage picture = imageList.get(0);
    private int currentIndex;
    
    //int currentIndex = JPanel.getCurrentIndex();
    public PicturePanel(){
        messageToShow = "x=0, y=0";
        setPreferredSize(new Dimension(200,200)); 
        addMouseListener(this);
        msgX = 10;
        msgY = 20;
        datas = new ArrayList<PictureData>();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try{
            //setPicture(imageList.get(currentIndex));
            g.drawImage(picture,0,0,null);
            repaint();
        } catch (Exception ex) {
         //   System.out.println("e");
   }
        g.drawString(messageToShow,msgX,msgY);
        for (PictureData data: datas) {
            g.fillOval(data.getXPos(), data.getYPos(), data.getRadius(), data.getRadius());
        }

    }
    public class nextBtnHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            currentIndex = currentIndex + 1;
            setPicture(imageList.get(currentIndex));
            repaint();
        }
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


