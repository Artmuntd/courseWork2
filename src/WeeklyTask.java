import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask  extends  Tasks implements  Repeatability{
    public WeeklyTask(String title, String description, boolean work, LocalDateTime dateTime) {
        super(title, description, work, dateTime);

    }


    @Override
    public  boolean  checkDate(LocalDate date) {
     return  date.getDayOfWeek() == dateTime.getDayOfWeek();
    }
}
   // @Override
   // public LocalDateTime nextDate(LocalDate date) {
    //    return date.plusWeeks(1).atStartOfDay();
   // }