package exceptionEx1;

public class ExceptionEx1 {

    public static void main(String args[]) {

        int[] nums = {3, 2, 6, 1};
        badUse(nums);
    }

    public static void badUse(int[] vals) {
        int total = 0;

        for (int i = 0; i < vals.length; i++) {
            try {
                int index = vals[i];
                total += vals[index];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Invalid index. Skipping element.");
            }
        }
        System.out.println("Result: " + total);
    }
}