package palilo.codejam;

import java.util.ArrayList;

public class Bot {
	private BotType _type;
	private ArrayList<Objective> _objectives = new ArrayList<Objective>();
	private Integer _objectiveIndex = 0;
	private Integer _position = 1;
	private Direction _moving = Direction.forward;
	private Boolean isLockedToExecuteObjective = true;
	
	public Bot(BotType bt, ArrayList<Objective> objectives) {
		_type = bt;
		_objectives = objectives;
	}

	public void action() {		
		if (getCurrentObjective() == null) return;
		if (_position == getCurrentObjective().getButtonPosition()) {
			if (canExecuteObjective()) 
				executeObjective();
		} else
			move();
	}

	private boolean canExecuteObjective() {
		return !isLockedToExecuteObjective();
	}
	
	private void executeObjective() {
		setCurrentObjectiveAccomplished();
		_objectiveIndex++;
	}

	private void setCurrentObjectiveAccomplished() {
		getCurrentObjective().setAccomplished();
		lockToExecuteObjective();
	}

	private void lockToExecuteObjective() {
		isLockedToExecuteObjective = true;
	}

	private void move() {
		_position = _moving.move(_position);
	}

	private Objective getCurrentObjective(){
		if (_objectiveIndex >= _objectives.size()) return null;
		Objective o = _objectives.get(_objectiveIndex);
		decideDirectionToMove(o);
		return o;
	}

	private void decideDirectionToMove(Objective o) {
		_moving = _position <= o.getButtonPosition() 
			? Direction.forward : Direction.back;
	}

	public void unLockToExecuteObjective() {
		isLockedToExecuteObjective = false;
	}
	
	public boolean isLockedToExecuteObjective() {
		return isLockedToExecuteObjective;
	}
	
	@Override
	public String toString() {
		return String.format("Objetivo Index: %s posicao: %s direcao: %s, tipo: %s podeExecutar: %s",
				_objectiveIndex, _position, _moving, _type, canExecuteObjective());
	}
}
