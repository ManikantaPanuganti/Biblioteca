package com.twu.biblioteca;

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
