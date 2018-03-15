package com.knoldus.lagom.assignment3;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data {

    int id;
    String first_name;
    String last_name;
    String avatar;

}