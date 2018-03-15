package com.knoldus.lagom.assignment3;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;
import static com.lightbend.lagom.javadsl.api.Service.restCall;
import static com.lightbend.lagom.javadsl.api.Service.named;
import java.util.Optional;

public interface EmployeeDataService extends Service {
    @Override
    default Descriptor descriptor() {
        return named("employeedata").withCalls(
                restCall(Method.GET, "/api/get/:id", this::externalServiceMethod),
                restCall(Method.POST,"/api/post",this::postToDB)
        ).withAutoAcl(true);

    }

    ServiceCall<CassandraData,String> postToDB();

    ServiceCall<NotUsed, Optional<DataResponse>> externalServiceMethod(int id);
}
