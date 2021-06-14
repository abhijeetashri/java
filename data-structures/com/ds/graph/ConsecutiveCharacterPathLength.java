package com.ds.graph;

public class ConsecutiveCharacterPathLength {

	private static final char[][] CHAR_MATRIX = { //
			{ 'D', 'E', 'H', 'X', 'B' }, //
			{ 'A', 'O', 'G', 'P', 'E' }, //
			{ 'D', 'D', 'C', 'F', 'D' }, //
			{ 'E', 'B', 'E', 'A', 'S' }, //
			{ 'C', 'D', 'Y', 'E', 'N' } //
	};

	private static final int MATRIX_ROW_LENGTH = (CHAR_MATRIX == null) ? 0 : CHAR_MATRIX.length;
	private static final int MATRIX_COL_LENGTH = (MATRIX_ROW_LENGTH > 0) ? CHAR_MATRIX[0].length : 0;
	private static final int[] NEIGHBOR_ROW = { -1, -1, -1, 0, 0, 1, 1, 1 };
	private static final int[] NEIGHBOR_COLUMN = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) {
		System.out.println(findMaxLength(CHAR_MATRIX, 'C'));
	}

	private static int findMaxLength(char[][] charMatrix, char startingChar) {
		int maxLength = 0;
		if (charMatrix != null && MATRIX_ROW_LENGTH > 0 && MATRIX_COL_LENGTH > 0) {
			for (int i = 0; i < charMatrix.length; i++) {
				for (int j = 0; j < charMatrix[i].length; j++) {
					if (charMatrix[i][j] == startingChar) {
						for (int k = 0; k < NEIGHBOR_ROW.length; k++) {
							int pathLength = findPathLength(charMatrix, i + NEIGHBOR_ROW[k], j + NEIGHBOR_COLUMN[k],
									startingChar);
							maxLength = Math.max(maxLength, pathLength + 1);
						}
					}
				}
			}
		}
		return maxLength;
	}

	private static int findPathLength(char[][] charMatrix, int row, int col, char prev) {
		if (!isInRange(row, col) || prev + 1 != charMatrix[row][col]) {
			return 0;
		}

		int maxLength = 0;

		for (int i = 0; i < NEIGHBOR_ROW.length; i++) {
			int len = findPathLength(charMatrix, row + NEIGHBOR_ROW[i], col + NEIGHBOR_COLUMN[i], charMatrix[row][col]);
			maxLength = Math.max(maxLength, len + 1);
		}
		return maxLength;
	}

	private static boolean isInRange(int row, int col) {
		return row >= 0 && col >= 0 && row < MATRIX_ROW_LENGTH && col < MATRIX_COL_LENGTH;
	}
}
