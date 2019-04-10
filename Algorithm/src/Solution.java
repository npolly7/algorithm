import java.io.*;
import java.util.*;

//사랑의 카운슬러 (지렁이 문제)
public class Solution {
	static Vec[] vec;
	static boolean[] visited;
	static int N, r;
 static long answer;

 public static void main(String args[]) throws Exception {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  StringBuilder sb = new StringBuilder();	
  StringTokenizer st;
 
  
  int T = Integer.parseInt(br.readLine());
 
  for (int test_case = 1; test_case <= T; test_case++) {
	  //지렁이 몇마리
   N = Integer.parseInt(br.readLine());
   
   
   r = N / 2;
   
   vec = new Vec[N];
   
  
   visited = new boolean[N];
 
   
   for (int i = 0; i < N; i++) {
    st = new StringTokenizer(br.readLine());
  
    vec[i] = new Vec(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
   }
 
   answer = Long.MAX_VALUE;
   dfs(0, 0);
 
   sb.append("#").append(test_case).append(" ").append(answer).append("\n");
  }
  bw.write(sb.toString());
  bw.close();
  br.close();
 }
 
 static void dfs(int depth, int start) {
  if (depth == r) {
   long sX = 0, sY = 0;
 
   for (int i = 0; i < N; i++) {
    sX += vec[i].x * (visited[i] ? 1 : -1);
    sY += vec[i].y * (visited[i] ? 1 : -1);
   }
 
   long tmp = sX * sX + sY * sY;
   answer = answer < tmp ? answer : tmp;
   return;
  }
 
  for (int i = start; i < N; i++) {
   if (!visited[i]) {
    visited[i] = true;
    dfs(depth + 1, i + 1);
    visited[i] = false;
   }
  }
 }
 
 static class Vec {
  int x, y;
 
  Vec(int x, int y) {
   this.x = x;
   this.y = y;
  }
 }
}