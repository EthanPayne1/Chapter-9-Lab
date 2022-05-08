
public class PriorityQueue<T extends IPriority & IKey<Integer>> implements IPriorityQueue<T> {
/**  
* ✔2 Code a one parameter constructor that takes a boolean that indicates whether a lower number should have a higher priority. 
*       ✔-If the parameter is true, then the constructor should instantiate the Heap as a min heap. 
*       ✔-If the parameter is false then the constructor should instantiate the heap as a max heap.
* ✔ 3 Code a default constructor to either call the other constructor passing true or instanitate the heap as a min heap(priority queue does this naturally)
* ✔ 4 Implement the methods in IPriorityQueue. IPriorityQueue has five methods you should implement each one.
*/

   //* Instance variable of type heap to store our data 
   Heap<T>pQueue = new Heap<T>();
   boolean isNumLow = true;
    
   // Default constructor 
   public PriorityQueue() {
       this(false);
   }

   // One parameter constructor 
   public PriorityQueue(boolean isMaxHeap) {
       this.pQueue = new Heap<>(isMaxHeap);
    /** Instanitate the Heap as a max heap
        if(pQueue.getHeapType() == "Max") {
            Heap<T> maxHeap = new Heap<>(isNumLow == false);
        }
    else {
        // Instanitate the Heap as a min heap
        Heap<T> minHeap = new Heap<>(isNumLow == true);
    } */
   }



@Override
public void push(T node) {
    this.pQueue.insert(node);
    
}

@Override
public T pop() {
    return this.pQueue.remove();
}

@Override
public T peek() {
    return this.pQueue.get();
}

@Override
public boolean isEmpty() {
    return this.pQueue.isEmpty();
}

@Override
public int getLength() {
    return this.pQueue.size();
}
}