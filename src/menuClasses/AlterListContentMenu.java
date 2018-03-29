package menuClasses;

import java.util.ArrayList;

import ioManagementClasses.IOComponent;

public class AlterListContentMenu extends Menu {
	 
	private static AlterListContentMenu ALC = new AlterListContentMenu();
	private AlterListContentMenu() { 
		super(); 
		String title; 
		ArrayList<Option> options = new ArrayList<Option>();  
		title = "Operate on Lists"; 
		
		
		options.add(new Option("Add a New Value to a List", new AddToListAction())); 
		options.add(new Option("Delete Position from a List", new DeleteFromListAction()));
		options.add(new Option("Show Content of a List", new ShowListAction())); 
		options.add(Option.EXIT); 

		super.InitializeMenu(title, options); 

	}
	
	
	public static AlterListContentMenu getAlterListsMenu() { 
		return ALC; 
	}



}
