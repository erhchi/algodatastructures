package week3;

public class Example {
    
    public static int recursiveSum(int[] array, int index) {
        if (index == array.length)
            return 0;
        else
            return array[index] + recursiveSum(array, index + 1);
    }
    
    
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        
        System.out.print( "Using recursion, we get: " );
        System.out.println( recursiveSum(array, 0) );

    }
}
