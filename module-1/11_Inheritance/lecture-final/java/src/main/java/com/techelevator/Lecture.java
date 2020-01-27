package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Lecture {

	public static void main(String[] args) {

		
		Auction firstAuction = new Auction("Air Jordans");
		
		Bid myBid = new Bid("David", 100);
		firstAuction.placeBid(myBid);
		
		firstAuction.placeBid(new Bid("Austin", 210));
		firstAuction.placeBid(new Bid("Zach", 209));
		
		System.out.println("The high bidder on the " + firstAuction.getItemForSale() + " is " +
							firstAuction.getHighBid().getBidder());
		
		System.out.println(firstAuction.getAllBids());
		
		ReserveAuction secondAuction = new ReserveAuction("Grilled Cheese Sandwich", 5);
		
		secondAuction.placeBid(new Bid("Matt", 2));
		secondAuction.placeBid(new Bid("David", 4));
		secondAuction.placeBid(new Bid("Matt", 5));
		
		System.out.println("The high bidder on the " + secondAuction.getItemForSale() + " is " +
				secondAuction.getHighBid().getBidder());
		
		BuyoutAuction thirdAuction = new BuyoutAuction("Yacht", 1_000_000);
		
		thirdAuction.placeBid(new Bid("Drew", 1));
		thirdAuction.placeBid(new Bid("Steve", 100));
		thirdAuction.placeBid(new Bid("Maggie", 10000));
		thirdAuction.placeBid(new Bid("Steve", 1_500_000));
		thirdAuction.placeBid(new Bid("Maggie", 2_000_000));
		
		System.out.println("The high bidder on the " + thirdAuction.getItemForSale() + " is " +
				thirdAuction.getHighBid().getBidder() + " for $" + thirdAuction.getHighBid().getBidAmount());

		
		BigDecimal amount = new BigDecimal("2.50");  //Setting with String also sets scale (how many decimal places)
		BigDecimal quarter = new BigDecimal("0.25");
		BigDecimal myAllowance = BigDecimal.ZERO;
		
		myAllowance = myAllowance.add(new BigDecimal("1.00"));
		myAllowance = myAllowance.add(BigDecimal.valueOf(1.00)); //Use valueOf if need to set from double
		
		System.out.println(myAllowance);
		
		System.out.println(myAllowance.divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP)); //Specify rounding to avoid exception.
		
		if (myAllowance.compareTo(new BigDecimal("1.00")) == 1) {
			System.out.println("Allowance more than a dollar.");
		}
		
		// <  | < 0 or == -1
		// <= | <= 0
		// == | == 0
		// >= | >= 0
		// >  | > 0 or == 1
		
		
	}

}
 