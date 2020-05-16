import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args)throws IOException {

        int countOfElements = 1000000;
        var random = new Random();

        var queue = new Queue(countOfElements+1);
        var stack = new MyStack(countOfElements+1);

        //Test values
        int array []= new int [countOfElements];
        int capas = array.length;
        for (int i = 0; i <array.length ; i++) {
            array[i] = random.nextInt();
        }
       //Check stack push

        long start = System.currentTimeMillis();

        for(int q = 0; q<array.length;q++){
            stack.Push(array[q]);
        }
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println(" Elements = "+capas+ " Time: " + elapsedTime);

        //Check stack pop
        start = System.currentTimeMillis();
        for(int q = 0; q<array.length;q++){
            stack.Pop();
        }
         end = System.currentTimeMillis();
         elapsedTime = end - start;
        //Check  Queue put
        start = System.currentTimeMillis();
        for(int q = 0; q<array.length;q++){
            queue.Put(array[q]);
        }
        end = System.currentTimeMillis();
        elapsedTime = end - start;
        System.out.println(" Elements = "+capas+ " Time: " + elapsedTime);
        start = System.currentTimeMillis();
        for(int q = 0; q<array.length;q++){
            queue.Take();
        }
        end = System.currentTimeMillis();
        elapsedTime = end - start;
       // writer.writeNext(new String[]{"Время на take " + array.length + " елементов = " + elapsedTime});

    }
}

class MyStack{

    public MyStack(int max) {
        this.maxSize = max;
        stackArray = new int[maxSize];
        top = -1;
    }
    public MyStack() {
        this.maxSize = 1000000;
        stackArray = new int[maxSize];
        top = -1;
    }
    private int maxSize;
    private int top;
    private int size;
    private int[] stackArray;

    public int getTop() {
        return top;
    }

    public int getSize() {
        return size;
    }

    public void Push(int n){
        stackArray[++size] = n;
        top = n;
    }

    public int Pop(){
        return stackArray[size--];
    }

}

class Queue{

    private int size;
    private int[] queue;

    Queue(){
        queue = new int[100000];
        size= 0;
    }
    Queue(int maxSize){
        queue = new int[maxSize];
        size= 0;
    }

    public void Put(int n){
        queue[size] = n;
        size++;

    }
        int i = 0;
    public int Take(){
        return queue[i++];
    }

}
