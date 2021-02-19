//THINK IM GONNA START WORKING WITH JAVA MORE ACCESSIBLE THAN C# AND PYTHON WORKS ON MACOS LINUX ETC... 
 //JAVA IS FASTER THAN PYTHON + C# ALSO    
 //BOTH JAVA AND PYTHON WERE TWO MAIN CANDIDATES FOR FRONT-END BUT IN THIS USE CASE I THINK IT IS MORE APPLICABLE
 //CAN USE IMAGES ASWELL POSSIBLE SHORTCUTS??????
  //REFERENCES- WEBSITE LINKS : https://www.javatpoint.com/java-awt-menuitem-and-menu ,
  // https://www.codota.com/code/java/classes/java.awt.Graphics
  // https://www.javatpoint.com/awt-program-in-java
  // WAVEFORM CODE: https://stackoverflow.com/questions/11017283/java-program-to-create-a-png-waveform-for-an-audio-file
  // WAVEFORM CODE 2.0: https://github.com/Radiodef/WaveformDemo/blob/master/waveformdemo/WaveformDemo.java
  // EXAMPLE GUI PROGRAM: https://www.guru99.com/java-swing-gui.html 
  // TEXTBOX EXAMPLE LINK: https://www.geeksforgeeks.org/java-swing-jtextarea/
  // Table example code: https://coderanch.com/t/331678/java/Table-AWT

  // BOOKS: 
  //Java for Absolute Beginners Learn to Program the Fundamentals the Java 9+ Way by Iuliana Cosmina 

//Packages and graphics libraries used to create the program 
package com.apress.bgn.ch10;
package waveformdemo;

import java.awt.event.*; 
import java.awt.*;
import javax.swing.*;

// importing libraries for the graph in the main window 

// import java.awt.EventQueue;
// import java.awt.Component;
// import javax.swing.SwingWorker;
// import javax.swing.JFrame;
// import javax.swing.JPanel;
// import javax.swing.JToolBar;
// import javax.swing.JLabel;
// import javax.swing.JButton;
// import javax.swing.JFileChooser;
// import javax.swing.JOptionPane;

// import java.awt.BorderLayout;
// import javax.swing.border.LineBorder;

// import java.awt.Color;
// import java.awt.Dimension;
// import java.awt.Font;
// import java.awt.Insets;

// import java.awt.GraphicsEnvironment;
// import java.awt.Graphics;
// import java.awt.Graphics2D;
// import java.awt.RenderingHints;
// import java.awt.image.BufferedImage;
// import java.awt.Transparency;
// import java.awt.geom.Path2D;

// import java.io.File;
// import java.io.IOException;

// import java.util.concurrent.CancellationException;
// import java.util.concurrent.ExecutionException;

// import java.awt.event.ActionListener;
// import java.awt.event.ActionEvent;
// import java.awt.event.WindowAdapter;
// import java.awt.event.WindowEvent;
// import java.awt.event.MouseAdapter;
// import java.awt.event.MouseEvent;

// import javax.sound.sampled.AudioSystem;
// import javax.sound.sampled.AudioFileFormat;
// import javax.sound.sampled.AudioFormat;
// import javax.sound.sampled.AudioInputStream;
// import javax.sound.sampled.SourceDataLine;
// import javax.sound.sampled.UnsupportedAudioFileException;
// import javax.sound.sampled.LineUnavailableException;



//graphics drawing 


//save and quit windowquit
class First extends Frame {
First(){
Button b = new Button ("");
b.setBounds(30,100,80,30);// guessing (X size ,Y size,X location, y location)
add(b);// adding button to frame
setSize(1300,1300);// frame sieze
setLayout(null);//layout manager
setVisible(true);//now frame iwll be visible, by not defualt not visible
}
public static void main (String args[]){
First f = new First(); 
}}
// menu for standard menu functions e.g. save, import, export, properties and more (2 or 3 menus ideally more if needed)...
public class MenuItem extends MenuComponent implements Accessible 
public class Menu extends MenuItem implements MenuContainer,Accessible 
class FileMenu  
{  
     FileMenu(){  
         Frame f= new Frame("File");  
         MenuBar mb=new MenuBar();  
         Menu menu=new Menu("Menu");  
         Menu submenu=new Menu("Sub Menu");  
         MenuItem i1=new MenuItem("Save");  
         MenuItem i2=new MenuItem("Open");  
         MenuItem i3=new MenuItem("Save all");  
         MenuItem i4=new MenuItem("Save As");  
         MenuItem i5=new MenuItem("Preferences");  
         menu.add(i1);  
         menu.add(i2);  
         menu.add(i3);  
         submenu.add(i4);  
         submenu.add(i5);  
         menu.add(submenu);  
         mb.add(menu);  
         f.setMenuBar(mb);  
         f.setSize(400,400);  
         f.setLayout(null);  
         f.setVisible(true);  
}  
public static void main(String args[])  
{  
new FileMenu();  
}  
}  

// menu for standard menu functions e.g. save, import, export, properties and more (2 or 3 menus ideally more if needed)...
public class MenuItem extends MenuComponent implements Accessible 
public class Menu extends MenuItem implements MenuContainer,Accessible 
class EditMenu  
{  
     MenuExample(){  
         Frame f= new Frame("Edit");  
         MenuBar mb=new MenuBar();  
         Menu menu=new Menu("Menu");  
         Menu submenu=new Menu("Sub Menu");  
         MenuItem i1=new MenuItem("Undo");  
         MenuItem i2=new MenuItem("Redo");  
         MenuItem i3=new MenuItem("Copy");  
         MenuItem i4=new MenuItem("Copy Entire Window");
         menu.add(i1);  
         menu.add(i2);  
         menu.add(i3);  
         submenu.add(i4);  
         menu.add(submenu);  
         mb.add(menu);  
         f.setMenuBar(mb);  
         f.setSize(400,400);  
         f.setLayout(null);  
         f.setVisible(true);  
}  
public static void main(String args[])  
{  
new MenuExample();  
}  
}  

// menu for standard menu functions e.g. save, import, export, properties and more (2 or 3 menus ideally more if needed)...
public class MenuItem extends MenuComponent implements Accessible 
public class Menu extends MenuItem implements MenuContainer,Accessible 
class ViewMenu  
{  
     ViewMenu(){  
         MenuBar mb=new MenuBar();  
         Menu menu=new Menu("Menu");  
         Menu submenu=new Menu("Menu");  
         MenuItem i1=new MenuItem("Channels");  
         MenuItem i2=new MenuItem("Add View");  
         MenuItem i3=new MenuItem("Reset View");  
         MenuItem i4=new MenuItem("Zoom In");  
         MenuItem i5=new MenuItem("Zoom Out");  
         menu.add(i1);  
         menu.add(i2);  
         menu.add(i3);  
         submenu.add(i4);  
         submenu.add(i5);  
         menu.add(submenu);  
         mb.add(menu);  
         f.setMenuBar(mb);  
         f.setSize(400,400);  
         f.setLayout(null);  
         f.setVisible(true);  
}  
public static void main(String args[])  
{  
new ViewMenu();  
}  
}  

// menu for standard menu functions e.g. save, import, export, properties and more (2 or 3 menus ideally more if needed)...
public class MenuItem extends MenuComponent implements Accessible 
public class Menu extends MenuItem implements MenuContainer,Accessible 
class ToolsMenu  
{  
     ToolsMenu(){  
         MenuBar mb=new MenuBar();  
         Menu menu=new Menu("Tools");  
         Menu submenu=new Menu("Sub Menu");  
         MenuItem i1=new MenuItem("Custom Probe");  
         MenuItem i2=new MenuItem("Serial Decoding");  
         MenuItem i3=new MenuItem("Masks");  
         MenuItem i4=new MenuItem("Macro Recording");  
         menu.add(i1);  
         menu.add(i2);  
         menu.add(i3);  
         submenu.add(i4);  
         submenu.add(i5);  
         menu.add(submenu);  
         mb.add(menu);  
         f.setMenuBar(mb);  
         f.setSize(400,400);  
         f.setLayout(null);  
         f.setVisible(true);  
}  
public static void main(String args[])  
{  
new MenuExample();  
}  
}

//main window/section for the "live" graph feed showing the waveform




// sections for buttons and their respective functions

public class ButtonExample {  
public static void main(String[] args) {  
    JFrame f=new JFrame("Zoom In");  
    JButton b=new JButton("Zoom In");  
    b.setBounds(50,100,95,30);  
    f.add(b);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);   
}  
}  


public class ButtonExample {  
    public static void main(String[] args) {  
        JFrame f=new JFrame("Zoom Out");  
        JButton b=new JButton("Zoom Out");  
        b.setBounds(50,100,95,30);  
        f.add(b);  
        f.setSize(400,400);  
        f.setLayout(null);  
        f.setVisible(true);   
    }  
    }  
    

public static void main(String[] args) {  
    Button b=new Button("STOP");  
    b.setBounds(50,100,60,30);  
    f.add(b);     
    f.setSize(300,300);  
    f.setLayout(null);  
    f.setVisible(true);  
    b.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            Toolkit.getDefaultToolkit().beep();  
        }  
    });       
}    



public static void main(String[] args) {  
    Button b=new Button("Play");  
    b.setBounds(50,100,60,30);  
    f.add(b);     
    f.setSize(300,300);  
    f.setLayout(null);  
    f.setVisible(true);  
    b.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            Toolkit.getDefaultToolkit().beep();  
        }  
    });       
}  



public static void main(String[] args) {  
    Button b=new Button("Screenshot");  
    b.setBounds(50,100,60,30);  
    f.add(b);     
    f.setSize(300,300);  
    f.setLayout(null);  
    f.setVisible(true);  
    b.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            Toolkit.getDefaultToolkit().beep();  
        }  
    });       
}


public static void main(String[] args) {  
    Button b=new Button("Switch graph and table of data");  
    b.setBounds(50,100,60,30);  
    f.add(b);     
    f.setSize(300,300);  
    f.setLayout(null);  
    f.setVisible(true);  
    b.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            Toolkit.getDefaultToolkit().beep();  
        }  
    });       
}



public static void main(String[] args) {  
    Button b=new Button("Record Wavefrom");  
    b.setBounds(50,100,60,30);  
    f.add(b);     
    f.setSize(300,300);  
    f.setLayout(null);  
    f.setVisible(true);  
    b.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            Toolkit.getDefaultToolkit().beep();  
        }  
    });       
}

// Y-axis toolbar SOME OF  the parameters are NEED CHANGING ASAP!!!!!!!!!!
class ScrollbarExample{  
    ScrollbarYAxis (){  
           final Label label = new Label();          
           label.setAlignment(Label.CENTER);  
           label.setSize(100,1000);  
           final Scrollbar s=new Scrollbar();  
           s.setBounds(100,100, 50,100);  
           f.add(s);f.add(label);   
           f.setSize(50,1000);  
           f.setLayout(null);  
           f.setVisible(true);  
           s.addAdjustmentListener(new AdjustmentListener() {  
               public void adjustmentValueChanged(AdjustmentEvent e) {  
                  label.setText("Vertical Scrollbar value is:"+ s.getValue());  
               }  
           });  
        }  
public static void main(String args[]){  
new ScrollbarExample();  
}  
}  

// Java Program Program to create a JTextArea and 
// set a voltage interval for the  
// the font of text area. 

class text11 extends JFrame implements ActionListener { 

	// JFrame 
	static JFrame f; 

	// JButton 
	static JButton b, b1, b2, b3; 

	// label to display text 
	static JLabel l, l1; 

	// text area 
	static JTextArea jt; 

	// default constructor 
	text11() 
	{ 
	} 

	// main class 
	public static void main(String[] args) 
	{ 
		// create a new frame to store text field and button 
		f = new JFrame("textfield"); 

		// create a label to display text 
		l = new JLabel("nothing entered"); 
		l1 = new JLabel("0 lines"); 

		// create a new buttons 
		b = new JButton("submit"); 
		b1 = new JButton("plain"); 
		b2 = new JButton("italic"); 
		b3 = new JButton("bold"); 

		// create a object of the text class 
		text11 te = new text11(); 

		// addActionListener to button 
		b.addActionListener(te); 
		b1.addActionListener(te); 
		b2.addActionListener(te); 
		b3.addActionListener(te); 

		// create a text area, specifying the rows and columns 
		jt = new JTextArea("please Enter voltage interval ", 10, 10); 

		JPanel p = new JPanel(); 

		// add the text area and button to panel 
		p.add(jt); 
		p.add(b); 
		p.add(b1); 
		p.add(b2); 
		p.add(b3); 
		p.add(l); 
		p.add(l1); 

		f.add(p); 
		// set the size of frame 
		f.setSize(300, 300); 

		f.show(); 
	} 

	// if the button is pressed 
	public void actionPerformed(ActionEvent e) 
	{ 
		String s = e.getActionCommand(); 
		if (s.equals("submit")) { 
			// set the text of the label to the text of the field 
			l.setText(jt.getText() + ", "); 
			l1.setText(jt.getLineCount() + " lines"); 
		} 
		else if (s.equals("bold")) { 

			// set bold font 
			Font f = new Font("Serif", Font.BOLD, 15); 
			jt.setFont(f); 
		} 
		else if (s.equals("italic")) { 
			// set italic font 
			Font f = new Font("Serif", Font.ITALIC, 15); 
			jt.setFont(f); 
		} 
		else if (s.equals("plain")) { 
			// set plain font 
			Font f = new Font("Serif", Font.PLAIN, 15); 
			jt.setFont(f); 
		} 
	} 
} 

// Java Program Program to create a JTextArea and 
// set a initial text and add buttons to change 
// the font of text area. 

class text11 extends JFrame implements ActionListener { 

	// JFrame 
	static JFrame f; 

	// JButton 
	static JButton b, b1, b2, b3; 

	// label to display text 
	static JLabel l, l1; 

	// text area 
	static JTextArea jt; 

	// default constructor 
	text11() 
	{ 
	} 

	// main class 
	public static void main(String[] args) 
	{ 
		// create a new frame to store text field and button 
		f = new JFrame("textfield"); 

		// create a label to display text 
		l = new JLabel("nothing entered"); 
		l1 = new JLabel("0 lines"); 

		// create a new buttons 
		b = new JButton("submit"); 
		b1 = new JButton("plain"); 
		b2 = new JButton("italic"); 
		b3 = new JButton("bold"); 

		// create a object of the text class 
		text11 te = new text11(); 

		// addActionListener to button 
		b.addActionListener(te); 
		b1.addActionListener(te); 
		b2.addActionListener(te); 
		b3.addActionListener(te); 

		// create a text area, specifying the rows and columns 
		jt = new JTextArea("please Enter time interval ", 10, 10); 

		JPanel p = new JPanel(); 

		// add the text area and button to panel 
		p.add(jt); 
		p.add(b); 
		p.add(b1); 
		p.add(b2); 
		p.add(b3); 
		p.add(l); 
		p.add(l1); 

		f.add(p); 
		// set the size of frame 
		f.setSize(300, 300); 

		f.show(); 
	} 

	// if the button is pressed 
	public void actionPerformed(ActionEvent e) 
	{ 
		String s = e.getActionCommand(); 
		if (s.equals("submit")) { 
			// set the text of the label to the text of the field 
			l.setText(jt.getText() + ", "); 
			l1.setText(jt.getLineCount() + " lines"); 
		} 
		else if (s.equals("bold")) { 

			// set bold font 
			Font f = new Font("Serif", Font.BOLD, 15); 
			jt.setFont(f); 
		} 
		else if (s.equals("italic")) { 
			// set italic font 
			Font f = new Font("Serif", Font.ITALIC, 15); 
			jt.setFont(f); 
		} 
		else if (s.equals("plain")) { 
			// set plain font 
			Font f = new Font("Serif", Font.PLAIN, 15); 
			jt.setFont(f); 
		} 
	} 
} 

//table example NEEDS EDITING TO BE FIT FOR PURPOSE
//two buttons On click of first Button u get some screen and On click of Second Button u get the Other Screen.
public class CardLayoutExample extends Frame implements ActionListener
{
Panel main,pan1,pan2;
TextField name_Text;
TextField age_Text;
Button first=new Button("first");
Button second=new Button("second");
Panel butt=new Panel();
CardLayout cardLayout=new CardLayout();
Choice choiceBox;

public CardLayoutExample()
{
butt.add(first);
butt.add(second);
Label name=new Label("Name");
name_Text=new TextField();
Label age=new Label("Age");
age_Text=new TextField();
pan1=new Panel();
pan1.setLayout(new GridLayout(2,2));
pan1.add(name);
pan1.add(name_Text);
pan1.add(age);
pan1.add(age_Text);
choiceBox=new Choice();
choiceBox.addItem("x1");
choiceBox.addItem("x2");
choiceBox.addItem("x3");
choiceBox.addItem("x4");
pan2=new Panel();
pan2.add(choiceBox);
setListeners();
setLayout(new BorderLayout());
main=new Panel();
main.setLayout(cardLayout);
main.add(pan1,"first");
main.add(pan2,"second");
add(butt,BorderLayout.SOUTH);
add(main,BorderLayout.CENTER);

}
private void setListeners()
{
first.addActionListener(this);
second.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==first)
{
cardLayout.next(main);
cardLayout.show(main,"first");
}
else
{
cardLayout.next(main);
cardLayout.show(main,"second");
}
}
public static void main(String arghs[])
{
CardLayoutExample c=new CardLayoutExample();
c.setVisible(true);
c.setSize(200,200);
}
}


//data imported from back-end C code and convert for Java




//Section for the meausrement details and other UI for the lower section with live meauserement data 
// such as voltage, rms, etc....
// button to pause


// in the form of audio recording. NEEDS EDITING FOR ELECTRICAL WAVEFROM USES instead
//code for creating a waveform trace in java creating an image to then use in program
// (REFERENCE PERSON AND WEBSITE ABOVE)


// public class WaveformDemo
// implements ActionListener {
//     public static void main(String[] args) {
//         EventQueue.invokeLater(new Runnable() {
//             @Override
//             public void run() {
//                 new WaveformDemo();
//             }
//         });
//     }
    
//     public static final int DEF_BUFFER_SAMPLE_SZ = 1024;
    
//     public static final Color LIGHT_BLUE = new Color(128, 192, 255);
//     public static final Color DARK_BLUE = new Color(0, 0, 127);
    
//     public enum PlayStat {
//         NO_FILE, PLAYING, PAUSED, STOPPED
//     }
    
//     public interface PlayerRef {
//         public Object getLock();
//         public PlayStat getStat();
//         public File getFile();
//         public void playbackEnded();
//         public void drawDisplay(float[] samples, int svalid);
//     }
    
//     private JFrame mainFrame = new JFrame("Waveform Demo");
//     private JPanel contentPane = new JPanel(new BorderLayout());
//     private JLabel fileLabel = new JLabel("No file loaded");
//     private DisplayPanel displayPanel = new DisplayPanel();
//     private JToolBar playbackTools = new JToolBar();
    
//     private ToolsButton bOpen = new ToolsButton("Open");
//     private ToolsButton bPlay = new ToolsButton("Play");
//     private ToolsButton bPause = new ToolsButton("Pause");
//     private ToolsButton bStop = new ToolsButton("Stop");
    
//     private File audioFile;
//     private AudioFormat audioFormat;
    
//     private final Object statLock = new Object();
    
//     private volatile PlayStat playStat = PlayStat.NO_FILE;
    
//     private final PlayerRef thisPlayer = new PlayerRef() {
//         @Override
//         public Object getLock() {
//             return statLock;
//         }
        
//         @Override
//         public PlayStat getStat() {
//             return playStat;
//         }
        
//         @Override
//         public File getFile() {
//             return audioFile;
//         }
        
//         @Override
//         public void playbackEnded() {
//             synchronized(statLock) {
//                 playStat = PlayStat.STOPPED;
//             }
//             displayPanel.reset();
//             displayPanel.repaint();
//         }
        
//         @Override
//         public void drawDisplay(float[] samples, int svalid) {
//             displayPanel.makePath(samples, svalid);
//             displayPanel.repaint();
//         }
//     };
    
//     public WaveformDemo() {
//         assert EventQueue.isDispatchThread();
        
//         mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//         mainFrame.addWindowListener(new WindowAdapter() {
//             @Override
//             public void windowClosing(WindowEvent we) {
//                 systemExit();
//             }
//         });
        
//         playbackTools.setFloatable(false);
//         playbackTools.add(bOpen);
//         playbackTools.add(bPlay);
//         playbackTools.add(bPause);
//         playbackTools.add(bStop);
        
//         bOpen.addActionListener(this);
//         bPlay.addActionListener(this);
//         bPause.addActionListener(this);
//         bStop.addActionListener(this);
        
//         fileLabel.setOpaque(true);
//         fileLabel.setBackground(Color.BLACK);
//         fileLabel.setForeground(Color.WHITE);
//         fileLabel.setHorizontalAlignment(JLabel.CENTER);
        
//         playbackTools.setBackground(Color.GRAY);
//         playbackTools.setMargin(new Insets(0, 24, 0, 0));
        
//         contentPane.add(fileLabel, BorderLayout.NORTH);
//         contentPane.add(displayPanel, BorderLayout.CENTER);
//         contentPane.add(playbackTools, BorderLayout.SOUTH);
        
//         mainFrame.setContentPane(contentPane);
        
//         mainFrame.pack();
//         mainFrame.setResizable(false);
//         mainFrame.setLocationRelativeTo(null);
        
//         mainFrame.setVisible(true);
//     }
    
//     private void systemExit() {
//         boolean wasPlaying;
//         synchronized(statLock) {
//             if(wasPlaying = (playStat == PlayStat.PLAYING)) {
//                 playStat = PlayStat.STOPPED;
//             }
//         }
        
//         mainFrame.setVisible(false);
//         mainFrame.dispose();
        
//         if(wasPlaying) {
//             /* 
//              * helps prevent 'tearing' sound
//              * if exit happens while during playback
//              * 
//              */
//             try {
//                 Thread.sleep(250L);
//             } catch(InterruptedException ie) {}
//         }
        
//         System.exit(0);
//     }
    
//     private void loadAudio() {
//         JFileChooser openDiag = new JFileChooser();
        
//         if(JFileChooser.APPROVE_OPTION == openDiag.showOpenDialog(mainFrame)) {
//             File selected = openDiag.getSelectedFile();
            
//             try {
                
//                 /*
//                  * first test to see if format supported.
//                  * sometimes the system will claim to support a format
//                  * but throw a LineUnavailableException on SourceDataLine.open
//                  * 
//                  * if retrieving a list of DataLine.Info for available
//                  * supported formats some systems return -1 for sample rates
//                  * indicating 'any' but evidently can be untrue: throws the exception.
//                  * 
//                  */
                
//                 AudioFileFormat fmt = AudioSystem.getAudioFileFormat(selected);
                
//                 audioFile = selected;
//                 audioFormat = fmt.getFormat();
//                 fileLabel.setText(audioFile.getName());
//                 playStat = PlayStat.STOPPED;
                
//             } catch(IOException ioe) {
//                 showError(ioe);
//             } catch(UnsupportedAudioFileException uafe) {
//                 showError(uafe);
//             }
//         }
//     }
    
//     @Override
//     public void actionPerformed(ActionEvent ae) {
//         Object source = ae.getSource();
        
//         if(source == bOpen) {
//             synchronized(statLock) {
//                 if(playStat == PlayStat.PLAYING) {
//                     playStat = PlayStat.STOPPED;
//                 }
//             }
            
//             loadAudio();
            
//         } else if(source == bPlay
//                 && audioFile != null
//                 && playStat != PlayStat.PLAYING) {
            
//             synchronized(statLock) {
//                 switch(playStat) {
                    
//                     case STOPPED: {
//                         playStat = PlayStat.PLAYING;
//                         new PlaybackLoop(thisPlayer).execute();
//                         break;
//                     }
                        
//                     case PAUSED: {
//                         playStat = PlayStat.PLAYING;
//                         statLock.notifyAll();
//                         break;
//                     }
//                 }
//             }
            
//         } else if(source == bPause
//                 && playStat == PlayStat.PLAYING) {
            
//             synchronized(statLock) {
//                 playStat = PlayStat.PAUSED;
//             }
            
//         } else if(source == bStop
//                 && (playStat == PlayStat.PLAYING || playStat == PlayStat.PAUSED)) {
            
//             synchronized(statLock) {
//                 switch(playStat) {
                    
//                     case PAUSED: {
//                         playStat = PlayStat.STOPPED;
//                         statLock.notifyAll();
//                         break;
//                     }
                        
//                     case PLAYING: {
//                         playStat = PlayStat.STOPPED;
//                         break;
//                     }
//                 }
//             }
//         }
//     }
    
//     private static void showError(Throwable t) {
//         JOptionPane.showMessageDialog(null,
//             "Exception <" + t.getClass().getName() + ">" +
//             " with message '" + t.getMessage() + "'.",
//             "There was an error",
//             JOptionPane.WARNING_MESSAGE
//         );
//     }
    
//     public static class PlaybackLoop
//     extends SwingWorker<Void, Void> {
        
//         private final PlayerRef playerRef;
        
//         public PlaybackLoop(PlayerRef pr) {
//             playerRef = pr;
//         }
        
//         @Override
//         public Void doInBackground() {
//             try {
//                 AudioInputStream in = null;
//                 SourceDataLine out = null;
                
//                 try {
//                     try {
//                         final AudioFormat audioFormat = (
//                             AudioSystem.getAudioFileFormat(playerRef.getFile()).getFormat()
//                         );
                        
//                         in = AudioSystem.getAudioInputStream(playerRef.getFile());
//                         out = AudioSystem.getSourceDataLine(audioFormat);
                        
//                         final int normalBytes = normalBytesFromBits(audioFormat.getSampleSizeInBits());
                        
//                         float[] samples = new float[DEF_BUFFER_SAMPLE_SZ * audioFormat.getChannels()];
//                         long[] transfer = new long[samples.length];
//                         byte[] bytes = new byte[samples.length * normalBytes];
                        
//                         out.open(audioFormat, bytes.length);
//                         out.start();
                        
//                         /*
//                          * feed the output some zero samples
//                          * helps prevent the 'stutter' issue.
//                          * 
//                          */
                        
//                         for(int feed = 0; feed < 6; feed++) {
//                             out.write(bytes, 0, bytes.length);
//                         }
                        
//                         int bread;
                        
//                         play_loop: do {
//                             while(playerRef.getStat() == PlayStat.PLAYING) {
                                
//                                 if((bread = in.read(bytes)) == -1) {
                                    
//                                     break play_loop; // eof
//                                 }
                                
//                                 samples = unpack(bytes, transfer, samples, bread, audioFormat);
//                                 samples = window(samples, bread / normalBytes, audioFormat);
                                
//                                 playerRef.drawDisplay(samples, bread / normalBytes);
                                
//                                 out.write(bytes, 0, bread);
//                             }
                            
//                             if(playerRef.getStat() == PlayStat.PAUSED) {
//                                 out.flush();
//                                 try {
//                                     synchronized(playerRef.getLock()) {
//                                         playerRef.getLock().wait(1000L);
//                                     }
//                                 } catch(InterruptedException ie) {}
//                                 continue;
//                             } else {
//                                 break;
//                             }
//                         } while(true);
                        
//                     } catch(UnsupportedAudioFileException uafe) {
//                         showError(uafe);
//                     } catch(LineUnavailableException lue) {
//                         showError(lue);
//                     }
//                 } finally {
//                     if(in != null) {
//                         in.close();
//                     }
//                     if(out != null) {
//                         out.flush();
//                         out.close();
//                     }
//                 }
//             } catch(IOException ioe) {
//                 showError(ioe);
//             }
            
//             return (Void)null;
//         }
        
//         @Override
//         public void done() {
//             playerRef.playbackEnded();
            
//             try {
//                 get();
//             } catch(InterruptedException io) {
//             } catch(CancellationException ce) {
//             } catch(ExecutionException ee) {
//                 showError(ee.getCause());
//             }
//         }
//     }
    
//     public static float[] unpack(
//         byte[] bytes,
//         long[] transfer,
//         float[] samples,
//         int bvalid,
//         AudioFormat fmt
//     ) {
//         if(fmt.getEncoding() != AudioFormat.Encoding.PCM_SIGNED
//                 && fmt.getEncoding() != AudioFormat.Encoding.PCM_UNSIGNED) {
            
//             return samples;
//         }
        
//         final int bitsPerSample = fmt.getSampleSizeInBits();
//         final int bytesPerSample = bitsPerSample / 8;
//         final int normalBytes = normalBytesFromBits(bitsPerSample);
        
//         /*
//          * not the most DRY way to do this but it's a bit more efficient.
//          * otherwise there would either have to be 4 separate methods for
//          * each combination of endianness/signedness or do it all in one
//          * loop and check the format for each sample.
//          * 
//          * a helper array (transfer) allows the logic to be split up
//          * but without being too repetetive.
//          * 
//          * here there are two loops converting bytes to raw long samples.
//          * integral primitives in Java get sign extended when they are
//          * promoted to a larger type so the & 0xffL mask keeps them intact.
//          * 
//          */
        
//         if(fmt.isBigEndian()) {
//             for(int i = 0, k = 0, b; i < bvalid; i += normalBytes, k++) {
//                 transfer[k] = 0L;
                
//                 int least = i + normalBytes - 1;
//                 for(b = 0; b < normalBytes; b++) {
//                     transfer[k] |= (bytes[least - b] & 0xffL) << (8 * b);
//                 }
//             }
//         } else {
//             for(int i = 0, k = 0, b; i < bvalid; i += normalBytes, k++) {
//                 transfer[k] = 0L;
                
//                 for(b = 0; b < normalBytes; b++) {
//                     transfer[k] |= (bytes[i + b] & 0xffL) << (8 * b);
//                 }
//             }
//         }
        
//         final long fullScale = (long)Math.pow(2.0, bitsPerSample - 1);
        
//         /*
//          * the OR is not quite enough to convert,
//          * the signage needs to be corrected.
//          * 
//          */
        
//         if(fmt.getEncoding() == AudioFormat.Encoding.PCM_SIGNED) {
            
//             /*
//              * if the samples were signed, they must be
//              * extended to the 64-bit long.
//              * 
//              * the arithmetic right shift in Java  will fill
//              * the left bits with 1's if the MSB is set.
//              * 
//              * so sign extend by first shifting left so that
//              * if the sample is supposed to be negative,
//              * it will shift the sign bit in to the 64-bit MSB
//              * then shift back and fill with 1's.
//              * 
//              * as an example, imagining these were 4-bit samples originally
//              * and the destination is 8-bit, if we have a hypothetical
//              * sample -5 that ought to be negative, the left shift looks
//              * like this:
//              * 
//              *     00001011
//              *  <<  (8 - 4)
//              *  ===========
//              *     10110000
//              * 
//              * (except the destination is 64-bit and the original
//              * bit depth from the file could be anything.)
//              * 
//              * and the right shift now fills with 1's:
//              * 
//              *     10110000
//              *  >>  (8 - 4)
//              *  ===========
//              *     11111011
//              * 
//              */
            
//             final long signShift = 64L - bitsPerSample;
            
//             for(int i = 0; i < transfer.length; i++) {
//                 transfer[i] = (
//                     (transfer[i] << signShift) >> signShift
//                 );
//             }
//         } else {
            
//             /*
//              * unsigned samples are easier since they
//              * will be read correctly in to the long.
//              * 
//              * so just sign them:
//              * subtract 2^(bits - 1) so the center is 0.
//              * 
//              */
            
//             for(int i = 0; i < transfer.length; i++) {
//                 transfer[i] -= fullScale;
//             }
//         }
        
//         /* finally normalize to range of -1.0f to 1.0f */
        
//         for(int i = 0; i < transfer.length; i++) {
//             samples[i] = (float)transfer[i] / (float)fullScale;
//         }
        
//         return samples;
//     }
    
//     public static float[] window(
//         float[] samples,
//         int svalid,
//         AudioFormat fmt
//     ) {
//         /*
//          * most basic window function
//          * multiply the window against a sine curve, tapers ends
//          * 
//          * nested loops here show a paradigm for processing multi-channel formats
//          * the interleaved samples can be processed "in place"
//          * inner loop processes individual channels using an offset
//          * 
//          */
        
//         int channels = fmt.getChannels();
//         int slen = svalid / channels;
        
//         for(int ch = 0, k, i; ch < channels; ch++) {
//             for(i = ch, k = 0; i < svalid; i += channels) {
//                 samples[i] *= Math.sin(Math.PI * k++ / (slen - 1));
//             }
//         }
        
//         return samples;
//     }
    
//     public static int normalBytesFromBits(int bitsPerSample) {
        
//         /*
//          * some formats allow for bit depths in non-multiples of 8.
//          * they will, however, typically pad so the samples are stored
//          * that way. AIFF is one of these formats.
//          * 
//          * so the expression:
//          * 
//          *  bitsPerSample + 7 >> 3
//          * 
//          * computes a division of 8 rounding up (for positive numbers).
//          * 
//          * this is basically equivalent to:
//          * 
//          *  (int)Math.ceil(bitsPerSample / 8.0)
//          * 
//          */
        
//         return bitsPerSample + 7 >> 3;
//     }
    
//     public class DisplayPanel
//     extends JPanel {
        
//         private final BufferedImage image;
        
//         private final Path2D.Float[] paths = {
//             new Path2D.Float(), new Path2D.Float(), new Path2D.Float()
//         };
        
//         private final Object pathLock = new Object();
        
//         {
//             Dimension pref = getPreferredSize();
            
//             image = (
//                 GraphicsEnvironment
//                 .getLocalGraphicsEnvironment()
//                 .getDefaultScreenDevice()
//                 .getDefaultConfiguration()
//                 .createCompatibleImage(
//                     pref.width, pref.height, Transparency.OPAQUE
//                 )
//             );
//         }
        
//         public DisplayPanel() {
//             setOpaque(false);
//         }
        
//         public void reset() {
//             Graphics2D g2d = image.createGraphics();
//             g2d.setBackground(Color.BLACK);
//             g2d.clearRect(0, 0, image.getWidth(), image.getHeight());
//             g2d.dispose();
//         }
        
//         public void makePath(float[] samples, int svalid) {
//             if(audioFormat == null) {
//                 return;
//             }
            
//             /* shuffle */
            
//             Path2D.Float current = paths[2];
//             paths[2] = paths[1];
//             paths[1] = paths[0];
            
//             /* lots of ratios */
            
//             float avg = 0f;
//             float hd2 = getHeight() / 2f;
            
//             final int channels = audioFormat.getChannels();
            
//             /* 
//              * have to do a special op for the
//              * 0th samples because moveTo.
//              * 
//              */
            
//             int i = 0;
//             while(i < channels && i < svalid) {
//                 avg += samples[i++];
//             }
            
//             avg /= channels;
            
//             current.reset();
//             current.moveTo(0, hd2 - avg * hd2);
            
//             int fvalid = svalid / channels;
//             for(int ch, frame = 0; i < svalid; frame++) {
//                 avg = 0f;
                
//                 /* average the channels for each frame. */
                
//                 for(ch = 0; ch < channels; ch++) {
//                     avg += samples[i++];
//                 }
                
//                 avg /= channels;
                
//                 current.lineTo(
//                     (float)frame / fvalid * image.getWidth(), hd2 - avg * hd2
//                 );
//             }
            
//             paths[0] = current;
                
//             Graphics2D g2d = image.createGraphics();
            
//             synchronized(pathLock) {
//                 g2d.setBackground(Color.BLACK);
//                 g2d.clearRect(0, 0, image.getWidth(), image.getHeight());
                
//                 g2d.setRenderingHint(
//                     RenderingHints.KEY_ANTIALIASING,
//                     RenderingHints.VALUE_ANTIALIAS_ON
//                 );
//                 g2d.setRenderingHint(
//                     RenderingHints.KEY_STROKE_CONTROL,
//                     RenderingHints.VALUE_STROKE_PURE
//                 );
                
//                 g2d.setPaint(DARK_BLUE);
//                 g2d.draw(paths[2]);
                
//                 g2d.setPaint(LIGHT_BLUE);
//                 g2d.draw(paths[1]);
                
//                 g2d.setPaint(Color.WHITE);
//                 g2d.draw(paths[0]);
//             }
            
//             g2d.dispose();
//         }
        
//         @Override
//         protected void paintComponent(Graphics g) {
//             super.paintComponent(g);
            
//             synchronized(pathLock) {
//                 g.drawImage(image, 0, 0, null);
//             }
//         }
        
//         @Override
//         public Dimension getPreferredSize() {
//             return new Dimension(DEF_BUFFER_SAMPLE_SZ / 2, 128);
//         }
        
//         @Override
//         public Dimension getMinimumSize() {
//             return getPreferredSize();
//         }
        
//         @Override
//         public Dimension getMaximumSize() {
//             return getPreferredSize();
//         }
//     }
    
//     public static class ToolsButton
//     extends JButton {
//         public ToolsButton(String text) {
//             super(text);
            
//             setOpaque(true);
//             setBorderPainted(true);
//             setBackground(Color.BLACK);
//             setForeground(Color.WHITE);
            
//             setBorder(new LineBorder(Color.GRAY) {
//                 @Override
//                 public Insets getBorderInsets(Component c) {
//                     return new Insets(1, 4, 1, 4);
//                 }
//                 @Override
//                 public Insets getBorderInsets(Component c, Insets i) {
//                     return getBorderInsets(c);
//                 }
//             });
            
//             Font font = getFont();
//             setFont(font.deriveFont(font.getSize() - 1f));
            
//             addMouseListener(new MouseAdapter() {
//                 @Override
//                 public void mousePressed(MouseEvent me) {
//                     if(me.getButton() == MouseEvent.BUTTON1) {
//                         setForeground(LIGHT_BLUE);
//                     }
//                 }
//                 @Override
//                 public void mouseReleased(MouseEvent me) {
//                     if(me.getButton() == MouseEvent.BUTTON1) {
//                         setForeground(Color.WHITE);
//                     }
//                 }
//             });
//         }
//     }
// }