package edu.zju.chwl.lintcode.graphsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http://www.lintcode.com/en/problem/clone-graph/
 * https://leetcode.com/problems/clone-graph/
 * 
 * DFS + HashMap
 * 
 * @author chwl
 * @Date 2016年3月8日 下午10:13:16
 */
public class CloneGraph {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		return clone(node, new HashMap<Integer, UndirectedGraphNode>());
	}

	public UndirectedGraphNode clone(UndirectedGraphNode node,
			Map<Integer, UndirectedGraphNode> map) {
		if (map.containsKey(node.label)) {
			return map.get(node.label);
		}
		UndirectedGraphNode p = new UndirectedGraphNode(node.label);
		map.put(node.label, p);
		for (UndirectedGraphNode n : node.neighbors) {
			p.neighbors.add(clone(n, map));
		}
		return p;
	}
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};
