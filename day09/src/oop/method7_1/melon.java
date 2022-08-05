package oop.method7_1;

public class melon {

	//field
	String title;
	String singer; 
	String album;
	int play;
	int like;

	//method
	//오버로딩은 필요한 상황에만 .. 
	void set(String title, String singer, String album, int play, int like){
		
		this.title = title;
		this.singer = singer;
		this.album  = album;
		this.play = play;
		this.like = like;
		
	}

	void vet() {
		
		System.out.print("<음원 정보>");
	
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
		int rankpoint = this.play *2 + this.like/2;
		System.out.println("랭킹 점수: " + rankpoint + "점");
		System.out.println();
		
		
	}
	
}
