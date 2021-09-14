package sk.stuba.fei.cvicenie2;

public enum Color {
    RED("ff0000"),
    BLUE("0000ff"),
    WHITE("ffffff"),
    BLACK("000000"),
    GREEN("00ff00"); //TODO

    private String hexCode;

    Color(String hexCode) {
        this.hexCode = hexCode;
    }

    public String getHexCode() {
        return hexCode;
    }


}
