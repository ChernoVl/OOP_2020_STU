package sk.example.exam.conrollers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sk.example.exam.domain.cannons.Cannon;
import sk.example.exam.domain.cannons.LargeCannon;
import sk.example.exam.domain.chassises.TrackedChassis;
import sk.example.exam.domain.componens.Nationality;
import sk.example.exam.domain.tanks.HeavyTank;
import sk.example.exam.domain.tanks.Tower;

import java.util.*;

@Controller
public class VehiclesController implements CommandLineRunner {

    //    public static final String[] itemNames = {"Alpha", "Bravo", "Charlie", "Delta"};
//    private final Map<Long, Item> items = new HashMap<>();
    private final Map<Long, HeavyTank> heavyTanks = new LinkedHashMap<>();
    //private LightTank lightTank = new LightTank(1,"");
    private TrackedChassis trackedChassis = new TrackedChassis(12, "Pásový podvozok “IS-3M”", 11, 65, 14, 4);
    private Cannon cannon = new LargeCannon(32, "Delo veľkého kalibru", 122, 43, 36, 2);
    private Tower tower = new Tower(54, "Veža “IS-3”", 15, 453, cannon);
    private HeavyTank heavyTank = new HeavyTank(1, "Ťažký tank “IS-3”", Nationality.USA, 10, trackedChassis, tower);
    private HeavyTank heavyTank2 = new HeavyTank(2, "Ťažký tank “Alpha”", Nationality.USA, 10, trackedChassis, tower);
    private HeavyTank heavyTank3 = new HeavyTank(3, "Ťažký tank “Bravo”", Nationality.USA, 10, trackedChassis, tower);

    @Override
    public void run(String... args) throws Exception {
        heavyTanks.put(heavyTank.getId(), heavyTank);
        heavyTanks.put(heavyTank2.getId(), heavyTank2);
        heavyTanks.put(heavyTank3.getId(), heavyTank3);
    }

    @GetMapping("/list-vehicles")
    public String findAll(Model model) {
        model.addAttribute("heavyTanks", heavyTanks.values());
        return "list-vehicles";
    }

    @PostMapping("/list-vehicles")
    public String find() {
        return "list-vehicles";
    }

    @GetMapping("detail/{id}")
    public String detailById(@PathVariable Long id, Model model) {
        model.addAttribute("item", heavyTanks.get(id));
        return "detail";
    }

    @GetMapping("detail-chassis/{id}")
    public String detailChassisById(@PathVariable Long id, Model model) {
        model.addAttribute("item", heavyTanks.get(id));
        return "detail-chassis";
    }

    @GetMapping("detail-tower/{id}")
    public String detailTowerById(@PathVariable Long id, Model model) {
        model.addAttribute("item", heavyTanks.get(id));
        return "detail-tower";
    }

    @GetMapping("detail-cannon/{id}")
    public String detailCannonById(@PathVariable Long id, Model model) {
        model.addAttribute("item", heavyTanks.get(id));
        return "detail-cannon";
    }
}
