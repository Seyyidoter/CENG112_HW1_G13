package data;

//This interface defines the basic operations of every bag
//Used generic to store any kind of object type
public interface IBag<T> {
    public boolean add(T anEntry);
    public boolean isEmpty();
    public boolean isFull();
    public T removeByIndex(int index);
    public boolean remove(T anEntry);
    public T remove();
    public int getFrequencyOf(T anEntry);
    public int getIndexOf(T anEntry);
    public boolean contains(T anEntry);
    public void clear();
    public void displayItems();
    public int getCurrentSize();
    public T[] toArray();
}
