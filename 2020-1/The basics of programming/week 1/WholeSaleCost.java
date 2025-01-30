public class WholeSaleCost {
	public static void main(String[] args) {
		double coverPrice = 24.95;				//책 정가
		double discountRate = 0.4;				//할인율 40%
		double initialShippingCost = 3.0;			//처음 한 권 배송료
		double additionalShippingCost = 0.75;			//추가 배송료
		int quantity = 60;					//주문한 양
		
		//책값
		double bookCost = coverPrice * (1.0 - discountRate) * quantity;

		//배송료
		double shippingCost = initialShippingCost + (quantity - 1) * additionalShippingCost;

		//총 가격
		double totalCost = bookCost + shippingCost;

		//출력
		System.out.println("총 구매 가격은 " + totalCost + "입니다.");
		System.out.printf("총 구매 가격은 %.2f입니다." , totalCost);	//형식지정자를 이용하여 소수점 아래 두 자리까지 출력
	}

}