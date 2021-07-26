package study.Test;

import org.junit.Test;
import study.part2Object.demo03This.Person;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionTest {
    @Test
    public void method() throws Exception {
        Class c = Class.forName("study.part2Object.demo03This.Person");
        System.out.println(c);
        Constructor cons = c.getConstructor(String.class, int.class);
        Person p = (Person) cons.newInstance("小明", 20);
        System.out.println(p);

    }

    @Test
    public void blankCons() throws Exception {
        Class clazz = Class.forName("study.part2Object.demo03This.Person");
        Person p = (Person) clazz.newInstance();
        Method getAge = clazz.getDeclaredMethod("getAge");
        System.out.println(getAge.invoke(p));
        throw new IOException();
    }
}
