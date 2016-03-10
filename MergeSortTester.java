//Ricky Wu, Vincent Tang
//APCS2 pd10
//HW11 -- Wrapping It Up
//2016-03-09

/*======================================
  class MergeSortTester
  ALGORITHM:
  <INSERT YOUR DISTILLATION OF ALGO HERE>
  
  1. Split the list in half. Although the number of comparisons made are the same regardless of the way you split, splitting it in half will create less "layers" (not sure if this affects run time).
  2. Repeat steps 1-2 with the two new lists, until all the lists have one element left.
  3. Return the list to its parent branch.
  4. The returned list will be merged with its sister list by the parent.
  5. Repeat until all numbers are sorted by the original parent.


  BIG-OH CLASSIFICATION OF ALGORITHM:

  1. Sort: this method loops through the list once, in order to place them in two new lists. Therefore, because it only loops once, it has a runtime of O(n)
  2. Merge: Similarly, this method loops through two lists, whose combined length is n. This method also has a runtime of O(n)

  Altogether, the runtime for a single sort/merge call is O(2n), which is still O(n).

  A generalized example:

  Row 1: n second runtime                                                                     = n

  Row 2: n/2                                     n/2                                          = n

  Row 3: n/4                 n/4                 n/4                 n/4                      = n

  Row 4: n/8       n/8       n/8       n/8       n/8       n/8       n/8       n/8            = n

  Row 5: n/16 n/16 n/16 n/16 n/16 n/16 n/16 n/16 n/16 n/16 n/16 n/16 n/16 n/16 n/16 n/16      = n

  As you can see, adding in 16 more elements into the list will only increase the runtime by another n. 
  Because of this, we can say that the runtime of the whole thing is the log2 of the list's length, or log2(n), multiplied by the time it takes to sort/merge the original list, which is n.
  The total runtime would be O(nlogn)



  Mean execution times for dataset of size n:
  Batch size: <# of times each dataset size was run>
  n=1       time: 
  n=10      time: 
  n=100     time: 
  ...
  n=<huge>  time: 
  ANALYSIS:
  <INSERT YOUR RESULTS ANALYSIS HERE>
  ======================================*/

public class MergeSortTester {
    public static void main (String[] args){
	long time1 = 0;
	long time2 = 0;
	MergeSort merge = new MergeSort();
	int[] test1 = {4};
	int[] test2 = {4,2,4,5,1,2,3,9,123,12};
	int[] test3 = new int[100];
	for (int i = 0; i < test3.length; i++){
	    test3[i] = (int)(Math.random() * 100);
	}
	int[] test4 = new int[1000];
	for (int i = 0; i < test4.length; i++){
	    test4[i] = (int)(Math.random() * 100);
	}
	int[] test5 = new int[10000];
	for (int i = 0; i < test5.length; i++){
	    test5[i] = (int)(Math.random() * 100);
	}
	   
	time1 = System.nanoTime();
	merge.sort(test1);
	time2 = System.nanoTime();
	System.out.println("Runtime for a 1 element array: " + (time2 - time1) + " nanoseconds");

	time1 = System.nanoTime();
	merge.sort(test2);
	time2 = System.nanoTime();
	System.out.println("Runtime for a 10 element array: " + (time2 - time1) + " nanoseconds");

	time1 = System.nanoTime();
	merge.sort(test3);
	time2 = System.nanoTime();
	System.out.println("Runtime for a 100 element array: " + (time2 - time1) + " nanoseconds");

	time1 = System.nanoTime();
	merge.sort(test4);
	time2 = System.nanoTime();
	System.out.println("Runtime for a 1000 element array: " + (time2 - time1) + " nanoseconds");

	time1 = System.nanoTime();
	merge.sort(test5);
	time2 = System.nanoTime();
	System.out.println("Runtime for a 10000 element array: " + (time2 - time1) + " nanoseconds");
    }
}
