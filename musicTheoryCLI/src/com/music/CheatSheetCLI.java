package com.music;

import java.util.Arrays;
import java.util.Scanner;

public class CheatSheetCLI {

	private static final String MAIN_MENU_GREETING = "MUSIC THEORY FOR BEGINNERS";
	private static final String SCALES_OPTION = "Scales";
	private static final String CIRCLE_OPTION = "Circle Of Fifths";
	private static final String ORDER_SHARPS_OPTION = "Order of Sharps";
	private static final String ORDER_FLATS_OPTION = "Order of Flats";
	private static final String GLOSSARY = "Dictionary of Common Terms";
	private static final String EXIT = "Exit the Application";
	private static final String[] MAIN_MENU_OPTIONS = { SCALES_OPTION, CIRCLE_OPTION, 
			ORDER_SHARPS_OPTION, ORDER_FLATS_OPTION, GLOSSARY, EXIT };
	private static final String CIRCLE_OF_FIFTHS = "C F Bb/A# Eb/D# Ab/G# Db/C# Gb/F# B E A D";
	private static final String ORDER_OF_SHARPS = "Sharps = Father Charles Goes Down And Ends Battle";
	private static final String ORDER_OF_FLATS = "Flats = Battle Ends And Down Goes Charles Father";
	private static final String C = "C"; private static final String Db = "Db/C#"; private static final String D = "D"; private static final String Eb = "Eb/D#";
	private static final String E = "E"; private static final String F = "F"; private static final String fSharp = "F#/Gb"; private static final String G = "G";
	private static final String Ab = "G#/Ab"; private static final String A = "A"; private static final String Bb = "Bb/A#"; private static final String B = "B";
	private static final String GO_BACK = "Go Back To Main Menu";
	private static final String[] SCALE_MENU_OPTIONS = {C, Db, D, Eb, E, F, fSharp, G, Ab, A, Bb, B, GO_BACK};
	private static final String MINOR = "Natural Minor";
	private static final String MIN_BLUES = "Minor Blues";
	private static final String HARM_MIN = "Harmonic Minor";
	private static final String PENT = "Major Pentatonic";
	private static final String[] SCALE_VARIANTS = {MINOR, MIN_BLUES, HARM_MIN, PENT, GO_BACK};
	private static final String CONT = "Press Enter to Continue... ";


	private static DisplayMenu menu;

	public CheatSheetCLI(DisplayMenu menu) {
		CheatSheetCLI.menu = menu;
	}

	public void run(MusicTheory majorScales) throws Exception {
		Scanner userChoice = new Scanner(System.in);
		String input;

		while (true) {
			System.out.println(MAIN_MENU_GREETING);
			input = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			System.out.println();
			if (input.equals(SCALES_OPTION)) {
				while (true) {
					System.out.println("Please pick a root note by selecting a number from 1-12 >>> ");
					System.out.println("=============================================================");
					String rootNote =  (String) menu.getChoiceFromOptions(SCALE_MENU_OPTIONS);
					System.out.println("You have selected " + rootNote +".");
					System.out.println("Here is the major scale >>> ");
					int target = majorScales.inputConverter(rootNote);
					String[] keyboard = majorScales.getKeyboard();
					String[] rotated = majorScales.rotateLeft(keyboard, target);
					System.out.println(Arrays.toString(majorScales.makeMajor(rotated)));
					System.out.println("\n<==Press Enter==>");
					userChoice.nextLine();
					System.out.println("Select major scale variaton if desired >>> ");
					String variant = (String) menu.getChoiceFromOptions(SCALE_VARIANTS);
					if (variant.equals(MINOR)) {
						System.out.println("To make a major scale minor, simply lower the 3rd, 6th and 7th scale tones by a half step");
						System.out.println(rootNote + " natural minor scale is >>> ");
						System.out.println(Arrays.toString(majorScales.makeMinor(rotated)));
						System.out.println();
						System.out.println(CONT);
					} else if (variant.equals(HARM_MIN)) {
						System.out.println("To make a major scale harmonic minor, lower just the 3rd and 6th scale tones by a half step");
						System.out.println(rootNote + " harmonic minor scale is >>> ");
						System.out.println(Arrays.toString(majorScales.makeHarmonic(rotated)));
						System.out.println();
						System.out.println(CONT);
					} else if (variant.equals(MIN_BLUES)) {
						System.out.println("A minor blues scale just takes a minor scale and adds the 4th tone, flat 5th and natural 5th");
						System.out.println(rootNote + " minor blues scale is >>> ");
						System.out.println(Arrays.toString(majorScales.makeBlues(rotated)));
						System.out.println();
						System.out.println(CONT);
					} else if (variant.equals(PENT)) {
						System.out.println("A major pentatonic scale only uses the natural root, 3rd, 5th, and 7th tone");
						System.out.println(rootNote + " major pentatonic is >>> ");
						System.out.println(Arrays.toString(majorScales.makePent(rotated)));
						System.out.println("\nThe pentatonic scale can also be thought of as an arppeggio ");
						System.out.println("Simply lower the 3rd and 7th by a half step to make it minor pentatonic");
						System.out.println();
						System.out.println(CONT);
					}
					userChoice.nextLine();
					if (input.equals(GO_BACK)) {
					menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
					}
					break;
				}
			} else if (input.equals(CIRCLE_OPTION)) {
				System.out.println(CIRCLE_OF_FIFTHS);
				System.out.println();
				
			} else if (input.equals(ORDER_SHARPS_OPTION)) {
				System.out.println(ORDER_OF_SHARPS);
				System.out.println();
				
			} else if (input.equals(ORDER_FLATS_OPTION)) {
				System.out.println(ORDER_OF_FLATS);
				System.out.println();
				
			} else if (input.equals(EXIT)) {
				System.out.println("Have a nice day and don't forget to practice!");
				System.exit(0);
				userChoice.close();
				break;
			} else if (input.equals(GO_BACK)) {
				menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			} else if (input.equals(GLOSSARY)) {
				System.out.println("Here are some commonly used music theory terms and definitions for beginners in western music: ");
				System.out.println();
				System.out.println("tone - [n] a steady sound or audible frequency which is most commonly characterized by its pitch. (ex. \"A\" or \"B\")");
				System.out.println();
				System.out.println("half step - [n] synonymous with semi-tone and it means the smallest movement you can make between two pitches(specifically in Western style music).\nThis equates to the distance between a white key on a piano and its adjacent black key. The distance between B and C, and E and F respectively is also a half step.");
				System.out.println();
				System.out.println("whole step - [n] can also be called a tone and it refers to the equivalent of two half steps(or semi-tones). On a piano this can be visualized \nby the distance between C and D or any two keys that are separated by a single black key.");
				System.out.println();
				System.out.println("enharmonic - [n] a note that can be referred to by two different names such as C# and Db or A# and Bb. How to choose the proper note name is dependent on what key you're playing in. \nBasically every note could be called by a different name but there are a few that aren't commonly used.");
				System.out.println();
				System.out.println("accidental - [n] can mean the literal symbols you see like \'b\'(flat) and \'#\'(sharp), or a note that is not a member of the key or mode being played.");
				System.out.println();
				System.out.println("sharp - [adj - n] a pitch raised by one semi-tone.");
				System.out.println();
				System.out.println("flat - [adj - n] a pitch lowered by one semi-tone.");
				System.out.println();
				System.out.println("natural - [adj - n] a symbol used in sheet music to let the reader know that the pitch immediately after the symbol is to be played with no sharps or flats and lasts until the end of the measure or stated otherwise. \nThe unaltered pitch of a note is natural (ex. CDEFG...).");
				System.out.println();
				System.out.println("chord - [n] more than two notes played simultaneously. A major chord consists of the 1st, 3rd and 5th tone of any scale.");
				System.out.println();
				System.out.println("octave - [n] an interval of 12 semi-tones at which the two notes have the same quality but one is higher and one is lower (ex. (C)DEFGAB(C))");
				System.out.println();
				System.out.println("interval - [n] the difference between two note pitches. They are named according to the number of letter names they span (ex. C to D is a second. C to E is a third and C to F is a fourth, etc.)");
				System.out.println();
				System.out.println("tonic - [n] synonymous with root note and first note of a scale. The tonic of a scale is the name of the given scale in most instances.");
				System.out.println();
				System.out.println("transpose - [v] to shift a piece of music, note, or chord up or down by a certain number of semitones, effectively changing the key for a piece of music.");
				System.out.println();
				System.out.println("key [adj - n] the scale on which a piece of music is based. Each key contains a certain number of flats or sharps that belong to said key. The key of G contains one sharp, which is F#. The key of F contains one flat, which is Bb. \nRefer to the order of flats and sharps to find out the order in which to add them. On staff paper, the accidental symbol farthest right is the last one and can be used to determine the key."
						+ "\nEvery staff line that has an accidental symbol on it intends to show the reader that all notes at the given pitch should be played as either sharp or flat unless noted otherwise. While the G major scale contains GABCDEF#G, the B major scale will contain B, C#, D#, E, F#, G#, A#, B.");
				System.out.println();
				System.out.println("time signature - [adj - n] this can be a complex topic, so to keep it short it specifies how many \'beats\' are contained in each measure, and which note value is equivalent to a beat. \n\'Common time\' in western music is 4/4 and means there are four beats per measure, and quarter notes get one beat(1  2  3  4 = 1 measure in 4/4).");
				System.out.println();
				System.out.println("measure - [n] how a bar on a piece of staff paper is split into sections. Staff lines go horizontal, and measure lines go vertical.");
				System.out.println();
				System.out.println("rhythm - [n] another complex topic, but in a nutshell means the pattern of pulses in music. In common time for instance, you can take a whole note, which lasts the entirety of a measure(4 beats), and split it up into shorter fragments. \nAn 1/8th note can be counted as 1 + 2 + 3 + 4 + for instance. The plus signs are spoken as \"and\". 1/16th notes are spoken as 1 e + a 2 e + a 3 e + a 4 e + a. Rhythm is a complex topic of music theory and can't be covered in only a few sentences. ");
				System.out.println();
				System.out.println("The world of music theory is vast and very old. Many parts of the world have their own rules, note names, time signatures and even pitches. However, western music is popular almost all over the world so these terms listed above are very common. \nThere are many books and websites available to learn more about music theory and you could spend years learning new things on a daily basis. No matter what you know or don't know about playing and making music, the most important thing is how it sounds.");		
				System.out.println();
			} else {
				System.exit(0);
				break;
			}
		
		}

	}

	public static void main(String[] args) {
		DisplayMenu menu = new DisplayMenu(System.in, System.out);
		CheatSheetCLI cli = new CheatSheetCLI(menu);
		MusicTheory majorScales = new MusicTheory();
		try {
			cli.run(majorScales);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
