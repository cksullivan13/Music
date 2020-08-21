package com.music;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DisplayMenu {
	
private  PrintWriter out;
private  Scanner in;

public DisplayMenu(InputStream input, OutputStream output) {
	this.out = new PrintWriter(output);
	this.in= new Scanner(input);
}



public Object getChoiceFromOptions(Object[] options) {
	Object choice = null;
	while (choice == null) {
		displayMenuOptions(options);
		choice = getChoiceFromUserInput(options);
	}
	return choice;
}

 void displayMenuOptions(Object[] options) {
	out.println();
	for (int i = 0; i < options.length; i++) {
		int optionNumber = i + 1;
		out.println(optionNumber + ") " + options[i]);
	}
	System.out.println();
	System.out.println("========================");
	out.println("Please choose an option >>> ");
	out.flush();
}

 void displayScalesOptions(Object[] options) {
	out.println();
	for (int i = 0; i < options.length; i++) {
		int optionNumber = i + 1;
		out.println(optionNumber + ") " + options[i]);
	}
	System.out.println();
	
	out.flush();
}



private Object getChoiceFromUserInput(Object[] options) {
	Object choice = null;
	String userInput = in.nextLine();
	try {
		int selectedOption = Integer.parseInt(userInput);
		if (selectedOption > 0 && selectedOption <= options.length) {
			choice = options[selectedOption - 1];
		}
	} catch (NumberFormatException nfe) {
		System.out.println("You must enter a number");
	} catch (NoSuchElementException nse) {
		System.out.println("That number doesn't exist");
	}
	return choice;
}

}
