import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
* !public static void main(String[] args)
* !You should do the following in main
*   ✔ 1. Instantiate a PriorityQueue<Student>
*   ✔ 2. Pass your PrioirtyQueue<Student> variable to readInData(...)
*   ✔ 3. Pass the value true to the Student class method setUsePriority(...)
*   Todo 4. Output all the students in priority order (See output example below).
*   X 5. Instantiate a max heap for Student
*   X 6. Pass false to the Student class method setKeyIsId(...)
*   X 7. Pass false to the Student class method setUsePriority(...)
*   X 8. Pass your Heap<Student> variable to readInData(...)
*   X 9. Declare an array of Student
*   X Pass your Heap<Student> variable to heapSort(...). Assign the return value to your Student array
**/ 

public class PriorityQueueDriver {
   public static void main(String[] args) {
       Scanner scnr = new Scanner(System.in);

       //* Instaniate a PriorityQueue<Student>
       PriorityQueue<Student> pQStudent = new PriorityQueue<>();

       //* Pass your PriortiyQueue<Student> variable to readInData()
       readInData(pQStudent);

       //* Passes true to the Student.setUsePriority which makes boolean usePriortiy true
       Student.setUsePriority(true);
       System.out.println("Students will register in the following order: " + '\n');
       
       //* Outputs all of the students in priority order
       while(pQStudent.isEmpty() != true) {
           System.out.println(pQStudent.pop());
       }



   }
   
/** 
* !Output the students sorted by GPA in descending order.
* !public static Student[] heapSort(Heap<Student> studentHeap)
* !You should do the following in the heapSort method
*   X 1. Using the clone(...) method in the class Heap, instantiate a new Heap<Student> assigning a copy of heapStudent
*   X 2. Instantiate an array of Student with the same size as studentHeap
*   X 3. From your copy of studentHeap, remove each Student placing it in the array
*   X 4. Return the array
*/
  //* public static Student[] heapSort(Heap<Student> studentHeap) {}
   
   private static void readInData(PriorityQueue<Student> students) {
        // Open text file
        int id;
        double gpa;
        String classification;

        try {
            Scanner myReader = new Scanner(new File("students.txt"));
            while (myReader.hasNextLine()) {
                // Each record has three lines
                // First line is id
                id = myReader.nextInt();

                // Second line should be the gpa
                gpa = myReader.nextDouble();

                // Burn the whitespace left by nextDouble
                myReader.nextLine();

                // Third line is classification
                classification = myReader.nextLine();

                // Instantiate a student and put in priority queue
                try {
                    students.push(new Student(id, gpa, Student.Classification.valueOf(classification)));
                }
                catch(IllegalArgumentException e) {
                    System.out.println(classification);
                    System.exit(0);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void readInData(Heap<Student> students) {
        // Open text file
        int id;
        double gpa;
        String classification;

        try {
            Scanner myReader = new Scanner(new File("students.txt"));
            while (myReader.hasNextLine()) {
                // Each record has three lines
                // First line is id
                id = myReader.nextInt();

                // Second line should be the gpa
                gpa = myReader.nextDouble();

                // Burn the whitespace left by nextDouble
                myReader.nextLine();

                // Third line is classification
                classification = myReader.nextLine();

                // Instantiate a student and put in priority queue
                try {
                    students.insert(new Student(id, gpa, Student.Classification.valueOf(classification)));
                }
                catch(IllegalArgumentException e) {
                    System.out.println(classification);
                    System.exit(0);
                }
            }
            myReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
