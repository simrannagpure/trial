package linkedlist.doublyLinkedList;

import org.w3c.dom.Node;

public class doublyLinkedList {
    Node head;
    Node tail;
    int size;

    private class Node{
        int val;
        Node next;
        Node prev;

        Node(int val){
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
    public void display(){                  //head to tail print
        Node temp = this.head;
        while (temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void displayreverse(){           // tail to head print
        Node temp = this.tail;
        while (temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }
    public int size(){
        return this.size;
    }
    public int getfirst() throws Exception{
        Node firstNode = this.head;
        if(firstNode != null){
            return firstNode.val;
        }
        else{
            throw new Exception("List is empty");
        }
    }
    public int getLast() throws Exception{
        Node lastNode = this.tail;
        if(lastNode != null){
            return lastNode.val;
        }
        else {
            throw new Exception("List is empty");
        }
    }
    public int getValAt(int index) throws Exception{
        if(this.size == 0){
            throw new Exception("List is empty");
        }
        if(index < 0 || index >=size){
            throw new Exception("Index out of bound" + "Index of " + index + ", size " + this.size);
        }
        Node temp = this.head;
        while(index-- != 0){
            temp = temp.next;
        }
        return temp.val;
    }
    public Node getNodeAt(int index) throws Exception{
        if(this.size == 0){
            throw new Exception("List is empty");
        }
        if(index < 0 || index >=size){
            throw new Exception("Index out of bound" + "Index of " + index + ", size " + this.size);
        }
        Node temp = this.head;
        while(index-- != 0){
            temp = temp.next;
        }
        return temp;
    }
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(this.size == 0){
            this.head = newNode;
            this.tail = newNode;
            this.size = 1;
        } else if (this.size >= 1) {
            newNode.next = this.head;
            this.head.prev = newNode;

            this.head = newNode;
            this.size++;
        }
    }
    public void addLast(int data){
        //create node
        Node newnode = new Node(data);
        //Attach to the chain
        //scenario 1 - size = 0;
        if(this.size == 0){
            this.head = newnode;
            this.tail = newnode;
            this.size = 1;
        }  // scenario 2
        else if (size >= 1) {
            Node tailNode = this.tail;
            tailNode.next = newnode;
            newnode.prev = tailNode;    //this is the only differnce from singly linked list
            //summary
            //update tail pointer
            this.tail = newnode;
            //size
            this.size++;
        }
    }
    public void addAt(int index, int data) throws Exception{
        // scene 1 : if size == 0 && index == 0
        if(this.size == 0 && index == 0){
            this.addFirst(data);
        }
        //scene 2 : only index == 0
        if(index == 0){
            this.addFirst(data);
        }
        //scene 3 : index == size
        if(index == this.size){
            this.addLast(data);
        }
        //scene 4 : index out of bound
        if(index < 0 || index > this.size){
            throw new Exception("Index out of bound" + "Index of " + index + ", size " + this.size);
        }
        //scene 5 : general case - 5 steps
        //step 1 : create node to attach
        Node newNode = new Node(data);
        //step 2 : Find previous node
        Node previousNode = getNodeAt(index-1);
        Node toBeReplaceNode = previousNode.next;
        //Step 3 : next(previousNode) = newNode
        previousNode.next = newNode;
        //step 4 : prev(newNode) = previousNode
        newNode.prev = previousNode;
        //step 5 : prev(toBeReplaceNode) = newNode
        toBeReplaceNode.prev = newNode;
        //step 6 : next(newNode) = toBeReplaceNode
        newNode.next = toBeReplaceNode;
        //step 7 : update summary - size increment
        this.size++;
    }
    public int middleNode(){
        Node fastPinter = this.head;
        Node slowPointer = this.head;
        while (fastPinter != null && fastPinter.next != null){
            fastPinter = fastPinter.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer.val;
    }
    public int nthElementFromLast(int n){
        Node aheadPointer = this.head;
        Node slowPointer = this.head;
        while (n != 0){
            aheadPointer = aheadPointer.next;
            n--;
        }
        while (aheadPointer != null){
            aheadPointer = aheadPointer.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer.val;
    }
    public Node nthNodeFromLast(int n){
        Node aheadPointer = this.head;
        Node slowPointer = this.head;
        while (n != 0){
            aheadPointer = aheadPointer.next;
            n--;
        }
        while (aheadPointer != null){
            aheadPointer = aheadPointer.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }
    public void deletenthElementFromLast(int n){
        Node nplusOneNodeFromLast = nthNodeFromLast(n+1); // 1 2 3 4 5 6
        Node nodeToBeDeleted = nplusOneNodeFromLast.next;
        Node nodeToBeAttached = nodeToBeDeleted.next;

        nplusOneNodeFromLast.next = nodeToBeAttached;
    }
    public Node removenthNodeFromLastDummyNode(int n, Node head){                //dummyNode if list is null or empty
        Node dummyNode = new Node(-1000);
        dummyNode.next = head;
        Node aheadPointer = dummyNode;
        Node slowPointer = dummyNode;

        while (n != -1){
            aheadPointer = aheadPointer.next;
            n--;
        }
        while (aheadPointer != null){
            aheadPointer = aheadPointer.next;
            slowPointer = slowPointer.next;
        }
        slowPointer.next = slowPointer.next.next;
        return dummyNode.next;
    }
    public boolean isCyclic(){
        Node dummyNode = new Node(-1000);
        dummyNode.next = head;

        Node fastPointer = dummyNode;
        Node slowPointer = dummyNode;

        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(slowPointer == fastPointer){
                return true;
            }
        }
        return false;
    }
}
