// ������ ���������� �������� ������� (Command)
// ��������� �������
interface Command {
    void execute();
}

// ���������� ������� ��� ��������� �����
class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

// ���������� ������� ��� ���������� �����
class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

// �����, ������� ����� ��������� ���������
class RemoteControl {
    private final Command[] commands;

    public RemoteControl(Command[] commands) {
        this.commands = commands;
    }

    // ����� ��� ���������� ������� �� �������
    public void pressButton(int index) {
        if (index >= 0 && index < commands.length) {
            commands[index].execute();
        }
    }
}

// �����, ������� ����� ��������� ������
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

// ������ �������������
public class CommandPatternExample {
    public static void main(String[] args) {
        // ������� ������� ������ � ����������, ������� ��� ����� ���������
        Light light = new Light();
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);

        // ������� ����� ���������� � ��������� �� ���� �������
        Command[] commands = {lightOnCommand, lightOffCommand};
        RemoteControl remoteControl = new RemoteControl(commands);

        // ��������� ������� �� ������� �� ������ ����������
        remoteControl.pressButton(0); // �������� ����
        remoteControl.pressButton(1); // ��������� ����
    }
}
