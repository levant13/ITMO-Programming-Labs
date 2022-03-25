package data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Main character. Is stored in the collection.
 */
public class Person {
    private Long id;
    private String name;
    private Coordinates coordinates;
    private LocalDateTime creationDate;
    private Integer height;
    private Date birthday;
    private Color hairColor; //Поле может быть null
    private Country nationality;
    private Location location;

    public Person(Long id, String name, Coordinates coordinates,
                  LocalDateTime creationDate, Date birthday,
                  Country nationality, Integer height,
                  Color hairColor, Location location) {

        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.height = height;
        this.birthday = birthday;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }

    /**
     * @return ID of the marine.
     */
    public Long getId() {
        return id;
    }

    /**
     * @return Name of the marine.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Coordinates of the marine.
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * @return Creation date of the marine.
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * @return Health of the marine.
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * @return Category of the marine.
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @return Weapon type of the marine.
     */
    public Color getHairColor() {
        return hairColor;
    }

    /**
     * @return Melee weapon of the marine.
     */
    public Country getNationality() {
        return nationality;
    }

    /**
     * @return Chapter of the marine.
     */
    public Location getLocation() {
        return location;
    }


    public int compareTo(Person personObj) {
        return id.compareTo(personObj.getId());
    }

    @Override
    public String toString() {
        String info = "";
        info += "Person №" + id;
        info += " Time " + creationDate.toLocalDate() + " " + creationDate.toLocalTime() + ")";
        info += "\n Name: " + name;
        info += "\n Coordinates : " + coordinates;
        info += "\n Creation day: " + creationDate;
        info += "\n Height: " + height;
        info += "\n BirthDay: " + birthday;
        info += "\n Hair color: " + hairColor;
        info += "\n Country: " + nationality;
        info += "\n Location: " + location;
        return info;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + coordinates.hashCode() + creationDate.hashCode() + (int) height + birthday.hashCode() + hairColor.hashCode() +
                nationality.hashCode() + location.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Person) {
            Person personObj = (Person) obj;
            return name.equals(personObj.getName()) && coordinates.equals(personObj.getCoordinates()) &&
                    (height == personObj.getHeight()) && (birthday == personObj.getBirthday()) &&
                    (hairColor == personObj.getHairColor()) && (nationality == personObj.getNationality()) &&
                    location.equals(personObj.getLocation());
        }
        return false;
    }
}