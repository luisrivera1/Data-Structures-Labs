package testerClasses;

import labUtils.Utils;
import treeClasses.LinkedTree;
import treeInterfaces.Position;

public class TreeTester7 {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		LinkedTree<String> t = new LinkedTree<>();
		LinkedTree<String> tclone;
		Position<String> p = t.addRoot("ROOT");
		
		t.addChild(p, "Ivan"); 
		p = t.addChild(p, "Javier");
		
		Position<String> p1 = t.addChild(p, "Gaby"); 
		
		p1 = t.addChild(p1, "Karla"); 
		t.addChild(p1, "Pedro R"); 
		
		p1 = t.addChild(p1, "Carlos"); 
		p1=t.addChild(p1, "Elvin"); 
		
		t.addChild(p1, "Dariel"); 
		t.addChild(p1, "Axel"); 
		
		p1 = t.addChild(p, "Manuel"); 
		
		t.addChild(p, "Georgie");
		t.addChild(p1, "Cristian"); 
		t.addChild(p1, "Natalia"); 
		t.addChild(p1, "Claudia"); 
		
		p1 = t.addChild(t.root(), "Andres");
		p = p1; 
		p1 = t.addChild(p1, "Lupita"); 
		p1 = t.addChild(p1, "Luis"); 
		p1 = t.addChild(p1, "Gabriela"); 
		t.addChild(p, "Michael");
		
		
		
		Utils.displayTree("Original t", t); 
		tclone = t.clone();
		Utils.displayTree("Clone of t", tclone); 

	}
}