import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Auxiliary {
   public static final Font mainFont = new Font ("Times New Roman", Font.PLAIN, 24);
   public static final Font buttonFont = new Font ("Times New Roman", Font.PLAIN, 16);
   public static final Font startButtonText = new Font ("Times New Roman", Font.PLAIN, 24);

   public static ImagePanel setBackground(String name){
      ImagePanel backgroundPanel = new ImagePanel();
      try {
         String currentWorkingPath = System.getProperty("user.dir");
         String fullPath = currentWorkingPath + File.separator + "src" + File.separator + "Images" + File.separator + "backgrounds" + File.separator +  name;
         BufferedImage image = ImageIO.read(new File(fullPath));
         backgroundPanel.setImage(image);
         backgroundPanel.setBounds(0,0, image.getWidth(null), image.getHeight(null));
      } catch (IOException e){
         System.out.println("IOException (wrong path): " + e);
      }
      System.out.println(backgroundPanel.getImage());
      return backgroundPanel;
   }

}
