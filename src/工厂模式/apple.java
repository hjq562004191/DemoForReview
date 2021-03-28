package 工厂模式;

public class apple implements FruitFactory {
    @Override
    public String run() {
        return "苹果汁";
    }
}
