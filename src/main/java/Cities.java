import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public enum Cities {

    SLOVYANSK("Slovyansk", Countries.UA),
    PRAGUE("Prague", Countries.CZ),
    BROVARY("Brovary", Countries.UA),
    KYIV("Kyiv", Countries.UA),
    ODESSA("Odessa", Countries.UA),
    UZHGOROD("Uzhgorod", Countries.UA),
    NEW_YORK("New York", Countries.US);

    private static final Map<String, Cities> BY_CITIES = new HashMap<>();
    private static final Map<Cities, Countries> BY_COUNTRIES = new HashMap<>();

    static {
        for (Cities cities : values()) {
            BY_CITIES.put(cities.city, cities);
            BY_COUNTRIES.put(cities, cities.country);
        }
    }

    public final String city;
    public final Countries country;

    private Cities(String city, Countries country) {
        this.city = city;
        this.country = country;
    }

    public static Cities valueOfCity(String city){
        return BY_CITIES.get(city);
    }

    public static Country valueOfCountry(Cities city){
        return BY_COUNTRIES.get(city);
    }

    public static Cities getRandom(){
        return values()[(int) (Math.random()*values().length)];
    }

//    private Map<String, Countries> map;
//
//    Cities(Map<String, Countries> map){
//        this.map = map;
//    }
//
//    public String getTitle(){
//        return title;
//    }
//
//    public static Cities getRandom(){
//        return values()[(int) (Math.random()*values().length)];
//    }
//
//    private String title;
//
//
//    Cities(String title, Countries country){
//        this.title = title;
//    }
//
//    public String getTitle(){
//        return title;
//    }
//
//    public static Cities getRandom(){
//        return values()[(int) (Math.random()*values().length)];
//    }
}
