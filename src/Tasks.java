import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Tasks {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");


    private  String title;
    private  String description;
    private boolean work;

    protected   LocalDateTime dateTime;

    private static int  count;
    private  int id;



    public Tasks(String title, String description,  boolean work, LocalDateTime dateTime) {
        this.title = title;
        this.description = description;
        count++;
        this.id = count ;
        this.work = work;
        this.dateTime =dateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public boolean isWork() {
        return work;
    }

    @Override
    public String toString() {
        return "Tasks{" + id + " " +
                "Название='" + title + '\'' +
                ", Описание='" + description + '\'' +
                ", тип=" + work +
                ", Время=" + dateTime +
                '}';
    }
}
