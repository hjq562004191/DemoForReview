package 单例模式;

/**
 * @Author JQiang
 * @create 2021/3/28 10:41
 *
 * 双重检查锁实现单例模式
 */
public class demo01 {
    private static demo01 Instance = null;

    public static demo01 getInstance(){
        if (Instance == null){
            synchronized (demo01.class){
                if (Instance == null){
                    Instance = new demo01();
                }
            }
        }
        return Instance;
    }
}
