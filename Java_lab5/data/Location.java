package data;


public class Location {
    private long x;
    private double y;
    private String name;

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