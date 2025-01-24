import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
//        ArrayStatistics();
//        PalindromeChecker();
    }


    public static void ArrayStatistics(){
        System.out.println("How many elements will be in array?");
        int size = scan.nextInt();

        if(size == 0){
            System.out.println("Array has to have something");
            return;
        }

        int[] nums = new int[size];

        System.out.println("Enter your  integers(every integer has to have its own line): ");
        for(int i=0; i<size; i++){
            nums[i] = scan.nextInt();
        }
        if(nums.length == 1){
            System.out.println("Sum,average,smallest/largest element: " + nums[0]);
            return;
        }
        int sum = 0;
        int smallest = nums[0];
        int largest = nums[0];

        for (int x:nums){
            if(x<smallest){
                smallest = x;
            }
            if (x>largest) {
                largest = x;
            }
            sum += x;
        }
        int avg = sum/ nums.length;
        System.out.println("Sum: " + sum + "\nAverage: " + avg + "\n Largest and smallest: " + largest + " " + smallest);

        //Challenge
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);}
        Integer[] new_nums = treeSet.toArray(new Integer[0]);
        if (new_nums.length>2){
        System.out.println("Bonus\n The second largest and the second smallest elements respectively are: " + new_nums[new_nums.length - 2] + " " + new_nums[1]);
    }
    }
    public static void PalindromeChecker() {
        System.out.println("Enter your word:");
        String word = scan.next();
        boolean isPalindrome = pch(word);

        if (isPalindrome) {
            System.out.println("The word \"" + word + "\" is a palindrome.");
        } else {
            System.out.println("The word \"" + word + "\" is not a palindrome.");
        }
    }
    private static boolean pch(String word) {
        int start = 0;
        int end = word.length() - 1;

        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}