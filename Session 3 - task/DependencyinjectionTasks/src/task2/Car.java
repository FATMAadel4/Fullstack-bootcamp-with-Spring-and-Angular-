package task2;

public class Car implements Vehicle{

    public DatabaseOperations databaseOperations;

    private String brand;


    public Car(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }

    public void saveToDatabase(Vehicle vehicle) {
        databaseOperations.save(vehicle);
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    @Override
    public String getBrand() {
        return this.brand;
    }
}

