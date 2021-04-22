package study.part3API.demo11StringBuilder;

public class Demo01 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.capacity());

        for (int i = 0; i < 5; i++) {

            sb.append(1 == 2);
        }
        System.out.println(sb.capacity());
        System.out.println(sb.charAt(2));

    }

}
