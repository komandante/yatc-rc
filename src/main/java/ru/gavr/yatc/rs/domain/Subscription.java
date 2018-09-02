package ru.gavr.yatc.rs.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * Created by gavr on 31.08.2018
 */
@ToString
@Getter
@Setter
public class Subscription {
    @NotBlank
    private String site;
    @NotBlank
    private String email;
}
