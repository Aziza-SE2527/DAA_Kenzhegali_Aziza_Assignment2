public class MinHeap
{
    private int[] heap;
    private int size;

    public MinHeap()
    {
        this.heap = new int[10];
        this.size = 0;
    }

    public void insert(int x)
    {
        if (size == heap.length)
        {
            resize();
        }
        heap[size] = x;
        size++;
        heapifyUp(size - 1);
    }


    public int peekMin()
    {
        if (size == 0)
        {
            throw new IllegalStateException("Heap is empty!");
        }

        return heap[0];
    }

    public int extractMin()
    {
        if (size == 0)
        {
            throw new IllegalStateException("Heap is empty!");
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return min;
    }

    private void heapifyUp(int index)
    {
        int parentIndex=(index-1) /2;
        while(index >0 && heap[index]<heap[parentIndex])
        {
            swap(index,parentIndex);
            index=parentIndex;
            parentIndex=(index-1)/2;
        }
    }

    private void heapifyDown(int index)
    {
        int smallest=index;
        int leftChild=2*index + 1;
        int rightChild =2*index + 2;
        if(leftChild< size && heap[leftChild]<heap[smallest])
        {
            smallest=leftChild;
        }
        if(rightChild<size && heap[rightChild]<heap[smallest])
        {
            smallest=rightChild;
        }
        if (smallest!=index)
        {
            swap(index,smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int index1,int index2)
    {
        int temp=heap[index1];
        heap[index1]=heap[index2];
        heap[index2]=temp;
    }

    private void resize()
    {
        int[] newHeap=new int[heap.length*2];
        for (int i=0;i<heap.length;i++)
        {
            newHeap[i]=heap[i];
        }
        heap=newHeap;
    }
}