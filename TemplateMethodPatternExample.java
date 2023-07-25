//������ ���������� �������� ��������� ����� (Template Method)
// ����������� ����� � ��������� �������
abstract class AbstractClass {
    // ��������� �����, ������������ ������������������ ���������� ��������
    public void templateMethod() {
        operation1();
        operation2();
        operation3();
    }

    // ����������� ������, ������� ����� ����������� � ���������� �������
    protected abstract void operation1();
    protected abstract void operation2();

    // �����, ������� ����� ���� ������������� � ���������� �������
    protected void operation3() {
        System.out.println("AbstractClass: operation3");
    }
}

// ���������� �����, ����������� ����������� ����� � ��������� �������
class ConcreteClass extends AbstractClass {
    protected void operation1() {
        System.out.println("ConcreteClass: operation1");
    }

    protected void operation2() {
        System.out.println("ConcreteClass: operation2");
    }

    // �������������� ����� �� ������������ ������
    protected void operation3() {
        System.out.println("ConcreteClass: operation3");
    }
}

// ������ �������������
public class TemplateMethodPatternExample {
    public static void main(String[] args) {
        // ������� ������ ����������� ������ � �������� ��� ��������� �����
        ConcreteClass concreteClass = new ConcreteClass();
        concreteClass.templateMethod();
    }
}