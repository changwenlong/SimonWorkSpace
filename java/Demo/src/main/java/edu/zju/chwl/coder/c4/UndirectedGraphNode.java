package edu.zju.chwl.coder.c4;

import java.util.ArrayList;

public class UndirectedGraphNode {
    public int label = 0;
    public UndirectedGraphNode left = null;
    public UndirectedGraphNode right = null;
    public ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

    public UndirectedGraphNode(int label) {
        this.label = label;
    }
}
