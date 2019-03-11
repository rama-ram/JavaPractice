package com.practice.cmp.ntnx;

public class Print2DMatrixSpirally {
	/*
	 * Input: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 Output: 1 2 3 4 8 12 16 15
	 * 14 13 9 5 6 7 11 10
	 * 
	 * 
	 * Input: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 Output: 1 2 3 4 5 6
	 * 12 18 17 16 15 14 13 7 8 9 10 11
	 */

	static void printArr2DSpiarally(int[][] arr, int row, int col) {
		for (int i = 0; i < row - i; i++) {
			for (int j = i; j < col - i; j++) {
				// horizontal left to right
				System.out.print(arr[i][j] + " ");

				// top to down
				if (j == (col - i - 1)) {
					int tdown = i + 1;
					while (tdown <= row - 1 - i) {
						System.out.print(arr[tdown][j] + " ");
						tdown++;
					}
					// horizontal right to left
					int rightleft = (col - 2 - i);
					while (rightleft >= i && i < row - i - 1) {
						System.out.print(arr[row - i - 1][rightleft] + " ");
						rightleft--;
					}
					// vertial down to top
					int downtop = row - 2 - i;
					while (downtop >= i + 1) {
						System.out.print(arr[downtop][i] + " ");
						downtop--;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int R = 3;
		int C = 6;
		int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
		printArr2DSpiarally(a, R, C);
	}

}
