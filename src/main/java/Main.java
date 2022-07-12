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
// 추상 메소드는 오버라이딩한 "자식" 클래스에게 만들어야하는 메소드를 알려주는 가이드 같은 존재
// abstract class는 상속 관계를 따지며 해당 관계 내에서의 공통 기능이 필요할 때 사용한다.
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

// =============== interface ==================
// 모든 필드는 public static final(해당 클래스 자체 선언 및 변경 불가) 이며
// 모든 메소드는 public abstract이다. 제어자는 생략 가능.
interface Animal { void cry(); }
interface Animal2 { void cry(); }

// abstract class(추상 클래스)는 단수만이 상속될 수 있지만
// interface는 implements를 통한 다수의 interface를 상속시킬 수 있다.
// interface와 abstract class는 기능적으론 비슷하나 사용 목적에서 확연한 차이가 난다.

// 추상 클래스는 클래스에서 함수를 정의해 같은 이름의 메소드를 호출하면 둘중 어느 클래스의
// 메소드인지 알 수 없는 모호성을 지니기에 다중성을 금한다.
// interface는 애초에 함수의 가이드이기 때문에 두가지 기능이 완성형으로 들어오지 않기 때문에
// 오버라이딩을 할 때 두개의 메소드를 나누지 않고 한번에 설정이 가능하다.
// *즉 interface는 상속 관계에 상관 없이 공통의 기능이 필요할 때 사용하고
// abstract class는 상속 관계를 따지며 해당 관계 내에서의 공통 기능이 필요할 때 사용한다.*
class Cat implements Animal, Animal2 {
    public void cry() { System.out.println("냐옹냐옹!"); }
}

class Dog implements Animal {
    public void cry() { System.out.println("멍멍!"); }
}

class Polymorphism03 {
    public static void main(String[] args) {
        Cat c = new Cat();
        Dog d = new Dog();

        c.cry();
        d.cry();
    }
}
// =============== interface ==================

// =============== inner class ================
class outer {
//    static한 class 주로 outer 클래스의 메소드 역할
     static class inner1 {}
//    local class 외부 접근은 불가하며 지역 내에서만 사용 가능한 클래스
//    local class ex1)
    { class inner2 {} }
//    local class ex2)
    void innerClass() { class inner3{} }
//    익명 클래스인데 계속 에러 뜸.
//    Insect inner4 = new Insect() {void innerFunc() {}};

//    인스턴트 클래스
//    outer클래스 영역에 정의 됐으며 static제어자가 없는 클래스로 인스턴트 생성시 사용 가능.
    class Inner5 {}
}
// =============== inner class ================

// =============== string buffer ===============
class stringBuffer {
//    string buffer클래스는 string과 달리 가변 클래스이다.
//    insert, append와 같은 함수로 값을 추가할 수 있는데 string은 그런 작업이 concat으로만 가능하게 되어있다.
//    불변 클래스는 멀티 쓰레드에서 하나의 객체에 접근하되 다른 객체에 영향을 주기 싫을떄 사용하는데
//    가변 클래스에 비해 불변성이 보장되기 때문에 신뢰할 수 있는 코드를 짤 수 있기 때문이다.
//
//    stringBuffer는 기본 string의 버퍼 사이즈보다 16정도의 크기를 더 가져 추후 변화에 대응할 수 있게 한다.
//    concat은 문자 한글자를 추가할 때마다 메모리 주소를 할당하는데
//    stringBuffer는 버퍼 자체를 수정하기에 속도가 빠르고 메모리 낭비가 없다.
    private void del() {
        StringBuffer str = new StringBuffer("Hello world!");
        System.out.println(str.delete(4, 8)); // Hellrld!
        System.out.println(str.deleteCharAt(1)); // Hllo world!
        System.out.println(str.insert(5, " the")); // Hello the world!
        System.out.println(str.reverse()); // !dlrow olleH
    }
}
// =============== string buffer ===============

// =============== wrapper =====================
class Wrapper02 {
//    타입과 달리 클래스로서 value만 갖는게 아닌 value는 데이터 형식으로 갖고 있으며 ~Value()를 통해 언박싱이 가능하다.
//    선언부터 래퍼 클래스를 쓰거나 Integer클래스를 int변수에 담으면 오토언박싱이 된다.
    public static void main(String[] args) {
        Integer num1 = new Integer(7); // 박싱
        Integer num2 = new Integer(3); // 박싱

        int int1 = num1.intValue();    // 언박싱
        int int2 = num2.intValue();    // 언박싱

        Integer result1 = num1 + num2; // 10
        Integer result2 = int1 - int2; // 4
        int result3 = num1 * int2;     // 21
    }
    public class Wrapper03 {
        public static void main(String[] args) {
            Integer num1 = new Integer(10);
            Integer num2 = new Integer(20);
            Integer num3 = new Integer(10);

            System.out.println(num1 < num2);       // true
            System.out.println(num1 == num3);      // false
            System.out.println(num1.equals(num3)); // true
        }
    }
}
// =============== wrapper =====================
