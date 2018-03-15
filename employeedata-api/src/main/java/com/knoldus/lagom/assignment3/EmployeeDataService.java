package com.knoldus.lagom.assignment3;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;

import java.util.Optional;

public interface EmployeeDataService extends Service {
    @Override
    default Descriptor descriptor() {
        return Service.named("employeedata").withCalls(
                Service.restCall(Method.GET, "/api/get/:id", this::externalServiceMethod)
        ).withAutoAcl(true);

    }

    ServiceCall<NotUsed, Optional<DataResponse>> externalServiceMethod(int id);
}
