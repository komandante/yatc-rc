package ru.gavr.yatc.rs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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

    @Value("${Y_MAIL_TO}")
    private String yMailTo;
    @Value("${Y_MAIL_FROM}")
    private String yMailFrom;

    @Autowired
    public JavaMailSender emailSender;


    @RequestMapping(value = "/application", method = RequestMethod.POST)
    public void application(@RequestBody @Valid Application application) {
        log.debug(application.toString());

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(yMailTo.split(","));
        message.setFrom(yMailFrom);
        message.setSubject("Заявка с " + application.getSite());
        message.setText("Имя: " + application.getName() + "\n" +
        "Телефон: " + application.getPhone()  + "\n" +
        "Email: " + application.getEmail()  + "\n" +
        "Комментарий: " + application.getComment());
        emailSender.send(message);

    }
    @RequestMapping(value = "/subscription", method = RequestMethod.POST)
    public void subscription(@RequestBody @Valid Subscription subscription) {
        log.debug(subscription.toString());

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(yMailTo.split(","));
        message.setFrom(yMailFrom);
        message.setSubject("Подписка с  " + subscription.getSite());
        message.setText("Email: " + subscription.getEmail());
        emailSender.send(message);
    }
}
