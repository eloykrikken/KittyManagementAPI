package eloy.personal.KittyManagementAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class LitterBox {
    @Id
    @GeneratedValue
    private int id;
    private boolean isDone = false;
    private LocalDateTime lastDone = LocalDateTime.now().minusHours(8);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        this.isDone = done;
    }

    public LocalDateTime getLastDone() {
        return lastDone;
    }

    public void setLastDone(LocalDateTime last_done) {
        this.lastDone = last_done;
    }
}
