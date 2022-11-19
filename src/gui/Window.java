package gui;

import java.awt.Font;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


public class Window extends JFrame {
    
    public JPanel panelGral;
   
    public Window() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        panelGral = new PanelGral();
        
        
        
        
        this.getContentPane().add(panelGral);
    }

   }

