package com.flipkart.flipomania.core.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;

/**
 * Created by :- Shiv Pratap Singh Parmar
 * Created on :- 5/6/15.
 */
@Setter
@Getter
public class FlipomaniaConfiguration extends Configuration {
    @NotEmpty
    @JsonProperty
    private String name;

    @NotEmpty
    @JsonProperty
    private String hostname;
}
