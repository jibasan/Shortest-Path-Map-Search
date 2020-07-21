import java.util.HashSet;

public class AStarSearch 
{
			public StreetMap graph;
			public String initialLoc;
			public String destinationLoc;
			public int limit;
			public int nodeExpansionCount = 0;
			
			public AStarSearch(StreetMap graph, String initialLoc, String destinationLoc, int limit)
			{ 
				this.graph = graph;
				this.initialLoc = initialLoc;
				this.destinationLoc = destinationLoc;
				this.limit = limit;
		    }
			

			public Node search(boolean check_state)
			{

				SortedFrontier frontier = new SortedFrontier(SortBy.f);       //children nodes are stored here
				Node node = new Node(graph.findLocation(initialLoc));           // the node is defined by the users input of the starting location
				frontier.addSorted(node);                 //add the initial node to the frontier
			
				HashSet<Location> explored = new HashSet<Location>();      //explored nodes are stored into a hash set to be checked
				HashSet<Node> junk = new HashSet<Node>();                 //junk nodes are stored into a hash set to be checked

													
				while(!frontier.isEmpty() && node.depth < limit) 
				{			
					Node node1 = frontier.removeTop();			            // gets the next node on the frontier
																												
						if(node1.isDestination(destinationLoc))     // if the destination is found, it will return the node
						{         
							return node1; 
						
						}
						
						else 
						{
							GoodHeuristic h = new GoodHeuristic(graph.findLocation(destinationLoc));        //initialize heuristic function to find final location
							node1.expand(h);               //not the goal node so we expand the node so that the children node are added to frontier
								
						if (check_state == true)               //checks if true then it adds explored sets to the sorted frontier and an entry is created in explored
						{
							explored.add(node1.loc);
									
							for (Node x: node1.children)        //adds the children of this node to the frontier if their states are not in the frontier
							{
								if(explored.contains(node1.loc) || frontier.contains(node1))
								junk.add(x);
							}
									
								frontier.addSorted(node1.children);      //if the child is in the explored set, the child is not added to the frontier
							
						}
						
						else
						{
							frontier.addSorted(node1.children);           //adds the children node to the frontier
						}
						
						nodeExpansionCount++;     
						
						}
						
						node = node1;              // set the node equal to the next node
						
				}
						
						return null;
				
			}
	}
