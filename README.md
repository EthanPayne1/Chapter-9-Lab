# Chapter-9-Lab
9.6 Chapter 9 Lab: Heaps and Priority Queues Java
In this lab you will implement a Priority Queue from a Heap. You will then use your Priority Queue with the Student class to output the students two different ways.

You are provided with 8 files:

PriorityQueueDriver.java
IKey.java
Heap.java
IPriority.java
IPriorityQueue.java
PriorityQueue.java
Student.java
students.txt
You will need to implement the following: an interface for priority methods in IPriority, a priority queue in PriorityQueue.java, and the main program in PrioirtyQueueDriver.java. The files IKey.java, Heap.java, IPriorityQueue.java, and Student.java are read only. You do not need to make an implementation changes to these files.

Part 1: Implement IPriority
In the file IPriority.java, you should implement an interface that will need to be used by any data type that contained by the priority queue. Make sure you do each of the following.
1 Write a method declaration for the getter. Use the signature Integer getPriority();
2 Write a method declaration for the setter. Use the signature void setPriority(Integer priority);
Note: This interface will only have two methods.

Part 2: Implement a PriorityQueue
In the file PriorityQueue.java, you should implement a generic priority queue. Make sure you do each of the following.
1 Declare one instance variable of type Heap to store your data
2 Code a one parameter constructor that takes a boolean that indicates whether a lower number should have a higher priority. If the parameter is true, then the constructor should instantiate the Heap as a min heap. If the parameter is false then the constructor should instantiate the heap as a max heap.
3 Code a default constructor. This constructor can simply call the one parameter constructor passing it true or you can have the constructor instantiate the Heap as a min heap since that is the default behavior for a priority queue.
4 Implement the methods in IPriorityQueue. IPriorityQueue has five methods you should implement each one.

Part 3: Implement PriorityQueueDriver Methods
In the file PriorityQueueDriver.java implement the methods main() and heapSort().
1
public static void main(String[] args)
You should do the following in main

1. Instantiate a PriorityQueue<Student>
2. Pass your PrioirtyQueue<Student> variable to readInData(...)
3. Pass the value true to the Student class method setUsePriority(...)
4. Output all the students in priority order (See output example below).
5. Instantiate a max heap for Student
6. Pass false to the Student class method setKeyIsId(...)
7. Pass false to the Student class method setUsePriority(...)
8. Pass your Heap<Student> variable to readInData(...)
9. Declare an array of Student
Pass your Heap<Student> variable to heapSort(...). Assign the return value to your Student array
Output the students sorted by GPA in descending order.
2
public static Student[] heapSort(Heap<Student> studentHeap)
You should do the following in the heapSort method

1. Using the clone(...) method in the class Heap, instantiate a new Heap<Student> assigning a copy of heapStudent
2. Instantiate an array of Student with the same size as studentHeap
3. From your copy of studentHeap, remove each Student placing it in the array
4. Return the array
Ex:

Assume that your students.txt file has the following three students.

3833 3.372 FRESHMAN
8241 3.501 SENIOR
4492 2.698 SOPHOMORE
The output should be the following:

Students will register in the following order:
8241 3.501 Senior
4492 2.698 Sophomore
3833 3.372 Freshman

Students descending sort by GPA:
8241 3.501 Senior
3833 3.372 Freshman
4492 2.698 Sophomore
