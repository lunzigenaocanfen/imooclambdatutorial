package imooclambda;

/**
 * 方法重载对于lambda表达式的影响
 */
public class App4 {

    interface Param1 {
        void outInfo(String info);
    }

    interface Param2 {
        void outInfo(String info);
    }

    // 定义重载的方法
    public void lambdaMethod(Param1 param1){
        param1.outInfo("hello1");
    }
    public void lambdaMethod(Param2 param2){
        param2.outInfo("hello2");
    }

    public static void main(String[] args) {
        App4 app4 = new App4();
        app4.lambdaMethod(new Param1() {
            @Override
            public void outInfo(String info) {
                System.out.println(info);
            }
        });

        app4.lambdaMethod(new Param2() {
            @Override
            public void outInfo(String info) {
                System.out.println("调用2");
                System.out.println(info);
            }
        });

        /**
         * lambda表达式存在类型检查-> 自动推到lambda表达式的目标类型
         * lambdaMethod() -> 方法 ->重载方法
         *      ->Param1 函数是接口
         *      ->Param2 函数是接口
         *          调用方法-> 传递lambda表达式 -> 自动推导 ->
         *              -> Param1 | Param2 同时存在，编译不通过,接口入参不同就可以
         *
         */
        /*app4.lambdaMethod((x)->{

        });*/
    }
}
