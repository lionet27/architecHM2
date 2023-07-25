//Пример реализации паттерна Итератора

// Интерфейс Итератора

import java.util.NoSuchElementException;

interface Iterator<T> {
    boolean hasNext();
    T next();
}

// Конкретный класс Итератора
class ArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int index = 0;

    public ArrayIterator(T[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[index++];
    }
}

// Пример использования
public class IteratorPatternExample {
    public static void main(String[] args) {
        String[] names = {"John", "Mike", "Anna"};

        Iterator<String> iterator = new ArrayIterator<>(names);

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println("Hello, " + name + "!");
        }
    }
}

// Output:
// Hello, John!
// Hello, Mike!
// Hello, Anna!