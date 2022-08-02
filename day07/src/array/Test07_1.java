package array;

public class Test07_1 {

	public static void main(String[] args) {
		
		// 데이터 준비 
		double[] data = new double[] {150.5, 185.2, 177.9, 175.4, 163.6};
		
		// 출력 
		for(int i=0; i <data.length; i++) {
			System.out.println("신장 = " + data[i] + "cm");
		}
		
		// 평균 
		double total = 0; 
		for(int i=0; i <data.length; i++) {			
			total += data[i];
		}
		System.out.println("합계 = " + total);
		
		double avg = total/data.length;
		System.out.println("평균 = " + avg + "cm");
		
		
		// 최솟값의 위치와 데이터 
		int index = 0;
		for(int i=1; i < data.length; i++) {
			if(data[index] > data[i]) {
				index = i;
		}
			
		}
		
		System.out.println("작은 값은 " + index + "위치에 있습니다.");
		System.out.println("데이터는 " + data[index] + "입니다.");
		
		// 평균에 가장 가까운 데이터 
		// 1. 새로운 배열을 같은 크기로 준비한다. 
		// 2. 모든 데이터를 평균에서 뺀 다음 저장한다 
		// 3. 비교를 통해 가장 작은 값을 찾는다. (차이가 가장 적은 값) 
		
		
		double[] gap = new double[data.length];
		
		for(int i=0; i < data.length; i++) {
			// 절대값 : 음수가 발생하지 않도록 차이 계산
			if(data[i] > avg) {
			gap[i]= data[i] -avg;
		}
			else {
				gap[i]= avg - data[i];
		}
		}
			
			
		// gap에서 최소값 위치를 찾으면 평균에 가장 가까운 데이터의 위치를 알 수 있다.	
		index=0;
		for(int i=0; i < data.length; i++) {
//			System.out.println("gap = " + gap[i]); // 음수가 나오는 값은 양수로 나오게끔 고로 큰거에ㅓㅅ 작은거 뺴면 됨 
			if(gap[index] > gap[i]) {
				index=i;
		}
		}
	
		System.out.println("평균과 가장 가까운 데이터는" + index + "위치에 있습니다.");
		System.out.println("데이터: " + data[index]+ "cm");
		
		
		
		
	}
}
