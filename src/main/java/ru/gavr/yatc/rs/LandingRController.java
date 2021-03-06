package ru.gavr.yatc.rs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import ru.gavr.yatc.rs.domain.Application;
import ru.gavr.yatc.rs.domain.Response;
import ru.gavr.yatc.rs.domain.Subscription;

import javax.validation.Valid;
import java.util.Map;

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


    @RequestMapping(value = "/application", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    @CrossOrigin
    public Response application(@RequestParam Map<String, String> body) {
        log.debug(body.toString());

    /*    SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(yMailTo.split(","));
        message.setFrom(yMailFrom);
        message.setSubject("Заявка с " + application.getSite());
        message.setText("Имя: " + application.getName() + "\n" +
        "Телефон: " + application.getPhone()  + "\n" +
        "Email: " + application.getEmail()  + "\n" +
        "Комментарий: " + application.getComment());
        emailSender.send(message);*/
        return new Response("OK");
    }
    @RequestMapping(value = "/subscription", method = RequestMethod.POST)
    public void subscription(@RequestBody @Valid Subscription subscription) {
        log.debug(subscription.toString());

       /* SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(yMailTo.split(","));
        message.setFrom(yMailFrom);
        message.setSubject("Подписка с  " + subscription.getSite());
        message.setText("Email: " + subscription.getEmail());
        emailSender.send(message);*/
    }
}
