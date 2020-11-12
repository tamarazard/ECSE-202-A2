import java.awt.Color;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class bSim extends GraphicsProgram{

	//parameters used in the program
	private static final int WIDTH = 1200;									//Screen Width
    private static final int HEIGHT = 600;									//Screen height
    private static final int OFFSET = 200;									//Screen Offset
    
    private static final int NUMBALLS = 60;								// Number of balls used in the simulation
    private static final double MINSIZE = 1.0; 								// Minumum ball radius (meters)
    private static final double MAXSIZE = 7.0; 							// Maximum ball radius (meters)
    private static final double EMIN = 0.2; 								// Minimum loss coefficient
    private static final double EMAX = 0.6; 								// Maximum loss coefficient
    private static final double VoMIN = 40.0; 								// Minimum velocity (meters/sec)
    private static final double VoMAX = 50.0; 								// Maximum velocity (meters/sec)
    private static final double ThetaMIN = 80.0; 							// Minimum launch angle (degrees)
    private static final double ThetaMAX = 100.0; 							// Maximum launch angle (degrees)
    private RandomGenerator rgen = RandomGenerator.getInstance(); 			
    
    public void run() {
    	this.resize(WIDTH, HEIGHT+OFFSET); //display setup
    	rgen.setSeed( (long) 424242 );
    	
        
		
	    GRect rect = new GRect(0, HEIGHT, WIDTH, 2); //creation of the "x axis"
	    rect.setFilled(true);
		rect.setColor(Color.black);
		add(rect);
    	
    	for (int i=0 ; i<NUMBALLS; i++) { //creation and start of NUMBALLS instances of aBall
    		
    		
	    	double bSize = rgen.nextDouble(MINSIZE,MAXSIZE);
	        Color bColor = rgen.nextColor();
	        double loss = rgen.nextDouble(EMIN,EMAX);
	        double Vo = rgen.nextDouble(VoMIN,VoMAX);  
	        double theta = rgen.nextDouble(ThetaMIN,ThetaMAX);
	        
	        double Xi = 100;
	        double Yi = bSize;
	
			
			aBall myBall = new aBall(Xi, Yi, Vo, theta, bSize, bColor, loss);
			add(myBall.getBall());
			myBall.start();
			

    	}
    }

}	
		