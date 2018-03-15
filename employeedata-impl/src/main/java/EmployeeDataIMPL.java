import akka.NotUsed;
import com.google.inject.Inject;
import com.knoldus.lagom.assignment3.CassandraData;
import com.knoldus.lagom.assignment3.DataResponse;
import com.knoldus.lagom.assignment3.EmployeeDataService;
import com.knoldus.lagom.assignment3.ExternalService;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class EmployeeDataIMPL implements EmployeeDataService {
    private ExternalService externalService;
    private CassandraSession cassandraSession;

    @Inject
    EmployeeDataIMPL(ExternalService externalService, CassandraSession cassandraSession) {
        this.externalService = externalService;
        this.cassandraSession = cassandraSession;
    }

    @Override
    public ServiceCall<CassandraData, String> postToDB() {

        return request -> {
            cassandraSession.executeWrite(Constants.POST_EMPLOYEE,request.getId(),request.getAge(),request.getCity(),
                    request.getFirstName(),request.getLastName());
            return CompletableFuture.completedFuture("Data Submitted");
        };

    }

    @Override
    public ServiceCall<NotUsed, Optional<DataResponse>> externalServiceMethod(int id) {
        return request -> externalService
                .dataResponse()
                .invoke()
                .thenApply(response -> response)
                .thenCompose(das ->

                    cassandraSession.selectOne(Constants.GET_EMPLOYEE, id)
                            .thenApply(empOpt -> empOpt.map(empRow -> DataResponse
                                    .builder()
                                    .c_age(empRow.getInt("age"))
                                    .c_firstName(empRow.getString("first_name"))
                                    .c_lastName(empRow.getString("last_name"))
                                    .c_id(empRow.getInt("id"))
                                    .c_city(empRow.getString("city"))
                                    .data(das.getData())
                                    .build()))
                );
    }


}
