package console_version;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Jacob Medvedev
 *
 */
public class TicTacToeGameComboChecker {
	
	private static int[] horizont_1 = {11,12,13};
	private static int[] horizont_2 = {21,22,23};
	private static int[] horizont_3 = {31,32,33};
	
	private static int[] vertical_1 = {11,21,31};
	private static int[] vertical_2 = {12,22,32};
	private static int[] vertical_3 = {13,23,33};
	
	private static int[] diagonal_1 = {11,22,33};
	private static int[] diagonal_2 = {13,22,31};
	
	private static int[][] allCombo =  {horizont_1,
										horizont_2,
										horizont_3,
										vertical_1,
										vertical_2,
										vertical_3,
										diagonal_1,
										diagonal_2};
	
	static boolean check(final Set<Integer> moveSet) {
		boolean result = false;
		for (int i = 0; i < allCombo.length; i++) {
			Set<Integer> mySet = Arrays.stream(allCombo[i]).boxed().collect(Collectors.toSet());
			result = moveSet.containsAll(mySet);
			if(result) {
				break;
			}
		}
		return result;
	}
}