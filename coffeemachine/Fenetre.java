package coffeemachine;
import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame{
  public Fenetre(){
    setSize(500,540);
		setTitle("CoffeeMachine Simulation");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    m_machine = new CoffeeMachine();
    getContentPane().add(m_machine);
    setVisible(true);
  }
  private CoffeeMachine m_machine;
}
