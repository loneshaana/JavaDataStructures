package DataStructures;
public class  DoublyLinkedListDemo{

}

class DoublyLinkedList{

    // alway at tail / end
    public void add(int data){
        // is  my root null
            // create not , assign to root and tail
        // add to tail // 

        // Worst
        // traverse till end of list , then add
    }

    public void remove(){

    }
    // add element at index provided
    public void addAtIndex(int data , int index){

    }
    public void removeAtIndex(int data , int index){

    }
}


class DllNode{
    int data;
    DllNode next;
    DllNode previous;

    public DllNode(int data){
        this.data = data;
    }

    public DllNode(int data , DllNode next , DllNode previous){
        this.data  = data;
        this.next  = next;
        this.previous =  previous;
    }
}