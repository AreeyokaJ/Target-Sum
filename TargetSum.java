import java.util.Arrays;

class TargetSum{
    public static void main(String[] args){
        int[] array = {3, 4, 1, 5, 6, 7, 9, 11}; 
        
        Arrays.sort(array);

        calculator(array, 5);


    }

    /*this method will recursively find all the combinations of the array, and if the current 
        combination is equal to the target it will print it 
    */
    public static int[] calculator(int[] array, int target){
        if(array.length == 0){
            //if array is empty return empty array
            int[] empty = new int[0];
            return empty;
        }

        //stores the first number of the current array
        int firstNumber = array[0]; 
        
        int[] rest;
        //rest will have a subset of the array from index = 1 to index = array.length-1
        if(array.length == 1)
            rest = Arrays.copyOf(array, 1);
        else 
            rest = Arrays.copyOfRange(array, 1, array.length-1);

        //these are combinations without the first number 
        int[] combWithoutFirst = calculator(rest, target);

        //these are combinations with the first number
        int[] combWithFirst = addNumber(array, firstNumber);

        calculator(combWithFirst, target );

        //if the sum of the array is equal to the target print in 
        if (sum(array) == target){
            printArray(array);
        }

        //just to return something 
        return combWithoutFirst;
    }

    //this method returns sum of all the numbers in an array 
    public static int sum (int[] array){
        int sum = 0; 
        
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }

        return sum; 
    }

    //this method adds a number to the end of the array 
    public static int[] addNumber(int[] array, int number){
        int newArrayLength = array.length+1;

        int[] newArray = new int[newArrayLength];
        
        for(int i = 0; i<newArray.length; i++){
            if( i != newArray.length-1){
                newArray[i] = array[i];
            }

            else 
                newArray[i] = number;
        }

        return newArray;
    }

    //method to print all of the elements in an array
    public static void printArray(int[] array){
        //print opening bracket 
        System.out.print("[");

        //cycle through and print out all of the elements in an array 
        for(int i = 0; i < array.length; i++){
            if(i != array.length-1)
                System.out.print(array[i] + " ");
            else 
                System.out.print(array[i]);
        }
        //print a closing bracket 
        System.out.print("]");
    }

}