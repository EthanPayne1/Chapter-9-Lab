/* 
Implement an interface that will need to be used by any data type that contained by the priority queue.
    1.) Write a method declaration for the getter. Use the signature Integer getPriority();
    2.) Write a method declaration for the setter. Use the signature void setPriority(Integer priority);
*/
public interface IPriority<T> {

    Integer getPriority(); 
    void setPriority(Integer priority);
}

