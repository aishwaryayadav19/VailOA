import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // read the length of the array
        System.out.print("Enter array length:");
        int len = scanner.nextInt();

        // create arraylist and populate it with elements
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Enter the elements:");
        for (int i=0; i<len; i++) {
            arr.add(scanner.nextInt());
        }
        // print original un-rotated array
        System.out.println("Original Array:" + arr);

        System.out.print("Enter the number of positions to rotate:");
        int n = scanner.nextInt();

        try {
            ArrayList<Integer> newArray = rotateArray(arr, n);
            System.out.println("Rotated Array:" + newArray);
        } catch(Exception e){
            System.out.println("Number of positions to be rotated should be non-negative");
        }
    }

    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Positions to rotate must be non-negative");
        }

        int len = arr.size();
        //if positions to rotate is larger than the length of the array
        n %= len;

        // no need to rotate
        if(n == 0){
            return arr;
        }

        ArrayList<Integer> rotated = new ArrayList<>(n);
        int i = n;
        while (i >= 0 && i != n - 1) {
            rotated.add(arr.get(i));
            i = (i + 1 ) % len;
        }
        rotated.add(arr.get(i));

        return rotated;
    }
}