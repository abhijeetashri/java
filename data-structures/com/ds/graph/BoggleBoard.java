package com.ds.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BoggleBoard {

	private static final char[][] BOGGLE_BOARD = { //
			{ 'M', 'S', 'E', 'F' }, //
			{ 'R', 'A', 'T', 'D' }, //
			{ 'L', 'O', 'N', 'E' }, //
			{ 'K', 'A', 'F', 'B' } //
	};

	private static final int BOARD_ROWS = BOGGLE_BOARD.length;
	private static final int BOARD_COLS = (BOARD_ROWS > 0) ? BOGGLE_BOARD[0].length : 0;
	private static final List<String> VALID_WORDS = Arrays.asList("START", "NOTE", "SAND", "STONED");

	private static final int[] NEIGHBORS_ROW = { -1, -1, -1, 0, 0, 1, 1, 1 };
	private static final int[] NEIGHBORS_COLUMN = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) {
		findWords(BOGGLE_BOARD);
	}

	private static void findWords(char[][] boggleBoard) {
		Set<String> words = new HashSet<>();
		boolean[][] visited = new boolean[BOARD_ROWS][BOARD_COLS];

		for (int i = 0; i < boggleBoard.length; i++) {
			for (int j = 0; j < boggleBoard[i].length; j++) {
				scanBoggle(boggleBoard, i, j, visited, words, "");
			}
		}

		System.out.println(words.parallelStream().filter(w -> VALID_WORDS.contains(w)).collect(Collectors.toSet()));
	}

	private static void scanBoggle(char[][] boggleBoard, int row, int col, boolean[][] visited, Set<String> words,
			String path) {
		visited[row][col] = true;
		path += boggleBoard[row][col];
		words.add(path);

		for (int i = 0; i < NEIGHBORS_ROW.length; i++) {
			if (isInRange(row + NEIGHBORS_ROW[i], col + NEIGHBORS_COLUMN[i], visited))
				scanBoggle(boggleBoard, row + NEIGHBORS_ROW[i], col + NEIGHBORS_COLUMN[i], visited, words, path);
		}

		visited[row][col] = false;
	}

	private static boolean isInRange(int row, int col, boolean[][] visited) {
		return row >= 0 && col >= 0 && row < BOARD_ROWS && col < BOARD_COLS && !visited[row][col];
	}
}
