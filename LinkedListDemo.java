package DataStructures;

public class LinkedListDemo {
    public static void main(String[] args) throws Exception {
        // List arr = new ArrayList<>();
        LinkedList<String> list = new LinkedList<>();
        // System.out.println("First Is my List Empty "+list.isEmpty());
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(100);
        // list.add(400);
        // list.add(-1);
        // // System.out.println("Last Is my List Empty " + list.isEmpty());
        // // System.out.println("Size of list is " + list.size());
        // // System.out.println("List contains value 600 "+ list.contains(600));
        // // System.out.println("Value at index 4 is "+list.get(4));
        // list.traverse();
        // // list.remove(0);
        // list.add(2,600);
        // list.traverse();

        list.add("anwar");
        list.add("ball");
        list.add("catch");
        list.add("dgod");
        list.add(0,"z");
        System.out.println("list contians d "+list.contains("d"));
        list.traverse();
        list.remove(0);
        list.traverse();
    }
}

class LinkedList<P> {
    private Node<P> root = null; // object value
    private Node<P> tail = null;
    private int size = 0;

    void traverse() {
        // print each element in linkedList
        Node<P> temp = root;
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
        Node<P> temp = root;
        Node<P> previous = root;
        while (temp != null) {
            /**
             * idx = last index
             * 
             */
            if (index == idx) {
                if (index == 0) {
                    // remove root
                    Node<P> newRoot = root.next;
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

    void add(P value) {
        Node<P> toAdd = new Node<P>(value); // create node
        if (root == null) {
            tail = toAdd;
            root = toAdd; // first time
        } else {
            tail.next = toAdd;
            tail = toAdd;
        }
        size += 1;
    }

    void add(int index , P value){
        Node<P> nodeToAdd = new Node<P>(value);
        if(index >= size){
            add(value);
            return;
        }
        if(index == 0){
            Node<P> previousRoot = root;
            root = nodeToAdd;
            root.next = previousRoot;
            return;
        }
        int idx = 0;
        Node<P> temp = root;
        Node<P> previous = root;
        while(temp != null){
            if(idx == index){
                // add node here
                Node<P> afterNode = previous.next;
                previous.next = nodeToAdd;
                nodeToAdd.next = afterNode;
                return;
            }
            idx += 1;
            previous = temp;
            temp = temp.next;
        }
    }

    boolean contains(P value) {
        Node<P> temp = root;
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
    P get(int index) throws Exception {
        // check
        if (index >= size) {
            throw new IndexOutOfBoundsException(index + " is out of bounds");
        }
        Node<P> temp = root;
        int idx = 0;
        while (temp != null) {
            if (idx == index) {
                return temp.value;
            }
            temp = temp.next;
            idx += 1;
        }
        return null;
    }
}

class Node<T> {
    T value;
    Node<T> next;// somewhere i have to keep null

    // constructore with 1 parameter
    public Node(T value) {
        this.value = value;
    }

    // constructore with 2 parameter , constructor overloading
    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public String toString() {
        return " Node value " + this.value + " " + "Next Node " + this.next;
    }
}