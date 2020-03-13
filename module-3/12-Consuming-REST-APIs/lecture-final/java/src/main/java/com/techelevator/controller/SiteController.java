package com.techelevator.controller;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.authentication.UnauthorizedException;
import com.techelevator.model.Amiibo;
import com.techelevator.model.AmiiboDao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * SiteController
 */
@Controller
public class SiteController {
	
	@Autowired
	private AmiiboDao amiiboDao;
    
    @GetMapping("/search")
    public String searchPage(@RequestParam(required = false) String character, ModelMap mm) {
    	
    	if (character != null) {
    		mm.put("amiibos", amiiboDao.getAmiibosForCharacter(character));
    	}
    	
        return "search";
    }
    
    @GetMapping("/details")
    public String detailsPage(@RequestParam String id, ModelMap mm) {
    	mm.put("amiibo", amiiboDao.getAmiiboById(id));
    	return "details";
    }

    @GetMapping("/collection")
    public String collectionPage() {
    	return "collection";
    }
    
    @PostMapping("/add")
    public String addToCollection(@RequestParam String id, HttpSession session) {
    	Set<Amiibo> collection = (Set<Amiibo>) session.getAttribute("collection");
    	if (collection == null) {
    		collection = new HashSet<>();
    		session.setAttribute("collection", collection);
    	}
    	collection.add(amiiboDao.getAmiiboById(id));
    	return "redirect:/collection";
    }
    
}