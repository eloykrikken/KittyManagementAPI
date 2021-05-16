package eloy.personal.KittyManagementAPI.service;

import eloy.personal.KittyManagementAPI.model.LitterBox;
import eloy.personal.KittyManagementAPI.repository.LitterBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LitterBoxService {

    private final LitterBoxRepository litterBoxRepositoy;

    public LitterBoxService(LitterBoxRepository litterBoxRepositoy) {
        this.litterBoxRepositoy = litterBoxRepositoy;
    }

    public List<LitterBox> getAllLitterBoxes() {
        return litterBoxRepositoy.findAll();
    }
    public LitterBox getSingleLitterBox(int id) {
        Optional<LitterBox> litterBox = litterBoxRepositoy.findById(id);
        if (litterBox.isPresent()) {
            LocalDateTime last = litterBox.get().getLastDone();
            litterBox.get().setDone(last.plusHours(8).isAfter(LocalDateTime.now()));
            litterBoxRepositoy.save(litterBox.get());
        }
        return litterBox.orElse(null);
    }

    public void createLitterBox(LitterBox litterBox) {
        if (litterBoxRepositoy.findAll().size() == 0)
            litterBoxRepositoy.save(litterBox);
    }

    public void setLitterBoxDone(int id) {
        Optional<LitterBox> litterBox = litterBoxRepositoy.findById(id);
        if (litterBox.isPresent()) {
            litterBox.get().setDone(true);
            litterBox.get().setLastDone(LocalDateTime.now());
            litterBoxRepositoy.save(litterBox.get());
        }
    }
}
