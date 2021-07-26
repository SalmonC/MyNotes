package study.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author SalmonC
 * @date 2021-06-14 22:31
 */
public class ThrowsTest {

    public static void main(String[] args) {
        try {
            method2(2);
        }catch (NullPointerException e){
            System.out.println("File");
        }
//        catch (IOException e) {
//            System.out.println("IO");
//        }
    }

    public static void method2(int n){
        method1(n);
    }

    public static void method1(int n){
        if (n == 1) {
            //throw new IOException();
        }else {
            throw new NullPointerException();
        }
    }
}
