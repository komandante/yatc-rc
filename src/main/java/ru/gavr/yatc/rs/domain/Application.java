package ru.gavr.yatc.rs.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by gavr on 31.08.2018
 */
@ToString @Getter @Setter
public class Application {
    private String name;
    private String phone;
    private String email;
    private String comment;
}
