import java.awt.*;
import javax.swing.*;
public class Display extends JFrame {
    private JPanel player1;
    private MainMapView mapView;
    private MainMenuView menuView;
    private int width, height;
    private String state;
    
    public Display(int width, int height, String state){
        this.width = width;
        this.height = height;
        this.state = state;
        
        Image playerImage1 = Toolkit.getDefaultToolkit().createImage("img/Player1.png");
            
        player1 = new ImagePanel(playerImage1, height/24*3/2, height/12*3/2);
        player1.setPreferredSize(new Dimension(height/24*3/2, height/12*3/2));
        player1.setBackground(new Color(0,0,0,0));
        player1.setBounds(height/8*7-height/24, height/8*7-height/24, height/24*3/2, height/12*3/2);//height/8*7-height/24
        this.add(player1);
        
        menuView = new MainMenuView(width, height);
        this.add(menuView);
        menuView.setBounds(0, 0, width, height);
        
        mapView = new MainMapView(width, height);
        this.add(mapView);
        mapView.setBounds(0, 0, width, height);
        
        this.setLayout(null);
        this.setBounds(0, 0, width, height);
        Container container = this.getContentPane();
        container.setLayout(null);
        
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JPanel getPlayer1() {
        return player1;
    }

    public MainMapView getMapView() {
        return mapView;
    }

    public MainMenuView getMenuView() {
        return menuView;
    }
    
    public void render(GameController game, String state){
        this.state = state;
        if(state.equals("GAME")){
        }else if(state.equals("MAIN_MENU")){
        }
    }
}
