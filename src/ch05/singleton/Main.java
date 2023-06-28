package ch05.singleton;

public class Main {
    public static void main(String[] args) {
//        // 생성자 private
////        Singleton s1 = new Singleton();
//
//        // static으로 쓸 때와 다른 점은
//        // 우리가 필요한 시점에 생성할 수 있음.
//        // getIntance() 메서드로 생성
//        Singleton s1 = Singleton.getInstance(); // 이떄 객체생성
//        Singleton s2 = Singleton.getInstance(); // 이전 생성된 것을 반환
//        Singleton s3 = Singleton.getInstance(); // 이전 생성된 것을 반환
//        System.out.println(s1); // ch05.singleton.Singleton@682a0b20
//        System.out.println(s2); // ch05.singleton.Singleton@682a0b20
//        System.out.println(s3); // ch05.singleton.Singleton@682a0b20
//        int[] arr = {1, 2, 3, 4, 5};
//        s1.multiply(arr);
//        s2.multiply(arr);

        // 여기서도 Operator(싱글턴)  쓰고 있음
        Test1 t1 = new Test1();
        t1.test();

        // 여기서도 Operator(싱글턴) 쓰고 있는데
        Test2 t2 = new Test2();
        t2.test();

        // 객체는 1회만 생성되었음.
    }
}
