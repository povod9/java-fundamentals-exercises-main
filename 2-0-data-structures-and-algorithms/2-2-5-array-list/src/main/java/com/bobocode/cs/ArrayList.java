package com.bobocode.cs;

import com.bobocode.util.ExerciseNotCompletedException;

import java.util.NoSuchElementException;

/**
 * {@link ArrayList} is an implementation of {@link List} interface. This resizable data structure
 * based on an array and is simplified version of {@link java.util.ArrayList}.
 * <p><p>
 * <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com">visit our website</a></strong>
 * <p>
 *
 * @author Serhii Hryhus
 */
public class ArrayList<T> implements List<T> {
    private T[] elementData;
    private int size;
    /**
     * This constructor creates an instance of {@link ArrayList} with a specific capacity of an array inside.
     *
     * @param initCapacity - the initial capacity of the list
     * @throws IllegalArgumentException – if the specified initial capacity is negative or 0.
     */
    public ArrayList(int initCapacity) {
        if(initCapacity <= 0){
            throw new IllegalArgumentException();
        }
        elementData = (T[]) new Object[initCapacity];
    }

    /**
     * This constructor creates an instance of {@link ArrayList} with a default capacity of an array inside.
     * A default size of inner array is 5;
     */
    public ArrayList() {
        this(5);
    }

    /**
     * Creates and returns an instance of {@link ArrayList} with provided elements
     *
     * @param elements to add
     * @return new instance
     */
    public static <T> List<T> of(T... elements) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (T element : elements){
            arrayList.add(element);
        }
        return arrayList;
    }

    /**
     * Adds an element to the array.
     *
     * @param element element to add
     */
    @Override
    public void add(T element) {
        if(size == elementData.length){
           createNewArray();
        }
        elementData[size] = element;
        size++;
    }

    /**
     * Adds an element to the specific position in the array where
     *
     * @param index   index of position
     * @param element element to add
     */
    @Override
    public void add(int index, T element) {
        if(size == elementData.length){
            createNewArray();
        }
        for (int i = size; i > index; i--){
            elementData[i] = elementData[i -1];
        }
        elementData[index] = element;
        size++;
    }

    /**
     * Retrieves an element by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index index of element
     * @return en element
     */
    @Override
    public T get(int index) {
        if(index >= size){
            throw new IndexOutOfBoundsException();
        }
        return elementData[index];
    }

    /**
     * Returns the first element of the list. Operation is performed in constant time O(1)
     *
     * @return the first element of the list
     * @throws java.util.NoSuchElementException if list is empty
     */
    @Override
    public T getFirst() {
        if(size == 0){
            throw new NoSuchElementException();
        }
        return elementData[0];
    }

    /**
     * Returns the last element of the list. Operation is performed in constant time O(1)
     *
     * @return the last element of the list
     * @throws java.util.NoSuchElementException if list is empty
     */
    @Override
    public T getLast() {
        if(size == 0){
            throw new NoSuchElementException();
        }
        return elementData[size - 1];
    }

    /**
     * Changes the value of array at specific position. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   position of value
     * @param element a new value
     */
    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        elementData[index] = element;
    }

    /**
     * Removes an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return deleted element
     */
    @Override
    public T remove(int index) {
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        T result = elementData[index];
        for (int i = index; i < size - 1; i++){
            elementData[i] = elementData[i+1];
        }
        size--;
        return result;
    }

    /**
     * Checks for existing of a specific element in the list.
     *
     * @param element is element
     * @return If element exists method returns true, otherwise it returns false
     */
    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a list is empty
     *
     * @return {@code true} if list is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    /**
     * @return amount of saved elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all list elements
     */
    @Override
    public void clear() {
        for (int i = 0; i < elementData.length; i++){
            elementData[i] = null;
        }
        size = 0;
    }

    private void createNewArray(){
        T[] newArray = (T[]) new Object[elementData.length * 2];
        for (int i = 0; i < size; i ++){
            newArray[i] = elementData[i];
        }
        this.elementData = newArray;
    }
}
