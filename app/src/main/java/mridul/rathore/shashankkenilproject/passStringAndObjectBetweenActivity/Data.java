package mridul.rathore.shashankkenilproject.passStringAndObjectBetweenActivity;

import java.io.Serializable;

public class Data implements Serializable {

    int x;
    String name;
    Float salary;

    public Data(int x, String name, Float salary) {
        this.x = x;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return
                " x = " + x +
                " name = " + name +
                " salary = " + salary ;
    }
}
