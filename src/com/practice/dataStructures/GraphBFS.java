// package com.practice.dataStructures;
//
// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.IOException;
// import java.util.ArrayDeque;
// import java.util.Queue;
// import java.util.Scanner;
//
// class Vertex {
// String name;
// Neighbor neighborsList;
//
// Vertex(String s, Neighbor neighbors) {
// name = s;
// this.neighborsList = neighbors;
// }
//
// }
//
// class Neighbor {
// int vertexNum;
// Neighbor next;
//
// Neighbor(int vnum, Neighbor n1) {
// vertexNum = vnum;
// next = n1;
// }
// }
//
// public class GraphBFS {
// Vertex[] vertexList;
//
// GraphBFS(String file) throws FileNotFoundException {
//
// Scanner scan = new Scanner(new File(file));
// String type = scan.next();
// boolean undirected = true;
// if ("DIRECTED".equalsIgnoreCase(type)) {
// undirected = false;
// }
// vertexList = new Vertex[scan.nextInt()];
//
// // read the vertices
// for (int i = 0; i < vertexList.length; i++)
// vertexList[i] = new Vertex(scan.next(), null);
//
// // read edges
// while (scan.hasNext()) {
// int v1 = indexForName(scan.next()); // get vertix number from name
// int v2 = indexForName(scan.next());// get vertix number from name
// // add v1 to v2 and v2 to v1
// vertexList[v1].neighborsList = new Neighbor(v2,
// vertexList[v1].neighborsList);
// if (undirected)
// vertexList[v2].neighborsList = new Neighbor(v1,
// vertexList[v2].neighborsList);
// }
//
// }
//
// int indexForName(String name) {
// for (int v = 0; v < vertexList.length; v++) {
// if (vertexList[v].name.equals(name)) {
// return v;
// }
// }
// return -1;
// }
//
// private void dfs(int v, boolean[] visited) {
// visited[v] = true;
// System.out.println("visting vertex.." + vertexList[v].name);
// for (Neighbor nbr = vertexList[v].neighborsList; nbr != null; nbr = nbr.next)
// {
// if (!visited[nbr.vertexNum]) {
// System.out.println(vertexList[v].name + "...." +
// vertexList[nbr.vertexNum].name);
// dfs(nbr.vertexNum, visited);
// }
// }
//
// }
//
// void dfs() {
// boolean[] visited = new boolean[vertexList.length];
// for (int i = 0; i < vertexList.length; i++) {
// if (!visited[i])
// dfs(i, visited);
// }
// }
//
// void bfs() {
//
// Queue<Integer> q = new ArrayDeque<Integer>();
// boolean[] visited = new boolean[vertexList.length];
// for (int i = 0; i < vertexList.length; i++) {
// if (!visited[i])
// bfs(i, visited, q);
// }
// }
//
// private void bfs(int i, boolean[] visited, Queue<Integer> q) {
// visited[i] = true;
// q.add(i);
// System.out.println("visting vertex.." + vertexList[i].name);
// while (!q.isEmpty()) {
// i = q.poll();
// for (Neighbor nbr = vertexList[i].neighborsList; nbr != null; nbr = nbr.next)
// {
// if (!visited[nbr.vertexNum]) {
// visited[nbr.vertexNum] = true;
// System.out.println("visting vertex.." + vertexList[nbr.vertexNum].name);
// q.add(nbr.vertexNum);
// }
// }
// }
// // bfs(visited, q);
// }
//
// public void print() {
// System.out.println();
// for (int v = 0; v < vertexList.length; v++) {
// System.out.print(vertexList[v].name);
// for (Neighbor nbr = vertexList[v].neighborsList; nbr != null; nbr = nbr.next)
// {
// System.out.print(" --> " + vertexList[nbr.vertexNum].name);
// }
// System.out.println("\n");
// }
// }
//
// public static void main(String[] args) throws IOException {
// Scanner sc = new Scanner(System.in);
// // test 1
// String file =
// "C:\\Users\\ramaram.ORADEV\\workspace_personal\\JavaPractice\\testResource\\test1.txt";//
// directed
// GraphBFS graph = new GraphBFS(file);
// // graph.print();
// // graph.dfs();
// // // test 2
// // file =
// //
// "C:\\Users\\ramaram.ORADEV\\workspace_personal\\JavaPractice\\testResource\\test2.txt";//
// // undirected
// // graph = new GraphBFS(file);
// // graph.print();
// // graph.dfs();
//
// file =
// "C:\\Users\\ramaram.ORADEV\\workspace_personal\\JavaPractice\\testResource\\test1.txt";//
// directed
// graph = new GraphBFS(file);
// graph.print();
// graph.bfs();
// // test 2
// file =
// "C:\\Users\\ramaram.ORADEV\\workspace_personal\\JavaPractice\\testResource\\test2.txt";//
// undirected
// graph = new GraphBFS(file);
// graph.print();
// graph.bfs();
//
// }
// }
