package quickSort;

public class QuickSort {

	  private int[] list; 										//Array - Declaring list. Will be initialized on line of code # 13
      private int listLength;									//In this case, the length of the list will be 7

      public void sort(int[] values) {
              // check for empty or null array
              if (values ==null || values.length==0){
                      return;
              }
              this.list = values;								//Initializing list[] by assigning the values within values[] array, which comes from our main() method.
              listLength = values.length;						//In this case, the length of the list will be 7
              quicksort(0, listLength - 1);					//Method call, happens only once, not recursion. In this case: quicksort(0, 7 - 1); which becomes quicksort(0, 6); in-order to represent listLength in an index format which the quicksort() method requires.
      }

      private void quicksort(int low, int high) {				//gets called more than once with different parameter values, see code line # 44 & # 46. quicksort(0, 6); Notice that quicksort() uses the index format of the list. Explained on code line # 15
              int i = low, j = high;							//low & high in terms of index. So in this case it would be 0,6....as these were passed through the quicksort() methods parameters.
              // Get the pivot element from the middle of the list:
              int pivot = list[low + (high-low)/2]; 
              //System.out.println("pivot = " + pivot);         Optional:here to help visualize different pivots, so 30,... 4,...73,...100

              // Divide into two lists:
              while (i <= j) {							//As long as i/low is less than or equal too j/high than do below block of code.
                      while (list[i] < pivot) {	  		//If the current value from the left list is smaller then the pivot element then get the next element from the left list...AKA move to the next one
                              i++;					 	//Think of pivot here almost how mid acts as the list separator in MergeSort. This is like the Left/lower part of the list.
                              //System.out.println("i = " + list[i]); 	    Optional:here to help visualize different i, so 4, 1, 30
                      }
                      while (list[j] > pivot) {			// If the current value from the right list is larger then the pivot element then get the next element from the right list...AKA move to the next one
                              j--;						//Think of pivot here almost how mid acts as the list separator in MergeSort. This is like the Right/Upper/Higher part of the list.
                              //System.out.println("j = " + list[j]);       Optional:here to help visualize different j, so 73, 100, 30...,73, 100
                      }

                      
                      // As we are done we can increase i and j
                      if (i <= j) {
                              exchange(i, j);			//swap, exchange() method call. Method implementation on code line # 50. //Explanation of code line #39: If we have found values in the left list which are larger then the pivot element,... and if we have found values in the right list which are smaller then the pivot element,...then we exchange those values.
                              i++;
                              j--;
                      }
              }
              // Recursion/we recurse back to the top of this quicksort() method.	  This is where Recursion occurs for quicksort(), method calling itself, but now with different values its parameters.
              if (low < j)
                      quicksort(low, j);
              if (i < high)
                      quicksort(i, high);
      }
      //realize that this is part just the method implementation of exchange(), exchange() method call is on code line #38
      private void exchange(int i, int j) {				//swap, exchange() method implementation. Method call on Code line # 38
              int temp = list[i];
              list[i] = list[j];
              list[j] = temp;
      }
      
      
      public static void main(String arg[]) {
    	  int[] values = {20, 4, 1, 30, 100, 73, 101};
    	  QuickSort qsObj =  new QuickSort();
    	  qsObj.sort(values);
	  
    	  for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}
    	  
		
	}
      
      
      
}