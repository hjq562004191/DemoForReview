package 生产者消费者模型;

public final class PCData {
    private final int intData;

    public PCData(int intData) {
        this.intData = intData;
    }

    public PCData(String intData) {
        this.intData = Integer.valueOf(intData);
    }

    public int getIntData() {
        return intData;
    }

    @Override
    public String toString() {
        return "data:" + intData;
    }
}
