package data;

/**
 * Chapter with marines.
 */
public class Location {
    private long x; //Поле не может быть null
    private double y;
    private String name; //Длина строки не должна быть больше 929, Поле не может быть null

    public Location(String name, long x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }


    public String getName() {
        return name;
    }

    public long getxLocation() {
        return x;
    }
    public double getyLocation() {
        return y;
    }


    @Override
    public String toString() {
        return name + " (" + x +":"+ y +" location )";
    }

    @Override
    public int hashCode() {
        return name.hashCode() +(int)  x;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Location) {
            Location locationObj = (Location) obj;
            return name.equals(locationObj.getName()) && (x == locationObj.getxLocation()) && (y == locationObj.getyLocation());
        }
        return false;
        }
}