public class Car {
    private String make;
    private String model;
    private int year;
    private boolean isStarted;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.isStarted = false;
    }

    public void start() {
        if (!isStarted) {
            isStarted = true;
            System.out.println("Car started.");
        } else {
            System.out.println("Car is already running.");
        }
    }

    public void accelerate() {
        if (isStarted) {
            System.out.println("Car is accelerating.");
        } else {
            System.out.println("Start the car first.");
        }
    }

    public void brake() {
        if (isStarted) {
            System.out.println("Car is braking.");
        } else {
            System.out.println("Start the car first.");
        }
    }


    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}

