package palilo.codejam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@SuppressWarnings("serial")
public class Mission extends ArrayList<Objective>{

	private Integer _objectiveIndex = 0;
	private HashMap<BotType, ArrayList<Objective>> _objectiveByBotType;
	private Mission(){
		_objectiveByBotType = new HashMap<BotType, ArrayList<Objective>>();
	}
	
	public static Mission generateMission(String commands){
		String[] exploded = commands.split(" ");
		int i = 0;
		Mission m = new Mission();
		while (i < exploded.length){
			m.add(new Objective(getBot(exploded[i++]), Integer.parseInt(exploded[i++])));
		}
		
		return m;
	}
	
	private static BotType getBot(String botTypeIndentifier) {
		return BotType.valueOf(botTypeIndentifier);
	}

	@Override
	public boolean add(Objective obj) {		
		ArrayList<Objective> objectives = _objectiveByBotType.get(obj.getBotType());
		if (objectives == null)
			objectives = new ArrayList<Objective>();
		
		objectives.add(obj);
		_objectiveByBotType.put(obj.getBotType(), objectives);
		
		return super.add(obj);
	}

	public Set<BotType> getBotTypes() {
		return _objectiveByBotType.keySet();
	}

	public ArrayList<Objective> getObjectsOfType(BotType bt) {
		return _objectiveByBotType.get(bt);
	}

	public boolean hasObjectiveToFinish() {
		for (Objective o : this)
			if (!o.isAccomplished())
				return true;
		
		return false;
	}

	public Objective nextObjective() {
		return getActiveObjective();
	}
	
	private Objective getActiveObjective(){
		if (get(_objectiveIndex).isAccomplished())
			_objectiveIndex++;
		
		if (_objectiveIndex >= size()) return null;
		
		return get(_objectiveIndex);
	}	
}
