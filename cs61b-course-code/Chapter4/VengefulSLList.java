public class VengefulSLList<Item> extends SLList<Item> {
    SLList<Item> deleteItems;

    public VengefulSLList() {
        deleteItems = new SLList<>();
    }

    public VengefulSLList(Item a) {
        super(a);
        deleteItems = new SLList<>();

    }

    /* print all items which are removed from the list */
    public void printLostItems() {
        deleteItems.print();
    }

    @Override
    public Item removeLast() {
        Item remove = super.removeLast();
        deleteItems.addLast(remove);
        return remove;
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> vs1 = new VengefulSLList<>(1);
        vs1.addLast(10);
        vs1.addLast(11);
        vs1.addLast(12);
        vs1.addLast(13);
        vs1.print();
        vs1.removeLast();
        vs1.removeLast();
        vs1.printLostItems();

    }
}
