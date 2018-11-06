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
    
    public int get(int pos){
        return elementData[pos];
    }
    
    public void add(int e){
        elementData[size] = e;
        size++;
        //Check if array is to small
        if(this.elementData.length <= this.size){
            resize(this.elementData.length*2);
        }
    }


    public void add(int element, int index){
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
        //Check if array is to small
        if(this.elementData.length <= this.size){
            resize(this.elementData.length*2);
        }
    }
    
    public void delete(int index){
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                    numMoved);
        elementData[--size] = 0;

        //Check if array is to large
        if(this.size <= this.elementData.length/3){
            resize((int)Math.ceil(this.elementData.length/2.));
        }
    }
    
    public void clear(){
        elementData = new int[elementData.length];
        size = 0;
    }
    
    public int size(){
        return size;
    }
    
    public int capacity(){
        return elementData.length;
    }
    
    @Override
    public String toString(){
        return Arrays.stream(elementData)
                .limit(size)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
    
    public MyArrayList clone(){
        MyArrayList list = new MyArrayList();
        // Set elements
        list.elementData = elementData;
        list.size = size;
        // Copy array
        list.resize(elementData.length);
        return list;
    }
    
    private void resize(int i)
    {
        int[] cpy = new int[i];
        System.arraycopy(elementData,0,cpy,0, this.size);
        elementData = cpy;
    }
}
