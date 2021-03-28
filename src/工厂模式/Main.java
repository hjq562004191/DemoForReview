package 工厂模式;

public class Main {
    public static void main(String[] args) {
        FruitFactory fruit = Factory.getresult("apple");
        System.out.println(fruit.run());
    }
}
