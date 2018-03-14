package AnatoliyAssignment;

import java.util.ArrayList;

public class ArrayList1 {

	public static void removeNumber(int command2, ArrayList<Integer> s1) {
		for(int i = 0; i < s1.size(); i++)
			if(s1.get(i) == command2)
			{
				s1.remove(i);
				removeNumber(command2, s1);
			}
		
	}

}
