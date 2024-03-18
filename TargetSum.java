import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class TargetSum{
    public static void main(String[] args) {
        
        //will hold user input of array
        List <Integer> numbers = new ArrayList<>();

        //will hold user input of target number 
        int target = -1;
        
        //will catch inputMismatchException
        try{
            //create array of integers inputted by user 
            numbers = userInputArray();
        
            //obtain target number from user 
            target = userTargetNumber();
        }

        catch(InputMismatchException e){
            System.out.println("Invalid input, please be sure to only enter integers.");
        }

        //create list of combinations using method that will find all combinations 
        List<List<Integer>> combinations = findCombinations(numbers);
        
        //print all combinations of the list that add to the target number 
        printAllCombinations(combinations, target);
        
    }

    //return target number 
    public static int userTargetNumber(){
        //create scanner 
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the target number: ");
        
        int target = input.nextInt();

        return target;
    }
    //method will return user input array of integers 
    public static List<Integer> userInputArray() {
          //create the array of numbers
          List<Integer> numbers = new ArrayList<>();

          //Create scanner for user input 
          Scanner input = new Scanner(System.in);
  
          System.out.print("Please enter the number of integers in the array you will input: ");
         
          //will store the amount of numbers the user will store 
          int length = input.nextInt();
  
          System.out.print("\nPlease enter the numbers: ");
          //will store each number to array
          for(int i = 0; i < length; i++){
              numbers.add(input.nextInt());
          }

          return numbers;
    }

    //This code returns a list of a list of all the possible combinations of a given array 
    public static List<List<Integer>> findCombinations(List<Integer> array) {
       
        //this is the base case, if the array is empty it will return a list of list of integers which is empty  
        if (array.size() == 0) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        //This list will store combinations 
        List<List<Integer>> combinations = new ArrayList<>();

        /*for each recursive call it will remove the first number of the array, which will subsequently 
        lead to the base case */
        for (List<Integer> combination : findCombinations(array.subList(1, array.size()))) {
            combinations.add(combination);
            List<Integer> newCombination = new ArrayList<>(combination);
            newCombination.add(array.get(0));
            combinations.add(newCombination);
        }
        return combinations;
    }

    /*method will take in list of combinations, as well as the target number, will print all combinations of 
    the array that add to the target number*/
    public static void printAllCombinations(List<List<Integer>> combinations, int target){
        //Print out display 
        System.out.println("All of the combinations of array that add to " + target + "... ");
        
        /*This will cycle through the list of list of combinations, if the number is equal to the target 
            it will print the array of integers
        */
        for(List<Integer> list:  combinations){
            int sum = 0; 
            for(int i = 0; i < list.size(); i++){
                sum += list.get(i);
            }

            if (sum == target){
                System.out.println(list);
            }
        }
    }
}
