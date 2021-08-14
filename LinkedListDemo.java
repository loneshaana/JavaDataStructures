package DataStructures;

public class LinkedListDemo {
    public static void main(String[] args) throws Exception {
        // List arr = new ArrayList<>();
        LinkedList list = new LinkedList();
        // System.out.println("First Is my List Empty "+list.isEmpty());
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(100);
        list.add(400);
        list.add(-1);
        // System.out.println("Last Is my List Empty " + list.isEmpty());
        // System.out.println("Size of list is " + list.size());
        // System.out.println("List contains value 600 "+ list.contains(600));
        // System.out.println("Value at index 4 is "+list.get(4));
        list.traverse();
        // list.remove(0);
        list.add(2,600);
        list.traverse();
    }
}

class LinkedList {
    private Node root = null; // object value
    private Node tail = null;
    private int size = 0;

    void traverse() {
        // print each element in linkedList
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println(); // endl // newline
    }

    int size() {
        // int size = 0;
        // Node temp = root;
        // while (temp != null) {
        // size += 1; // increment
        // temp = temp.next;
        // }
        // return size;
        return size;
    }

    boolean isEmpty() {
        return root == null;
    }

    /*
     * Remove Node at index
     */
    void remove(int idx) {
        int index = 0;
        Node temp = root;
        Node previous = root;
        while (temp != null) {
            /**
             * idx = last index
             * 
             */
            if (index == idx) {
                if (index == 0) {
                    // remove root
                    Node newRoot = root.next;
                    root.next = null;
                    root = newRoot;
                } else {
                    // update reference / link
                    previous.next = temp.next;
                    if (idx == size - 1) {
                        // is last element
                        tail = previous;
                    }
                }
                return;
            }
            previous = temp;
            temp = temp.next;
            index += 1;
        }
    }

    void add(int value) {
        Node toAdd = new Node(value); // create node
        if (root == null) {
            tail = toAdd;
            root = toAdd; // first time
        } else {
            tail.next = toAdd;
            tail = toAdd;
        }
        size += 1;
    }

    void add(int index , int value){
        Node nodeToAdd = new Node(value);
        if(index >= size){
            add(value);
            return;
        }
        if(index == 0){
            Node previousRoot = root;
            root = nodeToAdd;
            root.next = previousRoot;
            return;
        }
        int idx = 0;
        Node temp = root;
        Node previous = root;
        while(temp != null){
            if(idx == index){
                // add node here
                Node afterNode = previous.next;
                previous.next = nodeToAdd;
                nodeToAdd.next = afterNode;
                return;
            }
            idx += 1;
            previous = temp;
            temp = temp.next;
        }
    }

    boolean contains(int value) {
        Node temp = root;
        while (temp != null) {
            if (temp.value == value)
                return true;
            temp = temp.next;
        }
        return false;
    }

    /*
     * Return tthe value of the node present at that index
     */
    int get(int index) throws Exception {
        // check
        if (index >= size) {
            throw new IndexOutOfBoundsException(index + " is out of bounds");
        }
        Node temp = root;
        int idx = 0;
        while (temp != null) {
            if (idx == index) {
                return temp.value;
            }
            temp = temp.next;
            idx += 1;
        }
        return -1;
    }
}

class Node {
    int value;
    Node next;// somewhere i have to keep null

    // constructore with 1 parameter
    public Node(int value) {
        this.value = value;
    }

    // constructore with 2 parameter , constructor overloading
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public String toString() {
        return " Node value " + this.value + " " + "Next Node " + this.next;
    }
}