import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Main {
 private  static  Calendar calendar;

        public static void main(String[] args) {
            calendar = new Calendar();
            try (Scanner scanner = new Scanner(System.in)) {
                label:
                while (true) {
                    printMenu();
                    System.out.print("Выберите пункт меню: ");
                    if (scanner.hasNextInt()) {
                        int menu = scanner.nextInt();
                        switch (menu) {
                            case 1:
                                inputTask(scanner);
                                break;
                            case 2:
                               deleteTask(scanner);
                                break;
                            case 3:
                               getTaskDay(scanner);
                                break;
                            case 0:
                                break label;
                        }
                    } else {
                        scanner.next();
                        System.out.println("Выберите пункт меню из списка!");
                    }
                }
            }
        }

        private static void inputTask(Scanner scanner) {
            scanner.nextLine();
            System.out.print("Введите название задачи: ");
            String title = scanner.nextLine();
            System.out.print("Введите описание задачи: ");
            String description = scanner.nextLine();
            boolean work;
            System.out.print("Это рабочая задача?");
            switch (scanner.nextLine()) {
                case "да":
                    work = true;
                    break;
                default:
                    work = false;
            }




                LocalDateTime date = null;
                System.out.println("Введите дату и время задачи (01.01.1999 00:00:00):");
                boolean shouldEnterAgain = true;
                while (shouldEnterAgain) {
                    try {
                        date = LocalDateTime.parse(scanner.nextLine(), Tasks.DATE_TIME_FORMATTER);
                        shouldEnterAgain = false;
                    } catch (DateTimeException e) {
                        System.out.println(" Неправильно");
                    }
                }
                Tasks tasks;
                System.out.println("\t 0 - не повторятся");
                System.out.println("\t 1 - ежедневная задача");
                System.out.println("\t 2 - еженедельная задача");
                System.out.println("\t 3 - ежемесячная задача");
                System.out.println("\t 4 - ежегодная задача");
                switch (scanner.next()) {
                    case "1":
                        tasks = new DailyTask(title, description, work, date);
                        break;
                    case "2":
                        tasks = new WeeklyTask(title, description, work, date);
                        break;
                    case "3":
                        tasks = new MonthTask(title, description, work, date);
                        break;
                    case "4":
                        tasks = new YearTusk(title, description, work, date);
                        break;
                    default:
                        tasks = new OneTimeTask(title, description, work, date);

                }
                  calendar.addTask(tasks);

            }
            public  static  void  deleteTask(Scanner scanner){
                scanner.nextLine();
                System.out.println("введите id: ");
                int id = scanner.nextInt();
                calendar.removeTask(id);





            }
            public  static  void getTaskDay(Scanner scanner) {
                scanner.nextLine();
                System.out.println("Введите дату");
                LocalDate date = null;
                boolean shouldEnterAgain = true;
                while (shouldEnterAgain) {
                    try {
                        date = LocalDate.parse(scanner.nextLine(), Tasks.DATE_TIME_FORMATTER);
                        shouldEnterAgain = false;
                    } catch (DateTimeParseException e) {
                        System.out.println(" Неправильно");
                    }

                }
                System.out.println(calendar.getResult(date));
            }



            private static void printMenu () {
                    System.out.println(
                            """
                                    1. Добавить задачу
                                    2. Удалить задачу
                                    3. Получить задачу на указанный день
                                    0. Выход
                                    """
                    );
                }

            };