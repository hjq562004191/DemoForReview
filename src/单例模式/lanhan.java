package 单例模式;

/**
 * @Author JQiang
 * @create 2021/3/28 10:47
 */
public class lanhan {
    private static lanhan instance;

    public static lanhan getInstance(){
        if (instance == null){
            instance = new lanhan();
        }
        return instance;
    }
}
