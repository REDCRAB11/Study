package oop.method7;

public class melon {

	String title;
	String singer; 
	String album;
	double play;
	double like;

	void set(String title, String singer, String album, double play, double like){
		
		this.title = title;
		this.singer = singer;
		this.album  = album;
		this.play = play;
		this.like = like;
		
	}
	

	void vet() {

		double rank = (int)(this.play * 2) + (this.like/2);		
		
		if(this.play > 100000) {
			System.out.println("<<BEST!>>");
		} 
		
	
		if(this.like > 100000) {
			System.out.println("<<인기곡!>>");
		}
		
		System.out.println("가수: " + singer);
		System.out.println("앨범: " + album);
		System.out.println("재생수: "+ play);
		System.out.println("좋아요 수: " + like);
		System.out.println("랭킹 점수: " + rank + "점");
		System.out.println();
		
	}
	
}
