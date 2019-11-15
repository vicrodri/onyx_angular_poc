/**
 * 
 */
package com.vicrodri.angularpoc.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socgen.sng.util.context.SessionContext;
import com.socgen.sng.util.dj.Dj;
import com.socgen.sng.util.gen.Gen;

/**
 * @author vrodriguezgu
 *
 */
@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class InitController {
   
    @GetMapping("/init")
    public String init() {
    	loadParameters();
    	Dj.debJournee();
		Gen.debSession();
		
    	return "Inicie";
    }

    private void loadParameters() {
		SessionContext context = SessionContext.getInstance();
		context.setMatricule(999452282L);
		context.setHostName("VDF033JDV700");
		context.setReseau(1610);
		context.setOmf(479);
		context.setWebServiceHabilitation(false);
    }
}