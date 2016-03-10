package edu.zju.chwl.lintcode.graphsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * http://www.lintcode.com/en/problem/topological-sorting/
 * 题意不明朗
 * 
 * @author chwl
 * @Date 2016年3月9日 下午11:24:33
 */
public class TopologicalSorting {
	
	public static void main(String[] args) {
		DirectedGraphNode node4=new DirectedGraphNode(4);
		DirectedGraphNode node3=new DirectedGraphNode(3);
		node3.neighbors.add(node4);
		DirectedGraphNode node1=new DirectedGraphNode(1);
		node1.neighbors.add(node3);
		node1.neighbors.add(node4);
		DirectedGraphNode node2=new DirectedGraphNode(2);
		node2.neighbors.add(node1);
		node2.neighbors.add(node4);
		DirectedGraphNode node=new DirectedGraphNode(0);
		node.neighbors.add(node1);
		node.neighbors.add(node2);
		node.neighbors.add(node3);
		node.neighbors.add(node4);
		ArrayList<DirectedGraphNode> list = new ArrayList<DirectedGraphNode>();
		list.add(node);
		System.out.println(new TopologicalSorting().topSort(list));;
	}

	public ArrayList<DirectedGraphNode> topSort(
			ArrayList<DirectedGraphNode> graph) {
		if (graph == null) {
			return null;
		}
		Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
		Map<DirectedGraphNode, Integer> inMap = new HashMap<DirectedGraphNode, Integer>();
		for (DirectedGraphNode graphNode : graph) {
			for (DirectedGraphNode node : graphNode.neighbors) {
				if (!inMap.containsKey(node)) {
					inMap.put(node, 1);
				} else {
					inMap.put(node, 1 + inMap.get(node));
				}
			}
		}
		for (DirectedGraphNode graphNode : graph) {
			if(!inMap.containsKey(graphNode)){
				q.offer(graphNode);
			}
		}
		ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
		while (!q.isEmpty()) {
			DirectedGraphNode node = q.poll();
			result.add(node);
			for (DirectedGraphNode n : node.neighbors) {
				inMap.put(n, inMap.get(n) - 1);
				if (inMap.get(n) == 0) {
					q.offer(n);
				}
			}
		}
		return result;
	}
}

class DirectedGraphNode {
	int label;
	ArrayList<DirectedGraphNode> neighbors;

	DirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<DirectedGraphNode>();
	}
	
};
