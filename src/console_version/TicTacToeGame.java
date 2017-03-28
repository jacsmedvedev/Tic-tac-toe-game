package console_version;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Test vrsion of Tic-tac-toe game (console version).
 * 
 * @author Yakov Medvedev
 * @version 1.0
 *
 */
public class TicTacToeGame {
	
	private static int stepCount = 0;
	private static final String exChar = "X|";
	private static final String zeroChar = "O|";
	
	private static final String TOP_1 = "  1";
	private static final String TOP_2 = " 2";
	private static final String TOP_3 = " 3";
	private static final String SIDE_1 = "1 ";
	private static final String SIDE_2 = "2 ";
	private static final String SIDE_3 = "3 ";
	
	private static String oneone = "_|";
	private static String onetwo = "_|";
	private static String onethree = "_|";
	private static String twoone = "_|";
	private static String twotwo = "_|";
	private static String twothree = "_|";
	private static String threeone = "_|";
	private static String threetwo = "_|";
	private static String threethree = "_|";
	
	private static boolean EX;
	private static boolean ZERO;
	private static boolean SOMEBODYWIN = false;
	
	private static List<Integer> stepsEX = new ArrayList<Integer>();
	private static List<Integer> stepsZERO = new ArrayList<Integer>();
	
	static void drawField(){
		System.out.println(TOP_1 + TOP_2 + TOP_3);
		System.out.println(SIDE_1 + oneone + onetwo + onethree);
		System.out.println(SIDE_2 + twoone + twotwo + twothree);
		System.out.println(SIDE_3 + threeone + threetwo + threethree);
		System.out.println("");
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int chooseChar = 0;
		while (chooseChar != 1 && chooseChar != 2) {
			System.out.println("Нажмите 1, если первыми ходят КРЕСТИКИ или\nНажмите 2, если первыми ходят НОЛИКИ\n");
			chooseChar = s.nextInt();
			if (chooseChar == 1) {
				EX = true;
				ZERO = false;
			} else if (chooseChar == 2) {
				EX = false;
				ZERO = true;
			} else {
				System.out.println("Невалидный ввод. Попробуйте еще раз.");
			}
		}
		
		while (!SOMEBODYWIN) { 
			stepCount++;
			drawField();
			System.out.print("Введите координаты - ");
			int input = s.nextInt();
			if (input == 11) {
				if (EX){
					oneone = exChar;
					stepsEX.add(input);
				} else {
					oneone = zeroChar;
					stepsZERO.add(input);
				}	
			}
			if (input == 12) {
				if (EX){
					onetwo = exChar;
					stepsEX.add(input);
				} else {
					onetwo = zeroChar;
					stepsZERO.add(input);
				}
			}
			if (input == 13) {
				if (EX){
					onethree = exChar;
					stepsEX.add(input);
				} else {
					onethree = zeroChar;
					stepsZERO.add(input);
				}
			}
			if (input == 21) {
				if (EX){
					twoone = exChar;
					stepsEX.add(input);
				} else {
					twoone = zeroChar;
					stepsZERO.add(input);
				}
			}
			if (input == 22) {
				if (EX){
					twotwo = exChar;
					stepsEX.add(input);
				} else {
					twotwo = zeroChar;
					stepsZERO.add(input);
				}
			}
			if (input == 23) {
				if (EX){
					twothree = exChar;
					stepsEX.add(input);
				} else {
					twothree = zeroChar;
					stepsZERO.add(input);
				}
			}
			if (input == 31) {
				if (EX){
					threeone = exChar;
					stepsEX.add(input);
				} else {
					threeone = zeroChar;
					stepsZERO.add(input);
				}
			}
			if (input == 32) {
				if (EX){
					threetwo = exChar;
					stepsEX.add(input);
				} else {
					threetwo = zeroChar;
					stepsZERO.add(input);
				}
			}
			if (input == 33) {
				if (EX){
					threethree = exChar;
					stepsEX.add(input);
				} else {
					threethree = zeroChar;
					stepsZERO.add(input);
				}
			} 
			if (input != 11 && input != 12 && input != 13 &&
				input != 21 && input != 22 && input != 23 &&
				input != 31 && input != 32 && input != 33) {
				System.out.println("\nВы ввели неверные координаты. Ход оппонента.");
			}
			if(EX && !ZERO){
				EX = false;
				ZERO =true;
				System.out.println("\nХод НОЛИКОВ\n");
			} else {
				EX = true;
				ZERO = false;
				System.out.println("\nХод КРЕСТИКОВ\n");
			}
			if((stepsZERO.contains(11) && stepsZERO.contains(12) && stepsZERO.contains(13)) || 
			   (stepsZERO.contains(21) && stepsZERO.contains(22) && stepsZERO.contains(23)) ||
			   (stepsZERO.contains(31) && stepsZERO.contains(32) && stepsZERO.contains(33)) ||
			   (stepsZERO.contains(11) && stepsZERO.contains(22) && stepsZERO.contains(33)) ||
			   (stepsZERO.contains(31) && stepsZERO.contains(22) && stepsZERO.contains(13))){
				System.out.println("\nПобеда НОЛИКОВ !!!");
				drawField();
				SOMEBODYWIN = true;
			}
			if ((stepsEX.contains(11) && stepsEX.contains(12) && stepsEX.contains(13))
					|| (stepsEX.contains(21) && stepsEX.contains(22) && stepsEX.contains(23))
					|| (stepsEX.contains(31) && stepsEX.contains(32) && stepsEX.contains(33))
					|| (stepsEX.contains(11) && stepsEX.contains(22) && stepsEX.contains(33))
					|| (stepsEX.contains(31) && stepsEX.contains(22) && stepsEX.contains(13))) {
				System.out.println("\nПобеда КРЕСТИКОВ !!!");
				drawField();
				SOMEBODYWIN = true;
			}
			if(stepCount>9){
				System.out.println("\nНИЧЬЯ !!!");
				drawField();
				SOMEBODYWIN = true;
			}
		}
	}
}
