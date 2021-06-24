
package DataStructures;

/**
 * A simple Linear Node for use in linked structures such as lists
 * @author clatulip
 */
public class LinearNode<T> {
   private LinearNode<T> next;
   private LinearNode<T> prev;
   private T element;

   public LinearNode() {
       prev = null;
       next = null;
       element = null;
   }

   public LinearNode(T elem) {
       next = null;
       element = elem;
   }

   public LinearNode<T> getPrev() {
       return prev;
   }

   public void setPrev(LinearNode<T> node) {
       prev = node;
   }

   public LinearNode<T> getNext() {
       return next;
   }

   public void setNext(LinearNode<T> node) {
       next = node;
   }

   public T getElement() {
       return element;
   }

   public void setElement(T elem) {
       element = elem;
   }

   public String toString() {
       return element.toString();
   }
}