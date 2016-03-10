//Ricky Wu
//APCS1 pd10
//HW09 -- Mergers and Acquisitions
//2016-03-04

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 
1. Split the list in half. Although the number of comparisons made are the same regardless of the way you split, splitting it in half will create less "layers" (not sure if this affects run time).
2. Repeat steps 1-2 with the two new lists, until all the lists have one element left.
3. Return the list to its parent branch.
4. The returned list will be merged with its sister list by the parent.
5. Repeat until all numbers are sorted by the original parent.

  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
	int[] merged = new int[a.length + b.length];
	int acount = 0;
	int bcount = 0;
	for (int x = 0; x < merged.length; x++){
	    if (bcount == b.length){
		merged[x] = a[acount];
		acount++;
	    }
	    else if (acount == a.length || a[acount] > b[bcount]){
		merged[x] = b[bcount];
		bcount++;
	    }
	    else{
		merged[x] = a[acount];
		acount++;
	    }
	}
	return merged;
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
	if (arr.length == 1){
	    return arr;
	}
	int[] a= new int[arr.length/2];
	int acount = 0;
	int bcount = 0;
	int[] b= new int[arr.length - a.length];
	for (int x = 0; x < arr.length; x++){
	    if (x < arr.length/2){
		a[acount] = arr[x];
		acount++;
	    }
	    else {
		b[bcount] = arr[x];
		bcount++;
	    }
	}
	return merge(sort(a), sort(b));

    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {

	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );
	
	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
    }//end main()

}//end class MergeSort
