public class DoubleStackArray {
    private int[] Arr;
    private int top = -1;
    private int bottomSize;

    DoubleStackArray(int capacity) {
        Arr = new int[capacity];
        bottomSize = capacity; //Set bottom of stack to length of list
    }

    public int topSize() {
        return (top + 1); //top is the index values for the list, and topSize returns the length.
    }

    public void pushStackOne(int value) throws IllegalStateException {
        if (topSize() == bottomSize) //If the length of the left(top) values equal the right(bottom) size, that means the stacks have collided and cannot add anymore to either.
            throw new IllegalStateException("StackOverflowException");

        //Move the value onto the top of the stack and add one
        top++;
        Arr[top] = value;
    }

    public void pushStackTwo(int value) throws IllegalStateException {
        if (topSize() == bottomSize) //If the length of the left(top) values equal the right(bottom) size, that means the stacks have collided and cannot add anymore to either.
            throw new IllegalStateException("StackOverflowException");

        //Move the value onto the bottom of the stack and subtract one
        bottomSize--;
        Arr[bottomSize] = value;
    }

    public int popStackOne() {
        if (isStackOneEmpty())
            throw new IllegalStateException("StackEmptyException");

        //Removes one from the right of list, therefore it subtracts from top
        int topVal = Arr[top];
        top--;
        return topVal;
    }

    public int popStackTwo() {
        if (isStackTwoEmpty())
            throw new IllegalStateException("StackEmptyException");

        //Removes one from the right(bottom) of list, therefore it adds to bottom
        int bottomVal = Arr[bottomSize];
        bottomSize++;
        return bottomVal;
    }

    public boolean isStackOneEmpty() {
        return (top == -1);
    }

    public boolean isStackTwoEmpty() {
        return (bottomSize == Arr.length);
    }

    public static void main(String[] args) {

        DoubleStackArray doubleStackArray = new DoubleStackArray(10);

        //Stack 1 from the front of array
        doubleStackArray.pushStackOne(1);
        doubleStackArray.pushStackOne(3);
        doubleStackArray.pushStackOne(5);
        doubleStackArray.pushStackOne(7);

        //Stack 2 from the back of array
        doubleStackArray.pushStackTwo(2);
        doubleStackArray.pushStackTwo(4);
        doubleStackArray.pushStackTwo(6);
        doubleStackArray.pushStackTwo(8);
        doubleStackArray.pushStackTwo(10);
        doubleStackArray.pushStackTwo(12);

        System.out.println("First stack " + doubleStackArray.popStackOne());
        System.out.println("Second stack " + doubleStackArray.popStackTwo());
    }
}
