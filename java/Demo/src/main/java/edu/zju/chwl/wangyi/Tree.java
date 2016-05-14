package edu.zju.chwl.wangyi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

/**
 * http://www.nowcoder.com/question/next?pid=1429468&qid=44579&tid=2876312
 * 
 * 找到两个叶节点的最近公共祖先
 * @author chwl
 * @Date 2016年3月30日 上午1:31:13
 */
public class Tree {
	
	public int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
	
    public int getDis(TreeNode root) {
    	HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        helper(root,map);
        root.left=null;
        List<Integer> path1=getPath(min,map,new ArrayList<Integer>());
        List<Integer> path2=getPath(max,map,new ArrayList<Integer>());
        int len1 = path1.size();
		int len2 = path2.size();
        int result=0;
        for(int i=len1-1,j=len2-1;i>=0&&j>=0;i--,j--){
        	if(path1.get(i)==path2.get(j)){
        		result=i+j;
        	}
        }
        return result;
    }
    
    public int getDis1(TreeNode root) {
    	/*paths.get(0)用来存放从根结点到最大叶节点的路径
    	paths.get(1)用来存放从根结点到最大叶节点的路径*/
    	List<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
    	paths.add(new ArrayList<Integer>());
    	paths.add(new ArrayList<Integer>());
        paths(root,paths,new ArrayList<Integer>());
        ArrayList<Integer> maxPath = paths.get(0);
		int len1 = maxPath.size();
		ArrayList<Integer> minPath = paths.get(1);
		int len2 = minPath.size();
        int result=0;
        for(int i=0;i<len1&&i<len2;i++){
        	if(maxPath.get(i)!=minPath.get(i)){
        		break;
        	}
        	result=len1+len2-2*(i+1);
        }
        return result;
    }
    
    /**
     * 求二叉树中从根节点到最大、最小叶节点的路径
     * @param root
     * @param paths 保存从根节点到最大、最小叶节点的路径
     * @param list
     */
	private void paths(TreeNode root, List<ArrayList<Integer>> paths,ArrayList<Integer> list) {
		if(root==null){
			return;
		}
		int value = root.val;
		list.add(value);
		if(root.left==null&&root.right==null){
			ArrayList<Integer> maxPath = paths.get(0);
			if(maxPath.isEmpty()||value>maxPath.get(maxPath.size()-1)){
				paths.set(0,new ArrayList<Integer>(list));
			}
			ArrayList<Integer> minPath = paths.get(1);
			if(minPath.isEmpty()||value<minPath.get(minPath.size()-1)){
				paths.set(1,new ArrayList<Integer>(list));
			}
		}else{
			paths(root.left,paths,list);
			paths(root.right,paths,list);
		}
		list.remove(list.size()-1);
	}

	private List<Integer> getPath(int i,Map<Integer,Integer> map,List<Integer> list) {
    	while(map.containsKey(i)){
    		list.add(i);
			i=map.get(i);
		}
		list.add(i);
		return list;
	}

	public void helper(TreeNode root,Map<Integer,Integer> map){
		if(root==null){
			return;
		}
    	if(root.left==null&&root.right==null){
    		int value = root.val;
    		min = min<value?min:value;
    		max = max>value?max:value;
    	}
    	if(root.left!=null){
    		map.put(root.left.val, root.val);
    		helper(root.left,map);
    	}
    	if(root.right!=null){
    		map.put(root.right.val, root.val);
    		helper(root.right,map);
    	}
    }
	
	@Test
	public void test(){
		TreeNode root = new TreeNode(13);
		root.left=new TreeNode(8);
		root.left.left=new TreeNode(9);
		root.left.left.left=new TreeNode(7);
		root.left.left.right=new TreeNode(11);
		root.left.right=new TreeNode(6);
		root.left.right.left=new TreeNode(10);
		root.left.right.right=new TreeNode(14);
		root.right=new TreeNode(12);
		root.right.left=new TreeNode(4);
		root.right.left.left=new TreeNode(2);
		root.right.left.right=new TreeNode(5);
		root.right.right=new TreeNode(3);
		root.right.right.left=new TreeNode(1);
		Assert.assertEquals(6,getDis1(root));;
	}
}


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
