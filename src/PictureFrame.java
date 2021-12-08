import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.ArrayList;
public class PictureFrame extends JFrame{
    private ArrayList<PictureData> imageData = new ArrayList<PictureData>(PictureDataReader.readPictureDataFromFile());
    private ArrayList<BufferedImage> imageList = new ArrayList<BufferedImage>(PictureLoader.loadImagesFromPictureData(imageData));
    int currentIndex = 0;
    public ArrayList<BufferedImage> getImageList() {
        return imageList;
    }
    public ArrayList<PictureData> getImageData() {
        return imageData;
    }
    public void setupMainMenu(){
        JMenuBar mbar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        JMenu mnuHelp = new JMenu("Help");
        mbar.add(mnuFile);
        mbar.add(mnuHelp);
        JMenuItem miOpen = new JMenuItem("Open");
        mnuFile.add(miOpen);
        JMenuItem miSave = new JMenuItem("Save");
        mnuFile.add(miSave);
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
                    System.exit(0);
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
        JButton btnPrevious = new JButton("Prev");
        JButton btnNext= new JButton("Next");
        JTextField date = new JTextField(imageData.get(currentIndex).getImageDate());
        JTextArea description = new JTextArea(imageData.get(currentIndex).getImageDescription());
        subPanel.add(btnPrevious);
        subPanel.add(btnSave);
        subPanel.add(btnNext);
        panSouth.add(date,"North");
        panSouth.add(description,"Center");
        panSouth.add(subPanel,"South");
        c.add(panSouth,BorderLayout.CENTER);
        //c.add(dateAndDescription,BorderLayout.NORTH);
        PicturePanel picture = new PicturePanel();
        c.add(picture,BorderLayout.NORTH);
    }
    public PictureFrame() {
        setupGUI();
        setupMainMenu();
        getImageData();
        getImageList();
    }
}

