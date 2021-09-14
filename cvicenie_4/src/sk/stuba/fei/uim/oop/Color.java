package sk.stuba.fei.uim.oop;

public enum Color {
    RED(0,"ff0000"),
    GREEN(1,"00ff00"),
    BLUE(2,"0000ff");

    private int id;
    private String code;

    Color(int id, String code) {
        this.id = id;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return code;
    }
}
