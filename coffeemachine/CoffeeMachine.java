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
  }
  public void paint(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHints(m_rHint);
  }
  private RenderingHints m_rHint;
}
