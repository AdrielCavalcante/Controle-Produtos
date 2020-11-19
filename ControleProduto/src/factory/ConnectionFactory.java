package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory{
        public Connection getConnection() {

        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3308/projetofinaljava?useTimezone=true&serverTimezone=UTC","root","");
        }
        catch(SQLException excecao) {
            throw new RuntimeException(excecao);
        }
        }
}