package pkg328.lab.pkg6.bfs.dfs;

import java.util.Scanner;
import java.util.Random;

public class Lab6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	Random rand = new Random();
	GraphTraversal grapher = new GraphTraversal();

	//get size and order of graph from user
	System.out.print("What is the order of the graph? ");
	int order = input.nextInt();
	System.out.print("What is the size of the graph? ");
	int graphSize = input.nextInt();
	Node[] nodeList = new Node[order];

	//create nodes according to the order of the list
	grapher.populateNodeList(order);

	//create 2d array that is the size of the order of the graph
	int[][] adj = new int[order][order];

	//populate the graph
	adj = grapher.populateAdjacencyMatrix(adj, graphSize, order);

	//display the graph
	grapher.displayGraph(adj, order);

	//get initial vertex.
	int startingVertex;
	do {
	    System.out.print("What vertex would you like to start from? (0 - " + (order - 1) + ") ");
	    startingVertex = input.nextInt();
	} while (startingVertex < 0 && startingVertex >= order);

	//perform BFS and DFS
	Node[] BFSresult = grapher.BFS(adj, startingVertex);
	Node[] DFSresult = grapher.DFS(adj, startingVertex);

	System.out.print("Reachable nodes from " + startingVertex + " using BFS: ");
	for (int i = 0; i < BFSresult.length; i++) {
	    if (DFSresult[i].isMarked())
		System.out.print("1 ");
	    else
		System.out.print("0 ");
	}
	System.out.println("\n");

	System.out.print("Reachable nodes from " + startingVertex + " using DFS: ");
	for (int i = 0; i < DFSresult.length; i++) {
	    if (DFSresult[i].isMarked())
		System.out.print("1 ");
	    else
		System.out.print("0 ");
	}
	System.out.println();
	
	
	System.out.println("Shortest path: ");
	grapher.getShortestPath(startingVertex);

    
    
    }

}
