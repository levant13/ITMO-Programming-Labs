package data;

public enum Country {
    USA,
    INDIA,
    ITALY,
    THAILAND,
    JAPAN;

    public static String nameList() {
        String nameList = "";
        for (Country countryName : values()) {
            nameList += countryName.name() + ", ";
        }
        return nameList.substring(0, nameList.length() - 2);
    }
}