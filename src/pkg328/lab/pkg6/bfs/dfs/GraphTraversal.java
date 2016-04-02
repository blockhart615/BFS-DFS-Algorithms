package pkg328.lab.pkg6.bfs.dfs;

import java.util.Random;
import java.util.LinkedList;
import java.util.Stack;

public class GraphTraversal {

    private Random rand = new Random();
    private int[][] parentMatrix;	    //something crazy
    private Node[] nodeList;		    //the nodes in the graph

    /**
     *
     * @param adj
     * @param graphSize
     * @param order
     * @return
     */
    public int[][] populateAdjacencyMatrix(int[][] adj, int graphSize, int order) {
	int i = 0;
	while (i < graphSize) {
	    int xpos = rand.nextInt(order), ypos = rand.nextInt(order);
	    if (adj[xpos][ypos] != 1) {
		adj[rand.nextInt(order)][rand.nextInt(order)] = 1;
		i++;
	    }
	}
	return adj;
    }

    /**
     * CReate an array of nodes according to the order of the graph
     *
     * @param order
     */
    public void populateNodeList(int order) {
	nodeList = new Node[order];
	for (int i = 0; i < nodeList.length; i++) {
	    nodeList[i] = new Node(i);
	}
    }

    /**
     * display the adjacency matrix
     *
     * @param adj
     * @param order
     */
    public void displayGraph(int[][] adj, int order) {
	System.out.print("\t");
	for (int i = 0; i < order; i++) {
	    System.out.print(i + "  ");
	}
	System.out.print("\n\t");
	for (int i = 0; i < order; i++) {
	    System.out.print("---");
	}
	System.out.println();

	for (int i = 0; i < order; i++) {
	    System.out.print(i + "|\t");
	    for (int j = 0; j < order; j++) {
		System.out.print(adj[i][j] + "  ");
	    }
	    System.out.println();
	}
    }

    /**
     * 
     * @param adjMatrix
     * @param root
     * @return 
     */
    public Node[] BFS(int[][] adjMatrix, int root) {
	LinkedList<Node> q = new LinkedList();
	Node currentNode = nodeList[root];

//	for (int i = 0; i < nodeList.length; i++) {
//	    nodeList[i].setDistance(-1);
//	    nodeList[i].setParent(null);
//	}

	nodeList[root].mark();
	q.push(nodeList[root]);

	while (!q.isEmpty()) {
	    currentNode = q.pop();
	    for (int i = 0; i < adjMatrix.length; i++) {
		if (adjMatrix[currentNode.getValue()][i] == 1) {
		    if (!nodeList[i].isMarked()) {
			nodeList[i].mark();
			nodeList[i].setParent(currentNode);
			q.push(nodeList[i]);
		    }
		}
	    }
	}
	return nodeList;
    }
    
    /**
     * Perform Depth First Search
     *
     * @param adj
     * @param vertex
     * @return
     */
    public Node[] DFS(int[][] adjMatrix, int root) {
	Stack<Node> q = new Stack();
	Node currentNode = nodeList[root];

//	for (int i = 0; i < nodeList.length; i++) {
//	    nodeList[i].setDistance(-1);
//	    nodeList[i].setParent(null);
//	}

	nodeList[root].mark();
	q.push(nodeList[root]);

	while (!q.isEmpty()) {
	    currentNode = q.pop();
	    for (int i = 0; i < adjMatrix.length; i++) {
		if (adjMatrix[currentNode.getValue()][i] == 1) {
		    if (!nodeList[i].isMarked()) {
			nodeList[i].mark();
			nodeList[i].setParent(currentNode);
			q.push(nodeList[i]);
		    }
		}
	    }
	}
	return nodeList;
    }

    /**
     * Get the shortest path through the graph
     *
     * @param index
     */
    public void getShortestPath(int index) {

	for (int i = nodeList.length - 1; i >= 0; i--) {
	    Node current = nodeList[i];
	    LinkedList<Node> path = new LinkedList();
	   
	    while (current != null) {
		path.addFirst(current);
		current = current.getParent();
	    }
	    //display shortest path
	    for (Node j: path){
		System.out.print(j.getValue());
		if (path.indexOf(j) < path.size() - 1)
		    System.out.print(" -> ");
	    }
	    System.out.println();
	}
	System.out.println();
    }
}
