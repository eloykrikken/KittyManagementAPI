package eloy.personal.KittyManagementAPI.controller;

import eloy.personal.KittyManagementAPI.model.LitterBox;
import eloy.personal.KittyManagementAPI.service.LitterBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LitterBoxController {

    private final LitterBoxService litterBoxService;

    public LitterBoxController(LitterBoxService litterBoxService) {
        this.litterBoxService = litterBoxService;
    }

    @GetMapping("/litter-box")
    public List<LitterBox> getAllLitterBoxes() {
        return litterBoxService.getAllLitterBoxes();
    }

    @GetMapping("/litter-box/{id}")
    public boolean litterBoxIsDone(@PathVariable int id) {
        return litterBoxService.getSingleLitterBox(id).isDone();
    }

    @PostMapping("/litter-box")
    public void createLitterBox(@RequestBody LitterBox litterBox) {
        litterBoxService.createLitterBox(litterBox);
    }

    @PatchMapping("/litter-box/{id}")
    public void updateLitterBoxIsDoneById(@PathVariable int id) {
        litterBoxService.setLitterBoxDone(id);
    }
}
