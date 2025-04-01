package data;

public class Bag<T> implements IBag<T> {
    //Capacity
    private static final int DEFAULT_SIZE = 30;
    //Counter
    private int numberOfEntries;
    private T[] bag;

    public Bag(){
        this(DEFAULT_SIZE); //Call Bag(int)
    }

    @SuppressWarnings("unchecked") //Suppress unchecked casting
    public Bag(int size){
        bag = (T[]) new Object[size]; //Java doesn't allow direct creation of generic arrays
        numberOfEntries = 0;
    }

    @Override
    public boolean add(T newEntry) {
        if(isFull()){
            resize(); //If bag is full, then resize method doubles capacity
        }
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0; //Return True or False
    }

    @Override
    public boolean isFull() {
        return numberOfEntries == bag.length; //Return True or False
    }

    @Override
    public T removeByIndex(int index) {
        //Store the item
        T removedEntry = bag[index];

        for(int i = index; i < numberOfEntries - 1; i++){
            bag[i] = bag[i+1]; //Shift the elements
        }
        numberOfEntries--;
        return removedEntry;
    }

    @Override
    public T remove() {
        //Store last item
        T removedEntry = bag[numberOfEntries - 1];
        bag[numberOfEntries - 1] = null; //Make the last item null
        numberOfEntries--;
        return removedEntry;
    }

    @Override
    public void clear() {
        //Make each element null with for loop
        for(int i = 0; i < numberOfEntries; i++){
            bag[i] = null;
        }
        numberOfEntries = 0;
    }

    @Override
    public void displayItems() {
        //Print each item in the array with for loop
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
    //Convert bag to array
    public T[] toArray() {
        T[] result = (T[]) new Object[numberOfEntries]; //Create new array
        for (int i = 0; i < numberOfEntries; i++) {
            result[i] = bag[i]; //Copy each element to new array
        }
        return result;
    }

    @Override
    public boolean contains(T anEntry) {
        //Search each element to find given entry
        for(int i = 0; i < bag.length; i++){
            if(bag[i] == anEntry){
                return true; //If it exists, then return true
            }
        }return false;
    }

    @Override
    public int getIndexOf(T anEntry) {
        //Start with a default index
        int index = 0;
        //Search elements with for loop
        for(int i = 0; i < bag.length; i++){
            if(bag[i] == anEntry){
                return index;
            }else{
                index++; //If item doesn't exist in the default index, then increase the default index value by one
            }
        }return -1; //If entry doesn't exist then return -1
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        //Start with a default frequency value
        int frequency = 0;
        //Search elements in the list, if we find the given entry then frequency++
        for(int i = 0; i < bag.length; i++){
            if(bag[i] == anEntry){
                frequency++;
            }
        }return frequency;
    }

    @Override
    public boolean remove(T anEntry) {
        //Search the find given entry
        for(int i = 0; i < bag.length; i++){
            if(bag[i] == anEntry){ 
                //If entry exists than make it null and decrase numberOfEntries by one
                bag[i] = null;
                numberOfEntries--;
                //After that shift the elements
                for(int j = i; j < bag.length - 1; j++){
                    bag[j] = bag[j+1];
                }
                return true;
            }
        }return false; //If given entry does not exist then return false
    }

    @SuppressWarnings("unchecked")
    public void resize(){
        //Create a new bag with doubled size
        T[] newBag = (T[]) new Object[bag.length * 2];
        //Copy the elements to new bag
        for(int i = 0; i < bag.length; i++) {
            newBag[i] = bag[i];
        }
        //Change bag with the new one
        bag = newBag;
    }
}
