package task2_java;

import task2_java.presenter.ToyPresenter;
import task2_java.ui.ToyView;

public class Main {
    public static void main(String[] args) {
        ToyPresenter presenter = new ToyPresenter();
        ToyView view = new ToyView(presenter);
        presenter.setView(view);
        view.start();
    }
}
