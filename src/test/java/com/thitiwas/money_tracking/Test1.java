package com.thitiwas.money_tracking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thitiwas.money_tracking.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = MoneyTrackingApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
@Transactional
public class Test1 {

    @Autowired
    private UserService userService;

    private Gson gson;

    @Before
    public void setUp() throws Exception {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Test
    public void getUserTest() {
        String email = "twopee26@gmail.com";
        String password = "P@ssw0rd";
        var byEmailAndPassword = userService.findByEmailAndPassword(email, password);
        log.debug("result :{}", gson.toJson(byEmailAndPassword));
    }
}
