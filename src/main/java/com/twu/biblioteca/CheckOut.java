package com.twu.biblioteca;

public class CheckOut implements MenuOption {
    @Override
    public void onSelect(UI ui, Library library) {
        String book = ui.getBookTitle();
        try {
            library.checkOut(book);

        } catch (UnknownBook unknownBook) {
            ui.handleUnSuccessfulCheckedOut();
        }
    }

    @Override
    public String description() {
        return "CheckOut";
    }
}
