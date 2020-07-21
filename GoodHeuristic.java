//
// GoodHeuristic
//
// This class extends the Heuristic class, providing a reasonable
// implementation of the heuristic function method. The provided "good"
// heuristic function is admissible.
//
// YOUR NAME -- TODAY'S DATE
//


// IMPORT ANY PACKAGES THAT YOU NEED.
// import java.util.*;
public class GoodHeuristic extends Heuristic {
	
	    // YOU CAN ADD ANYTHING YOU LIKE TO THIS CLASS ... WHATEVER WOULD
        // ASSIST IN THE CALCULATION OF YOUR GOOD HEURISTIC VALUE.


	public GoodHeuristic(Location destination) {
		this.destination = destination;
	}

	// heuristicValue -- Return the appropriate heuristic values for the
	// given search tree node. Note that the given Node should not be
	// modified within the body of this function.
	public double heuristicValue(Node thisNode) {
		double hVal = 0.0;
		double low = 3.1;          //this is the shortest road value
				
		double lat = destination.latitude - thisNode.loc.latitude;       //returns the straight line distance between the two given location
		double lon = destination.longitude - thisNode.loc.longitude;      // I researched this implementation and it was a way to implement the euclidean distance 
		
		hVal = (Math.sqrt((lat * lat) + (lon * lon))) / low;
		
		return (hVal);
	}

}

