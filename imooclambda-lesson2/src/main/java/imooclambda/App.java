package imooclambda;

import com.imooc.IMessageFormat;
import com.imooc.IUserCredential;
import com.imooc.impl.MessageFormatImpl;
import com.imooc.impl.UserCredentialImpl;

import java.util.UUID;
import java.util.function.*;

/**
 * Hello world!
 *
 * 需求改动：
 *      所有的用户验证，可以同时获取用户的验证信息[是否认证成功、成功-返回用户|失败null]
 */
public class App {
    public static void main(String[] args) {
        /**
         * 1.
         * java.util.function提 供了大量的函数式接口
         * Predicate 接收参数T对象，返回一个boolean类型结果
         * Consumer 接收参数T对象，没有返回值
         * Function 接收参数T对象，返回R对象
         * Supplier 不接受任何参数，直接通过get()获取制定类型的对象
         * UnaryOperator 接口参数T对象，执行业务处理后，返回更新后的T对象
         * BinaryOperator 接口接收两个T对象，执行业务处理后，返回一个T对象
         */

        IUserCredential ic = new UserCredentialImpl();
        System.out.println(ic.verifyUser("admin"));
        System.out.println(ic.getCredential("admin"));


        String msg = "hellow world";
        if (IMessageFormat.verifyMessage(msg)) {
            IMessageFormat format = new MessageFormatImpl();
            format.format(msg,"json");
        }

        //匿名内部类，实现接口的抽象方法
        IUserCredential ic2 = new IUserCredential() {
            @Override
            public String verifyUser(String userName) {
                return "admin".equals(userName)?"管理员":"会员";
            }
        };

        System.out.println(ic2.verifyUser("admin"));
        System.out.println(ic2.verifyUser("asd"));

        //lambda表达式，针对函数式接口实现
        IUserCredential ic3 = (String userName) -> {
            return "admin".equals(userName)?"lbd管理员":"lbd会员";
        };
        System.out.println(ic3.verifyUser("admin"));
        System.out.println(ic3.verifyUser("asd"));

        Predicate<String> pre = (String username) -> {
          return "admin".equals(username);
        };
        System.out.println(pre.test("admin"));

        Consumer<String> con = (String message) -> {
            System.out.println("fasong"+message);
            System.out.println("wancheng ");
        };
        con.accept("info");

        Function<String,Integer> fun = (String gender) -> {
            return "male".equals(gender)?1:0;
        };
        System.out.println(fun.apply("male"));
        System.out.println(fun.apply("female"));

        Supplier<String> sup = () -> {
            return UUID.randomUUID().toString();
        };
        System.out.println(sup.get());
        System.out.println(sup.get());
        System.out.println(sup.get());

        UnaryOperator<String> uo = (String img) -> {
            return img+"[100*200]";
        };
        System.out.println(uo.apply("img--"));

        BinaryOperator<Integer> bo = (Integer i1,Integer i2) -> {
            return i1>i2?i1:i2;
        };
        System.out.println(bo.apply(12,13));


        /**
         * lambda表达式的基本语法
         * 1）声明：就是和lambda表达式绑定的接口类型
         * 2）参数：包含在一堆圆括号中，和绑定的接口中的抽象方法中的参数及顺序一致。
         * 3）操作符：->
         * 4）执行代码块：包含在一堆大括号中，出现在操作符号的右侧
         * [接口声明] = (参数) -> {执行代码块};
         *
         */
        // 1
        ILambda1 i1 = () -> {
            System.out.println("test");
        };
        i1.test();
        //只有一行的话
        ILambda1 i2 = () -> System.out.println("test");
        i2.test();
        // 2
        ILambda2 i2l = (String n,int a) -> {
            System.out.println(n+",year:"+a);
        };
        i2l.test("lsq",25);

        ILambda2 i22 = (n, a) -> {
            System.out.println(n+",year:"+a);
        };
        i22.test("lsq",25);
        // 3
        ILambda3 i3 = (x, y)-> {
            return x + y;
        };
        System.out.println(i3.test(11,22));

        ILambda3 i3l = (x, y)-> x + y;
        System.out.println(i3l.test(11,22));
        /**
         * 总结
         * 1.lambda表达式，必须和接口进行绑定
         * 2.lambda表达式的参数，可以附带0个到n个参数，括号中的参数类型可以不用制定
         *      ，jvm在运行时，会自动根据绑定的抽象方法中的参数进行推导
         * 3.lambda表达式的返回值，如果代码块只有一行，并且没有大括号，
         *      不用return关键字，单行代码的执行结果，会自动返回。
         *      如果添加了大括号，或者又多行代码，碧血通过return关键字返回执行结果
         */
    }
    // 没有参数，没有返回值的lambda表达式绑定的接口
    interface ILambda1{
        void test();
    }
    // 带有参数，没有返回值的lambda表达式
    interface ILambda2{
        void test(String name, int age);
    }
    // 带有参数，带有返回值的lambda表达式
    interface ILambda3 {
        int test(int x, int y);
    }

}
