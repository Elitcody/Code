package me.Elitcody.Crypto;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;
 
/**
 * @author	javacodex 
 * @link 	http://www.javacodex.com/More-Examples/2/14
 * 
 * 
 */
public class RoundButton extends JButton {
  
  Color c = null;
  public RoundButton(String label, Color c) {
    super(label);
    this.c = c;
    setBackground(c);
    setFocusable(false);
 
    /*
     These statements enlarge the button so that it 
     becomes a circle rather than an oval.
    */
    Dimension size = getPreferredSize();
    size.width = size.height = Math.max(size.width, size.height);
    setPreferredSize(size);
 
    /*
     This call causes the JButton not to paint the background.
     This allows us to paint a round background.
    */
    setContentAreaFilled(false);
  }
 
  protected void paintComponent(Graphics g) {
    if (getModel().isArmed()) {
      g.setColor(c.darker());
    } else {
      g.setColor(c);
    }
    g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
 
    super.paintComponent(g);
  }
 
  protected void paintBorder(Graphics g) {
    g.setColor(c.darker());
    g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
  }
 
  // Hit detection.
  Shape shape;
 
  public boolean contains(int x, int y) {
    // If the button has changed size,  make a new shape object.
    if (shape == null || !shape.getBounds().equals(getBounds())) {
      shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
    }
    return shape.contains(x, y);
  }
 
}