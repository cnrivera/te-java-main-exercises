package com.techelevator.shopping.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.shopping.model.Item;

@Component
public class JsonItemDao implements ItemDao {

	private Map<Integer, Item> groceries = new HashMap<>();

	public JsonItemDao() throws JsonParseException, JsonMappingException, IOException {
		loadJSON();
	}

	@Override
	public List<Item> list() {
		return new ArrayList<Item>(groceries.values());
	}

	@Override
	public Item create(Item item) {
		int max = Collections.max(groceries.keySet());
		item.setId(max+1);
		groceries.put(item.getId(), item);
		return item;
	}

	@Override
	public Item read(int id) {
		return groceries.get(id);
	}

	@Override
	public Item update(Item item) {
		Item result = null;
		if (groceries.get(item.getId()) != null) {
			groceries.put(item.getId(), item);
			result = item;
		}
		return result;
	}

	@Override
	public void delete(int id) {
		groceries.remove(id);
	}

	private void loadJSON() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		InputStream inputStream = this.getClass().getResourceAsStream("/data.json");
		Item[] jsondata = mapper.readValue(inputStream, Item[].class);
		for (Item item : jsondata) {
			groceries.put(item.getId(), item);
		}
	}

}
