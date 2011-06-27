package palilo.codejam;

import java.util.HashMap;

public class BotTrust {

	private Mission _mission;
	private HashMap<BotType, Bot> _bots = new HashMap<BotType, Bot>();
	private Objective _currentObjective;
	
	public BotTrust(int buttonsToPress, String commands) {
		_mission = Mission.generateMission(commands);
		initializeBots();
		_currentObjective = _mission.nextObjective();
		_bots.get(_currentObjective.getBotType()).unLockToExecuteObjective();
	}

	private void initializeBots() {
		for(BotType bt : _mission.getBotTypes()) 
			_bots.put(bt, new Bot(bt, _mission.getObjectsOfType(bt)));
	}

	public String getSecondsToExecute() {
		Integer time = 0;
		while (_mission.hasObjectiveToFinish()){
			executeActionOnBots();
			time++;
		}
		return time.toString();
	}

	private void executeActionOnBots() {
		for ( Bot b : _bots.values() )
			b.action();
		verifyAndSetNewObjectiveToFinish();
	}

	private void verifyAndSetNewObjectiveToFinish() {
		if (_currentObjective.isAccomplished()) {
			_currentObjective = _mission.nextObjective();
			
			if (_currentObjective != null)
				_bots.get(_currentObjective.getBotType()).unLockToExecuteObjective();
		}
	}
}
