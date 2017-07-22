package me.Elitcody.Crypto;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.plaf.ButtonUI;
import javax.swing.text.DefaultCaret;

public class Gui {
		JFrame mainframe = new JFrame("Crypto-v-1.0");
	    int howcenter = 100;
		public static StringBuffer stlog = new StringBuffer();
		public static JTextArea log = null; 
		public static JTextArea text = null;
		public static BufferedImage img = null;
		public static JLabel image = new JLabel();
		public static ImageIcon icon = new ImageIcon();
		public static File f = null;
		
		// Log checker and Preview Loader
		public class LogPreviewChecker extends Thread
		{
		   private int delay;

		   public LogPreviewChecker(int seconds)
		   {
		      this.delay = seconds*1000;
		   }

		   @Override
		   public synchronized void run()
		   {
			   while(true){
				   // Load file and set JLable icon
				    f = new File(Main.path+Main.imgname);
				    if(f.exists()){
				   		try {
				   			img = ImageIO.read(f);
				   		} catch (Exception e) {
					   		e.printStackTrace();
					   	}	
				   		Image dimg = img.getScaledInstance(Gui.image.getWidth(), Gui.image.getHeight(),
				   		        Image.SCALE_SMOOTH);
				   		
				   		try {
					   		icon = new ImageIcon(dimg);
						} catch (Exception e) {
							e.printStackTrace();
						}
				   		image.setIcon(icon);
				   	}else{
				   		image.setIcon(null);
				   		image.setOpaque(true);
				   		image.setText("Nothing is loaded!");
				   		image.setBackground(Color.WHITE);
				   	}
				   
				   // Set log text
			       log.setText(stlog.toString());
			       // Delay
			       try {
						Thread.sleep(delay);
			       } catch (InterruptedException e) {
						e.printStackTrace();
			       }
			   }
		   }
		}
		
		public static void add(String st)
		{
			stlog.append("\n"+st);
		}
		
		// @link https://tips4java.wordpress.com/2009/06/14/moving-windows/
		public class DragListener extends MouseInputAdapter
		{
		    Point location;
		    MouseEvent pressed;
		 
		    public void mousePressed(MouseEvent me)
		    {
		        pressed = me;
		    }
		 
		    public void mouseDragged(MouseEvent me)
		    {
		        Component component = me.getComponent();
		        location = component.getLocation(location);
		        int x = location.x - pressed.getX() + me.getX();
		        int y = location.y - pressed.getY() + me.getY();
		        component.setLocation(x, y);
		     }
		}
		public void initGui(){
			
			JPanel mainpanel = new JPanel();
			
			mainpanel.setLayout(null);
			
			// Label
			JLabel Text = new JLabel("Text");
			Text.setBounds(90, 50+howcenter, 300, 50);
			Text.setFont(new Font("Serif", Font.PLAIN, 25));

			
			JLabel Preview = new JLabel("Preview");
			Preview.setBounds(800, 50+howcenter, 300, 50);
			Preview.setFont(new Font("Serif", Font.PLAIN, 25));

			JLabel Url = new JLabel("Directory where file will be loaded/saved: ");
			Url.setBounds(340, -25, 500, 100);
			Url.setFont(new Font("Serif", Font.PLAIN, 25));

			mainpanel.add(Text);
			mainpanel.add(Preview);
			mainpanel.add(Url);
			// Button
			
			JButton texttoimage = new ColoredButton("", Color.DARK_GRAY);
			texttoimage.setText("Convert text to image");
			texttoimage.setBounds(370, 100+howcenter, 300, 50);
			texttoimage.setForeground(Color.WHITE);
			
			texttoimage.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					byte[] pos = null;
					pos = text.getText().getBytes();
					Main.encriptImage(pos);
				}
			});
			
			JButton imagetotext = new ColoredButton("", Color.DARK_GRAY);
			imagetotext.setText("Convert image to text");
			imagetotext.setBounds(370, 160+howcenter, 300, 50);
			imagetotext.setForeground(Color.WHITE);
			
			imagetotext.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Main.decriptImage();
				}
			});
			
			JButton options = new ColoredButton("", Color.DARK_GRAY);
			options.setText("Options");
			options.setBounds(370, 250+howcenter, 100, 50);
			options.setForeground(Color.WHITE);
			
			JButton close = new RoundButton("", Color.RED);
			close.setBounds(10, 10, 15, 15);

            close.setContentAreaFilled(false);
            close.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
            
            JButton fullsize = new RoundButton("", Color.ORANGE);
            fullsize.setBounds(30, 10, 15, 15);
            fullsize.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(mainframe.getExtendedState() == 0){
						mainframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
					}else{
						mainframe.setExtendedState(0);
					}
				}
			});
			
            
            JButton minimize = new RoundButton("", Color.GREEN);
			minimize.setBounds(50, 10, 15, 15);

			minimize.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					mainframe.setState(JFrame.ICONIFIED);
				}
			});
			
			mainpanel.add(fullsize);
            mainpanel.add(minimize);
			mainpanel.add(close);
			mainpanel.add(texttoimage);
			mainpanel.add(imagetotext);
			mainpanel.add(options);
			
			// LOG

			Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String strDate = dateFormat.format(date);
			
			log = new JTextArea(30,30);
			log.setLineWrap(true);
			log.setEditable(false);
			stlog.append("Log: "+strDate);
			log.setForeground(Color.GREEN);
			log.setBackground(Color.BLACK);
			log.setWrapStyleWord(true);
			JScrollPane jspl = new JScrollPane(log);
			jspl.setBounds(370, howcenter-10, 300, 100);
			DefaultCaret caret = (DefaultCaret)log.getCaret();
			caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
			
			mainpanel.add(jspl);
			
			// Textbox
			
			JTextField texturl = new JTextField(Integer.MAX_VALUE-8);
			texturl.setBounds(350, howcenter-40, 400, 25);
			texturl.setOpaque(false);
			texturl.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent ae){
					   Main.path = texturl.getText();
					   add("Directory Changed in "+ Main.path);
				   }
				});
			
			JTextField filename = new JTextField(Integer.MAX_VALUE-8);
			filename.setBounds(350, howcenter+400, 300, 25);
			filename.setOpaque(false);
			filename.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent ae){
					   Main.imgname = "/"+filename.getText()+".png";
					   add("Name of the image changed in "+ Main.imgname);
				   }
				});
			
			mainpanel.add(filename);
			mainpanel.add(texturl);
			

			
			// Text Area
			text = new JTextArea(30,30);
			text.setLineWrap(true);
			text.setWrapStyleWord(true);
			text.setOpaque(false);
			JScrollPane jsp = new JScrollPane(text);
			jsp.setBounds(26, 150+howcenter, 300, 300);
			
			mainpanel.add(jsp);

			// Preview
			
			image.setBounds(700, 150+howcenter, 325,325);
			mainpanel.add(image);

			// Drag
			DragListener drag = new DragListener();
			mainframe.addMouseListener( drag );
			mainframe.addMouseMotionListener( drag );
			
			// Resizer
			ComponentResizer cr = new ComponentResizer();
			cr.registerComponent(mainframe);
			cr.setMinimumSize(new Dimension(1100, 600));
			
			// Shape the corner
			mainframe.addComponentListener(new ComponentAdapter() {
	               @Override
	                public void componentResized(ComponentEvent e) {
	                    mainframe.setShape(new RoundRectangle2D.Double(0, 0, mainframe.getWidth(), mainframe.getHeight(), 30, 30));
	                }
	            });

			// Mainframe details
			mainpanel.setBackground(new Color(192, 192, 192));
			mainframe.add(mainpanel);
			mainframe.setUndecorated(true);
			mainframe.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
			mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainframe.pack();
			mainframe.setSize(1100, 600);
			mainframe.setLocationRelativeTo(null);
			mainframe.setVisible(true);
			
			// Run the logchecker
			LogPreviewChecker logpw = new LogPreviewChecker(2);
			logpw.run();
		}

}
