package LRU;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author JQiang
 * @create 2021/4/6 16:57
 */
public class LRULinkdList {
    static int maxSize = 5;
    public static void main(String[] args){
        List<Integer> list = new LinkedList<>();

        insert(list,1);
        insert(list,2);
        insert(list,3);
        insert(list,4);
        insert(list,5);
        get(3,list);
//        insert(list,maxSize,7);
        for (Integer i :
                list) {
            System.out.println(i);
        }
    }
    public static void insert(List<Integer> list,int num){
        if (maxSize != list.size()){
            list.add(num);
        }else if (list.contains(num)){
            list.remove(list.indexOf(num));
            list.add(num);
        }else {
            list.remove(0);
            list.add(num);
        }
    }
    public static int get(int num,List<Integer> list){
        for (Integer integer:
                list) {
            if (integer == num){
                boolean remove = list.remove(integer);
                insert(list,num);
                return num;
            }
        }
        return -1;
    }
}
