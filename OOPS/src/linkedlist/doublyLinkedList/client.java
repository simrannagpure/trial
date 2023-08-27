package linkedlist.doublyLinkedList;

public class client {
    public static void main(String[] args) {
        doublyLinkedList dll = new doublyLinkedList();
        System.out.println(dll);
        dll.addFirst(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.addLast(5);
        System.out.println(dll.size());
        dll.display();
        dll.displayreverse();
        System.out.println(dll.middleNode());
        System.out.println(dll.nthElementFromLast(4));
        dll.deletenthElementFromLast(3);
        dll.display();
        dll.removenthNodeFromLastDummyNode(2, dll.head);
        dll.display();
    }
}
