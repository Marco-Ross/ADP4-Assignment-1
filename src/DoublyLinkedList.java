import java.util.concurrent.TimeUnit;

public class DoublyLinkedList {

    private static class Node {
        private Node next;
        private Node prev;
        private int value;

        public Node(int v) {
            value = v;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    //Method for adding nodes at the head of the list.
    public void add(int valueToAdd) {
        Node node = new Node(valueToAdd);

        if (isEmpty())
            tail = head = node;
        else {
            head.prev = node;
            node.next = head;
            head = node;
        }

        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //Method to compare the two lists
    public boolean compareWithReverse(DoublyLinkedList compareNode) {
        if (compareNode.size != size) //If the lists aren't the same size return, since lists cannot be reverse of each other.
            return false;

        //If the tail or head is null, it should break out since there is nothing left in the list
        while (compareNode.tail != null && head != null) {
            if (compareNode.tail.value == head.value) {
                //Set the head to the next value, and the tail to the previous.
                compareNode.tail = compareNode.tail.prev;
                head = head.next;
            } else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime(); //Start timer

        //Set list values
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);list.add(2);list.add(3);
        list.add(6);list.add(5);list.add(9);
        list.add(18);list.add(2);

        DoublyLinkedList reverseList = new DoublyLinkedList();
        reverseList.add(2);reverseList.add(18);reverseList.add(9);
        reverseList.add(5);reverseList.add(6);reverseList.add(3);
        reverseList.add(2);reverseList.add(1);

        //Compare
        if (list.compareWithReverse(reverseList))
            System.out.println("Is Match");
        else
            System.out.println("Is Not Match");

        System.out.println();

        long stopTime = System.nanoTime();

        long microSeconds = TimeUnit.NANOSECONDS.toMicros(stopTime - startTime);
        System.out.println(microSeconds + " Micro seconds."); //Display time
    }
}
