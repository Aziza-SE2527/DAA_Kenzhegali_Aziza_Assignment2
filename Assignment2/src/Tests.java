public class Tests
{
    public static void main(String[] args)
    {
        testDynamicArray();
        testLinkedList();
        testMinHeap();
        System.out.println("SUCCESS: All algorithmic correctness tests passed!");
    }

    private static void testDynamicArray()
    {
        DynamicArray da = new DynamicArray();


        da.add(5);
        da.add(10);
        da.add(15);


        da.add(0,1);

        if (da.get(0) != 1) throw new AssertionError("DA boundary insert failed");
        if (da.get(2) != 10) throw new AssertionError("DA general get failed");
        if (!da.contains(10)) throw new AssertionError("DA contains failed");


        int removed =da.remove(1);
        if (removed != 5) throw new AssertionError("DA removal returned wrong element");
        if (da.get(1) != 10) throw new AssertionError("DA shift after removal failed");


        try
        {
            da.get(-1);
            throw new AssertionError("DA failed to catch invalid index");
        }
        catch (IndexOutOfBoundsException e)
        {

        }
    }

    private static void testLinkedList()
    {
        LinkedList ll=new LinkedList();

        ll.add(5);
        ll.add(10);
        ll.add(15);

        ll.add(0,1);

        if (ll.get(0) != 1) throw new AssertionError("LL boundary insert failed");
        if (ll.get(2) != 10) throw new AssertionError("LL general get failed");
        if (!ll.contains(10)) throw new AssertionError("LL contains failed");


        int removed=ll.remove(1);
        if (removed!=5) throw new AssertionError("LL removal returned wrong element");
        if (ll.get(1) != 10) throw new AssertionError("LL pointer shift after removal failed");

        try
        {
            ll.get(100);
            throw new AssertionError("LL failed to catch invalid index");
        }
        catch (IndexOutOfBoundsException e)
        {

        }
    }

    private static void testMinHeap()
    {
        MinHeap heap=new MinHeap();


        heap.insert(10);
        heap.insert(5);
        heap.insert(15);
        heap.insert(5);
        heap.insert(1);

        if (heap.peekMin() != 1)
        {
            throw new AssertionError("Heap peekMin failed");
        }

        int prev= Integer.MIN_VALUE;
        for (int i =0;i< 5;i++)
        {
            int current=heap.extractMin();
            if (current<prev) {
                throw new AssertionError("Heap property violated: "+ current + " is less than " + prev);
            }
            prev=current;
        }
    }
}