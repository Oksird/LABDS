import org.w3c.dom.Node;
import java.io.*;

import java.util.ArrayList;

public class MainHash {
    public static void main(String[] args) {
        var hashTable = new HashTableOpen();
        LinkedList linkedList = new LinkedList();
        hashTable.Put("1","Maxim");
        hashTable.Put("2","Sergey");
        hashTable.Put("3","Alex");
        System.out.println(hashTable.Get("1"));
        System.out.println(hashTable.Get("2"));
        System.out.println(hashTable.Get("3"));
        linkedList.insert(linkedList,2);
        linkedList.insert(linkedList,3);
        linkedList.insert(linkedList,4);
        linkedList.printList(linkedList);
    }
}

class HashTableOpen{
    private String key;
    private String value;
    private ArrayList list = new ArrayList();

    public void Put(String key,String value){
        list.add(key);
        list.add(value);
    }

    public String Get(String key){
        if(list.contains(key)){
            return (String) list.get(list.indexOf(key)+1);
        }
        return "List doesn't contain value with your key";
    }

}

class LinkedList {

    Node head;


    static class Node {

        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    public static LinkedList insert(LinkedList list, int data)
    {
        Node new_node = new Node(data);
        new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
        }
        else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;
        }

        return list;
    }

    public static void printList(LinkedList list)
    {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        while (currNode != null) {
            System.out.print(currNode.data + " ");

            currNode = currNode.next;
        }

        System.out.println();
    }

    public static LinkedList deleteAtPosition(LinkedList list, int index)
    {

        Node currNode = list.head, prev = null;

        if (index == 0 && currNode != null) {
            list.head = currNode.next;

            // Display the message
            System.out.println(index + " position element deleted");

            return list;
        }

        int counter = 0;
        while (currNode != null) {

            if (counter == index) {
                prev.next = currNode.next;

                System.out.println(index + " position element deleted");
                break;
            }
            else {

                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        if (currNode == null) {

            System.out.println(index + " position element not found");
        }

        return list;
    }



}

