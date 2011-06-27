package palilo.codejam;

public class Objective {

	private BotType _bot;
	private int _buttonPosition;
	private boolean isAccomplished = false;
	
	public Objective(BotType bot, int buttonPosition) {
		_bot = bot;
		_buttonPosition = buttonPosition;
	}

	public BotType getBotType() {
		return _bot;
	}

	public int getButtonPosition() {
		return _buttonPosition;
	}

	public boolean isAccomplished() {
		return isAccomplished;
	}

	public void setAccomplished() {
		this.isAccomplished = true;
	}
	
	@Override
	public String toString() {
		return _bot + " " + _buttonPosition + " terminado: " + isAccomplished;
	}
	
	
	
}
