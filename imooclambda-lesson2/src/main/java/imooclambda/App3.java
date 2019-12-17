package imooclambda;

import java.util.ArrayList;
import java.util.List;

/**
 * 表达式类型检查
 */
public class App3 {

    public static void test(MyInterface<String, List> inter) {
        List<String> list = inter.strategy("hello",new ArrayList());
        System.out.println(list);
    }

    public static void main(String[] args) {
        // 1.实现接口
        test(new MyInterface<String, List>() {
            @Override
            public List strategy(String s, List list) {
                list.add(s);
                return list;
            }
        });
        // 2.lambda表达式实现接口
        test((x, y) -> {
            y.add(x);
            return y;
        });
        /**
         * （x,y）->{...} --> test(param) --> param==MyInterface --> lambda表达式 -> MyInterface类型
         * 这个就是对于lambda表达式的类型检查，MyInterface接口就是lambda表达式的目标类型(target typing)
         *
         * (x,y) ->{..} --> MyInterface.strategy(T t,R r)--> MyInterface<String,List> inter
         *      --> T==String R==List --> lambda--> (x,y) == strategy(T t,R r)--> x==T==String y==R==List
         *      lambda表达式参数的类型检查
         */

    }
}

@FunctionalInterface
interface MyInterface<T, R> {
    R strategy (T t,R r);
}
