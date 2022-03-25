package mridul.rathore.shashankkenilproject.realm;

import io.realm.RealmObject;

public class Car extends RealmObject {

    public String name;

    public String color;

    public String getName() {
        return name;
    }

    public Car(){

    }


    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Car(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
