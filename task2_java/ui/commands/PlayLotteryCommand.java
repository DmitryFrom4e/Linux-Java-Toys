package task2_java.ui.commands;

import task2_java.presenter.ToyPresenter;

public class PlayLotteryCommand implements Command {
    private ToyPresenter presenter;

    public PlayLotteryCommand(ToyPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.playLottery();
    }
}
