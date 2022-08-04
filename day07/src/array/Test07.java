package array;

public class Test07 {

	public static void main(String[] args) {
		
		float[] data = new float[] {(float) 150.5, (float) 185.2, (float) 177.9, (float) 175.4, (float) 163.6};
		
		// 신장 배열 
		
		for(int i =0; i<=4; i++) {
			System.out.println("신장 : " + data[i]);
		}
		
		//평균 신장 배열 
		
		float total=0;
		for(int i=0; i<=4; i++) {
			total += data[i];
		}

		float avg = total/5;
		System.out.println("신장 평균: " + avg);
		
		// 가장 작은 학생의 위치와 신장 출력 
		float maxi = data[0];
		
		for(int i =1; i<4; i++) {
			if(maxi > data[i]) {
				maxi = data[i];
				System.out.println("가장 작은 신장: " + maxi);
			} 
		}
			
			int index =0;
		for(int i1=1; i1<4; i1++) {
			if(data[index] < data[i1]) {
				index=i1;
			}
			}
		System.out.println("가장 작은 신장 위치: " + index + "번");
		
		
		

		//평균에 가장 가까운 학생 출력 
		double[] gap = new double[data.length];
		for(int i=0; i<data.length; i++) {
			if(data[i] > avg) {//data[i]가 의미하는 것 
				gap[i] = data[i]-avg; // gap[i]가 의미하는 것 
			}else {
				gap[i] = avg - data[i]; // 
			}
		}
		
		index=0;
		for(int i=0; i<data.length; i++) {
			if(gap[index] > gap[i]) {// gap[index]가 의미하는 것 
				index=i;
			}
		
//		for(int i=0; i<4; i++) {
//			if(data[i] <= avg || avg >= data[i]) {
//				
//				System.out.println("평균과 가까운 학생의 신장: " + data[i]);
//		}
		}
		
		
		System.out.println("평균과 가장 가까운 데이터는" + index + "위치에 있습니다.");
		System.out.println("데이터: " + data[index]+ "cm");
		
		
	}

}
