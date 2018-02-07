import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class Scoreboard extends JPanel {

	private int bot1Score = 0;
	private int bot2Score = 0;
	private String bot1 = "";
	private String bot2 = "";
	private Moves bot1Move = Moves.None;
	private Moves bot2Move = Moves.None;
	public void setScores(int bot1Score, int bot2Score){
		this.bot1Score = bot1Score;
		this.bot2Score = bot2Score;
	}
	public void setMoves(Moves bot1Move, Moves bot2Move){
		this.bot1Move = bot1Move;
		this.bot2Move = bot2Move;
	}
	public boolean showWinner = false;
	public Scoreboard(){		
		JFrame frame = new JFrame();
		frame.add(this);
		 frame.setSize(1100, 400);
	     frame.setVisible(true);
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        
        if ( !showWinner ){
       g2d.drawString(this.bot1 + " vs. " + bot2 , 400 , 20 );
       
        g2d.drawString(this.bot1 + " points: " + bot1Score , 10 , 40 );
        g2d.drawString(this.bot1Move.toString() , 300 , 40 );
        
        g2d.fill3DRect(0, 55 , this.bot1Score , 50 , true );

        g2d.drawString(this.bot2 + " points: " + bot2Score , 10 , 120 );
        g2d.drawString(this.bot2Move.toString() , 300 , 120 );
         g2d.fill3DRect(0, 125 , this.bot2Score , 50 , true );
        }
        else{
        	
        	 g2d.drawString( this.bot1Score > this.bot2Score ? this.bot1 : this.bot2 , 400 , 300 );
             
        }
        
    }
    
    public void resetScoreboard( String bot1Name , String bot2Name ){

    	this.bot1 = bot1Name;
    	this.bot2 = bot2Name;
    	this.bot1Score = 0;
    	this.bot2Score = 0;
    	showWinner = false;
    }
    
   
    
}
