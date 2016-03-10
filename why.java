//Ricky Wu, Vincent Tang
//APCS2 pd10
//HW10 -- Justify
//2016-03-08

/*
Calculation of the runtime of a single sort/merge call

1. Sort: this method loops through the list once, in order to place them in two new lists. Therefore, because it only loops once, it has a runtime of O(n)
2. Merge: Similarly, this method loops through two lists, whose combined length is n. This method also has a runtime of O(n)

Altogether, the runtime for a single sort/merge call is O(2n), which is still O(n).


Example of "single sort/merge call":
|4|2|3|9|
SORT
|4|2| |3|9|
MERGE
|2|3|4|9|

Note that sort/merge can still be called on the two lists created after SORT. In the case of a 4 element list, a total of 3 sort/merge calls will be made.
However, NOT ALL CALLS ARE MADE EQUAL:
While it may be tempting to assume that all 3 calls are O(n), it should be noted that the 2 element lists only sort HALF THE LIST.

Example:

Assume that an 8 element list takes n seconds to loop through.

A: |4|2|0|9|1|5|6|7|             

B: |4|2|0|9| |1|5|6|7|

C: |4|2| |0|9| |1|5| |6|7|

D: |4| |2| |0| |9| |1| |5| |6| |7|

A- the list is 8 elements and takes n seconds to run
B- each list is 4 elements and each takes n/2 seconds to run. In total, n/2 + n/2 = n seconds to run
C- each list is 2 elements and each takes n/4 seconds to run. In total, n/4 + n/4 + n/4 + n/4 = n seconds to run
D- single element lists cannot split, nor merge. 

Altogether, this hypothetical list would take 3n seconds to run. 




A more generalized example:

Row 1: n second runtime                                                                     = n

Row 2: n/2                                     n/2                                          = n

Row 3: n/4                 n/4                 n/4                 n/4                      = n

Row 4: n/8       n/8       n/8       n/8       n/8       n/8       n/8       n/8            = n

Row 5: n/16 n/16 n/16 n/16 n/16 n/16 n/16 n/16 n/16 n/16 n/16 n/16 n/16 n/16 n/16 n/16      = n

As you can see, adding in 16 more elements into the list will only increase the runtime by another n. 
Because of this, we can say that the runtime of the whole thing is the log2 of the list's length, or log2(n), multiplied by the time it takes to sort/merge the original list, which is n.
The total runtime would be O(nlogn)

*/



















