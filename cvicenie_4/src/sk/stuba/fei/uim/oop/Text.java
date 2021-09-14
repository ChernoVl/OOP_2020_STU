package sk.stuba.fei.uim.oop;

public class Text extends Printable {

    private String content;

    public Text(String content) {
        if (content == null) {
            throw new IllegalArgumentException();
        }
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println(content);
    }
}
