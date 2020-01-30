package com.techelevator;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AuctionTest {

	private Auction testAuction;
	
	@Before
	public void setEverythingUp() {
		testAuction = new Auction("Thing");
	}
	
	@Test
	public void high_bid_starts_at_zero() {
		Bid startingBid = testAuction.getHighBid();
		Assert.assertEquals(0, startingBid.getBidAmount());
	}
	
	@Test
	public void auction_keeps_track_of_high_bid() {
		testAuction.placeBid(new Bid("Mickey", 100));
		testAuction.placeBid(new Bid("Donald", 150));
		testAuction.placeBid(new Bid("Goofy", 120));
		
		Bid highBid = testAuction.getHighBid();
		
		Assert.assertEquals("Donald", highBid.getBidder());
		Assert.assertEquals(150, highBid.getBidAmount());
	}
	
	@Test
	public void getItemForSale_returns_name_of_item() {
		String nameOfItem = testAuction.getItemForSale();
		Assert.assertEquals("Thing", nameOfItem);
	}
	
	@Test
	public void getAllBids_returns_right_number_of_bids() {
		testAuction.placeBid(new Bid("Mickey", 100));
		testAuction.placeBid(new Bid("Donald", 150));
		testAuction.placeBid(new Bid("Goofy", 120));
		
		List<Bid> bids = testAuction.getAllBids();
		
		Assert.assertEquals(3, bids.size());
	}
	
	@Test
	public void getAllBids_returns_right_order_of_bids() {
		Bid firstBid = new Bid("Mickey", 100);
		Bid secondBid = new Bid("Donald", 150);
		Bid thirdBid = new Bid("Goofy", 120);
		testAuction.placeBid(firstBid);
		testAuction.placeBid(secondBid);
		testAuction.placeBid(thirdBid);
		
		List<Bid> bids = testAuction.getAllBids();
		
		Assert.assertSame(firstBid, bids.get(0));
		Assert.assertSame(secondBid, bids.get(1));
		Assert.assertSame(thirdBid, bids.get(2));
	}
}
