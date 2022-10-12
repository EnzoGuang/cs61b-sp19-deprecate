import java.util.Arrays;
public class ArrayCopy{
	public static void main(String[] args){
		int[] from = {1, 2, 3, 4, 5};
		int[] to = {7, 8, 9, 10};
		System.arraycopy(from, 0, to, 1, 3);
		System.out.print(Arrays.toString(to));
	}
}