import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
public class Graphs {
    
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        //0-vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));
        //1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));
        //2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));
        //3
        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));
        //graph[0].add(new Edge(3,1));
        //4
        //graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        //graph[4].add(new Edge(4, 5, 1));
        //5
        // graph[5].add(new Edge(5, 3, 1));
        // graph[5].add(new Edge(5, 4, 1));
        // graph[5].add(new Edge(5, 6, 1));
        //6
        //graph[6].add(new Edge(6, 5, 1));
    }


    public static void bfs(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                bfsUtil(graph, vis);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean vis[]) {
        Queue <Integer> q = new LinkedList<>();
        // boolean vis[] = new boolean[graph.length];
        q.add(0);

        while(!q.isEmpty()) {
            int curr = q.remove();

            if(!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for(int i=0; i<graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }

    public static void dfs(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            dfsUtil(graph, i, vis);
        }
    }
    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
        //visit
        System.out.print(curr + " ");
        vis[curr] = true;
        
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(!vis[e.dest]) { //not visited
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    //has path
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) {
        if(src == dest) {
            return true;
        }
        vis[src] = true;
        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            //e.dest - neighbor
            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
                return true;
            }
        }
        return false;
    }
    //detect cycle code
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                if(detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par) {
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            //case3
            if(!vis[e.dest]) {
                if(detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            }
            //case1
            else if(vis[e.dest] && e.dest != par) {
                return true;
            }
            //case2 - do nothing - continue
        }
        return false;
    }

    //BIPARTITE GRAPH
    public static void createForBipar(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 2, 1));
    }

    public static boolean isBipartite(ArrayList<Edge> [] graph) {
        int col[] = new int[graph.length];
        for(int i=0; i<col.length; i++) {
            col[i] = -1; //no color
        }
        
        Queue <Integer> q = new LinkedList<>();

        for(int i=0; i<graph.length; i++) {
            if(col[i] == -1) {
                q.add(i);
                col[i] = 0; //yellow

                while(!q.isEmpty()) { //BFS
                    int curr = q.remove();
                    for(int j=0; j<graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if(col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0; //coloring the neighbor
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if(col[e.dest] == col[curr]) {
                            return false; //not bipartite
                        }
                    }
                }
            }
        }
        return false;
    }
    //directed graph detection
    public static void createForDirec(ArrayList<Edge> graph[]) { 
        for(int i=0; i<graph.length; i++) { //true graph
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2, 1));
        
        graph[1].add(new Edge(1, 0, 1));

        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 0, 1));

        for(int i=0; i<graph.length; i++) {  //false graph
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 3, 1));
    }
    public static boolean isCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                if(isCycleUtil(graph, i, vis, stack)) { //check cycle
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycleUtil(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest]) { //cycle exists
                return true;
            }
            if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    //topological sorting using DFS
    public static void createforSort(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3, 1)); //only for print all path ques

        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));
    }
    public static void topSort(ArrayList<Edge> []graph) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }
        while(!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
    public static void topSortUtil(ArrayList<Edge> []graph, int curr, boolean vis[], Stack<Integer>s) {
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }
    
    //topo sort using BFS
    public static void topSortBFS(ArrayList<Edge>[] graph) {
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<indeg.length; i++) {
            if(indeg[i] == 0) {
                q.add(i);
            }
        }
        //bfs
        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " "); //top sort print

            for(int i=0; i<graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;

                if(indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }
    public static void calcIndeg(ArrayList<Edge>[] graph, int indeg[]) {
        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }

    //print all path
    public static void printAllPath(ArrayList<Edge>[] graph, int src, int dest, String path) {
        if(src == dest) {
            System.out.println(path+dest);
            return;
        }
        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllPath(graph, e.dest, dest, path+src);
        }
    }

    //DIJKSTRA'S ALGORITHM
    public static void graphDijks(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }
    static class Pair implements Comparable <Pair> {  //using PQ
        int n; 
        int path;
        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }
        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }
    public static void dijkstra(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];
        for(int i=0; i<graph.length; i++) {
            if( i!=src ) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[graph.length];
        PriorityQueue <Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        //loop
        while(!pq.isEmpty()) {
            Pair curr = pq.remove(); //sorted value first
            if(!vis[curr.n]) {
                vis[curr.n] = true;
                //for neighbours
                for(int i=0; i<graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u]+wt < dist[v]) {  //updating dist
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        //print all source to vertices
        for(int i=0; i<graph.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    //Bellman's Ford Algorithm
    public static void forBell(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }
    public static void bellmanFord(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];
        for(int i=0; i<dist.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        int V = graph.length;

        for(int i=0; i<V-1; i++) {
            for(int j=0; j<graph.length; j++) {
                for(int k=0; k<graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }
        //print
        for(int i=0; i<graph.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    //prim's algorithm
    public static void formst(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }
    static class Pair implements Comparable<Pair> {
        int v;
        int cost;

        public Pair(int v, int c) {
            this.v = v;
            this.cost = c;
        }
        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }
    public static void prims(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost = 0;

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;

                for(int i=0; i<graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }
        System.out.println("Final(min) cost of MST = " + finalCost);
    }

    //cheapest flights
    static class Info {
        int v;
        int cost;
        int stops;
        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }
    public static void createCheap(int flights[][], ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }
    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        createCheap(flights, graph);
        int dist[] = new int[n];
        for(int i=0; i<n; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));
        while(!q.isEmpty()) {
            Info curr = q.remove();
            if(curr.stops > k) {
                break;
            }
            for(int i=0; i<graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                if(curr.cost+wt < dist[v] && curr.stops <= k ) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops+1));
                }
            }
        }
        if(dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }
    }

    //connecting cities
    static class Edge implements Comparable<Edge> {
        int dest;
        int cost;
        public Edge(int d, int c) {
            this.dest = d;
            this.cost = c;
        }
        @Override
        public int compareTo(Edge e2) {
            return this.cost - e2.cost;
        }
    }
    public static int connectCities(int cities[][]) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[cities.length];
        pq.add(new Edge(0, 0));
        int finalCost = 0;

        while(!pq.isEmpty()) {
            Edge curr = pq.remove();
            if(!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalCost += curr.cost;

                for(int i=0; i<cities[curr.dest].length; i++) {
                    if(cities[curr.dest][i] != 0) {
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }
        return finalCost;
    }


    public static void main(String[] args) {
        
        // int V = 5; 
        // ArrayList <Edge>[] graph = new ArrayList [V];
        // for(int i=0; i<V; i++) {
        //     graph[i] = new ArrayList<>();
        // }
        // //0-vertex
        // graph[0].add(new Edge(0, 1, 5));
        // //1
        // graph[1].add(new Edge(1, 0, 5));
        // graph[1].add(new Edge(1, 2, 1));
        // graph[1].add(new Edge(1, 3, 3));
        // //2
        // graph[2].add(new Edge(2, 1, 1));
        // graph[2].add(new Edge(2, 3, 1));
        // graph[2].add(new Edge(2, 4, 2));
        // //3
        // graph[3].add(new Edge(3, 1, 3));
        // graph[3].add(new Edge(3, 2, 1));
        // //4
        // graph[4].add(new Edge(4, 2, 2));

        // //2's neighbour
        // for(int i=0; i<graph[2].size(); i++) {
        //     Edge e = graph[2].get(i);
        //     System.out.println(e.dest);
        // }

        // int V = 7;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph(graph);
        // //bfs(graph);
        // //dfs(graph, 0, new boolean[V]);
        // System.out.println(hasPath(graph, 0, 5, new boolean[V]));

        //cycle detect
        // int V = 5;
        // ArrayList <Edge> graph[] = new ArrayList[V];
        // createGraph(graph);
        // System.out.println(detectCycle(graph));

        //bipartite graph
        // int V = 5;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createForBipar(graph);
        // System.out.println(isBipartite(graph));

        //directed graph cycle detection
        // int V = 4;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createForDirec(graph);
        // System.out.println(isCycle(graph));

        //topological sorting DFS
        // int V=6;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createforSort(graph);
        // topSort(graph);

        //topo sort BFS
        // int V=6;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createforSort(graph);
        // topSortBFS(graph);

        //print all path
        // int V=6;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createforSort(graph);
        // int src = 5, dest = 1;
        // printAllPath(graph, src, dest, "");

        //dijsktra's
        //int V=6;
        //ArrayList<Edge> graph[] = new ArrayList[V];
        //graphDijks(graph);
        //int src = 0;
        //dijkstra(graph, src);

        //bellman's algo
        //int V=5;
        //ArrayList<Edge> graph[] = new ArrayList[V];
        //forBell(graph);
        //int src = 0;
        //bellmanFord(graph, src);

        //PRIMS ALGO
        // int V=4;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // formst(graph);
        // prims(graph);

        //cheapest flights
        // int n=4;
        // int flights[][] = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        // int src = 0, dst = 3, k = 1;
        // ArrayList<Edge> graph[] = new ArrayList[n];
        // System.out.println(cheapestFlight(n, flights, src, dst, k));

        //connecting cities with min path
        int cities[][] = {{0, 1, 2, 3, 4},
                          {1, 0, 5, 0, 7},
                          {2, 5, 0, 6, 0},
                          {3, 0, 6, 0, 0},
                          {4, 7, 0, 0, 0}};
        System.out.println(connectCities(cities));
    }
}
