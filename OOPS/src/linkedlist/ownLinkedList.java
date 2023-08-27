package linkedlist;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
//LinkedList definition -
public class ownLinkedList {
        Node Head;
        Node tail;
        int size;

    private class Node{
        Node Next;
        int value;
        Node(){
        }
        Node(int val){
            this.value = val;
            this.Next = null;
        }
    }
    //default constructor
    ownLinkedList(){

    }
    public void display(){
        Node temp = this.Head;
        while(temp != null){
            System.out.print(temp.value +"->");
            temp = temp.Next;
        }
        System.out.println("null");
    }
    public int size(){
        return this.size;
    }
    public int getFirst() throws Exception {
        Node firstNode = this.Head;
        if(firstNode != null){
            return firstNode.value;
        }else {
            throw new Exception("size of LL is 0 right now");
        }
    }
    public int getLast() throws Exception{
//        Node lastNode = this.tail;
//        if(lastNode != null){
//            return lastNode.value;
//        }else {
//            throw new Exception("size of LL is 0 right now");
//        }
        // ------------ OR ---------//
        if(this.size == 0){
            throw new Exception("size of LL is 0 right now");
        }
        return this.tail.value;
    }
    public int getAt(int index) throws Exception{
        if(size == 0){
            throw new Exception("size of LL is 0 right now");
        }
        if(index <0 || index >=this.size){
            throw new Exception("Index out of bound" + "Index of " + index + ", size " + this.size);
        }
        Node temp = this.Head;
        while (index-- != 0){ //indez != 0 ---------Or -----
            temp = temp.Next;
            //index--;  -----OR-----
        }
        return temp.value;
    }
    //ADD  METHOD
    // ----addLast method ---------
    //SCENARIO ONE - when size is not zero
    //SCENARIO 2 - when size is zero
    // create node - create constructor - attach the Node
    public void addLast(int data){
        //create node and fill the data
        Node newNode = new Node(data);
        //attach the Node
        if(this.size == 0){ //scenario 1
            this.Head = newNode;
            this.tail = newNode;
            this.size = 1;
        }
        else if(this.size > 0){
            Node tailNode = this.tail;
            tailNode.Next = newNode;
            //change the tail pinter to newNode
            this.tail = newNode;
            // change the size
            this.size += 1;
        }
    }
    //addFirst method
    public void addFirst(int data){
        //create Node
        Node newNode = new Node(data);
        //attach to chain
        if(this.size == 0){ //scenario 1
            this.Head = newNode;
            this.tail = newNode;
            this.size = 1;
        }
        else{               //Scenario 2
            newNode.Next = this.Head;
            this.Head = newNode;
            this.size += 1;
        }
    }
    //addAt method
    public void addAt(int index, int data) throws Exception{
        //scenario one - index > size
        if(this.size == 0 && index == 0){
            this.addFirst(data);
            return;
        }
        //scenario two - index smaller than zero or greater than size
        if(index < 0 || index >= this.size){
            throw new Exception("Index out of bound" + "Index:" + index + " size :" + this.size);
        }
        //scnario three - size is not zero & index is not out of bound
        if(index == 0){
            this.addFirst(data);
            return;
        }
        if(index == this.size){
            this.addLast(data);
            return;
        }
        //create node
        Node newNode = new Node(data);
        //Find previous Node
        Node previousNode = this.getNodeAt(index - 1);
        //new node next will be next* of previous Node
        newNode.Next = previousNode.Next;
        //previous Nodes next will be newly created Node
        previousNode.Next = newNode;
        this.size +=1;
    }
    public Node getNodeAt(int index) throws Exception{
        if(size == 0){
            throw new Exception("size of LL is 0 right now");
        }
        if(index <0 || index >=this.size){
            throw new Exception("Index out of bound" + "Index of " + index + ", size " + this.size);
        }
        Node temp = this.Head;
        while (index-- != 0){ //indez != 0 ---------Or -----
            temp = temp.Next;
            //index--;  -----OR-----
        }
        return temp;
    }
    public int removeFirst() throws Exception{
        if(this.size == 0){
            throw new Exception("List is empty");
        }
        int removeValue = this.Head.value;
        if(this.size == 1){
            this.Head = this.tail = null;
        }
        else {
            this.Head = this.Head.Next;
        }
        this.size -=1;
        return removeValue;
    }
    public int removeLast() throws Exception{
        if(this.size == 0){
            throw new Exception("List is Empty");
        }
        int removedValue = this.Head.value;
        if(this.size == 1){
            this.Head = this.tail = null;
        }
        else{
            Node nodeBeforeTail = getNodeAt(this.size - 2);
            nodeBeforeTail.Next = null;
            this.tail = nodeBeforeTail;
        }
        this.size -= 1;
        return removedValue;
    }

    public int deleteAt(int index) throws Exception{
        if(this.size == 0){
            throw new Exception("List is Empty");
        }
        if(index < 0 || index >= this.size){
            throw new Exception("Index out of boind" + "Index :" + index + "size :" + this.size);
        }
        int removedValue = this.Head.value;
        if(index == 0){
            return removeFirst();
        }
        else if(index == this.size -1){
            return removeLast();
        }
        else {
            Node previousNode = this.getNodeAt(index-1);
            Node afterNode = this.getNodeAt(index +1);
            previousNode.Next = afterNode;
        }
        this.size --;
        return removedValue;
    }

}
