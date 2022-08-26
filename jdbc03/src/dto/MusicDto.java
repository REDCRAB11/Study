package dto;

public class MusicDto {
	
	private int no;
	private String title; 
	private String artist;
	private String album;
	private int play;
	private String releasetime;
	
	

	@Override
	public String toString() {
		return "MusicDto [no=" + no + ", title=" + title + ", artist=" + artist + ", album=" + album + ", play=" + play
				+ ", releasetime=" + releasetime + "]";
	}



	public int getNo() {
		return no;
	}



	public void setNo(int no) {
		this.no = no;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getArtist() {
		return artist;
	}



	public void setArtist(String artist) {
		this.artist = artist;
	}



	public String getAlbum() {
		return album;
	}



	public void setAlbum(String album) {
		this.album = album;
	}



	public int getPlay() {
		return play;
	}



	public void setPlay(int play) {
		this.play = play;
	}



	public String getReleasetime() {
		return releasetime;
	}



	public void setReleasetime(String releasetime) {
		this.releasetime = releasetime;
	}



	public MusicDto() {
		super();
	}
	
	
	
}
