import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;
public class GameController implements MouseListener, ActionListener, Runnable{
//    private MapView mapView;
    private Setting setting;
    private GameView gameView;
    private boolean isOpeningSetting = false;
    private int randomNum;
    private SettingView settingView;
    private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = 1280, height = 720;
//    private int width = (int) dimension.getWidth(), height = (int) dimension.getHeight();
    private int[] mapPositionWidth = {height/8*7-height/24, height/8*6-height/12,height/8*5-height/12,height/8*4-height/12,height/8*3-height/12,height/8*1-height/24,
    height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*3-height/12,height/8*4-height/12,
    height/8*5-height/12,height/8*6-height/12,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24};
    private int[] mapPositionHeight = {height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,
    height/8*6-height/12*3/2, height/8*5-height/12*3/2, height/8*4-height/12*3/2,height/8*3-height/12*3/2,height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,
    height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*3-height/12*3/2,height/8*4-height/12*3/2,height/8*5-height/12*3/2,height/8*6-height/12*3/2};
    private int currentPosition1 = 0,currentPosition2 = 0;
    private boolean isSetting = false, isPlayer1 = true;
//    private JPanel setting;
    public GameController() throws IOException{
        gameView = new GameView(width, height);
        Thread thread = new Thread(gameView);
        thread.start();
        
        gameView.getMenuView().getStartPanel().addMouseListener(this);
        gameView.getMenuView().getTutorialPanel().addMouseListener(this);
        gameView.getMenuView().getSettingPanel().addMouseListener(this);
        gameView.getMenuView().getExitPanel().addMouseListener(this);
    }
    
    public void run(){
    }
    
    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {
            if(e.getSource().equals(gameView.getMenuView().getStartPanel()) && isSetting == false){
                gameView.remove(gameView.getMenuView());
                gameView.revalidate();
                gameView.repaint();
                
                gameView.getPlayer1().setPreferredSize(new Dimension(height/24*3/2, height/12*3/2));
                gameView.getPlayer1().setBackground(new Color(0,0,0,0));
                gameView.getPlayer1().setBounds(height/8*7-height/24-height/48, height/8*7-height/24-height/48, height/24*3/2, height/12*3/2);
                gameView.add(gameView.getPlayer1());
                
                // <-------------------------------------------------- Change This -------------------------------------------------->
                gameView.getPlayer2().setPreferredSize(new Dimension(height/24*3/2, height/12*3/2));
                gameView.getPlayer2().setBackground(new Color(0,0,0));
                gameView.getPlayer2().setBounds(height/8*7-height/24+height/48, height/8*7-height/24*2, height/24*3/2, height/12*3/2);
                gameView.add(gameView.getPlayer2());
                
                gameView.add(gameView.getMapView());
                gameView.getMapView().setBounds(0, 0, width, height);
                gameView.revalidate();
                gameView.repaint();
                
                gameView.getMapView().getSettingPanel().addMouseListener(this);
                gameView.getMapView().getRollPanel().addMouseListener(this);
            }else if(e.getSource().equals(gameView.getMenuView().getExitPanel()) && isSetting == false){
                System.exit(0);
            }else if(e.getSource().equals(gameView.getMenuView().getSettingPanel()) && isSetting == false){
                setting = new Setting(width, height, gameView);
                isSetting = true;
                setting.getFalseNotFullScreenPanel().addMouseListener(this);
                setting.getTrueNotFullScreenPanel().addMouseListener(this);
                setting.getFalseFullScreenPanel().addMouseListener(this);
                setting.getTrueFullScreenPanel().addMouseListener(this);
                setting.getSavePanel().addMouseListener(this);
                setting.getBackPanel().addMouseListener(this);
            }else if(e.getSource().equals(gameView.getMapView().getSettingPanel()) && isSetting == false){
                currentPosition1 = 0;
                currentPosition2 = 0;
                gameView.dispose();
                gameView = new GameView(width, height);
                gameView.getMenuView().getStartPanel().addMouseListener(this);
                gameView.getMenuView().getTutorialPanel().addMouseListener(this);
                gameView.getMenuView().getSettingPanel().addMouseListener(this);
                gameView.getMenuView().getExitPanel().addMouseListener(this);
            }else if(e.getSource().equals(gameView.getMapView().getRollPanel()) && isSetting == false){
                // <-------------------------------------------------- Change This -------------------------------------------------->
                randomNum = ThreadLocalRandom.current().nextInt(1, 6 + 1);
                if(isPlayer1 == true){
                    currentPosition1 += randomNum;
                    currentPosition1 %= 20;
                    System.out.println("RandomNum: "+randomNum);
                    System.out.println("CurrentPosition: "+currentPosition1+"/"+mapPositionWidth[currentPosition1]+"/"+mapPositionHeight[currentPosition1]);
                    gameView.getPlayer1().setBounds(mapPositionWidth[currentPosition1]-height/48, mapPositionHeight[currentPosition1]-height/48, height/24*3/2, height/12*3/2);
                    isPlayer1 = !isPlayer1;
                }else{
                    currentPosition2 += randomNum;
                    currentPosition2 %= 20;
                    System.out.println("RandomNum: "+randomNum);
                    System.out.println("CurrentPosition: "+currentPosition2+"/"+mapPositionWidth[currentPosition2]+"/"+mapPositionHeight[currentPosition2]);
                    gameView.getPlayer2().setBounds(mapPositionWidth[currentPosition2]+height/48, mapPositionHeight[currentPosition2]-height/24, height/24*3/2, height/12*3/2);
                    isPlayer1 = !isPlayer1;
                }
            }else if(e.getSource().equals(setting.getFalseFullScreenPanel())){
                setting.getSetting().remove(setting.getFalseFullScreenPanel());
                setting.getSetting().remove(setting.getTrueNotFullScreenPanel());
                setting.getSetting().remove(setting.getSpace1());
                setting.getSetting().remove(setting.getSpace2());
                setting.getSetting().remove(setting.getSavePanel());
                setting.getSetting().remove(setting.getBackPanel());
                setting.getSetting().add(setting.getFalseNotFullScreenPanel());
                setting.getSetting().add(setting.getSpace1());
                setting.getSetting().add(setting.getTrueFullScreenPanel());
                setting.getSetting().add(setting.getSpace2());
                setting.getSetting().add(setting.getSavePanel());
                setting.getSetting().add(setting.getBackPanel());
                this.width = (int) dimension.getWidth();height = (int) dimension.getHeight();
                mapPositionWidth = new int[]{height/8*7-height/24, height/8*6-height/12,height/8*5-height/12,height/8*4-height/12,height/8*3-height/12,height/8*1-height/24,
                height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*3-height/12,height/8*4-height/12,
                height/8*5-height/12,height/8*6-height/12,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24};
                mapPositionHeight = new int[]{height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,
                height/8*6-height/12*3/2, height/8*5-height/12*3/2, height/8*4-height/12*3/2,height/8*3-height/12*3/2,height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,
                height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*3-height/12*3/2,height/8*4-height/12*3/2,height/8*5-height/12*3/2,height/8*6-height/12*3/2};
                
                setting.getWindow().revalidate();
                setting.getWindow().repaint();
            }else if(e.getSource().equals(setting.getFalseNotFullScreenPanel())){
                setting.getSetting().remove(setting.getTrueFullScreenPanel());
                setting.getSetting().remove(setting.getFalseNotFullScreenPanel());
                setting.getSetting().remove(setting.getSpace1());
                setting.getSetting().remove(setting.getSpace2());
                setting.getSetting().remove(setting.getSavePanel());
                setting.getSetting().remove(setting.getBackPanel());
                setting.getSetting().add(setting.getTrueNotFullScreenPanel());
                setting.getSetting().add(setting.getSpace1());
                setting.getSetting().add(setting.getFalseFullScreenPanel());
                setting.getSetting().add(setting.getSpace2());
                setting.getSetting().add(setting.getSavePanel());
                setting.getSetting().add(setting.getBackPanel());
                this.width = 1280;height = 720;
                mapPositionWidth = new int[]{height/8*7-height/24, height/8*6-height/12,height/8*5-height/12,height/8*4-height/12,height/8*3-height/12,height/8*1-height/24,
                height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*3-height/12,height/8*4-height/12,
                height/8*5-height/12,height/8*6-height/12,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24};
                mapPositionHeight = new int[]{height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,
                height/8*6-height/12*3/2, height/8*5-height/12*3/2, height/8*4-height/12*3/2,height/8*3-height/12*3/2,height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,
                height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*3-height/12*3/2,height/8*4-height/12*3/2,height/8*5-height/12*3/2,height/8*6-height/12*3/2};
                
                setting.getWindow().revalidate();
                setting.getWindow().repaint();
            }else if(e.getSource().equals(setting.getSavePanel())){
                setting.getWindow().dispose();
                gameView.dispose();
                gameView = new GameView(width, height);
                gameView.getMenuView().getStartPanel().addMouseListener(this);
                gameView.getMenuView().getTutorialPanel().addMouseListener(this);
                gameView.getMenuView().getSettingPanel().addMouseListener(this);
                gameView.getMenuView().getExitPanel().addMouseListener(this);
                isSetting = false;
            }else if(e.getSource().equals(setting.getBackPanel())){
                setting.getWindow().dispose();
                isSetting = false;
            }
        
    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
