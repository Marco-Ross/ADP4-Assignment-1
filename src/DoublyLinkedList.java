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

    public boolean compareWithReverse(DoublyLinkedList compareNode) {
        int compareCounter = 0;

        while (compareNode.tail != null && head != null && compareNode.tail.value == head.value) {
            compareNode.tail = compareNode.tail.prev;
            head = head.next;

            compareCounter++;
        }

        if (compareCounter != compareNode.size)
            return false;

        return true;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        for (int i = 0; i<1000000; i++)
            list.add(i);

//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);

        DoublyLinkedList reverseList = new DoublyLinkedList();

        for (int i = 1000000; i>=0; i--)
            list.add(i);

//        reverseList.add(5);
//        reverseList.add(4);
//        reverseList.add(3);
//        reverseList.add(2);
//        reverseList.add(1);
//        reverseList.add(1);

        long startTime = System.nanoTime();

        if (list.compareWithReverse(reverseList))
            System.out.println("Is Match");
        else
            System.out.println("Is Not Match");

        long stopTime = System.nanoTime();

        System.out.println(stopTime - startTime + " Nano seconds.");
    }
}
