package ADTs;

import Exceptions.EmptyCollectionException;

public interface TreeADT<T extends Object> extends CollectionADT {

    public T getRootElement() throws EmptyCollectionException;

    public boolean contains(T t);
}