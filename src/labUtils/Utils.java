package labUtils;

import treeClasses.LinkedBinaryTree;
import treeClasses.LinkedTree;
import treeInterfaces.Position;
import treeInterfaces.Tree;

public class Utils {
	public static <E> void displayTree(String msg, Tree<E> t) { 
		System.out.println("\n\n" + msg); 
		t.display(); 
	}

	public static <E> void displayTreeElements(String msg, Tree<E> t) {
		System.out.println("\n\n" + msg); 
		for (E element : t)
			System.out.println(element); 

	}

	public static LinkedTree<Integer> buildExampleTreeAsLinkedTree() { 
		LinkedTree<Integer> t = new LinkedTree<>();
		
		Position<Integer> r = t.addRoot(4);
		Position<Integer> ch9 = t.addChild(r, 9);

		t.addChild(ch9, 7);
		t.addChild(ch9, 10);

		Position<Integer> ch20 = t.addChild(r, 20);
		Position<Integer> ch15 = t.addChild(ch20, 15);

		t.addChild(ch15, 12);

		Position<Integer> ch17 = t.addChild(ch15, 17);
		t.addChild(ch17, 19);

		Position<Integer> ch21 = t.addChild(ch20, 21);
		Position<Integer> ch40 = t.addChild(ch21, 40);

		t.addChild(ch40, 30);
		t.addChild(ch40, 45);

		return t; 
	}

	public static LinkedBinaryTree<Integer> buildExampleTreeAsLinkedBinaryTree() {
		
		LinkedBinaryTree<Integer> t = new LinkedBinaryTree<>(); 

		Position<Integer> r = t.addRoot(4);
		Position<Integer> ch9 = t.addLeft(r, 9);

		t.addLeft(ch9, 7);
		t.addRight(ch9, 10);

		Position<Integer> ch20 = t.addRight(r, 20);
		Position<Integer> ch15 = t.addLeft(ch20, 15);

		t.addLeft(ch15, 12);

		Position<Integer> ch17 = t.addRight(ch15, 17);

		t.addLeft(ch17, 19);

		Position<Integer> ch21 = t.addRight(ch20, 21);
		Position<Integer> ch40 = t.addRight(ch21, 40);

		t.addLeft(ch40, 30);
		t.addRight(ch40, 45);

		return t;  
	}


}