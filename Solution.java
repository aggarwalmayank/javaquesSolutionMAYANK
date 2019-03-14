import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class ComparingStudent implements Comparator<Student> {
    public int compare(Student st1, Student st2) {
        if (st1.getCgpa() > st2.getCgpa()) {
            return -1;
        }
        if (st1.getCgpa() < st2.getCgpa()) {
            return 1;
        }
        if (st1.getName().compareTo(st2.getName()) < 0) {
            return -1;
        }
        if (st1.getName().compareTo(st2.getName()) > 0) {
            return 1;
        }
        if (st1.getToken() < st2.getToken()) {
            return -1;
        }
        if (st1.getToken() > st2.getToken()) {
            return 1;
        }
        return 0;
    }
}

class Student{
    private int token;
    private String name;
    private double cgpa;
    public Student(int id, String name, double cgpa) {
        super();
        this.token = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public int getToken() {
        return token;
    }
    public String getName() {
        return name;
    }
    public double getCgpa() {
        return cgpa;
    }
}
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int allevents = in.nextInt();
        PriorityQueue<Student> queue = new PriorityQueue(allevents, new ComparingStudent());
            while(allevents>0){
            String event = in.next();
            if (event.equals("ENTER")) {
                String name = in.next();
                double cgpa = in.nextDouble();
                int id = in.nextInt();
                Student s = new Student(id, name, cgpa);
                queue.add(s);
            }
            else {
                queue.poll();
            }

            allevents--;
        }
        if (queue.isEmpty()) {
            System.out.println("EMPTY");
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll().getName());
        }
    }
}