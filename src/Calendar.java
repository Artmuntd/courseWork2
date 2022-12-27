import java.time.LocalDate;
import java.util.*;

public class Calendar {
    private Map<Integer, Tasks>tasksMap;

    public Calendar(){
        tasksMap = new HashMap<>();
    }
    public  void addTask(Tasks tasks){
        tasksMap.put(tasks.getId(),tasks);
    }

    public  void  removeTask(int id){
        tasksMap.remove(id);
    }
    public List<Tasks> getResult(LocalDate date) {

        List<Tasks> result = new ArrayList<>();
       for(Map.Entry<Integer, Tasks> entry: tasksMap.entrySet()){
           if(entry.getValue() instanceof  Repeatability
           && ((Repeatability)entry.getValue()).checkDate(date) || entry.getValue().getDateTime().toLocalDate().equals(date)){
               result.add(entry.getValue());
           }
           }

        result.sort(Comparator.comparing(Tasks::getDateTime));
       return result;
    }
    }

