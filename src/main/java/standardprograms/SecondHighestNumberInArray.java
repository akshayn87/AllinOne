package standardprograms;

	public class SecondHighestNumberInArray {
		public static void main(String[] args) {
			int arr[] = { 100, 14, 46, 47, 94, 96, 52, 86, 36, 98, 89,0,-100,-50 };
			int largest = 0;
			int secondLargest = 0;
			int thirdLargest =0;
			int smallest=0;
			int secondsmallest=0;
			int thirdsmallest=0;
			System.out.println("The given array is:");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + "\t");
			}
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > largest) {
					secondLargest = largest;
					largest = arr[i];
				} else if (arr[i] > secondLargest) {
					thirdLargest=secondLargest;
					secondLargest = arr[i];
				}else if (arr[i]>thirdLargest) {
					thirdLargest =arr[i];
				}
			}
			smallest =Integer.MAX_VALUE;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] < smallest) {
					secondsmallest = smallest;
					smallest = arr[i];
				}
					else if (arr[i] < secondsmallest) {
					thirdsmallest=secondsmallest;
					secondsmallest = arr[i];
				}else if (arr[i]<thirdsmallest) {
					thirdsmallest =arr[i];
				}
			}
			
			System.out.println("\nThird largest number is:" + thirdLargest);
			System.out.println("Second largest number is:" + secondLargest);
			System.out.println("Largest Number is: " + largest);
			System.out.println("Smallest Number is: " + smallest);
			System.out.println("Second Smallest Number is: " + secondsmallest);
			System.out.println("Third Smallest Number is: " + thirdsmallest);
		}
	
}
