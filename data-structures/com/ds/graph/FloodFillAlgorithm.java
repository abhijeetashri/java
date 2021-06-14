package com.ds.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class FloodFillAlgorithm {

	private static final char[][] PAINT_SHEET = { //
			"YYYGGGGGGG".toCharArray(), //
			"YYYYYYGXXX".toCharArray(), //
			"GGGGGGGXXX".toCharArray(), //
			"WWWWWGGGGX".toCharArray(), //
			"WRRRRRGXXX".toCharArray(), //
			"WWWRRGGXXX".toCharArray(), //
			"WBWRRRRRRX".toCharArray(), //
			"WBBBBRRXXX".toCharArray(), //
			"WBBXBBBBXX".toCharArray(), //
			"WBBXXXXXXX".toCharArray() //
	};

	private static final int[] NEIGHBORS_ROW = { -1, -1, -1, 0, 0, 1, 1, 1 };
	private static final int[] NEIGHBORS_COLUMN = { -1, 0, 1, -1, 1, -1, 0, 1 };
	private static char TARGET_COLOR;

	public static void main(String[] args) {
		int targetRowIndex = 3;
		int targetColIndex = 9;
		char replacementColor = 'C';
		TARGET_COLOR = PAINT_SHEET[targetRowIndex][targetColIndex];
		floodFill(targetRowIndex, targetColIndex, replacementColor);
	}

	private static void floodFill(int targetRowIndex, int targetColIndex, char replacementColor) {
		Pixel pixel = new Pixel(targetRowIndex, targetColIndex);
		Queue<Pixel> queue = new ArrayDeque<>();
		queue.add(pixel);

		while (!queue.isEmpty()) {
			Pixel node = queue.poll();
			targetRowIndex = node.x;
			targetColIndex = node.y;
			PAINT_SHEET[targetRowIndex][targetColIndex] = replacementColor;

			for (int i = 0; i < NEIGHBORS_ROW.length; i++) {
				if (isValid(targetRowIndex + NEIGHBORS_ROW[i], targetColIndex + NEIGHBORS_COLUMN[i])) {
					pixel = new Pixel(targetRowIndex + NEIGHBORS_ROW[i], targetColIndex + NEIGHBORS_COLUMN[i]);
					queue.add(pixel);
				}
			}
		}

		for (var paintRow : PAINT_SHEET) {
			System.out.println(Arrays.toString(paintRow));
		}
	}

	private static boolean isValid(int row, int column) {
		return row >= 0 && column >= 0 && row < PAINT_SHEET.length && column < PAINT_SHEET[0].length
				&& PAINT_SHEET[row][column] == TARGET_COLOR;
	}

	private static class Pixel {
		int x;
		int y;

		public Pixel(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
