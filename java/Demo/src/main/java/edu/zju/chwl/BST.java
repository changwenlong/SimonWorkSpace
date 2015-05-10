package edu.zju.chwl;

public class BST {
public boolean deleteBST(Node root,Node f,int key){
		
		if(root==null){
			
			return false;
		}
		else {
			
			if(root.getValue()==key){
				return false;
				
				//return delete(root,f);
			}
			else if(root.getValue()>key){
				
				return deleteBST(root.getLeftChild(),root,key);
			}
			else {
				
				return deleteBST(root.getRightChild(),root,key);
			}
			
		}
	}
    
	public void delete(Node node,Node f){
		
		if(node.getLeftChild()==null&&node.getRightChild()==null){
			
			if(f.getLeftChild()==node){
				
				f.setLeftChild(null);
				
			}
			else 
				f.setRightChild(null);
			
			
			
		}
	}
}
