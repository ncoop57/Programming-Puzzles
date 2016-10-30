
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main1 {
    static Node[] G;
    static int M;
    static int N;
    static int count = 0;
    static Stack<Integer> s = new Stack<Integer>();
    
    static class Node{
        List<Edge> adj;
        int n;
        public boolean visited;
        int layer;
        
        public Node(int N){
            adj = new ArrayList<Edge>();
            n=N;
            layer = 0;
            visited = false;
        }
    }
    
    static class Edge{
	    int to, weight;
	    public Edge(int t, int w){
	        to=t;
	        weight=w;
	    }
	}
    
    static void makeGraph(int n){
        G = new Node[n];
        for(int i=0; i<n; i++){
            G[i] = new Node(i);
        }
    }
    
    public static void addEdge(int u, int v, int w){
        G[u].adj.add(new Edge(v,w));
        G[v].adj.add(new Edge(u,w));
    }
    
    public static int bfs(int s, int t){
        G[s].layer = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        int cur = -1;
        while(!q.isEmpty()){
            cur = q.peek();
            G[cur].visited = true;
            for(Edge e: G[cur].adj){
                if(!G[e.to].visited){
                    q.add(G[e.to].n);
                    G[e.to].visited = true;
                    G[e.to].layer = G[cur].layer + 1;
                    if(cur - e.to == -6){
                        System.out.print("N");
                    }
                    if(cur - e.to == 6){
                        System.out.print("S");
                    }
                    if(cur - e.to == -1){
                        System.out.print("W");
                    }
                    if(cur - e.to == 1){
                        System.out.print("E");
                    }
                    
                }
            }
            q.poll();
        }
        for(Node node: G){
            System.out.print(node.layer + " ");
        }
        return G[t].layer;
    }
    
    public static boolean areConnected(double cell1x, double cell1y, double cell2x, double cell2y){
        boolean isConnected = true;
        if(y3==y4){
            if(cell1x > x3 && cell1x < x4 && cell2x > x3 && cell2x < x4){
                if(cell1y > y3 && cell2y < y4){
                    isConnected = false;
                }
                else if(cell2y > y3 && cell1y < y4){
                    isConnected = false;
                }
            }
        }
        else if(x3==x4){
            if(cell1y > y3 && cell1y < y4 && cell2y > y3 && cell2y < y4){
                if(cell1x > x3 && cell2x < x4){
                    isConnected = false;
                }
                else if(cell2x > x3 && cell1x < x4){
                    isConnected = false;
                }
            }
        }
        if(y5==y6){
            if(cell1x > x5 && cell1x < x6 && cell2x > x5 && cell2x < x6){
                if(cell1y > y5 && cell2y < y6){
                    isConnected = false;
                }
                else if(cell2y > y5 && cell1y < y6){
                    isConnected = false;
                }
            }
        }
        else if(x5==x6){
            if(cell1y > y5 && cell1y < y6 && cell2y > y5 && cell2y < y6){
                if(cell1x > x5 && cell2x < x6){
                    isConnected = false;
                }
                else if(cell2x > x5 && cell1x < x6){
                    isConnected = false;
                }
            }
        }
        if(y7==y8){
            if(cell1x > x7 && cell1x < x8 && cell2x > x7 && cell2x < x8){
                if(cell1y > y7 && cell2y < y8){
                    isConnected = false;
                }
                else if(cell2y > y7 && cell1y < y8){
                    isConnected = false;
                }
            }
        }
        else if(x7==x8){
            if(cell1y > y7 && cell1y < y8 && cell2y > y7 && cell2y < y8){
                if(cell1x > x7 && cell2x < x8){
                    isConnected = false;
                }
                else if(cell2x > x7 && cell1x < x8){
                    isConnected = false;
                }
            }
        }
        return isConnected;
    }
//wall1
    static int x3,y3,x4,y4;
//wall2
    static int x5,y5,x6,y6;
//wall3
    static int x7,y7,x8,y8;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(true){
            //start
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            if(x1 == 0 && y1 == 0)break;
            //finish
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            //wall1
            x3 = in.nextInt();
            y3 = in.nextInt();
            x4 = in.nextInt();
            y4 = in.nextInt();
            //wall2
            x5 = in.nextInt();
            y5 = in.nextInt();
            x6 = in.nextInt();
            y6 = in.nextInt();
            //wall3
            x7 = in.nextInt();
            y7 = in.nextInt();
            x8 = in.nextInt();
            y8 = in.nextInt();
            
            makeGraph(36);
            for(int i=0; i<36 - 1; i++){
                if(!areConnected((double)((i%6)-0.5), 
                        (double)((i/6)-0.5), 
                        (double)((i+1%6)-0.5), 
                        (double)((i+1/6)-0.5)))continue;
                try{
                    addEdge(i, i+ 1,1);
                }catch(Exception e){}
                if(!areConnected((double)((i%6)-0.5), 
                        (double)((i/6)-0.5), 
                        (double)((i+6%6)-0.5), 
                        (double)((i+6/6)-0.5)))continue;
                try{
                    addEdge(i-1, i,1);
                }catch(Exception e){}
            }
            
            bfs(x1+((y1-1)*6), x2+((y2-1)*6));
        }
    }
}
