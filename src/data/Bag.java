package data;

public class Bag<T> implements IBag<T> {
    private static final int DEFAULT_SIZE = 30;
    private int numberOfEntries;
    private T[] bag;

    public Bag(){
        this(DEFAULT_SIZE);
    }

    @SuppressWarnings("unchecked")
    public Bag(int size){
        bag = (T[]) new Object[size];
        numberOfEntries = 0;
    }

    @Override
    public boolean add(T newEntry) {
        if(isFull()){
            resize();
        }
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean isFull() {
        return numberOfEntries == bag.length;
    }

    @Override
    public T removeByIndex(int index) {
        T removedEntry = bag[index];
        for(int i = index; i < numberOfEntries - 1; i++){
            bag[i] = bag[i+1];
        }
        numberOfEntries--;
        return removedEntry;
    }

    @Override
    public T remove() {
        T removedEntry = bag[numberOfEntries - 1];
        bag[numberOfEntries - 1] = null;
        numberOfEntries--;
        return removedEntry;
    }

    @Override
    public void clear() {
        for(int i = 0; i < numberOfEntries; i++){
            bag[i] = null;
        }
        numberOfEntries = 0;
    }

    @Override
    public void displayItems() {
        for(int i = 0; i < numberOfEntries; i++){
            System.out.println(bag[i].toString());
        }
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray() {
        T[] result = (T[]) new Object[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++) {
            result[i] = bag[i];
        }
        return result;
    }

    @Override
    public boolean contains(T anEntry) {
        for(int i = 0; i < bag.length; i++){
            if(bag[i] == anEntry){
                return true;
            }
        }return false;
    }

    @Override
    public int getIndexOf(T anEntry) {
        int index = 0;
        for(int i = 0; i < bag.length; i++){
            if(bag[i] == anEntry){
                return index;
            }else{
                index++;
            }
        }return -1;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        for(int i = 0; i < bag.length; i++){
            if(bag[i] == anEntry){
                frequency++;
            }
        }return frequency;
    }

    @Override
    public boolean remove(T anEntry) {
        for(int i = 0; i < bag.length; i++){
            if(bag[i] == anEntry){
                bag[i] = null;
                numberOfEntries--;
                for(int j = i; j < bag.length - 1; j++){
                    bag[j] = bag[j+1];
                }
                return true;
            }
        }return false;
    }

    @SuppressWarnings("unchecked")
    public void resize(){
        T[] newBag = (T[]) new Object[bag.length * 2];
        for(int i = 0; i < bag.length; i++) {
            newBag[i] = bag[i];
        }
        bag = newBag;
    }
}
