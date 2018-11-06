import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class MyArrayList
{
    private int[] elementData = new int[10];
    private int size = 0;

    /**
     * returns the element at the position pos
     * @param pos determines the position of the element which is to be returned
     * @return the element at the position pos
     */
    public int get(int pos)
    {
        checkPos(pos);
        return elementData[pos];
    }

    /**
     *  adds e to the end of the list
     * @param e gets added the end of the list
     */
    public void add(int e){
        elementData[size] = e;
        size++;
        //Check if array is to small
        if(this.elementData.length <= this.size){
            resize(this.elementData.length*2);
        }
    }

    /**
     * adds element to pos and shifts the following elements one position to the back
     * @param element gets added
     * @param pos determines the position the element gets added to
     */
    public void add(int element, int pos){
        checkPos(pos);
        System.arraycopy(elementData, pos, elementData, pos + 1, size - pos);
        elementData[pos] = element;
        size++;
        //Check if array is to small
        if(this.elementData.length <= this.size){
            resize(this.elementData.length*2);
        }
    }

    /**
     *
     * @param pos
     */
    private void checkPos(int pos)
    {
        if(pos < 0 || pos > this.size){
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * deletes the element at pos and moves all elements one position to the front
     * @param pos determines the position of the element to be determined
     */
    public void delete(int pos){
        checkPos(pos);
        int numMoved = size - pos - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, pos+1, elementData, pos,
                    numMoved);
        elementData[--size] = 0;

        //Check if array is to large
        if(this.size <= this.elementData.length/3){
            resize((int)Math.ceil(this.elementData.length/2.));
        }
    }

    /**
     * deletes the field
     */
    public void clear(){
        elementData = new int[elementData.length];
        size = 0;
    }

    /**
     * returns the number of the contained elements
     * @return the number of the contained elements
     */
    public int size(){
        return size;
    }

    /**
     * returns the size of the array including empty slots
     * @return the size of the array including empty slots
     */
    public int capacity(){
        return elementData.length;
    }

    /**
     * returns the arrays elements in a string
     * @return the arrays elements in a string
     */
    @Override
    public String toString(){
        return Arrays.stream(elementData)
                .limit(size)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    /**
     * returns a clone of the array
     * @return a clone of the array
     */
    public MyArrayList clone(){
        MyArrayList list = new MyArrayList();
        // Set elements
        list.elementData = elementData;
        list.size = size;
        // Copy array
        list.resize(elementData.length);
        return list;
    }

    /**
     *
     * @param i
     */
    private void resize(int i)
    {
        int[] cpy = new int[i];
        System.arraycopy(elementData,0,cpy,0, this.size);
        elementData = cpy;
    }
}
