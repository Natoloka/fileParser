public enum Countries {
    UA("Ukraine"),
    GB("Great Britain"),
    AU("Austria"),
    RO("Romania"),
    MD("Moldova"),
    CZ("Chech Republic"),
    US("United States of America");

    private String title;

    Countries(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public static Countries getRandom(){
        return values()[(int) (Math.random()*values().length)];
    }
}
