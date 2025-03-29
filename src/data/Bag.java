package data;

public class Bag<T> implements IBag<T> {
    //capacity
    private static final int DEFAULT_SIZE = 30;
    //counter
    private int numberOfEntries;
    private T[] bag;

    public Bag(){
        this(DEFAULT_SIZE); //call Bag(int)
    }

    @SuppressWarnings("unchecked") //suppress unchecked casting
    public Bag(int size){
        bag = (T[]) new Object[size]; //java doesn't allow direct creation of generic arrays
        numberOfEntries = 0;
    }

    @Override
    public boolean add(T newEntry) {
        if(isFull()){
            resize(); // if bag is full, than resize method doubles capacity
        }
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0; //return True or False
    }

    @Override
    public boolean isFull() {
        return numberOfEntries == bag.length; //return True or False
    }

    @Override
    public T removeByIndex(int index) {
        //store the item
        T removedEntry = bag[index];

        for(int i = index; i < numberOfEntries - 1; i++){
            bag[i] = bag[i+1]; //shift the elements
        }
        numberOfEntries--;
        return removedEntry;
    }

    @Override
    public T remove() {
        //store last item
        T removedEntry = bag[numberOfEntries - 1];
        bag[numberOfEntries - 1] = null; // make the last item null
        numberOfEntries--;
        return removedEntry;
    }

    @Override
    public void clear() {
        //make each element null with for loop
        for(int i = 0; i < numberOfEntries; i++){
            bag[i] = null;
        }
        numberOfEntries = 0;
    }

    @Override
    public void displayItems() {
        //print each item in the array with for loop
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
    //convert bag to array
    public T[] toArray() {
        T[] result = (T[]) new Object[numberOfEntries]; //create new array
        for (int i = 0; i < numberOfEntries; i++) {
            result[i] = bag[i]; //copy each element to new array
        }
        return result;
    }

    @Override
    public boolean contains(T anEntry) {
        //search each element to find given entry
        for(int i = 0; i < bag.length; i++){
            if(bag[i] == anEntry){
                return true; //if it exists, than return true
            }
        }return false;
    }

    @Override
    public int getIndexOf(T anEntry) {
        //start with a default index
        int index = 0;
        //search elements with for loop
        for(int i = 0; i < bag.length; i++){
            if(bag[i] == anEntry){
                return index;
            }else{
                index++; //if item doesn't exists in the default index, than increase the default index value by one
            }
        }return -1; //if entry doesn't exists than return -1
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        //start with a default frequency value
        int frequency = 0;
        //search elements in the list, if find the given entry than frequency++
        for(int i = 0; i < bag.length; i++){
            if(bag[i] == anEntry){
                frequency++;
            }
        }return frequency;
    }

    @Override
    public boolean remove(T anEntry) {
        //search the find given entry
        for(int i = 0; i < bag.length; i++){
            if(bag[i] == anEntry){ 
                //if entry exists than make it null and decrase numberOfEntries by one
                bag[i] = null;
                numberOfEntries--;
                //after that shift the elements
                for(int j = i; j < bag.length - 1; j++){
                    bag[j] = bag[j+1];
                }
                return true;
            }
        }return false; //if given entry does not exists than return false
    }

    @SuppressWarnings("unchecked")
    public void resize(){
        //create a new bag with doubled size
        T[] newBag = (T[]) new Object[bag.length * 2];
        //copy the elements to new bag
        for(int i = 0; i < bag.length; i++) {
            newBag[i] = bag[i];
        }
        //change bag with the new one
        bag = newBag;
    }
}
