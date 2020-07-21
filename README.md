# Shortest-Path-Map-Search
Implement uniform-cost search, greedy best-first search, and A* search algorithms in JavaTM to solve a simple shortest-path map search problem.

Provide JavaTM classes that implement the following three search algorithms: uniformcost search, greedy best-first search, and A* search. Source code must be
compatible with a collection of provided JavaTM classes that implement simple street maps, allowing your search algorithms to be used to find the shortest routes between locations on such maps.

All of these classes must have the following features . . .
• a constructor that takes four arguments:
  1. a complete StreetMap object, encoding the map to be searched
  2. a String providing the name of the starting location
  3. a String providing the name of the destination location
  4. an integer depth limit for the search — if this depth is ever reached during a search
  (i.e., a node at this depth or deeper is considered for expansion), the search should be
  abandoned and null (indicating search failure) should be returned

• a method that actually performs the search, called search, with the following properties:
  – it takes a single boolean argument — if this argument is “true”, then repeated state
  checking should be performed, otherwise no such checking should be done during
  search
  – it returns a Node object from the search tree that corresponds to the target destination,
  or null if no solution was found

• a public integer instance variable called nodeExpansionCount that contains the number
  of node expansions performed during the most recent call to the search method
  
• an admissible heuristic function in the domain of searching for a shortest path on a map
