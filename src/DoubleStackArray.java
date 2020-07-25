public class DoubleStackArray {
    private int[] data;
    private int top = -1;
    private static final int capacity = 2;

    DoubleStackArray(int capacity){
        data = new int [capacity];
    }

    DoubleStackArray(){
        this(capacity);
    }

    public int size() {
        return (top + 1);
    }

    public void push(int value) throws IllegalStateException {
        if (size() == data.length)
            throw new IllegalStateException("StackOverflowException");
        top++;
        data[top] = value;
    }

    public void push2(int value) throws IllegalStateException {
        if (size() == data.length)
            throw new IllegalStateException("StackOverflowException");
        top++;
        data[top] = value;
    }

    public int pop( ) {
        if (isEmpty( ))
            throw new IllegalStateException("StackEmptyException");
        int topVal = data[top];
        top--;
        return topVal;
    }
    public boolean isEmpty(){
        return (top == -1);
    }

    public int top( ) throws IllegalStateException {
        if (isEmpty( ))
            throw new IllegalStateException("StackEmptyException");
        return data[top];
    }


    public static void main(String[] args) {

        DoubleStackArray doubleStackArray = new DoubleStackArray();

        doubleStackArray.push(1);

        doubleStackArray.push2(2); //Stack 2 from the back of array



    }
}
