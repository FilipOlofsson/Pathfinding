import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Algorithm {
    
    public String getShortestPath(ArrayList<Node> nodes, Node start, Node finish) {
        if(start.equals(finish))
            return "Happy days, start is finish.";
    
        ArrayList<Node> openNodes = new ArrayList<>();
        ArrayList<Node> closedNodes = new ArrayList<>();
        closedNodes.addAll(nodes);
        openNodes.add(start);
    
        while(openNodes.size() > 0) {
            for(int i = 0; i < openNodes.size() -1; i++) {
                openNodes.get(i).Update(start, finish);
            }
            Node current = lowestFCost(openNodes);
        
            if(current.equals(finish))
                return "Happy days";
            
            openNodes.remove(current);
            closedNodes.add(current);
        
            ArrayList<Node> neighbors = getNeighbors(closedNodes, current);
        
            for(Node node : neighbors) {
                openNodes.add(node);
            
                float gCost = current.getgCost() + distance(current, node);
                if(gCost >= node.getgCost())
                    break;
                node.cameFrom = current;
            }
        }
        return "Unhappy days";
    }
    
    private float distance(Node first, Node second) {
        return (float)
                Math.sqrt(Math.pow(Math.abs(first.getX() - second.getX()), 2) +
                        Math.pow(Math.abs(first.getY() - second.getY()), 2));
    }
    
    private ArrayList<Node> getNeighbors(ArrayList<Node> list, Node current) {
        ArrayList<Node> neighbors = new ArrayList<>();
        ArrayList<Node> remaining = new ArrayList<>();
        ArrayList<Node> removalList = new ArrayList<>();
        remaining.addAll(list);
        if(remaining.size() == 0) {
            System.out.println("wtf are you doing");
            return null;
        }
        for(Node node : remaining) {
            if(isNeighbors(node, current) && !removalList.contains(node)) {
                removalList.add(node);
            }
        }
        remaining.removeAll(removalList);
        System.out.println("returning");
        return neighbors;
    }
    
    private boolean isNeighbors(Node first, Node second) {
        
        if(Math.abs(first.getX() - second.getX()) <= 1 && Math.abs(first.getY() - second.getY()) <= 1 && !first.equals
                (second))
            return true;
        return false;
    }
    
    private Node lowestFCost(ArrayList<Node> list) {
        Node lowest = list.get(0);
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getfCost() < lowest.getfCost()) {
                lowest = list.get(i);
            }
        }
        return lowest;
    }
    
}
