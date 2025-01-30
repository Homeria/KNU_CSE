public class SphereVolume {
	public static void main(String[] args) {
		double pi = 3.14;						//원주율
		double radius = 5.0;						//반지름
		double volume = 4.0 / 3.0 * pi * radius * radius * radius;		//부피
		System.out.println("구의 부피는 " + volume + "입니다.");
		System.out.printf("구의 부피는 %.2f입니다.", volume); //형식지정자를 이용하여 소수점 아래 두자리까지 출력
	}

}