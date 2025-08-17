package org.matteofavretto.command;

import org.matteofavretto.model.GamesList;
import org.matteofavretto.model.common.CommandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.matteofavretto.service.GamesListService;

@Component
@Scope("prototype")
public class CreateGamesListCommand implements BaseCommand<Object> {

    private final Object payload;
    private Object response;

    @Autowired
    private GamesListService gamesListService;

    public CreateGamesListCommand(Object payload) {
        this.payload = payload;
    }

    @Override
    public String getName() {
        return "create";
    }

    @Override
    public CommandResponse run(Object input) {
        try {
            int updatedRows = gamesListService.createList((GamesList)payload);
            if(updatedRows != 0) {
                return new CommandResponse(null, CommandResponse.Status.OK);
            } else {
                return new CommandResponse(null, CommandResponse.Status.KO);
            }
        } catch(Exception e) {
            return new CommandResponse(null, CommandResponse.Status.KO, e.getMessage());
        }
    }
}
