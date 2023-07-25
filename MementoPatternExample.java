// Пример реализации паттерна Памятка (Memento)
// Интерфейс хранителя состояния

import java.util.ArrayList;
import java.util.List;

interface Memento {
    // Метод для получения сохраненного состояния
    String getState();
}

// Реализация хранителя состояния
class ConcreteMemento implements Memento {
    private final String state;

    public ConcreteMemento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// Интерфейс создателя, который может создавать хранители состояния и восстанавливать состояние из хранителя
interface Originator {
    // Метод для сохранения состояния в хранителе
    Memento save();

    // Метод для восстановления состояния из хранителя
    void restore(Memento memento);

    // Метод для изменения состояния объекта
    void setState(String state);

    // Метод для получения текущего состояния объекта
    String getState();
}

// Реализация создателя
class ConcreteOriginator implements Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento save() {
        return new ConcreteMemento(state);
    }

    public void restore(Memento memento) {
        state = memento.getState();
    }
}

// Интерфейс опекуна, который управляет хранителями состояния
interface Caretaker {
    // Метод для сохранения хранителя состояния
    void addMemento(Memento memento);

    // Метод для получения хранителя состояния
    Memento getMemento(int index);
}

// Реализация опекуна
class ConcreteCaretaker implements Caretaker {
    private List<Memento> mementos = new ArrayList<>();

    public void addMemento(Memento memento) {
        mementos.add(memento);
    }

    public Memento getMemento(int index) {
        return mementos.get(index);
    }
}

// Пример использования
public class MementoPatternExample {
    public static void main(String[] args) {
        Originator originator = new ConcreteOriginator();
        Caretaker caretaker = new ConcreteCaretaker();

        // Изменяем состояние объекта и сохраняем его
        originator.setState("State 1");
        caretaker.addMemento(originator.save());

        // Изменяем состояние объекта и сохраняем его
        originator.setState("State 2");
        caretaker.addMemento(originator.save());

        // Изменяем состояние объекта и сохраняем его
        originator.setState("State 3");
        caretaker.addMemento(originator.save());

        // Восстанавливаем состояние объекта из хранителя
        originator.restore(caretaker.getMemento(1));
        System.out.println(originator.getState()); // Вывод: State 2
    }
}