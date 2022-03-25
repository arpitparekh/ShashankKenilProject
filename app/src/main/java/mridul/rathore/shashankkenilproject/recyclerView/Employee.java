package mridul.rathore.shashankkenilproject.recyclerView;

public class Employee {

    int id;
    String name;
    String depName;
    String email;

    Employee(){

    }

    public Employee(int id, String name, String depName, String email) {
        this.id = id;
        this.name = name;
        this.depName = depName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
