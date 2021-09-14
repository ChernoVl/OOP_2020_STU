import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<Integer>();
        array.add(10);
        array.add(10);
        array.add(10);

        assert array != null;

        System.out.println("Finish");
    }
}
