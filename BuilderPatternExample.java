// Пример реализации паттерна Строитель (Builder)

// Класс, объект которого мы будем создавать с помощью паттерна Строитель
class Car {
    private String brand;
    private String model;
    private int year;
    private int engineVolume;
    private boolean hasAirConditioning;

    public Car(String brand, String model, int year, int engineVolume, boolean hasAirConditioning) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineVolume = engineVolume;
        this.hasAirConditioning = hasAirConditioning;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", engineVolume=" + engineVolume +
                ", hasAirConditioning=" + hasAirConditioning +
                '}';
    }
}

// Интерфейс Строителя
interface CarBuilder {
    void setBrand(String brand);
    void setModel(String model);
    void setYear(int year);
    void setEngineVolume(int engineVolume);
    void setHasAirConditioning(boolean hasAirConditioning);
    Car getResult();
}

// Конкретный класс Строителя
class CarBuilderImpl implements CarBuilder {
    private String brand;
    private String model;
    private int year;
    private int engineVolume;
    private boolean hasAirConditioning;

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void setEngineVolume(int engineVolume) {
        this.engineVolume = engineVolume;
    }

    @Override
    public void setHasAirConditioning(boolean hasAirConditioning) {
        this.hasAirConditioning = hasAirConditioning;
    }

    @Override
    public Car getResult() {
        return new Car(brand, model, year, engineVolume, hasAirConditioning);
    }
}

// Директор, который управляет процессом сборки объекта с помощью Строителя
class Director {
    private CarBuilder carBuilder;

    public Director(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public void constructSportsCar() {
        carBuilder.setBrand("Ferrari");
        carBuilder.setModel("F430");
        carBuilder.setYear(2008);
        carBuilder.setEngineVolume(4);
        carBuilder.setHasAirConditioning(false);
    }

    public void constructFamilyCar() {
        carBuilder.setBrand("Toyota");
        carBuilder.setModel("Camry");
        carBuilder.setYear(2015);
        carBuilder.setEngineVolume(2);
        carBuilder.setHasAirConditioning(true);
    }
}

// Пример использования
public class BuilderPatternExample {
    public static void main(String[] args) {
        CarBuilder carBuilder = new CarBuilderImpl();
        Director director = new Director(carBuilder);

        director.constructSportsCar();
        Car sportsCar = carBuilder.getResult();
        System.out.println(sportsCar);

        director.constructFamilyCar();
        Car familyCar = carBuilder.getResult();
        System.out.println(familyCar);
    }
}