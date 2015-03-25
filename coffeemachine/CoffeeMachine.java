package coffeemachine;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;

public class CoffeeMachine extends JComponent implements MouseMotionListener,MouseListener{
  public CoffeeMachine(){
    m_rHint = new RenderingHints(
      RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON);
      m_machine = Toolkit.getDefaultToolkit().getImage("machine.png");
      m_oneDH = Toolkit.getDefaultToolkit().getImage("one-dh.png");
      m_twoDH = Toolkit.getDefaultToolkit().getImage("two-dh.png");
      m_trash = Toolkit.getDefaultToolkit().getImage("trash-bin.png");
      addMouseMotionListener(this);
      addMouseListener(this);
      m_heldObject = null;//let's make sure these are null..
      m_coffeeSlot = null;
      m_refundSlot = null;
  }
  public void paint(Graphics g){
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHints(m_rHint);
    //draw static images
    g2d.drawImage(m_machine,0,0,this);
    g2d.drawImage(m_oneDH,350,0,this);
    g2d.drawImage(m_twoDH,420,0,this);
    g2d.drawImage(m_trash,365,343,this);
    //end of static images
    if(m_heldObject != null){//draw held object
      m_heldObject.drawIN(g2d,this);
    }
    if(m_coffeeSlot != null){//draw coffee
      m_coffeeSlot.drawIN(g2d,this);
    }
    if(m_refundSlot != null){//draw refund money
      m_refundSlot.drawIN(g2d,this);
    }
  }
  private boolean isHodling(){//returns true if the user is holding something
    return m_heldObject != null;
  }
  public void mouseClicked(MouseEvent e){
    int X = e.getX();int Y = e.getY();//to save me some writing
    System.out.println("cliked "+X+" "+Y);
    if(X >= 350 && X<= 406 && Y >= 0 && Y<= 56){//user clicked one DH
      if(!isHodling()){
        m_heldObject = new Movable(MovableType.ONE_DH);
      }
    }
    else if(X >= 420 && X<= 476 && Y >= 0 && Y<= 56){//user clicked two DH
      if(!isHodling()){
        m_heldObject = new Movable(MovableType.TWO_DH);
      }
    }
    else if(X >= 365 && X<= 485 && Y >= 343 && Y<= 497){//user clicked trash bin
      if(isHodling()){
        m_heldObject = null;
      }
    }///these are machine buttons
    else if(X >= 114 && X<= 132 && Y >= 66 && Y<= 82){//user clicked petit BUTTON
      if(!isHodling()){

      }
    }
    else if(X >= 150 && X<= 167 && Y >= 67 && Y<= 83){//user clicked grand BUTTON
      if(!isHodling()){
      }
    }
    else if(X >= 180 && X<= 193 && Y >= 69 && Y<= 81){//user clicked cancel BUTTON
      if(!isHodling()){
      }
    }
    else if(X >= 180 && X<= 193 && Y >= 69 && Y<= 81){//user clicked insert money slot
      if(isHodling()){
      }
    }//end of machine buttons
  }
	public void mouseMoved(MouseEvent e){
    if(isHodling()){
      m_heldObject.setX(e.getX());
      m_heldObject.setY(e.getY());
    }
    this.repaint();
  }
  public void mouseDragged(MouseEvent e){}//we don't have to implement these...
  public void mouseExited(MouseEvent e){}
  public void mouseEntered(MouseEvent e){}
  public void mouseReleased(MouseEvent e){}
  public void mousePressed(MouseEvent e){}//end
  private RenderingHints m_rHint;
  private Image m_machine;
  private Image m_trash;
  private Image m_oneDH;
  private Image m_twoDH;
  private Movable m_coffeeSlot;
  private Movable m_refundSlot;
  private Movable m_heldObject;//something that the user is moving around with his mouse
}

class Movable{
  private MovableType m_type;
  private int m_x;
  private int m_y;
  private Image m_img;
  public Movable(MovableType type){
    this.m_type = type;
    switch(type){
      case ONE_DH:
        this.m_img = Toolkit.getDefaultToolkit().getImage("one-dh.png");
      break;
      case TWO_DH:
        this.m_img = Toolkit.getDefaultToolkit().getImage("two-dh.png");
      break;
      case COFFEE:
        this.m_img = Toolkit.getDefaultToolkit().getImage("coffee.png");
      break;
    }
  }
  public void setX(int x){
    this.m_x = x;
  }
  public void setY(int y){
    this.m_y = y;
  }
  public int getX(){
    return this.m_x;
  }
  public int getY(){
    return this.m_y;
  }
  public MovableType getType(){
    return this.m_type;
  }
  public void drawIN(Graphics2D g2d,CoffeeMachine machine){
    g2d.drawImage(m_img,m_x,m_y,machine);
  }
}

enum MovableType{
  ONE_DH,
  TWO_DH,
  COFFEE
}
