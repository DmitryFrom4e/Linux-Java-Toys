package task2_java.ui.commands;

import task2_java.presenter.ToyPresenter;

public class ViewToyListCommand implements Command {
    private ToyPresenter presenter;

    public ViewToyListCommand(ToyPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.displayToyList();
    }
}
