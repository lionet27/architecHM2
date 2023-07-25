// Пример реализации паттерна Команда (Command)
// Интерфейс команды
interface Command {
    void execute();
}

// Реализация команды для включения света
class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

// Реализация команды для выключения света
class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

// Класс, который будет управлять командами
class RemoteControl {
    private final Command[] commands;

    public RemoteControl(Command[] commands) {
        this.commands = commands;
    }

    // Метод для выполнения команды по индексу
    public void pressButton(int index) {
        if (index >= 0 && index < commands.length) {
            commands[index].execute();
        }
    }
}

// Класс, который будет управлять светом
class Light {
    private boolean isOn = false;

    public void turnOn() {
        isOn = true;
        System.out.println("Light is on");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Light is off");
    }
}

// Пример использования
public class CommandPatternExample {
    public static void main(String[] args) {
        // Создаем объекты команд и устройства, которое они будут управлять
        Light light = new Light();
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);

        // Создаем пульт управления и добавляем на него команды
        Command[] commands = {lightOnCommand, lightOffCommand};
        RemoteControl remoteControl = new RemoteControl(commands);

        // Выполняем команды по индексу на пульте управления
        remoteControl.pressButton(0); // Включаем свет
        remoteControl.pressButton(1); // Выключаем свет
    }
}
