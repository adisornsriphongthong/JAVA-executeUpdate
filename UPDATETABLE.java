import java.sql.*;

public class UPDATETABLE {
    // Database connection parameters
    private final String url = "jdbc:mysql://localhost:3306/mydb"; // JDBC URL for the database
    private final String username = "root"; // Database username
    private final String password = "199500"; // Database password

    // Getter method for the URL
    public String getUrl() {
        return url;
    }

    // Getter method for the username
    public String getUsername() {
        return username;
    }

    // Getter method for the password
    public String getPassword() {
        return password;
    }

    public static void main(String[] args) {
        UPDATETABLE updatetable = new UPDATETABLE(); // Create an instance of the UPDATETABLE class

        Connection connection = null; // Initialize a database connection object
        Statement statement = null; // Initialize a statement object for executing SQL queries

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL JDBC driver class

            connection = DriverManager.getConnection(updatetable.getUrl(), updatetable.getUsername(), updatetable.getPassword());
            // Establish a database connection using the URL, username, and password

            System.out.println("Connected"); // Print a message to indicate a successful connection

            statement = connection.createStatement(); // Create a statement object

            String sqlQuery = "UPDATE mydb.employees SET department_Id = 2 WHERE Id = 102;";
            // SQL query to update the "employees" table, setting department_Id to 2 for the row with Id 102

            int rowAffected = statement.executeUpdate(sqlQuery);
            // Execute the SQL update query and get the number of rows affected

            System.out.println(rowAffected); // Print the number of rows affected by the update
        } catch (Exception e) {
            System.out.println(e); // Print any exceptions that occur during execution
        }
    }
}
