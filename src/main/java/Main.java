public class Main {
    public static void main(String[] args) {
//        const
        final int AGES = 100;
//        타입 변환
        System.out.println((double) AGES);
//        해당 코드의 int부분에 class나 interface가 들어갔을떄 변수가
//        class || interface와 같은 타입인지 알려줌.(bool)
        //        System.out.println(AGES instanceof int);

        int[] arr = new int[]{1, 2, 3, 4, 5};
        for (int e : arr) {
            System.out.println(e+" ");
        }
//            1 2 3 4 5 for of?
        Car myCar = new Car("아반떼", 2016);
    }
}

class Car {
//    this == 자기 자신을 가르킴 
//    this()는 생성자를 가르킴
    private String modelName;
    private int modelYear;

//    Car setter
    Car(String modelName, int modelYear) {
//        this == 해당 클래스 내의 변수 사용
        this.modelName = modelName;
        this.modelYear = modelYear;
    }

    public String getModel() {
        return this.modelYear+"년식 "+this.modelName;
    }
}

// 메소드 오버로딩 == 같은 이름의 메소드라도 다른 타입을 가지면 사용 가능.
class Test {
    static void display(int num1) { System.out.println(num1); }
    static void display(int num1, int num2) { System.out.println(num1 * num2); }
    static void display(int num1, double num2) { System.out.println(num1 + num2); }
}

class Method06 {
    public static void main(String[] args) {
        Test func = new Test();

        func.display(10);
        func.display(10, 20);
        func.display(10, 3.14);
        func.display(10, 'a');
    }
}