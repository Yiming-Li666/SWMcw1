
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * this class is used to create the device
 * 
 */
public class CreateDevice extends Functionality{
	
	private static Simulator simulator;
    
    
    public CreateDevice(Simulator simulator){
	    this.simulator = simulator;
    }
    
    private static CreateDevice instance;
    synchronized public static CreateDevice getInstance() {
		if(instance == null){
			instance = new CreateDevice(simulator);
		}   	
	    	return instance;
	}

    // method in abstract class Functionality
    public void sendCommand(){
    	System.out.println("......");
    	
	    BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/Users/liyiming/Desktop/SM/cw1/src/InputCommand/Create.csv"));
            // read input
            String tempString = null;
            
            while ((tempString = reader.readLine()) != null) {
        	    String data = null;
        	    String[] commands = tempString.split(",");
        	    // split the String by ","
        	   
        	    // print out String one by one
        	    for(int i=0; i<commands.length; i++) {
            	    System.out.println(commands[i]);
        	    }
        	    // print out the number of Array
        	    System.out.println(commands.length);
        	    
        	    // invoke addDevice
        	 	simulator.addDevice(commands[0]+"&"+commands[1]+"&"+commands[2]+"&"+commands[3]);
 	       
            } 			    
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
