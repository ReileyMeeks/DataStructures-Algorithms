package DataStructures;

import ADTs.QueueADT;
import DataStructures.SinglyLinkedNode;
import Exceptions.EmptyCollectionException;
/**
 *
 * @author ITCS2214
 */
public class LinkedQueue<T> implements QueueADT<T> {
    SinglyLinkedNode<T> front, rear;
    int count;
    
    public LinkedQueue(){
	   // Initialize data member variables front, rear and count
        front = rear = null;
        count = 0;
    }
    
    @Override
    public void enqueue(T element) {
        SinglyLinkedNode<T> node = new SinglyLinkedNode<T>(element); 

        if (isEmpty()) {
            front = node;
        } else {
            rear.setNext(node);
        }

        rear = node; 
        count++; 
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Queue [first()]");
        }
        return front.getElement();
    }   

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty queue");
        }

        T result = front.getElement(); 
        front = front.getNext(); 
        count--; 

        if (isEmpty()) {
            rear = null; 
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0? true : false;
    }

    @Override
    public int size() {
        return this.count;
    }
}
