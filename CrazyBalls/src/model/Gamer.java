package model;

public class Gamer {
	private int level;
	private int score;
	private String name;
	public Gamer(int level, int score, String name) {
		super();
		this.level = level;
		this.score = score;
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
