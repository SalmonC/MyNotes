package study.Test;

import org.junit.Test;

import java.util.*;

import study.part6Lambda.Calc.Calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorTest {
    @Test
    public void testAdd(){
        System.out.println("1");
    }

    @Test
    public void insTest(){
        List<Integer> list = new ArrayList<>();
        System.out.println(list instanceof  List);
        System.out.println(list instanceof Collection);
    }
}
