public class DynamicArray
{
    private int[] data;
    private int size;
    private static final int INITIAL_CAPACITY= 10;

    public DynamicArray() {
        data =new int[INITIAL_CAPACITY];
        size= 0;
    }

    private void resize()
    {
        int[] newData =new int[data.length * 2];
        System.arraycopy(data, 0,newData,0, size);
        data =newData;
    }

    public void add(int x)
    {
        if (size== data.length) resize();
        data[size++] = x;
    }


    public void add(int index,int x)
    {
        if (index < 0|| index > size)
        {
            throw new IndexOutOfBoundsException();
        }
        if (size==data.length)
        {
            resize();
        }
        System.arraycopy(data,index, data,index+1, size-index);
        data[index]=x;
        size++;
    }

    public int remove(int index)
    {
        if (index<0||index>=size)
        {
            throw new IndexOutOfBoundsException();
        }
        int removed = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        return removed;
    }

    public int get(int index)
    {
        if(index<0 || index>= size)
        {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    public boolean contains(int x)
    {
        for (int i=0;i<size;i++)
        {
            if (data[i]==x)
            {
                return true;
            }
        }
        return false;
    }
}