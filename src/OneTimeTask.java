import java.time.LocalDateTime;

public class OneTimeTask  extends  Tasks{
    public OneTimeTask(String title, String description, boolean work, LocalDateTime dateTime) {
        super(title, description, work, dateTime);
    }
}
