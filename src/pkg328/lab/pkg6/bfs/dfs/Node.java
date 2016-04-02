
package pkg328.lab.pkg6.bfs.dfs;


public class Node {
    private int distance, value;
    private Node parent;
    boolean marked;
    
    public Node () {
	value = 0;
	distance = -1;
	parent = null;
	marked = false;
    }
    
    public Node(int value) {
	this.value = value;
	distance = -1; 
	parent = null;
	marked = false;
    }
    
    //DISTANCE GET AND SETTERS
    public int getDistance() {
	return distance;
    }
    
    public void setDistance(int distance) {
	this.distance = distance;
    }
    
    
    //VALUE GET AND SETTERS
    public int getValue() {
	return value;
    }
    
    public void setValue(int value) {
	this.value = value;
    }
    
    
    //PARENT GET AND SETTERS. Also determine whether or not the node is marked
    public Node getParent() {
	return parent;
    }
    
    public void setParent(Node parent) {
	this.parent = parent;
    }
    
    public boolean hasParent() {
	return parent != null;
    }
    
    public void mark() {
	marked = true;
    }
    
    public boolean isMarked() {
	return marked;
    }
        
}
