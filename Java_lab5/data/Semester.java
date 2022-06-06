package data;

public enum Semester {
    SECOND,
    THIRD,
    FIFTH,
    SIXTH,
    EIGHTH;
    public static String nameList() {
        String nameList = "";
        for (Semester semesterOder : values()) {
            nameList += semesterOder.name() + ", ";
        }
        return nameList.substring(0, nameList.length() - 2);
    }
}