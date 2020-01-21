/**
 * 
 */
package com.vicrodri.angularpoc.controller;

import java.util.Date;

import javax.validation.Valid;

import org.apache.commons.lang.mutable.MutableBoolean;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.socgen.rec.dossier.TQuestion;
import com.socgen.rec.dossier.TReponse;
import com.socgen.sng.core.cdn.TCClient;
import com.socgen.sng.core.cdn.TEq;
import com.socgen.sng.core.mutable.MutableString;
import com.socgen.sng.util.context.SessionContext;
import com.socgen.sng.util.dj.Dj;
import com.socgen.sng.util.gen.Gen;
import com.vicrodri.angularpoc.util.Rectif;

/**
 * @author vrodriguezgu
 *
 */
@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class InitController {
   
    @GetMapping("/init")
    public String init(@RequestHeader("Authorization") String authString) {
    	loadParameters(authString.split(" ")[1]);
    	Dj.debJournee();
		Gen.debSession();
		
    	return "Inicie";
    }

    @GetMapping("/rechLibelles")
    public TReponse rechLibelles(@RequestHeader("Authorization") String authString) {
    	loadParameters(authString.split(" ")[1]);
    	Dj.debJournee();
		Gen.debSession();
    	TEq header = new TEq(0, 1, SessionContext.getInstance().getContext().getDefUser().getUser(), 
    			SessionContext.getInstance().getContext().getDatejour());
    	TQuestion question = new TQuestion();
    	question.setBanc(SessionContext.getInstance().getContext().getBanque());
    	question.setAgenceOpe(SessionContext.getInstance().getContext().getAgence());
    	question.setEntite(SessionContext.getInstance().getContext().getDefUser().getCdnEntite());
    	question.setChoix("C");
    	question.setCleSuite(0);
    	question.setEntete(header);
    	
    	TReponse response = Rectif.rechLibelles(question);
		System.out.println(response);
    	return response;
    }
    
    @PostMapping("/getClient")
    public String getClient(@RequestHeader("Authorization") String authString, @Valid @RequestBody TCClient client) {
    	loadParameters(authString.split(" ")[1]);
    	Dj.debJournee();
    	Gen.debSession();
    	//TCClient clientData = new TCClient(2020, 100000, 2, 0);
		String response = Rectif.verifBcc(30076, client, (1000000L * client.getAgence()) + client.getClassement(), new MutableBoolean(true), new MutableString(""));
		System.out.println(response);
    	return response.trim();
    }
    
    private void loadParameters(String userString) {
    	
    	JsonObject jsonObject = new JsonParser().parse(new String(Base64Utils.decodeFromString(userString))).getAsJsonObject();
		SessionContext context = SessionContext.getInstance();
		context.setMatricule(jsonObject.get("matricule").getAsLong());
		context.setHostName("VDF033JDV700");
		context.setReseau(jsonObject.get("numRL").getAsInt());
		context.setOmf(jsonObject.get("omf").getAsInt());
		context.setWebServiceHabilitation(false);
		
		//
		context.getContext().setDatejour(new Date());
		context.getContext().setBanque(30076);
		context.getContext().getDefUser().setUser(jsonObject.get("matricule").getAsLong());
    }
}