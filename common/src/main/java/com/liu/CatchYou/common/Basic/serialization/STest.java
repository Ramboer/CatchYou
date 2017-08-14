package com.liu.CatchYou.common.Basic.serialization;

import java.io.*;

/**
 * Created by simon.liu on 2017/8/14.
 */
public class STest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("dw", "22", "3.0");
        File file = new File("D:\\output\\student.obj");
        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(student);
        oos.flush();
        oos.close();
        fos.close();

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student student1 = (Student) ois.readObject();
        System.out.println(student1.getName());
        System.out.println(student1.getAge());
        System.out.println(student1.getGpa());
        ois.close();
        fis.close();
    }
}
