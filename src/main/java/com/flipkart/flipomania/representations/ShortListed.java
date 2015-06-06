package com.flipkart.flipomania.representations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Map;

/**
 * Created by :- Shiv Pratap Singh Parmar
 * Created on :- 6/6/15.
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ShortListed {

    @JsonProperty
    private Map<String, List<String>> inputData;

    @JsonProperty
    private int roundNo;

    @JsonProperty
    private List<String> activeProjects;

    @JsonProperty
    private List<Integer> projectCapacities;
}
