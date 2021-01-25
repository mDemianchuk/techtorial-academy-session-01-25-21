package com.techtorial.academy;

class Car {
    private final static int LOWER_SPEED_LIMIT = 45;
    private final static int UPPER_SPEED_LIMIT = 75;
    private int speed;

    public Car() {
        this.speed = LOWER_SPEED_LIMIT;
    }

    public void accelerate(int speed) {
        int newSpeed = this.speed + speed;
        if (newSpeed > UPPER_SPEED_LIMIT) {
            System.out.println("Over the speed limit. Slow down!");
        } else {
            System.out.println("Accelerating!");
            this.speed += speed;
        }
    }

    public void slowDown(int speed) {
        int newSpeed = this.speed - speed;
        if (newSpeed < LOWER_SPEED_LIMIT) {
            System.out.println("Under the speed limit. Drive faster!");
        } else {
            System.out.println("Slowing down!");
            this.speed -= speed;
        }
    }

    public void displayCurrentSpeed() {
        System.out.println("The current speed is " + this.speed + " miles/hour");
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {
        Car car = new Car();
        car.slowDown(10);
        car.displayCurrentSpeed();
        car.accelerate(20);
        car.displayCurrentSpeed();
        car.accelerate(20);
        car.displayCurrentSpeed();
    }
}
