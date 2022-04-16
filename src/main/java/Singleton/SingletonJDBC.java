package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonJDBC {

        private static Connection connection;
        static{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/design", "root", "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static Connection getConnection(){
            return connection;
        }

}
