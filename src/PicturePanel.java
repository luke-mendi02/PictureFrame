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
    // initializing variables
    private String messageToShow;
    private int msgX, msgY;
    private ArrayList<PictureData> datas;
    private ArrayList<PictureData> imageData = new ArrayList<PictureData>(PictureDataReader.readPictureDataFromFile());
    private ArrayList<BufferedImage> imageList = new ArrayList<BufferedImage>(PictureLoader.loadImagesFromPictureData(imageData));
    private BufferedImage picture = imageList.get(0);
    private int currentIndex;
    // creating getters and setters for variables
    public ArrayList<BufferedImage> getImageList() {
        return imageList;
    }
    public ArrayList<PictureData> getImageData() {
        return imageData;
    }

    public void setImageList(ArrayList<BufferedImage> imageList) {
        this.imageList = imageList;
    }
    public void setImageData(ArrayList<PictureData> imageData) {
        this.imageData = imageData;
    }
    // creating picturePanel default constructor
    public PicturePanel(){
        messageToShow = "x=0, y=0";
        setPreferredSize(new Dimension(200,200)); 
        addMouseListener(this);
        msgX = 10;
        msgY = 20;
        datas = new ArrayList<PictureData>();
    }
    // painting images and coordinates to panel
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try{
            g.drawImage(picture,0,0,null);
            repaint();
        } catch (Exception ex) {
        
   }
        g.drawString(messageToShow,msgX,msgY);
        for (PictureData data: datas) {
            g.fillOval(data.getXPos(), data.getYPos(), data.getRadius(), data.getRadius());
        }

    }
    // creating mouse events
    public void mouseClicked(MouseEvent e){
        messageToShow = String.format("x=%d, y=%d", e.getX(),e.getY());
        msgX = e.getX();
        msgY = e.getY();
        repaint(); 
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
    messageToShow = String.format("x=%d, y=%d", e.getX(),e.getY());
    repaint();
}
public void mouseDragged(MouseEvent e){
    
}
/**
 * takes in a BufferedImage Object, sets it to the picture variable, and repaints the screen to show the image
 * @param picture BufferedImage object
 */
public void setPicture(BufferedImage picture){
    this.picture = picture;
    repaint();
}

}


