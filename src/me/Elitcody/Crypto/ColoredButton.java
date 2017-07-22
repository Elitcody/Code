package me.Elitcody.Crypto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class ColoredButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Color c = null;
	Graphics gr = null;
	
	public ColoredButton(String label, Color c) {
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
	 
	  public void paintComponent(Graphics g) {
		gr = g;
		
	    if (getModel().isArmed()) {
	      g.setColor(c.darker());
	    } else {
	      g.setColor(c);
	    }
	    g.fillRect(0, 0, getSize().width-1 , getSize().height-1);
	 
	    super.paintComponent(g);
	  }
	 
	  protected void paintBorder(Graphics g) {
		
	    g.setColor(c.darker());
	    g.drawRect(0, 0, getSize().width - 1, getSize().height - 1);
	  }

}
