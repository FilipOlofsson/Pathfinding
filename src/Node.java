public class Node {
    
    public float getgCost() {
        return gCost;
    }
    
    public void setgCost(float gCost) {
        this.gCost = gCost;
    }
    
    public float gethCost() {
        return hCost;
    }
    
    public void sethCost(float hCost) {
        this.hCost = hCost;
    }
    
    private float gCost;          // Distance from starting Node Sqrt(|Δx|^2 + |Δy|^2)
    private float hCost;          // Distance from end Node Sqrt(|Δx|^2 + |Δy|^2)
    private float fCost;          // gCost + hCost
    public Node cameFrom;
    private int x, y;
    
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    void Update(Node start, Node finish) {
        this.gCost = (float) Math.sqrt(Math.pow(Math.abs(this.x - start.x), 2) + Math.pow(Math.abs(this.y - start.y), 2));
        this.hCost = (float) Math.sqrt(Math.pow(Math.abs(this.x - finish.x), 2) + Math.pow(Math.abs(this.y - finish.y), 2));
        this.fCost = gCost + hCost;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public boolean equals(Node Second) {
        return (this.x == Second.x && this.y == Second.y);
    }
    
    public float getfCost() {
        return fCost;
    }
}
