package com.twu.biblioteca.Logic;

import com.twu.biblioteca.Logic.Library;
import com.twu.biblioteca.Logic.MenuOption;
import com.twu.biblioteca.Logic.UI;
import com.twu.biblioteca.Logic.UnknownBook;

public class ReturnBook implements MenuOption {
    @Override
    public void onSelect(UI ui, Library library) {
        String book =ui.getBookTitle();
        try {
            library.returnBook(book);
            ui.handleSuccessFulReturn();

        } catch (UnknownBook unknownBook) {
            ui.handleUnSuccessfulReturn();
        }
    }

    @Override
    public String description() {
        return "Return Book";
    }
}
