import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.ArrayList;
public class PictureFrame extends JFrame{
    private ArrayList<BufferedImage> imageList = new ArrayList<BufferedImage>();
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
        panSouth.setLayout(new FlowLayout());
        JButton btnSave = new JButton("Save");
        JButton btnPrevious = new JButton("Prev");
        JButton btnNext= new JButton("Next");
        JTextField date = new JTextField("date");
        panSouth.add(btnPrevious);
        panSouth.add(btnSave);
        panSouth.add(btnNext);
        c.add(panSouth,BorderLayout.SOUTH);
        PicturePanel panCenter = new PicturePanel();
        c.add(panCenter,BorderLayout.CENTER);
    }
    public PictureFrame() {
        setupGUI();
        setupMainMenu();
    }
}

