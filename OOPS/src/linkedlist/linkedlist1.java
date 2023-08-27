package linkedlist;

import java.util.LinkedList;

public class linkedlist1 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list);
        list.addFirst("first");
        System.out.println(list);
        list.addLast("HI");
        System.out.println(list);
        System.out.println(list.get(2));
        System.out.println(list.getLast());
        list.remove();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        list.remove("A");
        System.out.println(list);
        System.out.println(list.clone());
    }
}
