import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends  Tasks implements Repeatability{
    public DailyTask(String title, String description, boolean work, LocalDateTime dateTime) {
        super(title, description, work, dateTime);
    }

    @Override
    public boolean checkDate(LocalDate date) {
        return true;
    }
}
