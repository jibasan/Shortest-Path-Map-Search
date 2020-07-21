import java.util.HashSet;

public class UniformCostSearch 
{
	public StreetMap graph;
	public String initialLoc;
	public String destinationLoc;
	public int limit;
	public int nodeExpansionCount;
	
	public UniformCostSearch(StreetMap graph, String initialLoc, String destinationLoc, int limit)
	{ 
		this.graph = graph;
		this.initialLoc = initialLoc;
		this.destinationLoc = destinationLoc;
		this.limit = limit;
    }
	
	public Node search(boolean check_state)         //returns the destination node if it is found
	{       
			
			nodeExpansionCount = 0;  //sets the node expansion count to 0 every time a new search starts
			Node node = new Node(graph.findLocation(initialLoc), null);    // Node is defined by the users input of the starting location
			
			SortedFrontier frontier = new SortedFrontier(SortBy.g);     // a frontier that contains explored nodes 
			frontier.addSorted(node);
			
			HashSet<String> explored = new HashSet<String>();	//explored nodes are stored into a hash set to be checked
			explored.add(node.loc.name);
			
								
			
			if(check_state) 
			{
				
				while(!frontier.isEmpty())
				{			
					node = frontier.removeTop();			
					
					if(limit <= node.depth) {
						return null;
					}
					if(node.isDestination(destinationLoc))     // if the destination is found, it will return the node
					{         
						return node; 
					}
					else {
						frontier.addSorted(node.children);
						node.expand(); //expands the node so that the children node are added to frontier
						nodeExpansionCount++;  //increments every time a node is expanded
					}
				}
				
			}	
			
				 else{
			            while (!frontier.isEmpty()){
			                
			                node = frontier.removeTop();
			                if (node.depth >= limit){
			                    return null;
			                }
			                if(node.isDestination(destinationLoc)){
			                    return node;
			                }
			                else{
			                    node.expand();
			                    frontier.addSorted(node.children);
			                    nodeExpansionCount++;
			                }
			            }
			        }
			        
			            return null;
				}
			}
			