package data;

public enum Color {
    GREEN,
    BLUE,
    BLACK;

    public static String nameList() {
        String nameList = "";
        for (Color colorType : values()) {
            nameList += colorType.name() + ", ";
        }
        return nameList.substring(0, nameList.length() - 2);
    }
}