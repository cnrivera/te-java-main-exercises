package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BidTest {

	private Bid b;
	
	@Before
	public void setup() {
		b = new Bid("Austin", 100); //Arrange
	}
	
	@Test
	public void getBidder_returns_name_of_bidder() {
		String name = b.getBidder(); //Act
		Assert.assertEquals("Austin", name); //Assert
	}
	
	@Test
	public void getBidAmount_returns_amount_of_bid() {
		int bidAmount = b.getBidAmount();
		Assert.assertEquals(100, bidAmount);
	}
	
}
