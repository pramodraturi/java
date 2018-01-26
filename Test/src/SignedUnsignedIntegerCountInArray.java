import java.util.HashMap;
import java.util.Map;

public class SignedUnsignedIntegerCountInArray {
	public static void main(String args[]) {
		int intArray[] = { 9, 1, 0, 54, -22, 22, 34, 56, 76 };

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int item : intArray) {
			Integer value = map.put(Math.abs(item), Math.abs(item));
			if (value != null && value == Math.abs(item)) {
				System.out.println("Duplicate Item:" + Math.abs(item));
				break;
			}
		}
	}
}
