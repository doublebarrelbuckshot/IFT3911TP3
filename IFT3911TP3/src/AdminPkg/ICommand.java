package AdminPkg;

public interface ICommand {

	public void execute();
	public void unexecute();
	public String getMessage(boolean isExecute);
}