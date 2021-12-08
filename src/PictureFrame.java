import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
public class PictureFrame extends JFrame{
    private ArrayList<PictureData> imageData = new ArrayList<PictureData>(PictureDataReader.readPictureDataFromFile());
    private ArrayList<BufferedImage> imageList = new ArrayList<BufferedImage>(PictureLoader.loadImagesFromPictureData(imageData));
    private int currentIndex = 0;
    //private PicturePanel picture;
    public ArrayList<BufferedImage> getImageList() {
        return imageList;
    }
    public ArrayList<PictureData> getImageData() {
        return imageData;
    }
    //public void setImageList(ArrayList<BufferedImage> imageList) {
      //  this.imageList = imageList;
    //}
    //public void setImageData(ArrayList<PictureData> imageData) {
      //  this.imageData = imageData;
    //}
    public int getCurrentIndex(){
        return currentIndex;
    }
    public void setCurrentIndex(int currentIndex){
        this.currentIndex = currentIndex;
    }
    public void setupMainMenu(){
        JMenuBar mbar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        JMenu mnuHelp = new JMenu("Help");
        mbar.add(mnuFile);
        mbar.add(mnuHelp);
        JMenuItem miSave = new JMenuItem("Save");
        mnuFile.add(miSave);
        miSave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //ArrayList<PictureData> imageData = getImageData();
                JFileChooser jfc = new JFileChooser();
                if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    PictureDataWriter.writePictureDataToFile(getImageData(), jfc.getSelectedFile());
                    //repaint();
                }
            }
    });
        JMenuItem miExit = new JMenuItem("Exit");
        miExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mnuFile.add(miExit);
        JMenuItem miAbout = new JMenuItem("About");
        miAbout.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Created by Luke Mendiola in December, 2021.");
                }
        });
        mnuHelp.add(miAbout);
        setJMenuBar(mbar);
    }
    public void setupGUI() {
        setTitle("Picture Frame");
        setBounds(600,240,290,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel panSouth = new JPanel();
        JPanel subPanel = new JPanel();
        panSouth.setLayout(new BorderLayout());
        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //ArrayList<PictureData> imageData = getImageData();
                JFileChooser jfc = new JFileChooser();
                if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    PictureDataWriter.writePictureDataToFile(getImageData(), jfc.getSelectedFile());
                    //repaint();
                }
            }
        });
        JButton btnPrevious = new JButton("Prev");
        JButton btnNext= new JButton("Next");
        JTextField date = new JTextField();
        JTextArea description = new JTextArea();
        date.setText((imageData.get(currentIndex).getImageDate()));
        description.setText((imageData.get(currentIndex).getImageDescription()));
        subPanel.add(btnPrevious);
        subPanel.add(btnSave);
        subPanel.add(btnNext);
        PicturePanel picture = new PicturePanel();
        c.add(picture,BorderLayout.NORTH);
        btnNext.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (currentIndex < 3){
                currentIndex = currentIndex + 1;
                }
                else if (currentIndex == 3){
                    currentIndex = 0;
                }
                date.setText((imageData.get(currentIndex).getImageDate()));
                description.setText((imageData.get(currentIndex).getImageDescription()));
                picture.setPicture(imageList.get(currentIndex));
                repaint();
            }
        });

        btnPrevious.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (currentIndex > 0){
                    currentIndex = currentIndex - 1;
                    //setCurrentIndex(currentIndex + 1);
                    }
                    else if (currentIndex == 0){
                        currentIndex = 3;
                    }
                    date.setText((imageData.get(currentIndex).getImageDate()));
                    description.setText((imageData.get(currentIndex).getImageDescription()));
                    picture.setPicture(imageList.get(currentIndex));
                    repaint();
            }
        });
        panSouth.add(date,"North");
        panSouth.add(description,"Center");
        panSouth.add(subPanel,"South");
        c.add(panSouth,BorderLayout.CENTER);
        //c.add(dateAndDescription,BorderLayout.NORTH);
        //PicturePanel picture = new PicturePanel();
        //c.add(picture,BorderLayout.NORTH);
    }
    public PictureFrame() {
        setupGUI();
        setupMainMenu();
        getImageData();
        getImageList();
        getCurrentIndex();
        currentIndex = 0;
    }
}

