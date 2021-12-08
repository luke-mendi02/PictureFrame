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
    // using ArrayLists created in the PictureDataReader and PictureLoader classes
    private ArrayList<PictureData> imageData = new ArrayList<PictureData>(PictureDataReader.readPictureDataFromFile());
    private ArrayList<BufferedImage> imageList = new ArrayList<BufferedImage>(PictureLoader.loadImagesFromPictureData(imageData));
    // creating the PicturePanel object
    private PicturePanel picture = new PicturePanel();
    // initializing the currentIndex variable
    private int currentIndex = 0;
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
    public int getCurrentIndex(){
        return currentIndex;
    }
    public void setCurrentIndex(int currentIndex){
        this.currentIndex = currentIndex;
    }
    // setting up the main menu with the File, Help, Save, Exit, and About options
    public void setupMainMenu(){
        JMenuBar mbar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        JMenu mnuHelp = new JMenu("Help");
        mbar.add(mnuFile);
        mbar.add(mnuHelp);
        JMenuItem miSave = new JMenuItem("Save");
        mnuFile.add(miSave);
        // telling the save menu button what to do
        miSave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                repaint();
                if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    PictureDataWriter.writePictureDataToFile(picture.getImageData(), jfc.getSelectedFile());
                }
            }
    });
        // telling the exit menu button what to do
        JMenuItem miExit = new JMenuItem("Exit");
        miExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mnuFile.add(miExit);
        // telling the about menu button what to do
        JMenuItem miAbout = new JMenuItem("About");
        miAbout.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Created by Luke Mendiola in December, 2021.");
                }
        });
        mnuHelp.add(miAbout);
        setJMenuBar(mbar);
    }
    
    // creating and arranging the picture frame, buttons (previous, save, next), and JTextFields/Areas (date, description)
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
        // telling the save button what to do
        btnSave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                repaint();
                if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    PictureDataWriter.writePictureDataToFile(picture.getImageData(), jfc.getSelectedFile());
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
        c.add(picture,BorderLayout.NORTH);
        // telling the next button what to do
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
        // telling the previous button what to do
        btnPrevious.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (currentIndex > 0){
                    currentIndex = currentIndex - 1;
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
    }
    // creating default PictureFrame constructor
    public PictureFrame() {
        setupGUI();
        setupMainMenu();
        getImageData();
        getImageList();
        getCurrentIndex();
    }
}

