import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.net.URL;
public class ImageLabel extends JLabel{
    private static final long serialVersionUID = 1L;
    private Image image = null;
    private int iWidth2;
    private int iHeight2;
    private int width, height;
    private boolean isSize = false;
    private String path;

    public ImageLabel(Image image)
    {
        this.image = image;
        this.iWidth2 = image.getWidth((ImageObserver) this)/2;
        this.iHeight2 = image.getHeight((ImageObserver) this)/2;
    }
    public ImageLabel(String path, int width, int height) throws IOException
    {
        this.image = new ImageIcon(new URL("http://i.stack.imgur.com/KSnus.gif")).getImage();
        this.width = width;
        this.height = height;
        this.iWidth2 = image.getWidth(this)/2;
        this.iHeight2 = image.getHeight(this)/2;
        isSize = true;
        this.setBackground(Color.black);
    }


    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        if (image != null & !isSize){
            g2.drawImage(image, 0, 0, null);
            
        }else if(image != null & isSize){
            g2.drawImage(image,1,1,  null);
        }
    }
}
