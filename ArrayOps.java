public class ArrayOps {
    public static void main(String[] args) {

        int[] arr = {3, 0, 1};
        int[] arr2 = {5, -4, 3, 1};
        System.out.println(findMissingInt(arr));
        System.out.println(secondMaxValue(arr));
        System.out.println(containsTheSameElements(arr, arr2));
        System.out.println(isSorted(arr));


        
    }

    /** This function takes a single parameter: an array of integer values.
     * The array contains each integer 0 ≤𝑥≤𝑛, when n is the size of the array, exactly once, except for one of these integers, which is missing.
     * The function returns the missing integer */
    
    public static int findMissingInt (int [] array) {

        int ln = array.length;
        int sum = sum(array);
        int[] fullArr = new int[ln];
        int count = 0;
        for (int i = 0; i< ln ;i++ ) {

            fullArr[i] = i; 
            for (int j = 0; j < ln ; j++ ) {

                if(array[i] == fullArr[j])
                    count++;
                
            }

            if (count == 0) {
                return array[i];
                
            }
               
           }           
       
           return -1;
        }
    

        /** Returns the second largest number in the array*/
    public static int secondMaxValue(int [] array) {

        int maxArray = max(array);
        int secMax = 0;
        int n = array.length;

        int[] newArray = new int[n];
         
        for (int i = 0; i < n ; i++ ) {

            if(array[i] != maxArray)
            {
                newArray[i] = array[i];
            }
           
        }
        
        return max(newArray);
            

    }
        /** Returns true if both arrays contain the same numbers */ 

    public static boolean containsTheSameElements(int [] array1,int [] array2) {

         int ln1 = array1.length;
         int ln2 = array2.length;

         for (int i = 0; i < ln1; i++ ) {

            int count = 0;

            for (int j = 0; j < ln2 ;j++ ) {

                if (array1[i] == array2[j]) {
                    count++;
                
            }

            }

            if(count == 0)                
                return false;


         }

       return true;
    }

    public static boolean isSorted(int [] array) {


        int ln = array.length;
        int min1 = array[0];
        int max1 = array[0];

        if(array[0] <= array[ln - 1])
        {
            for (int i = 1; i < ln ; i++ ) {

            if(array[i] >= min1)
                min1 = array[i];

            else
                return false;
            
            }
        }

        else if(array[0] >= array[ln - 1]) {

            for (int i = 1; i < ln ; i++ ) {

            if(array[i] <= max1)
                max1 = array[i];

            else
                return false;
            
            }

        }

        return true;
    }

//}
    /** Returns the sum of the elements of the array */ 
    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    /** Returns the largest number from the elements of the array */ 
    public static int max(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            
            if(arr[i] > max)
                max = arr[i];
        }
        return max;


    }

     /** Returns the largest number from the elements of the array */ 
    public static int min(int[] arr) {
         int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            
            if(arr[i] < min)
                min = arr[i];
        }
        return min;


    }
}
