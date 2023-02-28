package AAA_Coba2;
public class SchedulerReadTime {
    public static void main(String[] args) {
        Integer hours = java.time.LocalTime.now().getHour();
        Integer minute = java.time.LocalTime.now().getMinute();
        System.out.println(hours+":"+minute);
        //SELECT task FROM user_data where date='2023-02-28' and time='21:14:00' order by id asc;
    }
}
