package 单例模式;

/**
 * @Author JQiang
 * @create 2021/3/28 10:45
 */
public class ehan {
    private static ehan instance = new ehan();

    public static ehan getInstance(){
        return instance;
    }
}
