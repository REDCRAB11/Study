package select;

// DB에 한줄을 옮겨 담을 수 있도록 필드를 구
public class Country {
	private int rank;
	private String state; 
	private double score;
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Country [rank=" + rank + ", state=" + state + ", score=" + score + "]";
	}
	
	
}
