package edu.zju.chwl.offer.add;

import edu.zju.chwl.offer.datastructure.TreeLinkNode;

/**
 * 二叉树的下一个节点
 * @author chwl
 * @Date 2016年4月17日 下午9:39:23
 */
public class GetNext {

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null){
        	return null;
        }
        if(pNode.right!=null){
        	TreeLinkNode node = pNode.right;
        	while(node.left!=null){
        		node = node.left;
        	}
        	return node;
        }else{
        	TreeLinkNode parent = pNode.next;
        	TreeLinkNode node = pNode;
        	while(parent!=null&&parent.right==node){
        		node=node.next;
        		parent=parent.next;
        	}
        	return parent;
        }
    }
}
