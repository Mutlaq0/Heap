// Java program to implement Max Heap 
public class MaxHeap { 
	
	public class Element{
		int key;
		int id;
		public Element(int i1,int k1) {
			key = k1;
			id = i1;
		}
		public Element(int k1) {
			key = k1;
		}
		public void setId(int i) {
			id = i;
		}
		public void setKey(int i) {
			key = i;
		}
	}
	private Element[] Heap;
	private int size; 
	private int maxsize; 

	// Constructor to initialize an 
	// empty max heap with given maximum 
	// capacity. 
	public MaxHeap(int maxsize) 
	{ 
		this.maxsize = maxsize; 
		this.size = 0; 
		Heap = new Element[this.maxsize + 1];
		Heap[0] = new Element(Integer.MAX_VALUE);
	} 
	public int getSize() {
		return size;
	}
	public int getMaxSize() {
		return maxsize;
	}
	public int getMaxElement() {
		return Heap[1].key;
	}
	
	// Returns position of parent 
	private int parent(int pos) 
	{ 
		return pos / 2; 
	} 

	// Below two functions return left and 
	// right children. 
	private int leftChild(int pos) 
	{ 
		return (2 * pos); 
	} 
	private int rightChild(int pos) 
	{ 
		return (2 * pos) + 1; 
	} 

	// Returns true of given node is leaf 
	private boolean isLeaf(int pos) 
	{ 
		if (pos >= (size / 2) && pos <= size) { 
			return true; 
		} 
		return false; 
	} 

	private void swap(int fpos, int spos) 
	{ 
		int tmp1,tmp2; 
		tmp1 = Heap[fpos].key;
		tmp2 = Heap[fpos].id;
		Heap[fpos].key = Heap[spos].key;
		Heap[fpos].id = Heap[spos].id;
		Heap[spos].key = tmp1;
		Heap[spos].id = tmp2;
	} 

	// A recursive function to max heapify the given 
	// subtree. This function assumes that the left and 
	// right subtrees are already heapified, we only need 
	// to fix the root. 
	private void maxHeapify(int pos) 
	{ 
		if (isLeaf(pos)) 
			return; 

		if (Heap[pos].key < Heap[leftChild(pos)].key || 
			Heap[pos].key < Heap[rightChild(pos)].key) { 

			if (Heap[leftChild(pos)].key > Heap[rightChild(pos)].key) { 
				swap(pos, leftChild(pos)); 
				maxHeapify(leftChild(pos)); 
			} 
			else { 
				swap(pos, rightChild(pos)); 
				maxHeapify(rightChild(pos)); 
			} 
		} 
	} 

	// Inserts a new element to max heap 
	public void insert(Element element) 
	{ 
		Heap[++size] = element; 

		// Traverse up and fix violated property 
		int current = size; 
		while (Heap[current].key > Heap[parent(current)].key) { 
			swap(current, parent(current)); 
			current = parent(current); 
		} 
	}
	public void insert(int key, int id) 
	{ 
		Element e = new Element(key,id);
		this.insert(e);
	} 

	public void print() 
	{ 
		for (int i = 1; i <= size / 2; i++) { 
			System.out.print(" PARENT : " + "(" + Heap[i].key + "," + Heap[i].id + ")" + " LEFT CHILD : " + 
					"(" + Heap[i*2].key + "," + Heap[i*2].id + ")" + " RIGHT CHILD :" + "(" + Heap[2 * i + 1].key + "," + Heap[2 * i + 1].id + ")"); 
			System.out.println(); 
		} 
	}
	
	public void print_id() {
		System.out.print("{");
		for(int i=1;i<=maxsize;i++) {
			System.out.print(Heap[i].id);
			if(i<=maxsize-1)System.out.print(",");
		}
		System.out.println("}");
	}

	// Remove an element from max heap 
	public int extractMax() 
	{ 
		int popped = Heap[1].key; 
		Heap[1] = Heap[size--]; 
		maxHeapify(1); 
		return popped; 
	}
	/*public static void main(String[] arg) 
	{ 
		System.out.println("The Max Heap is "); 
		MaxHeap maxHeap = new MaxHeap(9); 
		maxHeap.insert(5,0); 
		maxHeap.insert(3,1); 
		maxHeap.insert(17,2); 
		maxHeap.insert(10,3); 
		maxHeap.insert(84,4); 
		maxHeap.insert(19,5); 
		maxHeap.insert(6,6); 
		maxHeap.insert(22,7); 
		maxHeap.insert(9,8); 

		maxHeap.print(); 
		System.out.println("The max val is " + maxHeap.extractMax()); 
	}*/
} 

