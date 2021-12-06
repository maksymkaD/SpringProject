package com.example.application.scheduling;

import com.example.application.dal.model.User;
import com.example.application.security.MyUserDetails;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class Scheduler {
    private User user;

    @Scheduled(fixedDelay = 5000)
    public void scheduleFixedDelayTask() {
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        try {
            UserDetails userDetails = new MyUserDetails(user);
            System.out.println(userDetails.getUsername() +
                    " is logged at " + time.format(formatter));
        }
        catch (Exception e)
        {
            System.out.println("No user is logged at " + time.format(formatter));
        }
    }

    @Scheduled(cron = "0 55 23 * * ?")
    //fires at 23:55 every day
    public void dailyCacheClear() {

        //TODO clear cache

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Cache cleared - " + strDate);
    }
}