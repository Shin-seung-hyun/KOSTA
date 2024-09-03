package com.edu;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Kickboard {

		static int M;
		static int N;
		static int[][] map;
		static boolean[][] visited;    
	    static int dir[][] = { { 0,-1},{0,1},{1,0},{-1,0}};
	    static int cnt =0;
		
	    public static int execute(File path) throws IOException {
	        BufferedReader br = new BufferedReader(new FileReader(path));
	        StringTokenizer st = new StringTokenizer(br.readLine());

	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());

	        map = new int [N+1][M+1];
	        visited = new boolean[N+1][M+1];

	        for(int i=1; i<=N; i++) {
	            st = new StringTokenizer(br.readLine());
	            for(int j=1; j<=M; j++) {
	                map[i][j] = Integer.parseInt(st.nextToken());
	            }
	        }

	        DFS(1, 1, map[1][1]);

	        return cnt;
	    }

	    public static void DFS(int x, int y, int current) {

	        for(int i=0; i<4; i++){

	            int nx = x + dir[i][0];
	            int ny = y + dir[i][1];

	            if( nx == N && ny ==M ){

	                cnt = cnt +1;
	                //System.out.println();

	                return ;
	            }
	            else if( nx >N || nx <=0 || ny >M || ny <=0) continue;
	            else if (map[nx][ny] >= current) continue;
	            else if (visited[nx][ny]) continue;
	            else {

	                visited[nx][ny] = true;
	                //System.out.println(map[nx][ny]);
	                DFS(nx, ny, map[nx][ny]);
	                visited[nx][ny] = false;
	            }
	        }

	    }

	    public static void main(String[] args) throws IOException {
	    	
	        System.out.println(execute(new File("src/input.txt")));

	    }

}
