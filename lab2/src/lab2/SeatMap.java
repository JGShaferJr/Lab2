package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SeatMap {

	String[][] seats = new String[6][6];

	SeatMap() {
	}

	void userInput() {
		String line;
		String[] lineVector;
		Scanner reader = new Scanner(System.in);
		int x = 1, y = 0;

		while (x != 0) {
			System.out.println("Choose a seat in the format row,column (e.g. 4,2), or 0 to quit.");

			line = reader.nextLine(); // read coordinate input

			lineVector = line.split(",");
			x = Integer.parseInt(lineVector[0]); // parsing the values to Integer
			if (x == 0)
				break;
			y = Integer.parseInt(lineVector[1]);

			if (x == 5 && y >= 0 && y <=5)
				System.out.println("This seat is empty.");
			else if ((x > 5 || x < 0) || (y > 5 || y < 0))
				System.out.println("This seat does not exist.");
			else
				System.out.println("The person in seat " + x + "," + y + " is " + seats[x][y] + "\n");
		}
	}

	void getNames() {
		String line;
		int row = 0, column = -1;

		File input = new File("src/lab2/names.dat");
		Scanner inputFile = null;

		try {
			inputFile = new Scanner(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (inputFile.hasNext()) {

			line = inputFile.nextLine();

			if (column == 5) {
				row++;
				column = 0;
			} else {
				column++;
			}

			seats[row][column] = line;
		}
	}
}
