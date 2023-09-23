import java.sql.*;

public class UPDATETABLE{
    private final String url ="jdbc:mysql://localhost:3306/mydb";
    private final String username = "root";
    private final String password = "199500";

    //getUrl
    public String getUrl(){
        return url;
    }

    //getUsername
    public String getUsername(){
        return username;
    }

    //getPassword
    public String getPassword(){
        return password;
    }

    public static void main(String[] args) {
        UPDATETABLE updatetable = new UPDATETABLE();

        Connection connection = null;
        Statement statement = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(updatetable.getUrl(), updatetable.getUsername(), updatetable.getPassword());

            System.out.println("Connected");

            statement = connection.createStatement();

            String sqlQuery = "UPDATE mydb.employees SET department_Id = 2 WHERE Id = 102;";

            int rowAffected = statement.executeUpdate(sqlQuery);
            
            System.out.println(rowAffected);

            String sqlQuery2 = "SELECT  employees.Id, employees.FirstName, employees.LastName, employees.department_Id, department.department_name FROM mydb.employees JOIN mydb.department ON employees.department_Id = department.department_Id;";
 
            ResultSet resultSet = statement.executeQuery(sqlQuery2);

            while(resultSet.next()){
                String colum1Id = resultSet.getString("Id");
                String colum2FirstName = resultSet.getString("FirstName");
                String colum3LastName = resultSet.getString("LastName");
                String colum4Department_Id = resultSet.getString("department_Id");
                String colum5Department_name = resultSet.getString("department_name");
                
                System.out.format("|%s |%s |%s |%s |%s | %n", colum1Id, colum2FirstName, colum3LastName, colum4Department_Id, colum5Department_name );
            }


        }catch(Exception e){
            System.out.println(e);
        }
    }
}