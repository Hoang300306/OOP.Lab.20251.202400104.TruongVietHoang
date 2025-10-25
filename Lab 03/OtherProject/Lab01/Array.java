import java.util.Scanner;
public class Array {

	static void merge(int arr[], int l, int m, int r){
        
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int arr[], int l, int r){
        
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter array length: ");
		int size = keyboard.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = keyboard.nextInt();
		}
		mergeSort(arr, 0, size -1);
		System.out.print("Sorted array: ");
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println("");
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += arr[i];
		}
		System.out.println("The sum of the array is: " + sum);
		System.out.println("The average value  of the array is: " + (sum/size));
	}
}
