---------------Builder Design Pattern--------------------
Scenario: Create a constructor which contains the all of entity in model
          public class Car {
          
              private String plate;
              private String brand;
              private String model;
              private String color;
              private String carType;
              private double maxSpeed;
              private double torque;
              private int year;
          
              public Car(String plate, String brand, String model, String color, String carType, double maxSpeed, double torque, int year) {
                  this.plate = plate;
                  this.brand = brand;
                  this.model = model;
                  this.color = color;
                  this.carType = carType;
                  this.maxSpeed = maxSpeed;
                  this.torque = torque;
                  this.year = year;
              }
          }
Create a Car:
        public class Main {
            public static void main(String[] args) {
                Car car = new Car("34 ABC 12",
                        "BMW",
                        "i320",
                        "White",
                        "Sport",
                        300,
                        2000,
                        2020);
            }
        }
Result: Create a Car seems very heavy to developer. To avoid this we can use Builder Design Pattern
Builder Design Pattern : Create a static Builder class and use it as a parameter in constructor method. It provide to call entities from the Builder class.
      public class Car {
          private String plate;
          private String brand;
          private String model;
      
          private Car(Builder builder) {
              this.plate = builder.plate;
              this.brand = builder.brand;
              this.model = builder.model;
          }
      
          public String getPlate() {
              return plate;
          }
      
          public String getBrand() {
              return brand;
          }
      
          public String getModel() {
              return model;
          }
      
          public static class Builder {
              private String plate;
              private String brand;
              private String model;
      
              public Builder setPlate(String plate) {
                  this.plate = plate;
                  return this;
              }
      
              public Builder setBrand(String brand) {
                  this.brand = brand;
                  return this;
              }
      
              public Builder setModel(String model) {
                  this.model = model;
                  return this;
              }
      
              public Car build() {
                  return new Car(this);
              }
          }
      }
Create Car with Builder Design Pattern :
      Car car = new Car.Builder()
                .setPlate("34ABC123")
                .setBrand("Ford")
                .setModel("Mustang")
                .build();

      }
Create Car (BDP) with lombok : Add @Builder annotation to model class
      import lombok.Builder;
      
      @Builder
      public class Car {
          private String plate;
          private String brand;
          private String model;
      }

      Car car = Car.builder()
        .plate("34ABC123")
        .brand("Ford")
        .model("Mustang")
        .build();
        
@SuperBuilder: It provides to access parent class features
      import lombok.Builder;
      import lombok.Getter;
      import lombok.Setter;
      import lombok.experimental.SuperBuilder;
      
      @Getter
      @Setter
      @SuperBuilder
      public class Vehicle {
          private String plate;
      }
      
      @Getter
      @Setter
      @SuperBuilder
      public class Car extends Vehicle {
          private String brand;
          private String model;
      }

      Car car = Car.builder()
        .plate("34ABC123")
        .brand("Ford")
        .model("Mustang")
        .build();
