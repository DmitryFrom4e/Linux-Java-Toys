package task2_java.ui.commands;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Goodbye! See You later!");
        System.exit(0);
    }
}
