package DataStructures;

public class StackDemo {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++)
            stack.push(i);
        // for (int i = 0; i < 10; i++)
        //     System.out.println(stack.pop());
        System.out.println(stack.top());
    }
}

class Stack<T> implements StackImpl<T> {
    LinkedList<T> list = new LinkedList<>(); // @TODO move to doubly linkedList

    /**
     * timeComplexity = O(1)
     */
    @Override
    public void push(T data) {
        // somewhere i have to store it
        list.add(data);
    }


    // timeComplexity : O(n)
    // timeComplexity : O(1)
    @Override
    public T pop() {
        return list.remove();
    }

    @Override
    public T top(){
        return list.getTailElement();
    }
}

interface StackImpl<T> {
    void push(T data);

    T pop();

    T top();
}

/*
 * LinkedList create add() -> always at tail pop() -> always at tail
 * 
 */