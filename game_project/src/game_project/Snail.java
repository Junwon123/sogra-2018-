package game_project;

public class Snail {
	private int current_location;
	private int rank;
	private boolean is_ranked;
	private boolean is_arrived;
	
	public Snail() {
		this.current_location = 0;
		this.rank = -1;
		this.is_arrived = false;
		this.is_ranked = false;
	}
	
	public void move_foward(int number) {
		current_location = current_location + number;
	}
	
	public int getCurrent_location() {
		return current_location;
	}
	
	public int getRank() {
		return rank;
	}
	
	public boolean get_is_arrived() {
		return is_arrived;
	}
	
	public boolean get_is_ranked() {
		return is_ranked;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public void set_is_arrived() {
		this.is_arrived = true;
	}
	
	public void set_is_ranked() {
		this.is_ranked = true;
	}
}
