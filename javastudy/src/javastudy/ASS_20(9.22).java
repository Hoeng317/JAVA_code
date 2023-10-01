package javaStudy;

public class java {

	
	public static void main(String[] args) {
	
		int[][] a = {
			    {5, 10, 2, 7, 5},
			    {4, 6, 2, 2, 9},
			    {1, 9, 2, 8, 4}
			};

		int[][] b = {
			    {5, 2, 7, 4, 5},
			    {10, 6, 9, 2, 3},
			    {2, 6, 4, 7, 1}
			};

		int[][] c = new int[3][5];

			for (int i = 0; i < 3; i++) {
			    for (int j = 0; j < 5; j++) {
			        c[i][j] = Math.max(a[i][j], b[i][j]);
			    }
			}

			// 출력
			for (int i = 0; i < 3; i++) {
			    for (int j = 0; j < 5; j++) {
			        System.out.print(c[i][j] + " ");
			    }
			    System.out.println();
			}

	
	}

}
