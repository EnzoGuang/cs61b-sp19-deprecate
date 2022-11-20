public class Sort{
	/** sort the String array destructively */
	public static void sort(String[] x){
		// Find the smallest item
		// Move it to the Front
		// Selection sort the rest
		sort(x, 0);
	}

	private static void sort(String[] x, int start){
		if(start == x.length){
			return;
		}
		int smallestIndex = findSmallest(x, start);
		swap(x, start, smallestIndex);
		sort(x, start + 1);
	}

	/** Return the smallest string's index in x, starting at start;
	 * @ source Got help with string compares from <a href="https://stackoverflow.com/questions/5153496/">...</a>;
	 */
	public static int findSmallest(String[] x, int start){
		int smallestIndex = start;
		for(int i = start; i < x.length; i++){
			int cmp = x[i].compareTo(x[smallestIndex]);
			// from the internet, if x[i] < x[smallestIndex],cmp will be -1;
			if(cmp < 0){
				smallestIndex = i;
			}
		}
		return smallestIndex;
	}

	/* Swap item a with b */
	public static void swap(String[] x, int a, int b){
		String temp = x[a];
		x[a] = x[b];
		x[b] = temp;
	}
}