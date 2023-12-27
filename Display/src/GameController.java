import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;
public class GameController implements MouseListener, ActionListener, Runnable{
//    private MapView mapView;
    private Setting setting;
    private Display display;
    private boolean isOpeningSetting = false;
    private int randomNum;
    private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = 1280, height = 720;
//    private int width = (int) dimension.getWidth(), height = (int) dimension.getHeight();
    private int mapPositionWidth[] = {height/8*7-height/24, height/8*6-height/12,height/8*5-height/12,height/8*4-height/12,height/8*3-height/12,height/8*1-height/24,
    height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*3-height/12,height/8*4-height/12,
    height/8*5-height/12,height/8*6-height/12,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24};;
    private int mapPositionHeight[] = {height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,
    height/8*6-height/12*3/2, height/8*5-height/12*3/2, height/8*4-height/12*3/2,height/8*3-height/12*3/2,height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,
    height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*3-height/12*3/2,height/8*4-height/12*3/2,height/8*5-height/12*3/2,height/8*6-height/12*3/2};
    private int currentPosition = 0, test[] = {1, 2, 3};
    private enum STATE{
        MAIN_MENU,
        SETTING,
        GAME,
        TUTORIAL
    };
    private STATE state = STATE.MAIN_MENU;
    
    public GameController(){
        display = new Display(width, height, state+"");
        
        if(state == STATE.MAIN_MENU){
            display.getMenuView().getStartPanel().addMouseListener(this);
            display.getMenuView().getTutorialPanel().addMouseListener(this);
            display.getMenuView().getSettingPanel().addMouseListener(this);
            display.getMenuView().getExitPanel().addMouseListener(this);
            
        }else if(state == STATE.GAME){
            display.getMapView().getSettingPanel().addMouseListener(this);
            display.getMapView().getRollPanel().addMouseListener(this);
        }
        
    }
    
    public void run(){
//        if(state == STATE.MAIN_MENU){
//            display.getMenuView().getStartPanel().addMouseListener(this);
//            display.getMenuView().getTutorialPanel().addMouseListener(this);
//            display.getMenuView().getSettingPanel().addMouseListener(this);
//            display.getMenuView().getExitPanel().addMouseListener(this);
//            
//        }else if(state == STATE.GAME){
//            System.out.println("Test");
////            mapView = new MapView(width, height);
//            display.getMapView().getSettingPanel().addMouseListener(this);
//            display.getMapView().getRollPanel().addMouseListener(this);
//        }
        while(true){
            if(state == STATE.MAIN_MENU){
                state = STATE.MAIN_MENU;
            }else if(state == STATE.GAME){
                state = STATE.GAME;
            }
        }
    }
    
    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {
        if(state == STATE.MAIN_MENU){
            if(e.getSource().equals(display.getMenuView().getStartPanel())){
                display.remove(display.getMenuView());
                display.revalidate();
                display.repaint();
                state = STATE.GAME;
                display.getMapView().getSettingPanel().addMouseListener(this);
                display.getMapView().getRollPanel().addMouseListener(this);
            }else if(e.getSource().equals(display.getMenuView().getExitPanel())){
                System.exit(0);
            }
        }else if(state == STATE.GAME){
            
            if(e.getSource().equals(display.getMapView().getSettingPanel())){
                setting = new Setting(display.getMapView().getWidth(), display.getMapView().getHeight(), display);
                setting.getOk().addActionListener(this);
                setting.getExit().addActionListener(this);
                state = STATE.SETTING;
            }else if(e.getSource().equals(display.getMapView().getRollPanel())){
                randomNum = ThreadLocalRandom.current().nextInt(1, 6 + 1);
                currentPosition += randomNum;
                currentPosition %= 20;
                System.out.println("RandomNum: "+randomNum);
                System.out.println("CurrentPosition: "+currentPosition+"/"+mapPositionWidth[currentPosition]+"/"+mapPositionHeight[currentPosition]);
                display.getPlayer1().setBounds(mapPositionWidth[currentPosition], mapPositionHeight[currentPosition], height/24*3/2, height/12*3/2);
            }    
        }
        
    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public void actionPerformed(ActionEvent e) {
        if(state == STATE.SETTING || true){
            if(e.getSource().equals(setting.getOk())){
                setting.getWindow().dispose();
                isOpeningSetting = false;
                state = STATE.GAME;
            }else if(e.getSource().equals(setting.getExit())){
                System.exit(0);
            }
        }
        
    }
    
    public void update(){
        
    }
    
    public void render(){
        display.render(this, state+"");
    }
}
