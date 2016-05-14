package edu.zju.chwl.coder.c4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Path {
    public boolean checkPath1(UndirectedGraphNode a, UndirectedGraphNode b) {
        return bfs(a,b)||bfs(b,a);
    }

	private boolean bfs(UndirectedGraphNode a, UndirectedGraphNode b) {
		if(a==null||b==null){
			return false;
		}
		if(a==b){
			return true;
		}
		Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		Map<UndirectedGraphNode, Boolean> checkedMap = new HashMap<UndirectedGraphNode, Boolean>();
		q.offer(a);
		checkedMap.put(a, true);
		while(!q.isEmpty()){
			UndirectedGraphNode node = q.poll();
			for(UndirectedGraphNode neighbor:node.neighbors){
				if(neighbor==b) return true;
				if(checkedMap.get(neighbor)==null){
					q.offer(neighbor);
					checkedMap.put(neighbor, true);
				}
			}
		}
		return false;
	}       
}
