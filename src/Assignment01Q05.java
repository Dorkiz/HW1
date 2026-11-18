public class Assignment01Q05 { 
    static int current_shortest_trail;
    public static int findShortestPath(int[][] m, int i, int j) {
        if (i==j) {return 0;}
        int my_null = -1;
        int len = m.length;
        int[] distances = new int[len];
        for(int z=0; z<len; z++){ distances[z] = my_null; }
        int[] queue = new int[len];
        int start = 0; 
        int end = 0;
        distances[i] = 0;
        queue[end] = i; 
        end++;
        while (start < end) {
            int current = queue[start]; 
            start++;
            if (current == j) {return distances[current];}
            for(int adj=0; adj<len; adj++){
                if (m[current][adj] == 1 && distances[adj] == my_null) {
                    distances[adj] = distances[current] + 1;
                    queue[end] = adj;
                    end++;
                }
            }
        }
        return my_null;
    }


    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}