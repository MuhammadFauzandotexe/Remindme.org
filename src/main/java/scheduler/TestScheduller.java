package scheduler;

import io.quarkus.logging.Log;
import io.quarkus.scheduler.Scheduled;

import javax.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class TestScheduller {
    @Scheduled(every = "5s")
    public void everySecond(){
        Log.info("every SECONd");
    }
}
/*
|--------------(Second 0-59)
| |-------------------(Minute 0-59)
| | |------------------------(Hour 0-23)
| | | |---------------------------(Day of the month 1-31)
| | | | |--------------------------------(Month 1-2) or (JAN-DEC)
| | | | | |-----------------------------------(Day of the week 0-7)
* * * * * *
 */
