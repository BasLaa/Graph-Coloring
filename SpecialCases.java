
import java.util.*;

/**
 * class for testing the graphs on special cases
 */
public class SpecialGraphs {
     
    /**
     * Here we use BFS where we choose a root node
     * We colour it with colour 1
     * We then colour all it's neighbours with colour 2
     * We then colour all the neighbour's neighbours with colour 1 etc...
     * If we find a neighbour of a node already coloured with the same colour, it's not bipartite
     * We do it iteratively, not recursively
     * Bipartite graphs, graphs phase 3: 4, 15
     * @param graph adj matrix
     * @param root root node, can just be 0
     * @return true / false
     */
    public boolean isBipartite(int[][] graph, int root, ColEdge[] e) {
        int n = graph[0].length;
        int[] colorArr = new int[n];
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i=0; i<n; i++) {
            colorArr[i] = -1;
            adj[i] = new ArrayList<Integer>();
        }

        for (ColEdge edge : e) {
            adj[edge.v].add(edge.u);
            adj[edge.u].add(edge.v);
        }

        //set colour node 1 to 1
        colorArr[root] = 1;

        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        //take node with highest degree to be root node
        queue.add(root);

        while (queue.size() != 0) {
            //takes first node in queue
            int currNode = queue.poll();
            ArrayList<Integer> neighbours = adj[currNode];
            for (Integer neighbour : neighbours) {
                if (colorArr[neighbour] == -1) {
                    if (colorArr[currNode] == 0) 
                        colorArr[neighbour] = 1;
                    else {
                        colorArr[neighbour] = 0;
                    }
                    queue.add(neighbour);
                }
                if (colorArr[neighbour] == colorArr[currNode]) {
                    return false;
                }
            }
            if (queue.size() == 0) {
                for (int i=0; i<n; i++) {
                    if (colorArr[i] == -1) {
                        queue.add(i);
                        break;
                    }
                }
            }            
        }

        return true;


    }


    /**
     * Tests for completeness of a graph
     * @param n number of nodes
     * @param m number of edges
     * @return true / false
     */
    public boolean isComplete(int n, int m) {
        if (m == (n*(n-1))/2) {
            return true;
        }
        
        else {
            return false;
        }
    }
}
