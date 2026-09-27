# DAA_Kenzhegali_Aziza_Assignment2

1. Overview
For this project, I had to build three data structures from scratch in Java: a Dynamic Array, a Linked List, and a Min-Heap. The goal was to see how fast they run and if my actual code matches the math (Big-O notation) we learned in class.   

2. Complexity Analysis 
Dynamic Array: Finding an item by index get(index) is super fast O(1). But adding or removing stuff at the very beginning is slow O(n) because you have to push everything else over.
  
Linked List: Finding an item get(index) is slow O(n) because you have to count from the start every time. But adding at the beginning add(0, x) is fast O(1) because you just change one pointer.   

Min-Heap: Adding things insert and taking the smallest thing out extractMin both take O(log n) time. The smallest number is always right at the top, which is O(1) to just look at.   
4. Correctness
I had to prove two of my loops actually work.   

Array Contains: The loop checks each spot one by one. Before it starts, we know the item isn't in the empty spots we haven't checked. Every time it moves to the next spot, if it doesn't find the item, it knows the item wasn't in any of the spots behind it either. When it finishes looking at everything and doesn't find it, we know for sure it's not in the array.

Heap Sift-Up: When I insert a number at the bottom, the tree is fine except maybe that one number is smaller than its parent. The loop checks if it's smaller, and if it is, they swap. It keeps doing this until the number is bigger than its parent or it reaches the top. Since it fixes the only broken part on the way up, the whole heap is correct at the end.

5. Experimental Setup
I tested my code using these rules:   
Sizes of n: I tested with 100, 1,000, 10,000, and 100,000 items.   
Repetitions: I ran every single test 5 times and found the average so a random computer lag wouldn't mess it up.   

Timer: I used System.nanoTime() in Java to track how long the code took.   

Random Seed: I used seed 42 so the random numbers were the exact same every time.   

5. Results
Workload 1 (Array vs List Random Access)
Workload 2 (Array vs List Search)
Workload 3 (Array vs List Insert/Remove at 0)
Workload 4 (Min-Heap insert and extract)

7. Discussion
When I made n really big (like 100,000), the O(n) stuff got really slow. For example, the linked list took way longer to find things than the array. This proves that the Big-O math actually works in real life. One weird thing was that even though searching is technically O(n) for both the array and the list, the array usually finished faster. I learned this is because arrays are stored in a straight line in the computer's memory, so the computer can read it faster than a list which is scattered everywhere.   

8. Design Recommendations
Use a Dynamic Array for almost everything, especially if you need to look up items by their index number a lot.   

Only use a Linked List if you have a specific program that only ever adds and deletes things from the very front of the line.   

Use a Min-Heap if you are making a program that constantly needs to find the smallest number or highest priority thing really fast.   

8. Conclusion
This homework showed me that picking the right data structure really matters. If you pick a slow one for a big list of items, your program will freeze up. Big-O notation is a good rule of thumb, but how the computer's memory actually works makes a big difference too.
