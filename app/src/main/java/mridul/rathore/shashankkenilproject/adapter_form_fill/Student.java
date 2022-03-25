package mridul.rathore.shashankkenilproject.adapter_form_fill;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Student implements Parcelable {

    String name;
    int roll;
    String email;
    String address;

    public Student(String name, int roll, String email, String address) {
        this.name = name;
        this.roll = roll;
        this.email = email;
        this.address = address;
    }

    protected Student(Parcel in) {
        name = in.readString();
        roll = in.readInt();
        email = in.readString();
        address = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(roll);
        dest.writeString(email);
        dest.writeString(address);
    }

    @Override
    public String toString() {
        return
                "name= " + name +
                "\nroll= " + roll +
                "\nemail= " + email +
                "\naddress= " + address ;
    }
}
