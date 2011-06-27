package palilo.codejam;

public enum Direction {
	forward(1), back(-1);
	
	private Integer operator;
	private Direction(Integer op){
		operator = op;
	}
	
	public Integer move(Integer position){
		return position + operator;
	}
}
