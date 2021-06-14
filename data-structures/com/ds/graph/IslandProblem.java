package com.ds.graph;

public class IslandProblem {
	private static final int[][] ISLAND_MATRIX = { //
			{ 1, 1, 0, 0, 0 }, //
			{ 0, 1, 0, 0, 1 }, //
			{ 1, 0, 0, 1, 1 }, //
			{ 0, 0, 0, 0, 0 }, //
			{ 1, 0, 1, 0, 1 } //
	};

	private static final int[] ROW = { -1, -1, -1, 0, 0, 1, 1, 1 };
	private static final int[] COLUMN = { -1, 0, 1, -1, 1, -1, 0, 1 };
	private static int MATRIX_ROW = ISLAND_MATRIX.length;
	private static int MATRIX_COL = (MATRIX_ROW > 0) ? ISLAND_MATRIX[0].length : 0;

	public static void main(String[] args) {
		System.out.println("Total islands found: " + findIslandCount(ISLAND_MATRIX));
	}

	private static int findIslandCount(int[][] matrix) {
		int islandCount = 0;
		if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
			boolean[][] visited = new boolean[matrix.length][matrix[0].length];

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					if (matrix[i][j] == 1 && !visited[i][j]) {
						countIslands(matrix, i, j, visited);
						++islandCount;
					}
				}
			}
		}

		return islandCount;
	}

	private static void countIslands(int[][] matrix, int row, int col, boolean[][] visited) {
		visited[row][col] = true;

		for (int i = 0; i < ROW.length; i++) {
			// Visit neighbors
			if (isInRange(row + ROW[i], col + COLUMN[i], visited)) {
				countIslands(matrix, row + ROW[i], col + COLUMN[i], visited);
			}
		}
	}

	private static boolean isInRange(int row, int col, boolean[][] visited) {
		return row >= 0 && col >= 0 && row < MATRIX_ROW && col < MATRIX_COL && ISLAND_MATRIX[row][col] == 1
				&& !visited[row][col];
	}
}
