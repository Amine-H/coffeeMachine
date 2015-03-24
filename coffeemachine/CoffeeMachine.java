package coffeemachine;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;

public class CoffeeMachine extends JComponent{
  public CoffeeMachine(){
    m_rHint = new RenderingHints(
      RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON);
      m_img = Toolkit.getDefaultToolkit().getImage("img.png");
  }
  public void paint(Graphics g){
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHints(m_rHint);
    g2d.drawImage(m_img,0,0,this);
  }
  private RenderingHints m_rHint;
  private Image m_img;
}
