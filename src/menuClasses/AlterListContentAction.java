package menuClasses;

import dataManager.DMComponent;

public class AlterListContentAction implements Action {
	public void execute(Object arg) {
		DMComponent dm = (DMComponent) arg; 
		dm.getMenuStack().push(AlterListContentMenu.getAlterListsMenu()); 
	}
	
	
	}

