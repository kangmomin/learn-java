public class Main {
    public static void main(String[] args) {
//        const != final
//        final은 const와 같이 상수 선언도 해주나
//        오버라이딩을 통한 타입 변경 제선언도 불가함.
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

//    private == 선언된 클래스 내에서만 접근 가능
//    public  == 선언된 클래스를 넘어 다른 패키지에서도 접근 가능
//    default == 선언된 클래스가 있는 패키지 내에서 접근 가능
//    protect == default + 선언된 클래스의 자식 클래스는 다른 패키지에서 접근 가능
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
//    static 변수명 == 클래스 변수
//    프로그램 시작시 선언되며 인스턴스와 관련 없이 프로그램 종료까지 남아있음.
//
//    변수 == 인스턴스 변수
//    해당 클래스를 활용해 만드는 인스턴스가 생성될 때부터 끝날때 까지.
    static void display(int num1) { System.out.println(num1); }
    static void display(int num1, int num2) { System.out.println(num1 * num2); }
    static void display(int num1, double num2) { System.out.println(num1 + num2); }
}

class Method06 {
    void function() {
//        지역 변수는 사용전 초기화 필수
        Test func = new Test();

        func.display(10);
        func.display(10, 20);
        func.display(10, 3.14);
        func.display(10, 'a');
    }
}