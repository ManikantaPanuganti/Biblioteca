package com.twu.biblioteca.Logic;

public class CheckOut implements MenuOption {
    @Override
    public void onSelect(UI ui, Library library) {
        String book = ui.getBookTitle();
        try {
            library.checkOut(book);
            ui.handleSuccessfulCheckOut();

        } catch (UnknownBook unknownBook) {
            ui.handleUnSuccessfulCheckedOut();
        }
    }

    @Override
    public String description() {
        return "CheckOut";
    }
}
