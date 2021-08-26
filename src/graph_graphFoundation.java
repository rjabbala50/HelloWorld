

//Graphs Modeling

import java.lang.reflect.Array;
import java.util.*;

public class graph_graphFoundation {

        Map<Integer,List<Integer>> adjList ;
        int V ;

        public graph_graphFoundation(int size)
        {
            this.V = size ;
            adjList = new HashMap<>() ;
        }

        public void addEdge(int start, int end, boolean direction)
        {
            List<Integer> edge = new ArrayList<>() ;
            edge.add(end) ;
            adjList.putIfAbsent(start,edge) ;
            if(direction == true) {
                List<Integer> edge1 = new ArrayList<>() ;
                edge.add(start) ;
                adjList.put(end,edge1) ;
            }
        }

        public boolean hasEulerianCycle() {
            int odd = 0;
            for(Map.Entry<Integer,List<Integer>> entry :adjList.entrySet() )
                if(entry.getValue().size()%2 == 1)
                    odd++ ;

            if(odd == 0) return  true;
            else return false ;

        }
    class Solution {

        int[] visited ;
        Map<Integer,List<Integer>> adjList ;


        private void DFS(Integer node)
        {
            visited[node] = 1;
            List<Integer> list = adjList.get(node) ;
            if(list != null) {
                int listSize = list.size() ;
                for(int i=0; i<listSize;i++) {
                    Integer vertex = list.get(i) ;
                    if(visited[vertex] == 0)
                        DFS(vertex) ;
                }
            }
        }

        //build adj List
        private void buildAdjList(int n, int[][] edges)
        {
            for(int i=0; i<edges.length;i++) {
                Integer edgeA = edges[i][0] ;
                Integer edgeB= edges[i][1] ;
                List<Integer> list =  adjList.get(edgeA);
                if(list != null)
                    list.add(edgeB) ;
                else {
                    list = new ArrayList<Integer>() ;
                    list.add(edgeB) ;
                }

                adjList.put(edgeA, list)  ;
                List<Integer> list1 =  adjList.get(edgeB);
                if(list1 != null)
                    list1.add(edgeA) ;
                else {
                    list1 = new ArrayList<Integer>() ;
                    list1.add(edgeA) ;
                }
                adjList.put(edgeB, list1)  ;
            }
        }

        public int countComponents(int n, int[][] edges) {
            adjList = new HashMap<>() ;

            visited = new int[n] ;
            buildAdjList(n,edges) ;
            int connCount = 0;

            for(int i=0; i<n;i++) {
                if(visited[i] == 0) {
                    connCount ++ ;
                    DFS(i) ;
                }
            }
            return connCount ;
        }
    }
/*
        private void BFS(Integer root)
        {
            Queue<Integer> q = new ArrayDeque<Integer>() ;
            List<Integer> captured = new ArrayList<Integer>() ;
            List<Integer> visited = new ArrayList<Integer>() ;
            List<Integer> parent = new ArrayList<Integer>() ;


            captured.add(root) ;
            visited.add(root) ;

            q.offer(root) ;
            while(!q.isEmpty()) {
                Integer node = q.poll();
                if(node != root)
                    captured.add(node) ;
                List<Integer> list = adjList.get(node) ;
                for(Integer i:list) {
                    if(!visited.contains(i)) {
                        visited.add(i) ;
                        parent.add(root) ;
                        q.offer(i);
                    }
                }
            }
        }
 */

        private void BFS(Integer root)
        {
            Queue<Integer> q = new ArrayDeque<Integer>() ;
            List<Integer> visited = new ArrayList<Integer>() ;
            q.offer(root) ;
            visited.add(root,1) ;

            while(!q.isEmpty()) {
                Integer node = q.poll();
                List<Integer> list = adjList.get(node) ;
                for(Integer vertex:list) {
                    if(visited.get(vertex) == 0) {
                        q.offer(vertex);
                        visited.add(vertex,1) ;
                    }
                }
            }
        }

        List<Integer> visited = new ArrayList<>();
        private void findConnectedComponents()
        {
            for(Integer vertex : visited)
                if(visited.get(vertex) == 0)
                    DFS(vertex);
        }

        //Recursive DFS
        private void DFS(Integer node)
        {
            visited.add(node,1);
            for(Integer vertex: adjList.get(node))
                if(visited.get(vertex) == 0)
                    DFS(vertex);
        }

        public static void main(String[] args) {
            graph_graphFoundation graph = new graph_graphFoundation(3) ;
            graph.addEdge(1,2,true);
            graph.addEdge(2,3,false);
            graph.addEdge(3,1,true);

            System.out.println(graph.hasEulerianCycle());
            graph.BFS(3);
            graph.DFS(3);
        }
}
