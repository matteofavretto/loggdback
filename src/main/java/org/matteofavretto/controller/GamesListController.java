package org.matteofavretto.controller;

import org.matteofavretto.command.CreateGamesListCommand;
import org.matteofavretto.model.GamesList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class GamesListController {

    private final Map<String, CreateGamesListCommand> commands;

    @Autowired
    public GamesListController(Map<String, CreateGamesListCommand> commands) {
        this.commands = commands;
    }

    @PostMapping(value =  "/lists")
    public ResponseEntity<Object> createList(@RequestBody GamesList list) {

        System.out.println("DEBUG");
        CreateGamesListCommand command = commands.get("CreateGamesListCommand");
        try  {
            Object response = command.run(list);
            return ResponseEntity.ok(response);
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
