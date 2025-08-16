package command;

import model.GamesList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import service.GamesListService;

@Component
@Scope("prototype")
public class GamesListCommand {

    public enum Operation {
        CREATE_LIST,
        ADD_GAME,
        REMOVE_GAME,
        UPDATE_LIST,
        DELETE_LIST
    }

    private final Operation operation;
    private final Object payload;
    private Object response;

    @Autowired
    private GamesListService gamesListService;

    public GamesListCommand(Operation operation, Object payload) {
        this.operation = operation;
        this.payload = payload;
    }

    public Object execute() throws Exception {
        switch (operation) {
            case CREATE_LIST:
                int updatedRows = gamesListService.createList((GamesList)payload);
                if(updatedRows == 0)  {
                    throw new Exception();
                }
                response = updatedRows;
                break;
            case ADD_GAME:
                // Logic to add a game to the list
                break;
            case REMOVE_GAME:
                // Logic to remove a game from the list
                break;
            case UPDATE_LIST:
                // Logic to update the games list
                break;
            case DELETE_LIST:
                // Logic to delete the games list
                break;
            default:
                throw new IllegalArgumentException("Unknown operation: " + operation);
        }
        return response;
    }
}
