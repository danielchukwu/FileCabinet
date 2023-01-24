public class Stack {
    private String[][] array=new String[20][4];
    private int top=-1;
    private int capacity=20;

    private boolean isFull() { return top == capacity - 1; }
    private boolean isEmpty() { return top == -1; }

    String[] pop() {
        if (isEmpty()) { return null; }

        String[] deletedValue = array[top];
        array[top] = null;
        top--;
        return deletedValue;
    }

    void push(String[] value) {
        if (isFull()) { return; }
        top++;
        array[top] = value;
    }

    String[] peek() {
        if (isEmpty()) { return null; }
        return array[top];
    }

//    void printStack() {
//        System.out.print("[ ");
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + ", ");
//        }
//        System.out.println("]");
//    }
}
