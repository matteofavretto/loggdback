package service;

import connector.DatabaseConnection;
import model.GamesList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import constants.Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
@Scope("prototype")
public class GamesListService {

    @Autowired
    private DatabaseConnection databaseConnection;

    public int createList(GamesList newList) throws SQLException {

        int updatedRows;
        try {
            Connection connection = databaseConnection.connect();
            String query =  Queries.CREATE_EMPTY_LIST;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(0, newList.getListTitle());
            statement.setString(1, newList.getListDescription());
            updatedRows = statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally  {
            databaseConnection.disconnect();
        }
        return updatedRows;
    }

}
