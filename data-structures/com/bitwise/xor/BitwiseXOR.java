package com.bitwise.xor;

import java.util.Arrays;

public class BitwiseXOR {

	public static void main(String[] args) {
		System.out.println("Missing number is: " + findSingleMissingNumber(new int[] { 1, 5, 2, 6, 4 }));
		System.out.println("Missing number from repeating array is: "
				+ findSingleRepeatingMissingNumber(new int[] { 1, 4, 2, 1, 3, 2, 3 }));
		System.out.println("Missing numbers from repeating array are: "
				+ Arrays.toString(findMultipleRepeatingMissingNumber(new int[] { 1, 4, 2, 1, 3, 5, 6, 2, 3, 5 })));
		System.out.println("Complement: " + complement(9));
	}

	private static int findSingleRepeatingMissingNumber(int[] arr) {
		if (arr == null || arr.length < 1) {
			return 0;
		}

		int result = arr[0];
		for (int i = 1; i < arr.length; i++) {
			result = result ^ arr[i];

		}

		return result;
	}

	private static int findSingleMissingNumber(int[] arr) {
		if (arr == null || arr.length < 1) {
			return 0;
		}

		int sumOfAll = 1;
		for (int i = 2; i <= arr.length + 1; i++) {
			sumOfAll = sumOfAll ^ i;
		}

		int sumOfArr = arr[0];
		for (int i = 1; i < arr.length; i++) {
			sumOfArr = sumOfArr ^ arr[i];

		}

		return sumOfAll ^ sumOfArr;
	}

	public static int[] findMultipleRepeatingMissingNumber(int[] arr) {
		int n1xn2 = 0;
		for (int num : arr) {
			n1xn2 = n1xn2 ^ num;
		}

		int rightMostSetBit = 1;
		while ((rightMostSetBit & n1xn2) == 0) {
			rightMostSetBit = rightMostSetBit << 1;
		}

		int num1 = 0, num2 = 0;
		for (int num : arr) {
			if ((num & rightMostSetBit) != 0) {
				num1 = num1 ^ num;
			} else {
				num2 = num2 ^ num;
			}
		}
		return new int[] { num1, num2 };
	}

	public static int complement(int number) {
		int bitCount = 0;
		int n = number;
		while (n > 0) {
			++bitCount;
			n = n >> 1;
		}

		int rightMostSetBit = 1;
		for (int i = 0; i < bitCount; i++) {
			number = number ^ rightMostSetBit;
			rightMostSetBit = rightMostSetBit << 1;
		}
		return number;
	}
}
