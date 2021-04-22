package study.part3API.demo10Calendar;

import java.util.Calendar;
import java.util.Date;

public class Demo01 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();

        int month = c.get(1);
        System.out.println(month);

        Date date = new Date();
        System.out.println(date);
        System.out.println(c.getTime());

    }
}
