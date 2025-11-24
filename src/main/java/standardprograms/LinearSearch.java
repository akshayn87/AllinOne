package standardprograms;

public class LinearSearch {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 10, 40 };
		int x = 10;
		int result = search(arr, x);
		System.out.println((result == -1) ? "not" : "yes");
	}

	public static int search(int arr[], int x) {
		int N = arr.length;
		for (int i = 0; i < N; i++) {
			if (arr[i] == x)
				return i;
		}
		return -1;
	}
}
