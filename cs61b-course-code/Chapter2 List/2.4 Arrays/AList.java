/** Arrays based list.
 *  @author EnzoGuang
 */

public class AList<Item> implements List61B<Item>{
    private Item[] items;
    private int size;
    private double usageRatio;

    /** Creates an empty list. */
    public AList() {
        items = (Item[]) new Object[100];
        size = 0;
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity){
        Item[] other =(Item[]) new Object[capacity];
        System.arraycopy(items, 0, other, 0, size);
        items = other;
    }

    /** Inserts X into the back of the list. */
    @Override
    public void addLast(Item x) {
        if(size == items.length){
            resize(size * 2);
        }
        items[size++] = x;
    }

    /** Returns the item from the back of the list. */
    @Override
    public Item getLast() {
        return items[size - 1];       
    }

    /** Gets the ith item in the list (0 is the front). */
    @Override
    public Item get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    @Override
    public int size() {
        return size;        
    }

    @Override
    public void insert(Item x, int position){};

    @Override
    public void addFirst (Item x){};

    @Override
    public Item getFirst() { return null;}

    /* Returns the length of items in the list */
    public int getLength(){
        return items.length;
    }

    /** Deletes item from back of the list and
      * returns deleted item.
      */
    @Override
    public Item removeLast() {
        Item x = getLast();
        items[size - 1] = null;
        size--;
        usageRatio = (double)size / items.length;
        if(usageRatio < 0.25){
            resize((int)(0.5 * items.length));
        }
        return x;
    }

//     public static void main(String[] args){
//         AList<Integer> a = new AList<>();
//         a.addLast(10);
//         int x = a.getLast();
//         System.out.println(x);
//         for(int i = 0; i < 1000; i++){
//             a.addLast(i);
//         }
//         System.out.println(a.size());
//        for(int i = 0; i < 951; i++){
//            a.removeLast();
//        }
//        System.out.println("a.size:" + a.size());
//        System.out.println("after resizing:" + a.getLength());
//    }
}