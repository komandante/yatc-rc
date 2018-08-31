package ru.gavr.yatc.rs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.gavr.yatc.rs.domain.Application;
import ru.gavr.yatc.rs.domain.Subscription;

import javax.validation.Valid;

/**
 * Created by gavr on 31.08.2018
 */
@RestController
public class LandingRController {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/application", method = RequestMethod.POST)
    public void application(@RequestBody @Valid Application application) {
        log.info(application.toString());
    }
    @RequestMapping(value = "/subscription", method = RequestMethod.POST)
    public void subscription(@RequestBody @Valid Subscription subscription) {
        log.info(subscription.toString());
    }
}
