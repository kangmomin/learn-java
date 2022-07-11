public class Main {
    public static void main(String[] args) {
//        const != final
//        final은 const와 같이 상수 선언도 해주나
//        오버라이딩을 통한 타입 변경 제선언도 불가함.+
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

        Parent testP = new Parent();
        Parent test = new Child();
        test.display(); // 자식 클래스의 display()
//        메소드 오버라이딩
//        부모 메소드를 같은 이름의 메소드를 자식 메소드에 선언함으로써 덮어씌움.

        Parent test2 = new Brother();
        Parent test3 = new Child();
//        Child test4 = new Brother();
//        Child test5 = new Parent();
//        다향성 / 자식 클래스 끼리는 동일 타입으로 취급하지 않고
//        부모 클래스는 자식클래스로 그대로 대입 가능하며
//        부모 클래스는 자식 클래스에 타입 변환 없이 대입 불가.
        System.out.println(test3 instanceof Parent); // true
        System.out.println(test3 instanceof Child); // true
        System.out.println(testP instanceof Child); // false
    }
}

class Parent {
    void display() { System.out.println("부모 클래스의 display() 메소드입니다."); }
}

class Child extends Parent {
    void display() { System.out.println("자식 클래스의 display() 메소드입니다."); }
}

class Brother extends Parent {
    void display() { System.out.println("형제 클래스의 display() 메소드입니다."); }
}

// 추상 클래스는 추상 메소드를 포함하기 위해 있음
// 추상 메소드는 오버라이딩한 자식 클래스에게 만들어야하는 메소드를 알려주는 가이드 같은 존재
abstract class abstractTest {
    abstract void cry();
    void crying(){};
}

class Car {
//    this == 자기 자신을 가르킴 
//    this()는 생성자를 가르킴
//    super와 super()도 위와 같음

//    private == 선언된 클래스 내에서만 접근 가능
//    public  == 선언된 클래스를 넘어 다른 패키지에서도 접근 가능
//    default == 선언된 클래스가 있는 패키지 내에서 접근 가능
//    protect == default + 선언된 클래스의 자식 클래스는 다른 패키지에서 접근 가능
    static String className;
    public String modelName;
    public int modelYear;

//    ===========클래스 내의 변수를 초기화 해줄 수 있음.=========
//    인스턴스 초기화 블록
    {
        modelYear = 10;
    }

//    클래스 변수 초기화 블록
    static {
        className = "Car";
    }
//    ===========클래스 내의 변수를 초기화 해줄 수 있음.=========

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

// Car클래스의 defualt생성자가 있어야 함(예제에는 없어도 괜찮다 뜨는데 뭐 그렇다고 하니께)
class hisCar extends Car {
    public int c = 0;

    // 이 부분 이 없으면 디폴트 메소드 없다고 에러뜸
    hisCar(String modelName, int modelYear) {
        super(modelName, modelYear);
    }

    void display() {
        new Car("ionic", 2018);
        System.out.println(getModel());
        System.out.println(c);
    }
}

// 메소드 오버로딩 == 같은 이름의 메소드라도 다른 타입을 가지면 사용 가능.
class Test {
//    static 변수명 == 클래스 변수
//    프로그램 시작시 선언되며 인스턴스와 관련 없이 프로그램 종료까지 남아있음.
//
//    변수 == 인스턴스 변수
//    해당 클래스를 활용해 만드는 인스턴스가 생성될 때부터 끝날때 까지.
//    위 내용은 함수(메소드)에도 동일하게 적용됨
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