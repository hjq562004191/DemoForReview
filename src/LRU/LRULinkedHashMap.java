package LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author JQiang
 * @create 2021/4/6 17:41
 */
public class LRULinkedHashMap{
    public static void main(String[] args){
        LinkedHashMap<Integer,Integer> list = new LinkedHashMap<Integer,Integer>(5,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > 5;
            }
        };
        list.put(1,1);
        list.put(2,2);
        list.put(3,3);
        list.put(4,4);
        list.put(5,5);
        list.put(6,6);
        list.put(7,7);
        list.get(4);
        for (Map.Entry<Integer, Integer> e :
                list.entrySet()) {
            System.out.println(e.getKey());
        }
    }
}
