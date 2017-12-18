import java.util.ArrayList;

public class Test {
    
    public static void main(String[] args) {
        ArrayList<Node> list = new ArrayList<>();
        
        for(int x = 0; x < 5; x++) {
            for(int y = 0; y < 5; y++) {
                list.add(new Node(x, y));
            }
        }
        
        AStar algorithm = new AStar();
        System.out.println(algorithm.getShortestPath(list, list.get(0), list.get(list.size() -1)));
        
    }
    
}
