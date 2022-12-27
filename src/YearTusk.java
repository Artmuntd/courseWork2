import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearTusk extends Tasks implements Repeatability{
    public YearTusk(String title, String description, boolean work, LocalDateTime dateTime) {
        super(title, description, work, dateTime);
    }

    @Override
    public boolean checkDate(LocalDate date) {
        return  date.getDayOfYear() == dateTime.getDayOfYear();
    }
}
