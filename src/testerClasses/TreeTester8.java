package testerClasses;

import labUtils.Utils;
import treeClasses.LinkedBinaryTree;

public class TreeTester8 {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		LinkedBinaryTree<Integer> t = Utils.buildExampleTreeAsLinkedBinaryTree(), 
				clt = Utils.buildExampleTreeAsLinkedBinaryTree(); 

		Utils.displayTree("Original t", t); 
		clt = t.clone();
		Utils.displayTree("Clone of t", clt); 
		
	}

}