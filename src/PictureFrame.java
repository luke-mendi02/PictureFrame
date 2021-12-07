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
public class PictureFrame extends JFrame{
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
        setTitle("Menu and Mouse Frame");
        setBounds(100,100,500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
        JLabel labSize = new JLabel("Size");
        JTextField txtSize = new JTextField(2);
        JButton btnChange = new JButton("Change");
        JRadioButton rbRed = new JRadioButton("red");
        JRadioButton rbBlack = new JRadioButton("black");
        ButtonGroup bgrp = new ButtonGroup();
        bgrp.add(rbRed);
        bgrp.add(rbBlack);
        panSouth.add(labSize);
        panSouth.add(txtSize);
        panSouth.add(rbRed);
        panSouth.add(rbBlack);
        panSouth.add(btnChange);
        c.add(panSouth,BorderLayout.SOUTH);
        PicturePanel panCenter = new PicturePanel();
        c.add(panCenter,BorderLayout.CENTER);

    }
    public PictureFrame() {
        setupGUI();
    }
}

