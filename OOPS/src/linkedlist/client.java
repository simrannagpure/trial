package linkedlist;

import java.util.LinkedList;

public class client {
    public static void main(String[] args) throws Exception {
       ownLinkedList list1 = new ownLinkedList();
//        System.out.println(list1.Head);
//        System.out.println(list1.tail);
//        System.out.println(list1.size);
        list1.addFirst(31);
        list1.addFirst(96);
        list1.addAt(0, 61);
        list1.deleteAt(1);
        System.out.println(list1.size);
//        display
        list1.display();

    }
}
