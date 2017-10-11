package console_version;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Test vrsion of Tic-tac-toe game (console version).
 * 
 * @author Yakov Medvedev
 * @version 1.2
 *
 */
public class TicTacToeGame {
	
	private static int stepCount = 0;
	private static  String cell = "_|";
	private static final String exChar = "X|";
	private static final String zeroChar = "O|";
	
	private static String oneone = cell;
	private static String onetwo = cell;
	private static String onethree = cell;
	private static String twoone = cell;
	private static String twotwo = cell;
	private static String twothree = cell;
	private static String threeone = cell;
	private static String threetwo = cell;
	private static String threethree = cell;
	
	private static boolean EX;
	private static boolean ZERO;
	private static boolean SOMEBODYWIN = false;
	
	private static Set<Integer> stepsEX = new HashSet<Integer>();
	private static Set<Integer> stepsZERO = new HashSet<Integer>();
	
	static void drawField(){
		System.out.println("  1 2 3");
		System.out.println("1 " + oneone + onetwo + onethree);
		System.out.println("2 " + twoone + twotwo + twothree);
		System.out.println("3 " + threeone + threetwo + threethree);
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("Правило ввода координат ячейки:");
		System.out.println("ПЕРВАЯ цифра - номер строки по ВЕРТИКАЛИ");
		System.out.println("ВТОРАЯ цифра - номер строки по ГОРИЗОНТАЛИ\n");
		System.out.println("Нажмите 1, если первыми ходят КРЕСТИКИ или\nНажмите 2, если первыми ходят НОЛИКИ\n");
		
// Блок выбора игры крестиками или ноликами **************************** 		
		Scanner scaner = new Scanner(System.in);
		int chooseChar = 0;
		while (chooseChar != 1 && chooseChar != 2) {		
			chooseChar = scaner.nextInt();
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
//**********************************************************************
		
		while (!SOMEBODYWIN) { 
			stepCount++;
			drawField();
			System.out.print("Введите координаты - ");
			final int input = scaner.nextInt();
			switch(input){
			case 11: oneone = EX ? exChar : zeroChar;
				  boolean x = EX ? stepsEX.add(input) : stepsZERO.add(input);
				  break;
			case 12: onetwo = EX ? exChar : zeroChar;
			      boolean y = EX ? stepsEX.add(input) : stepsZERO.add(input);
			      break;
			case 13: onethree = EX ? exChar : zeroChar;
				    boolean z = EX ? stepsEX.add(input) : stepsZERO.add(input);
				    break;
			case 21: twoone = EX ? exChar : zeroChar;
		      	  boolean a = EX ? stepsEX.add(input) : stepsZERO.add(input);
		      	  break;
			case 22: twotwo = EX ? exChar : zeroChar;
		      	  boolean b = EX ? stepsEX.add(input) : stepsZERO.add(input);
		      	  break;
			case 23: twothree = EX ? exChar : zeroChar;
		      	    boolean c = EX ? stepsEX.add(input) : stepsZERO.add(input);
		      	    break;
			case 31: threeone = EX ? exChar : zeroChar;
	      	  	    boolean q = EX ? stepsEX.add(input) : stepsZERO.add(input);
	      	  	    break;
			case 32: threetwo = EX ? exChar : zeroChar;
	      	  	    boolean w = EX ? stepsEX.add(input) : stepsZERO.add(input);
	      	  	    break;
			case 33: threethree = EX ? exChar : zeroChar;
	      	  	      boolean e = EX ? stepsEX.add(input) : stepsZERO.add(input);
	      	  	      break;
	      	 default: System.out.println("\nВы ввели неверные координаты. Ход оппонента.");
			}
			
// Блок проверки выигрышных комбинаций *****************************************************************
			if(EX) {
				if(TicTacToeGameComboChecker.check(stepsEX)) {
				System.out.println("\nПобеда КРЕСТИКОВ !!!");
				drawField();
				SOMEBODYWIN = true;
				break;
				}
			} else {
				if(TicTacToeGameComboChecker.check(stepsZERO)){
				System.out.println("\nПобеда НОЛИКОВ !!!");
				drawField();
				SOMEBODYWIN = true;
				break;
				}
			}
//********************************************************************************************************
			if(stepCount>9){
				System.out.println("\nНИЧЬЯ !!!");
				drawField();
				SOMEBODYWIN = true;
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
		}
	}
}
