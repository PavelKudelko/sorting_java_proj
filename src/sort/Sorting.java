package src.sort;

/**
 * src.sort.Sorting demonstrates sorting and searching on an array
 * of objects.
 *
 * @author Lewis and Chase
 * @version 4.0 
 */
public class Sorting 
{
    /**
	 * Sorts the specified array of integers using the selection
	 * sort algorithm.
	 *
	 * @param data the array to be sorted
	 * @return
	 */
    public static <T extends Comparable<T>>
	int selectionSort(T[] data)
    {
        int min;
        T temp;
		int comparisonCount = 0;
        
        for (int index = 0; index < data.length-1; index++)
        {
            min = index;
            for (int scan = index+1; scan < data.length; scan++) {
				comparisonCount++;
				if (data[scan].compareTo(data[min]) < 0)
					min = scan;
			}
			
            swap(data, min, index);
        }
		return comparisonCount;
    }
	
	/**
	 * Swaps to elements in an array. Used by various sorting algorithms.
	 * 
	 * @param data   the array in which the elements are swapped
	 * @param index1 the index of the first element to be swapped
	 * @param index2 the index of the second element to be swapped
	 */
	private static <T extends Comparable<T>> 
		void swap(T[] data, int index1, int index2)
	{
		T temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
	
    /**
     * Sorts the specified array of objects using an insertion
     * sort algorithm.
     *
     * @param data the array to be sorted
     */
	public static <T extends Comparable<T>> int insertionSort(T[] data)
	{
		int comparisonCount = 0;

		for (int index = 1; index < data.length; index++)
		{
			T key = data[index];
			int position = index;

			// shift larger values to the right
			while (position > 0)
			{
				comparisonCount++; // Increment counter for each comparison
				if (data[position-1].compareTo(key) > 0)
				{
					data[position] = data[position-1];
					position--;
				}
				else {
					break;
				}
			}
			data[position] = key;
		}
		return comparisonCount; // Return the number of comparisons
	}
	
    /**
	 * Sorts the specified array of objects using a bubble sort
	 * algorithm.
	 *
	 * @param data the array to be sorted
	 * @return int
	 */
    public static <T extends Comparable<T>>
	int bubbleSort(T[] data)
    {
        int position, scan;
        T temp;
		int comparisonCount = 0;
		
        for (position =  data.length - 1; position >= 0; position--)
        {
            for (scan = 0; scan <= position - 1; scan++)
            {
				comparisonCount++;
                if (data[scan].compareTo(data[scan+1]) > 0)
                    swap(data, scan, scan + 1);
            }
        }
		return comparisonCount;
    }

    /**
     * Sorts the specified array of objects using the merge sort
     * algorithm.
     *
     * @param data the array to be sorted
     */
	public static <T extends Comparable<T>> int mergeSort(T[] data)
	{
		return mergeSort(data, 0, data.length - 1);
	}

    /**
	 * Recursively sorts a range of objects in the specified array using the
	 * merge sort algorithm.
     *
     * @param data the array to be sorted
     * @param min  the index of the first element
     * @param max  the index of the last element
     */
	private static <T extends Comparable<T>> int mergeSort(T[] data, int min, int max)
	{
		int comparisonCount = 0;
		if (min < max)
		{
			int mid = (min + max) / 2;
			comparisonCount += mergeSort(data, min, mid);
			comparisonCount += mergeSort(data, mid + 1, max);
			comparisonCount += merge(data, min, mid, max);
		}
		return comparisonCount;
	}

	/**
     * Merges two sorted subarrays of the specified array.
     *
     * @param data the array to be sorted
     * @param first the beginning index of the first subarray
     * @param mid the ending index fo the first subarray
     * @param last the ending index of the second subarray
     */
	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>> int merge(T[] data, int first, int mid, int last)
	{
		T[] temp = (T[])(new Comparable[data.length]);
		int comparisonCount = 0;

		int first1 = first, last1 = mid;  // endpoints of first subarray
		int first2 = mid + 1, last2 = last;  // endpoints of second subarray
		int index = first1;  // next index open in temp array

		// Copy smaller item from each subarray into temp until one of the subarrays is exhausted
		while (first1 <= last1 && first2 <= last2)
		{
			comparisonCount++; // Increment counter for each comparison
			if (data[first1].compareTo(data[first2]) < 0)
			{
				temp[index] = data[first1];
				first1++;
			}
			else
			{
				temp[index] = data[first2];
				first2++;
			}
			index++;
		}
		// Copy remaining elements from first subarray, if any
		while (first1 <= last1)
		{
			temp[index] = data[first1];
			first1++;
			index++;
		}
		// Copy remaining elements from second subarray, if any
		while (first2 <= last2)
		{
			temp[index] = data[first2];
			first2++;
			index++;
		}
		// Copy merged data into original array
		for (index = first; index <= last; index++)
			data[index] = temp[index];
		return comparisonCount;
	}

	/**
	 * Sorts the specified array of objects using the quick sort algorithm.
	 * 
	 * @param data the array to be sorted
	 */
	public static <T extends Comparable<T>> int quickSort(T[] data)
	{
		return quickSort(data, 0, data.length - 1);
	}

	/**
	 * Recursively sorts a range of objects in the specified array using the
	 * quick sort algorithm.
	 *
	 * @param data the array to be sorted
	 * @param min  the minimum index in the range to be sorted
	 * @param max  the maximum index in the range to be sorted
	 */
	private static <T extends Comparable<T>> int quickSort(T[] data, int min, int max)
	{
		int comparisonCount = 0;
		if (min < max)
		{
			// create partitions
			int[] partitionResult = partition(data, min, max);
			int indexofpartition = partitionResult[0];
			comparisonCount += partitionResult[1]; // Count comparisons in partitioning
			// sort the left partition (lower values)
			comparisonCount += quickSort(data, min, indexofpartition - 1);
			// sort the right partition (higher values)
			comparisonCount += quickSort(data, indexofpartition + 1, max);
		}
		return comparisonCount;
	}
	/**
	 * Used by the quick sort algorithm to find the partition.
	 *
	 * @param data the array to be sorted
	 * @param min  the minimum index in the range to be sorted
	 * @param max  the maximum index in the range to be sorted
	 * @return an array where the first element is the partition index and the second element is the comparison count
	 */
	private static <T extends Comparable<T>> int[] partition(T[] data, int min, int max)
	{
		T partitionelement;
		int left, right;
		int middle = (min + max) / 2;
		int comparisonCount = 0;
		// use the middle data value as the partition element
		partitionelement = data[middle];
		// move it out of the way for now
		swap(data, middle, min);
		left = min;
		right = max;
		while (left < right)
		{
			// search for an element that is > the partition element
			while (left < right && data[left].compareTo(partitionelement) <= 0)
			{
				left++;
				comparisonCount++; // Increment counter for each comparison
			}
			// search for an element that is < the partition element
			while (data[right].compareTo(partitionelement) > 0)
			{
				right--;
				comparisonCount++; // Increment counter for each comparison
			}
			// swap the elements
			if (left < right)
				swap(data, left, right);
		}
		// move the partition element into place
		swap(data, min, right);
		return new int[]{right, comparisonCount};
	}
}

