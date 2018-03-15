package com.knoldus.lagom.assignment3;

import com.knoldus.lagom.assignment3.Data;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class DataResponse {
    Data data;
    String c_firstName;
    String c_lastName;
    String c_city;
    int c_age;
    int c_id;
}
