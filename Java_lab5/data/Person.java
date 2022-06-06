package data;

import java.util.Date;

public class Person {
    private String name;
    private java.util.Date birthday;
    private Color hairColor;
    private Integer height;
    private Country nationality;
    private Location location;
    public Person(String name, Date birthday,
                  Country nationality, Integer height,
                  Color hairColor, Location location) {
        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }
    public String getname(){
        return name;
    }

    public Integer getHeight() {
        return height;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public Location getLocation() {
        return location;
    }
    @Override
    public String toString() {
        String info = "";
        info += "\n Group Admin: " + name;
        info += "\n Height: " + height;
        info += "\n BirthDay: " + birthday;
        info += "\n Hair color: " + hairColor;
        info += "\n Country: " + nationality;
        info += "\n Location: " + location;
        return info;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + hairColor.hashCode() + (int) height + birthday.hashCode() + nationality.hashCode() + location.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Person) {
            Person personGroupObj = (Person) obj;
            return name.equals(personGroupObj.getname()) && (height == personGroupObj.getHeight()) && (birthday == personGroupObj.getBirthday()) &&
                    (hairColor == personGroupObj.getHairColor()) && (nationality == personGroupObj.getNationality()) &&
                    location.equals(personGroupObj.getLocation());
        }
        return false;
    }
}