import com.google.inject.AbstractModule;
import com.knoldus.lagom.assignment3.EmployeeDataService;
import com.knoldus.lagom.assignment3.ExternalService;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;

public class EmployeeModule  extends AbstractModule implements ServiceGuiceSupport{
    @Override
    protected void configure(){
        bindService(EmployeeDataService.class,EmployeeDataIMPL.class);
        bindClient(ExternalService.class);
    }
}