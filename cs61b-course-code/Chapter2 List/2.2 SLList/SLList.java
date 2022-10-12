public class SLList{
	public IntNode sentinel;
	private static int size;


	public SLList(){
		sentinel = new IntNode(63, null);
		size = 0;
	}

	public SLList(int x){
		this();
		sentinel.next = new IntNode(x, null);
		size = 1;
	}

	public void addFirst(int x){
		sentinel.next = new IntNode(x, sentinel.next);
		size++;
	}

	public void addLast(int x){
		IntNode p = sentinel;
		while(p.next != null){
			p = p.next;
		}
		p.next = new IntNode(x, null);
		size++;
	}

	public int getFirst(){
		return sentinel.next.item;
	}

	public int getLast(){
		IntNode p = sentinel;
		while(p.next != null){
			p = p.next;
		}
		return p.item;
	}

	public int size(){
	 	return size;
	 }

	public static void main(String[] args){
		SLList L = new SLList(15);
		System.out.println(L.getFirst());
		L.addFirst(10);
		System.out.println(L.getFirst());
		L.addFirst(5);
		System.out.println(L.getFirst());
		L.addLast(20);
		System.out.println(L.getLast());
		L.addLast(25);
		System.out.println(L.getLast());
		System.out.println("L.size:" + L.size());
		// SLList L = new SLList(0);
		// for(int i = 1; i < 21000; i++){
		// 	L.addLast(i);
		// }
		// System.out.println(L.size());
		SLList empty = new SLList();
		System.out.println("empty.size:" + empty.size());
		System.out.println("L.size:" + L.size());
		empty.addLast(5);
		System.out.println(empty.getLast());
		System.out.println("empty.size:" + empty.size());
		
	}
}