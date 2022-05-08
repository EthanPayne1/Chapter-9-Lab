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
*   ✔ 4. Output all the students in priority order (See output example below).
*   ✔ 5. Instantiate a max heap for Student
*   ✔ 6. Pass false to the Student class method setKeyIsId(...)
*   ✔ 7. Pass false to the Student class method setUsePriority(...)
*   ✔ 8. Pass your Heap<Student> variable to readInData(...)
*   ✔ 9. Declare an array of Student
*   ✔ Pass your Heap<Student> variable to heapSort(...). Assign the return value to your Student array
*   ✔ Output the students sorted by GPA in descending order.
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
       //* Instainate a max heap for students 
       Heap<Student> studentHeap = new Heap<Student>(true);

       Student.setKeyIsId(false);
       Student.setUsePriority(false);
       readInData(studentHeap);

       //* Declares an array of students then passes maxStudent to heapSort assigns RV to arrStudent
       Student[] arrStudent = heapSort(studentHeap);
       //arrStudent = heapSort(maxStudent);

       //* Outputs the students sorted by GPA in descending order.
       System.out.println('\n' + "Students descending sort by GPA:");
       for(Student newStudent: arrStudent) {
           System.out.println(newStudent);
       } 
       //Student[] student = arrStudent;
       //System.out.println(student);
    }
   
/** 
* 
* !public static Student[] heapSort(Heap<Student> studentHeap)
* !You should do the following in the heapSort method
*   ✔ 1. Using the clone(...) method in the class Heap, instantiate a new Heap<Student> assigning a copy of heapStudent
*   ✔ 2. Instantiate an array of Student with the same size as studentHeap
*   ✔ 3. From your copy of studentHeap, remove each Student placing it in the array
*   ✔ 4. Return the array
*/
   public static Student[] heapSort(Heap<Student> studentHeap) {
       Heap<Student> heapStudent = new Heap<>(studentHeap);
       int i = 0; 
       //* Instantiates an array of Student with the same size as studentHeap
       Student[] arrStudent = new Student[heapStudent.size()];
       
       //* Removes each student placing it in the array from the copy of studentHeap 
       while(heapStudent.isEmpty() != true) {
        arrStudent[i] = heapStudent.remove(); i++;
       }
       //* Returns the array Student[] arrStudent
       return arrStudent;
   }
   
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
