//Ricky Wu
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
  n=8       time:5500 ns 
  n=16      time:12000 ns 
  n=32      time:26000 ns 
  n=64      time:55000 ns
  n=128     time:130000 ns 
  ...
  n=x       time:roughly 75x * log2(75x)
  
  NOTE: results may vary from computer to computer

  ANALYSIS:
  From the results, you can see that the method's runtime is indeed O(nlog(n)). When the length of the list doubles, the runtime is roughly doubled as well
  The reason I didn't include when n is 1,2, or 4 is because they didn't follow the rules for some reason.
  ======================================*/

public class MergeSortTester {
    public static void main (String[] args){
	long time1 = 0;
	long time2 = 0;
	MergeSort merge = new MergeSort();
	int[] test1 = {4,2};
	int[] test2 = {4,2,4,5};
	int[] test3 = {4,2,4,5,1,2,76,2};
	int[] test4 = new int[16];
	for (int i = 0; i < test4.length; i++){
	    test4[i] = (int)(Math.random() * 100);
	}
	int[] test5 = new int[32];
	for (int i = 0; i < test5.length; i++){
	    test5[i] = (int)(Math.random() * 100);
	}
	int[] test6 = new int[64];
	for (int i = 0; i < test6.length; i++){
	    test6[i] = (int)(Math.random() * 100);
	}
	int[] test7 = new int[128];
	for (int i = 0; i < test7.length; i++){
	    test7[i] = (int)(Math.random() * 100);
	}
	int[] test8 = new int[(int)Math.pow(2,10)];
	for (int i = 0; i < test8.length; i++){
	    test8[i] = (int)(Math.random() * 100);
	}
	
	time1 = System.nanoTime();
	merge.sort(test1);
	time2 = System.nanoTime();
	System.out.println("Runtime for a 2 element array: " + (time2 - time1) + " nanoseconds");

	time1 = System.nanoTime();
	merge.sort(test2);
	time2 = System.nanoTime();
	System.out.println("Runtime for a 4 element array: " + (time2 - time1) + " nanoseconds");

	time1 = System.nanoTime();
	merge.sort(test3);
	time2 = System.nanoTime();
	System.out.println("Runtime for a 8 element array: " + (time2 - time1) + " nanoseconds");

	time1 = System.nanoTime();
	merge.sort(test4);
	time2 = System.nanoTime();
	System.out.println("Runtime for a 16 element array: " + (time2 - time1) + " nanoseconds");

	time1 = System.nanoTime();
	merge.sort(test5);
	time2 = System.nanoTime();
	System.out.println("Runtime for a 32 element array: " + (time2 - time1) + " nanoseconds");

	time1 = System.nanoTime();
	merge.sort(test6);
	time2 = System.nanoTime();
	System.out.println("Runtime for a 64 element array: " + (time2 - time1) + " nanoseconds");

	time1 = System.nanoTime();
	merge.sort(test7);
	time2 = System.nanoTime();
	System.out.println("Runtime for a 128 element array: " + (time2 - time1) + " nanoseconds");

	time1 = System.nanoTime();
	merge.sort(test8);
	time2 = System.nanoTime();
	System.out.println("Runtime for a 2^10 element array: " + (time2 - time1) + " nanoseconds");
    }
}
