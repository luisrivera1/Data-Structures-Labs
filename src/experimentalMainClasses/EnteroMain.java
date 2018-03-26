package experimentalMainClasses;

import dataGenerator.DataGenerator;
import sorterClasses.BubbleSortSorter;
import sortersTesterClasses.Entero;

public class EnteroMain {

	public static void main(String[] args) {
		Entero [] array = new Entero [10];
		DataGenerator generator = new DataGenerator(10);
		Integer [] data = generator.generateData();
		for (int i = 0; i < array.length; i++) {
			array[i] = new Entero (data[i]);
			System.out.println(data[i]);
		}

		BubbleSortSorter<Entero> sorter = new BubbleSortSorter<>();
		sorter.sort(array, null);
	}

}
