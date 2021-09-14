package sk.stuba.fei.uim.oop.petrinet;

public abstract class Vertex {

    private long id;
    private String title;

    protected Vertex(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}