package dsassignment3;

import ADTs.WorkAheadQueueADT;
import DataStructures.LinearNode;
import Exceptions.EmptyCollectionException;
import Exceptions.InvalidArgumentException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ReileyMeeks
 */
import java.util.ArrayList;

public class WorkAheadQueue<T> implements WorkAheadQueueADT<T> {

    private LinearNode<T> front;
    private LinearNode<T> back;
    private ArrayList<LinearNode<T>> frontThreeNodes;
    private ArrayList<T> frontThreeElements;
    private int numNodes;

    /**
     * Default constructor
     */
    public WorkAheadQueue() {
        front = null;
        back = null;
        numNodes = 0;
    }

    /**
     * Enqueue specific element of type T
     *
     * @param element
     */
    @Override
    public void enqueue(T element) {

        LinearNode<T> node = new LinearNode<T>(element);
        if (front == null) {
            front = node;
        } else {

            node.setPrev(back);
            back.setNext(node);
        }
        back = node;
        numNodes++;
    }

    /**
     * dequeue an element
     *
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        } else {

            T item = front.getElement();
            front = front.getNext();

            if (front == null) {
                back = null;
            } else {
                front.setPrev(null);
            }

            numNodes--;
            return item;
        }
    }

    /**
     * Dequeue an element at specific index x
     *
     * @param x
     * @return
     * @throws EmptyCollectionException
     * @throws InvalidArgumentException
     */
    @Override
    public T dequeue(int x) throws EmptyCollectionException,
            InvalidArgumentException {

        if (isEmpty()) {
            throw new EmptyCollectionException();
        } else {

            if (x > numNodes) {
                throw new InvalidArgumentException();
            } else {

                if (x == 0) {
                    return dequeue();
                } else {

                    LinearNode<T> node = front;

                    while (x > 0) {
                        node = node.getNext();
                        x--;
                    }

                    node.getPrev().setNext(node.getNext());
                    if (node == back) {
                        back = node.getPrev();
                    } else {
                        node.getNext().setPrev(node.getPrev());
                    }

                    numNodes--;
                    return node.getElement();
                }
            }
        }
    }

    /**
     * Return element at first position
     *
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        } else {
            return front.getElement();
        }
    }

    /**
     *
     * @param x
     * @return
     * @throws EmptyCollectionException
     * @throws InvalidArgumentException
     */
    @Override
    public T first(int x) throws EmptyCollectionException,
            InvalidArgumentException {

        if (isEmpty()) {
            throw new EmptyCollectionException();
        } else if (x >= numNodes || x > 4) {
            throw new InvalidArgumentException();
        } else {

            LinearNode<T> node = front;

            while (x > 0) {
                node = node.getNext();
                x--;
            }

            return node.getElement();
        }
    }

    /**
     * Returns an ArrayList of the first three elements in the queue.
     *
     * @return ArrayList<T> array list of elements
     * @throws EmptyCollectionException if the queue is empty
     */
    @Override
    public ArrayList<T> firstThreeElements() throws
            EmptyCollectionException {

        if (isEmpty()) {
            throw new EmptyCollectionException();
        }

        ArrayList<T> list = new ArrayList<T>();

        LinearNode<T> node = front;
        int n = 1;

        while (n <= 3 && node != null) {
            list.add(node.getElement());
            n++;
            node = node.getNext();
        }

        return list;
    }

    /**
     * Returns true if the collection contains no elements
     *
     * @return true if the collection is empty
     */
    @Override
    public boolean isEmpty() {
        return numNodes == 0;
    }

    /**
     * Returns the number of elements in the collection
     *
     * @return the number of elements as an int
     */
    @Override
    public int size() {
        return numNodes;
    }

    /**
     * Returns a string representation of the collection
     *
     * @return a string representation of the collection
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        LinearNode curr = front;
        for (int i = 0; i < size(); i++) {
            sb.append(curr.getElement().toString());
            if (i < size() - 1) {
                sb.append(", ");
            }
            curr = curr.getNext();
        }
        return sb.toString();
    }

    @Override
    public ArrayList<LinearNode<T>> firstThreeNodes() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }

        ArrayList<LinearNode<T>> list = new ArrayList<LinearNode<T>>();

        LinearNode<T> node = front; // set node to front
        int n = 1; // set n to 1

        while (n <= 3 && node != null) {
            list.add(node);
            n++;
            node = node.getNext();
        }

        return list;
    }
}
