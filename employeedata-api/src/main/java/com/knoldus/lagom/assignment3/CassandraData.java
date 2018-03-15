package com.knoldus.lagom.assignment3;

import lombok.Builder;
import lombok.Value;

@Value
@Builder

public class CassandraData {
    String firstName;
    String lastName;
    String city;
    int age;
    int id;
}
