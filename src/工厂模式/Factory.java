package 工厂模式;

public class Factory {
    public static FruitFactory getresult(String name) {
        FruitFactory fruit = null;
        switch (name) {
            case "apple":
                fruit = new apple();
                break;
            case "banan":
                fruit = new banan();
                break;
        }
        return fruit;
    }
}
