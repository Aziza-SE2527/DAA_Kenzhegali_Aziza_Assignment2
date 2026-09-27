import java.util.Random;

public class Benchmark {
    private static final int[] N_VALUES={100, 1000, 10000, 100000};
    private static final int REPETITIONS=5;
    private static final long SEED=42;
    private static final int RAND_BOUND=1000000;

    public static void main(String[] args)
    {
        for (int n: N_VALUES)
        {
            System.out.println("Running benchmarks for N = "+n);
            runWorkload1(n);
            runWorkload2(n);
            runWorkload3(n);
            runWorkload4(n);
        }
    }

    private static void runWorkload1(int n)
    {
        Random rand=new Random(SEED);
        DynamicArray da=new DynamicArray();
        LinkedList ll=new LinkedList();

        for (int i=0;i<n;i++)
        {
            int val= rand.nextInt(RAND_BOUND);
            da.add(val);
            ll.add(val);
        }

        int[] indices=new int[10000];
        for (int i=0;i<10000;i++)
        {
            indices[i]=rand.nextInt(n);
        }

        long daTotalTime= 0,llTotalTime = 0;

        for (int r=0;r<REPETITIONS;r++)
        {
            long start=System.nanoTime();
            for (int i=0;i<10000;i++) da.get(indices[i]);
            daTotalTime+=(System.nanoTime() - start);

            start=System.nanoTime();
            for (int i=0;i<10000; i++) ll.get(indices[i]);
            llTotalTime+=(System.nanoTime()-start);
        }
        System.out.println("W1 - Random Access (10,000 operations)");
        System.out.println("Dynamic Array Avg Time: "+(daTotalTime / REPETITIONS) + " ns");
        System.out.println("Linked List Avg Time:   "+(llTotalTime / REPETITIONS) + " ns\n");
    }

    private static void runWorkload2(int n)
    {
        Random rand =new Random(SEED);
        DynamicArray da= new DynamicArray();
        LinkedList ll =new LinkedList();

        for (int i= 0;i<n;i++)
        {
            int val= rand.nextInt(RAND_BOUND);
            da.add(val);
            ll.add(val);
        }

        int[] searchValues = new int[1000];
        for (int i=0;i<1000;i++)
        {
            searchValues[i]=rand.nextInt(RAND_BOUND);
        }

        long daTotalTime=0,llTotalTime=0;

        for (int r = 0; r < REPETITIONS; r++)
        {
            long start=System.nanoTime();
            for (int i=0;i<1000;i++) da.contains(searchValues[i]);
            daTotalTime+=(System.nanoTime() - start);

            start=System.nanoTime();
            for (int i=0;i<1000;i++) ll.contains(searchValues[i]);
            llTotalTime += (System.nanoTime() - start);
        }
        System.out.println("W2 - Search (1,000 operations)");
        System.out.println("Dynamic Array Avg Time: " + (daTotalTime / REPETITIONS) + " ns");
        System.out.println("Linked List Avg Time:   " + (llTotalTime / REPETITIONS) + " ns\n");
    }

    private static void runWorkload3(int n)
    {
        long daInsert0Time = 0, llInsert0Time = 0;
        long daRemove0Time = 0, llRemove0Time = 0;
        long daInsertMidTime = 0, llInsertMidTime = 0;
        long daRemoveMidTime = 0, llRemoveMidTime = 0;

        for (int r = 0; r < REPETITIONS; r++)
        {

            DynamicArray da0= new DynamicArray();
            LinkedList ll0= new LinkedList();
            for (int i =0;i<n;i++) { da0.add(i); ll0.add(i); }

            long start= System.nanoTime();
            for (int i=0;i<1000;i++) da0.add(0, -1);
            daInsert0Time += (System.nanoTime() - start);

            start= System.nanoTime();
            for (int i=0;i<1000;i++) ll0.add(0, -1);
            llInsert0Time+=(System.nanoTime() - start);

            start = System.nanoTime();
            for (int i=0;i<1000;i++) da0.remove(0);
            daRemove0Time += (System.nanoTime() - start);

            start = System.nanoTime();
            for (int i=0;i<1000; i++) ll0.remove(0);
            llRemove0Time += (System.nanoTime() - start);

            // Middle Index Setup
            DynamicArray daMid=new DynamicArray();
            LinkedList llMid=new LinkedList();
            for (int i=0;i<n;i++) { daMid.add(i); llMid.add(i); }
            int mid=n/2;

            start= System.nanoTime();
            for (int i=0;i<1000;i++) daMid.add(mid, -1);
            daInsertMidTime += (System.nanoTime() - start);

            start = System.nanoTime();
            for (int i = 0; i < 1000; i++) llMid.add(mid, -1);
            llInsertMidTime += (System.nanoTime() - start);

            start = System.nanoTime();
            for (int i = 0; i < 1000; i++) daMid.remove(mid);
            daRemoveMidTime += (System.nanoTime() - start);

            start = System.nanoTime();
            for (int i = 0; i < 1000; i++) llMid.remove(mid);
            llRemoveMidTime += (System.nanoTime() - start);
        }

        System.out.println("W3 - Insertion/Removal (1,000 operations)");
        System.out.println("DA Insert Index 0 Avg: " + (daInsert0Time / REPETITIONS) + " ns");
        System.out.println("LL Insert Index 0 Avg: " + (llInsert0Time / REPETITIONS) + " ns");
        System.out.println("DA Remove Index 0 Avg: " + (daRemove0Time / REPETITIONS) + " ns");
        System.out.println("LL Remove Index 0 Avg: " + (llRemove0Time / REPETITIONS) + " ns");
        System.out.println("DA Insert Middle Avg:  " + (daInsertMidTime / REPETITIONS) + " ns");
        System.out.println("LL Insert Middle Avg:  " + (llInsertMidTime / REPETITIONS) + " ns");
        System.out.println("DA Remove Middle Avg:  " + (daRemoveMidTime / REPETITIONS) + " ns");
        System.out.println("LL Remove Middle Avg:  " + (llRemoveMidTime / REPETITIONS) + " ns\n");
    }

    private static void runWorkload4(int n)
    {
        Random rand=new Random(SEED);
        long totalInsertTime = 0;
        long totalExtractTime = 0;

        for (int r=0;r<REPETITIONS;r++)
        {
            MinHeap heap =new MinHeap();
            int[] data=new int[n];

            for (int i=0;i<n;i++) data[i]=rand.nextInt(RAND_BOUND);

            long start=System.nanoTime();
            for (int i=0;i<n;i++) heap.insert(data[i]);
            totalInsertTime += (System.nanoTime() - start);

            start=System.nanoTime();
            for (int i=0;i<n;i++) heap.extractMin();
            totalExtractTime+=(System.nanoTime() - start);
        }
        System.out.println("W4 - Priority Processing (Min-Heap)");
        System.out.println("Heap Insert Avg:  " +(totalInsertTime / REPETITIONS) + " ns");
        System.out.println("Heap Extract Avg: " +(totalExtractTime / REPETITIONS) + " ns\n");
    }
}