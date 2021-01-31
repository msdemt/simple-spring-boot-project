package org.msdemt.simple.redis_kyro.test.osxm;

public class GenericsTypeDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // MyGenericsType myGenericsType = new MyGenericsType();
        // Class cls= myGenericsType.getActualClass();
        // ParameterizedType pt = (ParameterizedType)
        // myGenericsType.getClass().getGenericSuperclass();
        // Class clazz = (Class) pt.getActualTypeArguments()[0];
        // Class clazz = myGenericsType.getTClass();

        MyService myService = new MyService();
        System.out.println(myService.getActualClass());

    }

}