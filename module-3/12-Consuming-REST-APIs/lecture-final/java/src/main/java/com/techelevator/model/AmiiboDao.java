package com.techelevator.model;

import java.util.List;

public interface AmiiboDao {

	List<Amiibo> getAmiibosForCharacter(String character);
	Amiibo getAmiiboById(String id);
}
