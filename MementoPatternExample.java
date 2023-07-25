// ������ ���������� �������� ������� (Memento)
// ��������� ��������� ���������

import java.util.ArrayList;
import java.util.List;

interface Memento {
    // ����� ��� ��������� ������������ ���������
    String getState();
}

// ���������� ��������� ���������
class ConcreteMemento implements Memento {
    private final String state;

    public ConcreteMemento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// ��������� ���������, ������� ����� ��������� ��������� ��������� � ��������������� ��������� �� ���������
interface Originator {
    // ����� ��� ���������� ��������� � ���������
    Memento save();

    // ����� ��� �������������� ��������� �� ���������
    void restore(Memento memento);

    // ����� ��� ��������� ��������� �������
    void setState(String state);

    // ����� ��� ��������� �������� ��������� �������
    String getState();
}

// ���������� ���������
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

// ��������� �������, ������� ��������� ����������� ���������
interface Caretaker {
    // ����� ��� ���������� ��������� ���������
    void addMemento(Memento memento);

    // ����� ��� ��������� ��������� ���������
    Memento getMemento(int index);
}

// ���������� �������
class ConcreteCaretaker implements Caretaker {
    private List<Memento> mementos = new ArrayList<>();

    public void addMemento(Memento memento) {
        mementos.add(memento);
    }

    public Memento getMemento(int index) {
        return mementos.get(index);
    }
}

// ������ �������������
public class MementoPatternExample {
    public static void main(String[] args) {
        Originator originator = new ConcreteOriginator();
        Caretaker caretaker = new ConcreteCaretaker();

        // �������� ��������� ������� � ��������� ���
        originator.setState("State 1");
        caretaker.addMemento(originator.save());

        // �������� ��������� ������� � ��������� ���
        originator.setState("State 2");
        caretaker.addMemento(originator.save());

        // �������� ��������� ������� � ��������� ���
        originator.setState("State 3");
        caretaker.addMemento(originator.save());

        // ��������������� ��������� ������� �� ���������
        originator.restore(caretaker.getMemento(1));
        System.out.println(originator.getState()); // �����: State 2
    }
}