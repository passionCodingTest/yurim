package beakjoon;

import java.util.*;
import java.io.*;
public class Q1991 {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Tree tree = new Tree();
		for(int i = 0; i<N; i++) {
			char[] data = br.readLine().replaceAll(" " , "").toCharArray();
			tree.createNode(data[0], data[1], data[2]);
		}
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
		br.close();
	}
	
	static class Node {
		char data;
		Node left;
		Node right;
		Node(char data){
			this.data = data;
		}
	}
	
	static class Tree{
		Node root;
		public void createNode(char data, char leftData, char rightData) {
			if(root == null) {
				root = new Node(data);
				if(leftData != '.') root.left = new Node(leftData);
				if(rightData != '.') root.right = new Node(rightData);
			}else {
				searchNode(root, data, leftData, rightData);
			}
		}
		public void searchNode(Node root, char data, char leftData, char rightData) {
			if(root == null) return;
			else if (root.data == data) {
				if(leftData != '.') root.left = new Node(leftData);
				if(rightData != '.') root.right = new Node(rightData);
			}else {
				searchNode(root.left, data, leftData, rightData);
				searchNode(root.right, data, leftData, rightData);
			}
		}
		//중위 순회 
		public void inOrder(Node node) {
			if(node == null) return;
			inOrder(node.left);
			System.out.print(node.data);
			inOrder(node.right);
		}
		//전위 순회 
		public void preOrder(Node node) {
			if(node == null) return;
			System.out.print(node.data);
			preOrder(node.left);
			preOrder(node.right);
		}
		//후위 순회 
		public void postOrder(Node node) {
			if(node == null) return;
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data);
		}
	}
}
