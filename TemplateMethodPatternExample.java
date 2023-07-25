//Пример реализации паттерна Шаблонный метод (Template Method)
// Абстрактный класс с шаблонным методом
abstract class AbstractClass {
    // Шаблонный метод, определяющий последовательность выполнения операций
    public void templateMethod() {
        operation1();
        operation2();
        operation3();
    }

    // Абстрактные методы, которые будут реализованы в конкретных классах
    protected abstract void operation1();
    protected abstract void operation2();

    // Метод, который может быть переопределен в конкретных классах
    protected void operation3() {
        System.out.println("AbstractClass: operation3");
    }
}

// Конкретный класс, реализующий абстрактный класс с шаблонным методом
class ConcreteClass extends AbstractClass {
    protected void operation1() {
        System.out.println("ConcreteClass: operation1");
    }

    protected void operation2() {
        System.out.println("ConcreteClass: operation2");
    }

    // Переопределяем метод из абстрактного класса
    protected void operation3() {
        System.out.println("ConcreteClass: operation3");
    }
}

// Пример использования
public class TemplateMethodPatternExample {
    public static void main(String[] args) {
        // Создаем объект конкретного класса и вызываем его шаблонный метод
        ConcreteClass concreteClass = new ConcreteClass();
        concreteClass.templateMethod();
    }
}