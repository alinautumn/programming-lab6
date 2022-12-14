package com.alisha.common.commands;

import com.alisha.common.dto.CommandResultDto;
import com.alisha.common.utilities.CollectionManager;
import com.alisha.common.utilities.HistoryManager;

public class RemoveByIdCommand extends Command {

    public RemoveByIdCommand(String arg) {
        super(arg, "remove_by_id");
    }

    @Override
    public CommandResultDto execute(
            CollectionManager collectionManager,
            HistoryManager historyManager
    ) {

        historyManager.addNote(this.getName());
        int intArg;
        try {
            intArg = Integer.parseInt((String) arg);
        } catch (NumberFormatException e) {
            return new CommandResultDto("Your argument was incorrect. The command was not executed.");
        }

        if (collectionManager.getMainData().removeIf(x -> x.getId() == intArg)) {
            return new CommandResultDto("The element was deleted successfully.");
        } else {
            return new CommandResultDto("Could not find written id. The command was not executed");
        }
    }
}
