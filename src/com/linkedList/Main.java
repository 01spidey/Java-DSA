package com.linkedList;

import java.util.Scanner;

class ListEmptyException extends Exception{
    ListEmptyException(){
        super("List is Empty!!");
    }

    void printMsg(){
        System.out.println("Exception : The List is Empty!!");
    }
}

interface LinkedList{
//    INSERTION
    void append(int data);
    void insert(int pos, int data);
    void insertAtMiddle(int data);

//    TRAVERSAL
    void traverse() throws ListEmptyException;

//    DELETION
    void deleteByIndex(int pos);
    void deleteByElement(int data);
    void deleteFromMiddle();
    void deleteHead() throws ListEmptyException;
    Node pop() throws ListEmptyException;

//    SEARCHING
    int search(int data);

//    SORTING
    void sort(boolean reverse);

//    OTHERS
    int getLength();
    Node getNode(int index);
}

interface Node{
    int getData();
    void setData(int data);
}

class SinglyLinkedListNode implements Node{
    private int data;
    private SinglyLinkedListNode next;

    SinglyLinkedListNode(int data){
        this.data = data;
        this.next = null;
    }

    @Override
    public int getData() {
        return data;
    }

    @Override
    public void setData(int data) {
        this.data = data;
    }

    SinglyLinkedListNode getNext(){
        return this.next;
    }

    void setNext(SinglyLinkedListNode node){
        this.next = node;
    }
}

class DoublyLinkedListNode implements Node{
    private int data;

    DoublyLinkedListNode(int data){
        this.data = data;
    }

    @Override
    public int getData() {
        return 0;
    }

    @Override
    public void setData(int data) {
        this.data = data;
    }
}

class CircularSinglyLinkedListNode implements Node{
    private int data;

    CircularSinglyLinkedListNode(int data){
        this.data = data;
    }

    @Override
    public int getData() {
        return 0;
    }

    @Override
    public void setData(int data) {
        this.data = data;
    }
}

class CircularDoublyLinkedListNode implements Node{
    private int data;

    CircularDoublyLinkedListNode(int data){
        this.data = data;
    }

    @Override
    public int getData() {
        return this.data;
    }

    @Override
    public void setData(int data) {
        this.data = data;
    }
}

class SinglyLinkedList implements LinkedList{
    private SinglyLinkedListNode head;
    
    SinglyLinkedList(int head){
        this.head = new SinglyLinkedListNode(head);
    }

//    DONE
    SinglyLinkedListNode getHead() throws ListEmptyException{
        if(this.head==null) throw new ListEmptyException();
        return this.head;
    }

//    DONE
    public void setHead(int data){
        SinglyLinkedListNode newHead = new SinglyLinkedListNode(data);
        if(this.head!=null) newHead.setNext(this.head);
        this.head = newHead;
    }

//    DONE
    @Override
    public void append(int data){
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        if(this.head==null) {
            this.head = newNode;
            return;
        }

        SinglyLinkedListNode curNode = this.head;
        
        while(curNode.getNext()!=null) {
            curNode = curNode.getNext();
        }

        curNode.setNext(newNode);
    }

    @Override
    public void insert(int pos, int data) {

    }

    @Override
    public void insertAtMiddle(int data) {

    }

//    DONE
    @Override
    public void traverse() throws ListEmptyException{
        if(this.head==null) throw new ListEmptyException();

        SinglyLinkedListNode curNode = this.head;

        while(curNode!=null){
            if(curNode.getNext()!=null) System.out.print(curNode.getData()+" -> ");
            else System.out.println(curNode.getData());
            curNode = curNode.getNext();
        }
    }

    @Override
    public void deleteByIndex(int pos) {

    }

    @Override
    public void deleteByElement(int data) {

    }

    @Override
    public void deleteFromMiddle() {

    }

//    DONE
    @Override
    public void deleteHead() throws ListEmptyException{
        if(this.head==null) throw new ListEmptyException();
        else {
            SinglyLinkedListNode curHead = this.head;

            if (this.head.getNext() != null) this.head = this.head.getNext();
            else this.head = null;

            curHead.setNext(null);

        }
    }

//    DONE
    @Override
    public SinglyLinkedListNode pop() throws ListEmptyException {
        if(this.head==null) throw new ListEmptyException();

        SinglyLinkedListNode curNode = this.head;
        while(curNode.getNext().getNext()!=null) curNode = curNode.getNext();

        SinglyLinkedListNode poppedNode = curNode.getNext();

        curNode.setNext(null);

        return poppedNode;
    }

//    DONE
    @Override
    public int search(int data){
        SinglyLinkedListNode curNode =  this.head;

        int pos = 0;

        while(curNode!=null){
            if(curNode.getData()==data) return pos;
            curNode = curNode.getNext();
            pos++;
        }

        return -1;
    }

    @Override
    public void sort(boolean reverse) {

    }

//    DONE
    @Override
    public int getLength() {
        SinglyLinkedListNode curNode = this.head;
        int len = 0;
        while(curNode!=null){
            curNode = curNode.getNext();
            len++;
        }
        return len;
    }

//    DONE
    @Override
    public Node getNode(int index) {
        int len = this.getLength();
        if(index>len-1) throw new IndexOutOfBoundsException();

        SinglyLinkedListNode curNode = this.head;
        int pos = 0;
        while(curNode!=null){
            if(pos==index) return curNode;
            curNode = curNode.getNext();
            pos++;
        }

        return null;
    }
}

class DoublyLinkedList implements LinkedList{

    @Override
    public void append(int data) {

    }

    @Override
    public void insert(int pos, int data) {

    }

    @Override
    public void insertAtMiddle(int data) {

    }

    @Override
    public void traverse() {

    }

    @Override
    public void deleteByIndex(int pos) {

    }

    @Override
    public void deleteByElement(int data) {

    }

    @Override
    public void deleteFromMiddle() {

    }

    @Override
    public void deleteHead() {

    }

    @Override
    public DoublyLinkedListNode pop() {
        return new DoublyLinkedListNode(0);
    }

    @Override
    public int search(int data) {
        return 0;
    }

    @Override
    public void sort(boolean reverse) {

    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public Node getNode(int index) {
        return null;
    }
}

class CircularSinglyLinkedList implements  LinkedList{

    @Override
    public void append(int data) {

    }

    @Override
    public void insert(int pos, int data) {

    }

    @Override
    public void insertAtMiddle(int data) {

    }

    @Override
    public void traverse() {

    }

    @Override
    public void deleteByIndex(int pos) {

    }

    @Override
    public void deleteByElement(int data) {

    }

    @Override
    public void deleteFromMiddle() {

    }

    @Override
    public void deleteHead() {

    }

    @Override
    public CircularSinglyLinkedListNode pop() {
        return new CircularSinglyLinkedListNode(0);
    }

    @Override
    public int search(int data) {
        return 0;
    }

    @Override
    public void sort(boolean reverse) {

    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public Node getNode(int index) {
        return null;
    }
}

class CircularDoublyLinkedList implements LinkedList{

    @Override
    public void append(int data) {

    }

    @Override
    public void insert(int pos, int data) {

    }

    @Override
    public void insertAtMiddle(int data) {

    }

    @Override
    public void traverse() {

    }

    @Override
    public void deleteByIndex(int pos) {

    }

    @Override
    public void deleteByElement(int data) {

    }

    @Override
    public void deleteFromMiddle() {

    }

    @Override
    public void deleteHead() {

    }

    @Override
    public CircularDoublyLinkedListNode pop() {
        return new CircularDoublyLinkedListNode(0);
    }

    @Override
    public int search(int data) {
        return 0;
    }

    @Override
    public void sort(boolean reverse) {

    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public Node getNode(int index) {
        return null;
    }
}

public class Main {

    public static int askFirst(){
        return 0;
    }

    public static void main(String[] args) {
	// write your code here
        try{
            Scanner scn = new Scanner(System.in);

            SinglyLinkedList singlyLinkedList = new SinglyLinkedList(1);

            boolean isRunning = true;
            char op = 0;
            int val = 0;

            SinglyLinkedListNode head = singlyLinkedList.getHead();

            System.out.println("The Head of the Singly Linked List is : "+head.getData());

        singlyLinkedList.append(2);
        singlyLinkedList.append(3);
        singlyLinkedList.append(4);
        singlyLinkedList.append(5);
        singlyLinkedList.append(6);
        singlyLinkedList.append(7);

        singlyLinkedList.traverse();

        singlyLinkedList.setHead(0);

        singlyLinkedList.traverse();

        singlyLinkedList.pop();

        singlyLinkedList.traverse();

        singlyLinkedList.deleteHead();

        singlyLinkedList.traverse();

        System.out.println("The value of Node at Index 4 is : "+singlyLinkedList.getNode(4).getData());

//        String welComeMessage = "\n------------------------ Welcome to LinkedList Console App ------------------------\n" +
//                "\nDescription :\n" +
//                "\t- A linked list is a linear data structure, in which the elements are not stored at contiguous memory locations.\n\t- The elements in a linked list are linked using pointers." +
//                "\n\nTypes of Linked Lists :\n\ta. Singly Linked List\n\tb. Doubly Linked List\n\tc. Singly Linked List - Circular\n\td. Doubly Linked List - Circular\n\te. EXIT";
//
//        while (isRunning) {
//            System.out.println(welComeMessage);
//            System.out.println("\nChoose an Linked List Type : ");
//            op = scn.next().charAt(0);
//            switch (op){
//                case 'a':
//                    val = playWithSinglyLinkedList();
//                    if(val==0) isRunning = false;
//
//                    break;
//                case 'b':
//                    break;
//                case 'c':
//                    break;
//                case 'd':
//                    break;
//                case 'e':
//                    isRunning = false;
//                    break;
//                default:
//                    System.out.println("\nChoose an Valid Option!!\n");
//            }
//
//        }

        }
        catch (ListEmptyException exp){
            exp.printMsg();
        }

    }

    public static int playWithSinglyLinkedList(){
        boolean isRunning = true;
        Scanner scn = new Scanner(System.in);
        int op =0;

        while(isRunning){
            System.out.println("1. Singly Linked List :\n\t- A singly linked list is a linear data structure in which the elements are not stored in contiguous memory locations." +
                    "\n\t- Each element in the Linked List is connected only to its next element using a pointer.\n\n\tAvailable Methods : " +
                    "\n\t\t1. Append\n\t\t2. Insert\n\t\t3. Insert At Middle\n\t\t4. Make Head\n\t\t5. Traverse\n\t\t6. Delete By Index\n\t\t7. Delete By Element\n\t\t8. Delete From Middle\n\t\t9. Pop\n\t\t10. Insert\n\t\t11. Search\n\t\t12. Sort\n\t\t13. BACK TO MAIN\n\t\t14. EXIT" +
                    "\n\nChoose an Operation : ");

            op = scn.nextInt();

            switch (op){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;

                case 11:
                    break;

                case 12:
                    break;

                case 13:
                    isRunning = false;
                    break;

                case 14:
                    return 0;

                default:
                    System.out.println("\nChoose an Valid Option!!\n");
                    break;
            }

        }

        return -1;
    }

    public static void playWithDoublyLinkedList(){

    }

    public static void playWithCircularlySinglyLinkedList(){

    }

    public static void playWithCircularlyDoublyLinkedList(){

    }

}
