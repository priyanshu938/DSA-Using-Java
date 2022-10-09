import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Heap {
    static ArrayList<Integer> list= new ArrayList<>();
    static int size=0;
    public static void main(String[] args) {
        insert(10);
        insert(20);
        insert(15);
        insert(40);
        insert(50);
        insert(100);
        insert(25);
        insert(45);
        insert(12);
        display();
    }
    static int left(int i){
        return 2*i+1;
    }
    static int right(int i){
        return 2*i+2;
    }
    static int parent(int i){
        return ((i-1)/2);
    }
    static void insert(int x){
        size++;
        list.add(x);
        for(int i=size-1;i!=0 && list.get(parent(i))>list.get(i);){
            Collections.swap(list, i,parent(i));
            i=parent(i);            
        }
    }
    static void display(){
        System.out.println(list);
    }
}
