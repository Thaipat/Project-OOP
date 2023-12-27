import javax.swing.*;
import java.awt.*;
public class SettingView extends JFrame{
    private JPanel setting, blackdrop;
    private JButton test;
    
    public SettingView(int width, int height){
        this.setBackground(new Color(0,0,0,200));
//        this.setPreferredSize(new Dimension(width, height));
        Image settingBackground = Toolkit.getDefaultToolkit().createImage("img/setting.jpg");
        
        setting = new ImagePanel(settingBackground, height-height/12, height-height/12);
        setting.setPreferredSize(new Dimension(height-height/12, height-height/12));
        
        this.setLayout(new FlowLayout());
//        this.setBounds(0, 0, width, height);
//        this.add(setting);
//        setting.setBounds((int)(width-(height-height/12))/2, 0, height-height/12, height-height/12);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
