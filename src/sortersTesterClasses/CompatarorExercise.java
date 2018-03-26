package sortersTesterClasses;

import sorterClasses.BubbleSortSorter;
import java.util.Arrays;

public class CompatarorExercise {
	
	public static void main(String args[]){
Integer [] array = {5, 9, 20, 22, 20, 5, 13, 17, 8, 22, 1, 3, 7, 11, 9, 10};
BubbleSortSorter sorter = new BubbleSortSorter();

System.out.println("The original array is:" + Arrays.toString(array));


sorter.sort(array, new IntegerComparator1());
System.out.println("The array sorted in increasing order:" + Arrays.toString(array));

sorter.sort(array, new IntegerComparator2());
System.out.println("The array sorted in decreasing order:" + Arrays.toString(array));




	}
}
