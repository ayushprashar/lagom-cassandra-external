package com.knoldus.lagom.assignment3;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static com.lightbend.lagom.javadsl.api.transport.Method.GET;
import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;

public interface ExternalService extends Service {
    @Override
    default Descriptor descriptor() {
        return named("external").withCalls(
                restCall(GET, "/api/users/2", this::dataResponse)
        ).withAutoAcl(true);
    }

    ServiceCall<NotUsed, DataResponse> dataResponse();
}