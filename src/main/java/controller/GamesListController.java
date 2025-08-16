package controller;

import command.GamesListCommand;
import model.GamesList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GamesListController {

    @PostMapping(value =  "/lists")
    public ResponseEntity<Object> createList(@RequestBody GamesList list) {

        GamesListCommand command = new GamesListCommand(GamesListCommand.Operation.CREATE_LIST, list);
        try  {
            Object response = command.execute();
            return ResponseEntity.ok(response);
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
