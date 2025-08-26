public class Main {
    void show1() {
        System.out.println("I am non static method");
    }

    static void show2() {
        System.out.println("I am static method");
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");

        show2(); //or Main.show2();

        Main.show2();
    }
}