package com.edu;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.apache.tomcat.websocket.WsRemoteEndpointImplBase;

public class Kickboard {

		static int M;
		static int N;
		static int[][] map;
		static boolean[][] visited;
		
		static int dir[][] = { { 0,-1},{0,1},{1,0},{-1,0}};
		
		public static int execute(File path) throws IOException , FileNotFoundException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
			
	        M = Integer.parseInt(st.nextToken());
	        N = Integer.parseInt(st.nextToken());
	        
	        map = new int [M+1][N+1];
	        visited = new boolean[M+1][N+1];
	        
	        for(int i=1; i<=M; i++) {
	        	st = new StringTokenizer(br.readLine());
	        	for(int j=1; j<=N; j++) {
	        		map[i][j] = Integer.parseInt(st.nextToken());
	        	}
	        }
	        
	        int cnt =0;
	        
	        DFS(1, 1);
			
			return cnt;
		}
		
		public static void DFS(int x, int y) {
			
			
		}
		
		
		public static void main(String[] args) throws IOException {
			System.out.println(execute(new File("input.txt")));
			
		}

}
