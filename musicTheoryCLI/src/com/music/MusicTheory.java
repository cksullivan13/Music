package com.music;


public class MusicTheory {

	private String[] keyboard = { "C", "C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab", "A", "A#/Bb", "B", "C",
			"C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab", "A", "A#/Bb", "B", "C" };

	public String[] rotateLeft(String[] keyboard, int converted) {
		int i = 0;
		int targetScaleSpot = converted;
		String[] rotated = new String[keyboard.length];

		while (targetScaleSpot < keyboard.length) {
			rotated[i] = keyboard[targetScaleSpot];
			i++;
			targetScaleSpot++;
		}
		targetScaleSpot = 0;
		while (i < keyboard.length) {
			rotated[i] = keyboard[targetScaleSpot];
			i++;
			targetScaleSpot++;
		}
		return rotated;

	}

	public int inputConverter(Object choice) {
		int converted = 0;

		if (choice.equals("C")) {
			converted = 0;
		} else if (choice.equals("Db/C#")) {
			converted = 1;
		} else if (choice.equals("D")) {
			converted = 2;

		} else if (choice.equals("Eb/D#")) {
			converted = 3;

		} else if (choice.equals("E")) {
			converted = 4;

		} else if (choice.equals("F")) {
			converted = 5;

		} else if (choice.equals("F#/Gb")) {
			converted = 6;

		} else if (choice.equals("G")) {
			converted = 7;
			;
		} else if (choice.equals("G#/Ab")) {
			converted = 8;

		} else if (choice.equals("A")) {
			converted = 9;

		} else if (choice.equals("Bb/A#")) {
			converted = 10;

		} else if (choice.equals("B")) {
			converted = 11;

		}
		return converted;
	}

	public String[] makeMajor(String[] rotated) {
		String[] scaleToPrint = new String[8];
		int count = 0;

		for (int i = 0; i < rotated.length; i++) {
			if (i == 0 || i == 2 || i == 4 || i == 5 || i == 7 || i == 9 || i == 11 || i == 12) {
				scaleToPrint[count] = rotated[i];
				count++;

			}
		}
		return scaleToPrint;
	}

	public String[] makeMinor(String[] rotated) {
		String[] minorPrint = new String[8];
		int count = 0;

		for (int i = 0; i < rotated.length; i++) {
			if (i == 0 || i == 2 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
				minorPrint[count] = rotated[i];
				count++;
			}
		}
		return minorPrint;
	}

	public String[] makeHarmonic(String[] rotated) {
		String[] harmoPrint = new String[8];
		int count = 0;

		for (int i = 0; i < rotated.length; i++) {
			if (i == 0 || i == 2 || i == 3 || i == 5 || i == 7 || i == 8 || i == 11 || i == 12) {
				harmoPrint[count] = rotated[i];
				count++;
			}
		}
		return harmoPrint;

	}

	public String[] makePent(String[] rotated) {
		String[] pentPrint = new String[5];
		int count = 0;

		for (int i = 0; i < rotated.length; i++) {
			if (i == 0 || i == 4 || i == 7 || i == 11 || i == 12) {
				pentPrint[count] = rotated[i];
				count++;
			}
		}
		return pentPrint;
	}

	public String[] makeBlues(String[] rotated) {
		String[] bluesPrint = new String[7];
		int count = 0;

		for (int i = 0; i < rotated.length; i++) {
			if (i == 0 || i == 3 || i == 5 || i == 6 || i == 7 || i == 10 || i == 12) {
				bluesPrint[count] = rotated[i];
				count++;
			}
		}
		return bluesPrint;
	}

	public String[] getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(String[] keyboard) {
		this.keyboard = keyboard;
	}

}
