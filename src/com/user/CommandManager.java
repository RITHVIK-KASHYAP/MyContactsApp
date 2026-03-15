package com.user;

import java.util.Stack;

public class CommandManager {

    private Stack<ProfileCommand> history = new Stack<>();

    public void executeCommand(ProfileCommand command) {

        command.execute();
        history.push(command);

    }

    public void undo() {

        if (!history.isEmpty()) {

            ProfileCommand cmd = history.pop();
            cmd.undo();

        }

    }

}