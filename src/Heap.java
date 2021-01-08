
public class Heap {
	MaxHeap h;
	int c;

	public void init(int c1, int m) {
		h = new MaxHeap(m);
		c = c1;
	}

	public void addGuess(int id, int guess) {

		int temp = Math.abs(guess-c);
		if(h.getSize()<h.getMaxSize()) {
			h.insert(id,temp);
		} else {
			if(h.getMaxElement()>temp) {
				h.extractMax();
				h.insert(id,temp);
			}
		}
	}

	public void GivePrize() {
		h.print_id();
	}


	public static void main(String[] arg)
	{
		/*System.out.println("The Max Heap is ");
		HW3Heap h = new HW3Heap();
		h.init(10, 5);
		h.addGuess(0,10);
		h.addGuess(1,8);
		h.addGuess(2,1);
		h.addGuess(3,2);
		h.addGuess(4,84);
		h.addGuess(5,82);
		h.h.print();

		h.h.print_id();*/
		HW3Heap h = new HW3Heap();
		h.init(500, 3);
		h.addGuess(5,450);
		h.addGuess(6,500);
		h.addGuess(2,550);
		h.addGuess(23,500);
		h.addGuess(17,700);
		h.GivePrize();
	}
}
