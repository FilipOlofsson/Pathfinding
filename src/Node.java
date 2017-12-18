public class Node {
    
    private int gCost;          // Distance from starting Node Sqrt(|Δx^2| + |Δy^2|)
    private int hCost;          // Distance from end Node Sqrt(|Δx^2| + |Δy^2|)
    private int fCost;          // gCost + hCost
    private boolean Visited = false;
    
    
    public void updatefCost() throws NullPointerException {
        this.fCost = gCost + hCost;
    }
    
    public int gethCost() {
        return hCost;
    }
    
    public void sethCost(int hCost) {
        this.hCost = hCost;
    }
    
    public int getgCost() {
        return gCost;
    }
    
    public void setgCost(int gCost) {
        this.gCost = gCost;
    }
    
    public boolean isVisited() {
        return Visited;
    }
    
    public void setVisited(boolean visited) {
        Visited = visited;
    }
}
