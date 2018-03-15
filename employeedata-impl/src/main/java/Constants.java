public class Constants {
    public static final String GET_EMPLOYEE = "select * from knoldus.employee where id = ?";
    public static final String POST_EMPLOYEE = "INSERT INTO knoldus.employee (id,age,city,first_name,last_name)" +
            "values (?,?,?,?,?)";
}
