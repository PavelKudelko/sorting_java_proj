# Searching and Sorting Program Project

- **Linear Search**: Perform a linear search on a predefined array of integers (0 to 9).
- **Binary Search**: Perform a binary search on a predefined array of integers (0 to 9).
- **Sorting Algorithms**:
    - Insertion Sort (O(n^2) complexity)
    - Merge Sort (O(n log n) complexity)
    - Performance comparison for various sorting algorithms including:
        - Selection Sort
        - Insertion Sort
        - Bubble Sort
        - Merge Sort
        - Quick Sort

## How to run?

1. Clone the repository or download the project files.
2. Open the project in intellij
3. Run the `Main` class.

### Example 

```bash
Menu of searching and Sorting testbed.

1) Linear searching
2) Binary searching
3) O(n^2) type of sorting
4) O(n*log(n)) type of sorting
5) Sorting performance

q/Q) Quit

Your choice: 1
In the list are values 0, ..., 9; which value would you like to search with linear search? 2
Found

Menu of searching and Sorting testbed.

1) Linear searching
2) Binary searching
3) O(n^2) type of sorting
4) O(n*log(n)) type of sorting
5) Sorting performance

q/Q) Quit

Your choice: 2
In the list are values 0, ..., 9; which value would you like to search with binary search? 3
Found

Menu of searching and Sorting testbed.

1) Linear searching
2) Binary searching
3) O(n^2) type of sorting
4) O(n*log(n)) type of sorting
5) Sorting performance

q/Q) Quit

Your choice: 3
Data set before insertion sorting:
65 78 5 -63 -77 -72 7 22 -48 -2 

Data set after insertion sorting:
-77 -72 -63 -48 -2 5 7 22 65 78 

Menu of searching and Sorting testbed.

1) Linear searching
2) Binary searching
3) O(n^2) type of sorting
4) O(n*log(n)) type of sorting
5) Sorting performance

q/Q) Quit

Your choice: 4
Data set before merge sorting:
21 -29 56 34 14 7 43 62 39 23 

Data set after merge sorting:
-29 7 14 21 23 34 39 43 56 62 

Menu of searching and Sorting testbed.

1) Linear searching
2) Binary searching
3) O(n^2) type of sorting
4) O(n*log(n)) type of sorting
5) Sorting performance

q/Q) Quit

Your choice: 5
Sorting performance:

				1000          2000          3000          4000          5000          6000          7000          8000          9000          10000         
Selection sort, comparisons     499500        1999000       4498500       7998000       12497500      17997000      24496500      31996000      40495500      49995000      
Selection sort, ms              2             5             12            24            39            51            103           99            111           190           
Insertion sort, comparisons     254347        993073        2233000       4013975       6153521       9039354       12168316      15742869      20255541      24870811      
Insertion sort, ms              2             5             13            17            27            39            52            66            96            149           
Bubble sort, comparisons        499500        1999000       4498500       7998000       12497500      17997000      24496500      31996000      40495500      49995000      
Bubble sort, ms                 6             27            49            82            145           199           252           316           393           493           
Merge sort, comparisons         8718          19440         30876         42834         55196         67830         80683         93650         106859        120358        
Merge sort, ms                  1             3             6             11            18            29            33            32            32            661           
Quick sort, comparisons         11920         28645         52720         79879         116057        148723        185948        239567        294533        344012        
Quick sort, ms                  0             0             0             1             1             2             3             2             4             4             

Menu of searching and Sorting testbed.

1) Linear searching
2) Binary searching
3) O(n^2) type of sorting
4) O(n*log(n)) type of sorting
5) Sorting performance

q/Q) Quit

Your choice: q
Exiting...
