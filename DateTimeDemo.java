import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeDemo {
    public static void main(String[] args) {

        LocalDate date= LocalDate.now();
        System.out.println("current date is :"+date);

        LocalTime time= LocalTime.now();
        System.out.println("current time is :"+time);

        LocalDateTime dateTime=LocalDateTime.now();
        System.out.println("before formatting ");
        System.out.println("current date time is :"+dateTime);

        DateTimeFormatter  formatter=DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        System.out.println("after formatting "+dateTime.format(formatter));

    }
}
