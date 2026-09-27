public class DynamicArray
{
    private int[] data;
    private int size;

    public DynamicArray(int size)
    {
        this.data = new int[10];
        this.size = 0;
    }

    public void add(int x)
    {
        if(size==data.length)
            {
            resize();
            }
        data[size] = x;
        size++;
    }

    public int get(int index)
    {
        if(index<0 || index>=size)
        {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        return data[index];
    }

    public boolean contains(int x)
    {
        for(int i=0;i<size;i++)
        {
            if(data[i]==x)
            {
                return true;
            }
        }
        return false;
    }

    public void remove(int index,int x)
    {
        if(index<0 || index>=size)
        {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        if (size==data.length)
        {
            resize();
        }
        for(int i=size;i>index;i--)
        {
            data[i] = data[i-1];
        }
        data[index] = x;
        size++;
    }


    public void resize() {
        int[] newData = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}
