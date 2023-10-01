package javaStudy;

public class java {

	
	public static void main(String[] args) {
	
		int[][] array = { {95, 86}, {83, 92, 96}, {78, 83, 93, 87, 88} };
		int sum = 0;
		int count = 0;

		for (int[] array2 : array) {
		    for (int num : array2) {
		        sum += num;
		        count++;
		    }
		}

		double avg = (double) sum / count;

		System.out.println("sum: " + sum);
		System.out.println("avg: " + avg);
	
	
	}

}
