package task2_java.ui.commands;

import task2_java.presenter.ToyPresenter;

public class AddToyCommand implements Command {
    private ToyPresenter presenter;

    public AddToyCommand(ToyPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.addNewToy();
    }
}
