package sk.stuba.fei.oop.cvicenie3;

public enum Color {
    RED("ff0000"),
    BLUE("0000ff"),
    WHITE("ffffff"),
    BLACK("000000");

    private String hexCode;

    Color(String hexCode) {
        this.hexCode = hexCode;
    }

    public String getHexCode() {
        return hexCode;
    }
}
