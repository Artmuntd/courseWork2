import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthTask extends  Tasks implements  Repeatability{
    public MonthTask(String title, String description, boolean work, LocalDateTime dateTime) {
        super(title, description, work,dateTime);
    }

    @Override
    public boolean checkDate(LocalDate date) {
        return  date.getDayOfMonth() == dateTime.getDayOfMonth();
    }
}
