package com.vicrodri.angularpoc.util;

import org.apache.commons.lang.mutable.MutableBoolean;

import com.socgen.bc.dossier.TRgCl;
import com.socgen.bc.enums.TBcRetour;
import com.socgen.bc.pojo.TIdfCpt;
import com.socgen.bc.pojo.TRgCpt;
import com.socgen.bc.util.Bc2;
import com.socgen.rec.dossier.TQuestion;
import com.socgen.rec.dossier.TReponse;
import com.socgen.sng.cent.tr.TR;
import com.socgen.sng.cent.tr.TTrOk;
import com.socgen.sng.core.cdn.TCClient;
import com.socgen.sng.core.cdn.TEq;
import com.socgen.sng.core.mutable.MutableString;
import com.socgen.sng.util.DateUtil;
import com.socgen.sng.util.bf.Bf;
import com.socgen.sng.util.context.SessionContext;

public class Rectif {

	public static final String MNEMO = "REC";

	public static final String NUM_VERS = "1432";

	public static final String BIB_ECRAN = "REC1400.xqtf";

	public static final int NO_QUESTION = 1972;

	public static final int NO_REPONSE = 6972;

	public static final int CTG_DO_RECTIF = 12328;

	/**
	 * (*nbre de lignes max par ecran*)
	 */

	public static final int NB_MAX_LIG = 14;

	/**
	 * (*no ligne max de l'ecran (=nb_max_lig - 1) *)
	 */

	public static final int MAX_LIG = 13;
	
	/**
	 * Number of rows to be displayed in the datatable
	 */
	public static final int NB_MAX_ROWS = 14;
	
	public static final int MAX_ROWS = 13;
	
	// MIG_SUIVI [PSYSTEM_0_1.REC.REC1432.rech_libelles(0)] - Ne pas supprimer ### source : rech_libelles ### cible : rechLibelles ### 
		public static TReponse rechLibelles(TQuestion question) {

			//TQuestion question = new TQuestion();
			TReponse reponse = new TReponse();
			TTrOk repTrQuestion = TTrOk.OK;
			int i;
			int j;

//			TEq tEq = question.getEntete();
//			tEq.setVerItr(1);
//			tEq.setOmfUser(SessionContext.getInstance().getContext().getDefUser().getUser());
//			tEq.setDItr(SessionContext.getInstance().getContext().getDatejour());
//
//			question.setBanc(SessionContext.getInstance().getContext().getBanque());
//			question.setAgenceOpe(SessionContext.getInstance().getContext().getAgence());
//			question.setEntite(SessionContext.getInstance().getContext().getDefUser().getCdnEntite());
////			if (ApplicationContext.getInstance().getRectifContext().getTitre() == TTypTitre.COUPONS) {
//				question.setChoix("C");
////			} else {
////				question.setChoix("M");
////			}
//			question.setCleSuite(0);		
//			ApplicationContext.getInstance().getRectifContext().getOriRec().setNbLibel(0);
			reponse.setCleSuite(999);
			// TODO MIG MIG [PSYSTEM_0_1.REC.REC1432.rech_libelles(0)] - [PSYSTEM_0_1.REC.REC1432.rech_libelles(0)] - Améliorer la condition de fin -- TODO - Repeat
			do {			
				repTrQuestion = TR.trQrService(Rectif.NO_QUESTION, question, reponse);
				if (repTrQuestion != TTrOk.OK) {
					interpel(19);
					reponse.setCleSuite(0);
				} else {
					if (reponse.getRetOmf() != 0) {
						interpel(20);
						reponse.setCleSuite(0);
					} else {
						if (reponse.getRetApl() != 0) {
							Bf.smesg(reponse.getLibAno());
							reponse.setCleSuite(0);
						} else {
//							for (i = 0; i <= reponse.getNbLig() - 1; i++) {
//								j = reponse.getLigne()[i].getNoOrdre() - 1;
//								ApplicationContext.getInstance().getRectifContext().getOriRec().getLigne()[j].setCodeRec(reponse.getLigne()[i].getCodeRec());
//								ApplicationContext.getInstance().getRectifContext().getOriRec().getLigne()[j].setLibelle(reponse.getLigne()[i].getLibelle());
//								ApplicationContext.getInstance().getRectifContext().getOriRec().getLigne()[j].setMtt(0);
//								ApplicationContext.getInstance().getRectifContext().getOriRec().setNbLibel(
//										ApplicationContext.getInstance().getRectifContext().getOriRec().getNbLibel() + 1);
//							}
//							for (int k=1;k<30;k++) {
//								ApplicationContext.getInstance().getRectifContext().getOriRec().getLigne()[k].setCodeRec("8");
//								ApplicationContext.getInstance().getRectifContext().getOriRec().getLigne()[k].setLibelle("Soy una Libelle");
//								ApplicationContext.getInstance().getRectifContext().getOriRec().getLigne()[k].setMtt(8);
//								ApplicationContext.getInstance().getRectifContext().getOriRec().setNbLibel(
//										ApplicationContext.getInstance().getRectifContext().getOriRec().getNbLibel() + 1);
//							}
						}
					}
				}
				if (reponse.getCleSuite() != 0) {
					question.setCleSuite(reponse.getCleSuite());
				}
			} while (!(reponse.getCleSuite() == 0));
			/* (* init libelles a blanc pour affichage correct derniere page d'ecran*) */
//			for (i = ApplicationContext.getInstance().getRectifContext().getOriRec().getNbLibel(); i <= 99; i++) {
//				ApplicationContext.getInstance().getRectifContext().getOriRec().getLigne()[i].setCodeRec(" ");
//				ApplicationContext.getInstance().getRectifContext().getOriRec().getLigne()[i].setLibelle(" ");
//				ApplicationContext.getInstance().getRectifContext().getOriRec().getLigne()[i].setMtt(0);
//			}
			return reponse;
		}
		
		public static void interpel(final int choixMes) {

			switch (choixMes) {	
				case 1 : 
					Bf.smesg("Dossier enregistré");
					break;			
				case 2 : 
					Bf.smesg("Dossier courant perdu");
					break;			
				case 3 : 
					Bf.smesg("Pas de dossier précédent");
					break;			
				case 4 : 
					Bf.smesg("Fin de liste");
					break;			
				case 5 : 
					Bf.smesg("Dossier en cours de création");
					break;			
				case 6 : 
					Bf.smesg("Dernier dossier");
					break;			
				case 7 : 
					Bf.smesg("Client trouvé différent de celui demandé");
					break;			
				case 8 : 
					Bf.smesg("Pas de dossier rectification fiscale dans la base");
					break;			
				case 9 : 
					Bf.smesg("Création impossible,base pleine");
					break;			
				case 10 : 
					Bf.smesg("Opération non autorisée");
					break;			
				case 11 : 
					Bf.smesg("Anomalie : dossier non transmis au CTI");
					break;			
				case 12 : 
					Bf.smesg("Rectification fiscale incorrecte");
					break;			
				case 13 : 
					Bf.smesg("Renseigner toutes les données concernant la valeur");
					break;			
				case 14 : 
					Bf.smesg("Numéro de compte incorrect");
					break;			
				case 15 : 
					Bf.smesg("Compte inexistant en BCC");
					break;			
				case 16 : 
					Bf.smesg("Dossier non visualisable par cette option");
					break;			
				case 17 : 
					Bf.smesg("La date crédit doit être inférieure à la date jour");
					break;			
				case 18 : 
					Bf.smesg("Valeur non autorisée pour cette option");
					break;			
				case 19 : 
					Bf.smesg("Pas de liaison avec le CTI");
					break;			
				case 20 : 
					Bf.smesg("Incident communication CTI (PB transaction CICS)");
					break;			
				case 21 : 
					Bf.smesg("Renseigner au moins 1 montant");
					break;			
				case 22 : 
					Bf.smesg("seules 20 rubriques seront prises en compte");
					break;			
				case 23 : 
					/* (*1416*) */
					Bf.smesg("Une saisie a déjà été faite ce jour pour ce compte");
					break;			
				default : 
					break;			
			}
		}
		
		// MIG_SUIVI [PSYSTEM_0_1.REC.REC1432.verif_bcc(5)] - Ne pas supprimer ### source : verif_bcc ### cible : verifBcc ### 
		public static String verifBcc(final long banque, final TCClient compte, final long ageClaConc, 
				final MutableBoolean clientOk_Mutable, final MutableString nomClient_Mutable) {

			boolean clientOk = clientOk_Mutable.booleanValue();
			String nomClient = nomClient_Mutable.stringValue();
			TIdfCpt idfCpt = new TIdfCpt();
			TRgCpt rgCpt = new TRgCpt();
			int resultat = 0;
			long idfCl;
			TRgCl clRg = new TRgCl();
			boolean cloture;
			clientOk = false;
			cloture = false;
			idfCpt.setBanque(banque);
			idfCpt.setCompte(compte);
			resultat = Bc2.bcCptInterroger(idfCpt, rgCpt, resultat);
			/* omega
			 *   if (resultat = 0) and (rg_cpt.d_cloture.m <> 0) then */
			if (resultat == TBcRetour.RAS_TOUT_OK && DateUtil.getMonth(rgCpt.getdCloture()) != 0) {
				//ApplicationContext.getInstance().getRectifContext().getMessages().add("Compte clôturé");
				cloture = true;
			}
			/* omega
			 *   if resultat = 0 then */
			if (resultat == TBcRetour.RAS_TOUT_OK) {
				idfCl = ageClaConc;
				resultat = Bc2.bcClIdfInterroger(banque, idfCl, clRg, resultat);
				/* omega
				 *       case resultat of
				 *          13     : begin
				 *                    smesg('Client en cours de clôture') ;
				 *                    cloture:=true;
				 *                   end;
				 *          14     : begin
				 *                    smesg('Client clôturé') ;
				 *                    cloture:=true;
				 *                   end;
				 *       end;
				 *       if (resultat = 9) or (resultat = 13) or (resultat = 14) then */
				switch (resultat) {	
					case TBcRetour.CLOTURE_CLIENT_EN_COURS: 
//						Bf.smesg("Client en cours de clôture");
						//ApplicationContext.getInstance().getRectifContext().getMessages().add("Client en cours de clôture");
						cloture = true;
						break;				
					case TBcRetour.CLIENT_CLOTURE: 
//						Bf.smesg("Client clôturé");
						//ApplicationContext.getInstance().getRectifContext().getMessages().add("Client clôturé");
						cloture = true;
						break;				
					default : 
						break;				
				}
				if (resultat == TBcRetour.LE_CLIENT_EXISTE || 
						resultat == TBcRetour.CLOTURE_CLIENT_EN_COURS || 
						resultat == TBcRetour.CLIENT_CLOTURE) {
					nomClient = clRg.getRgx().getNomContracte();
					clientOk = true;
				} else {
//					ApplicationContext.getInstance().getRectifContext().getMessages().add(interpelText(15));
//					ApplicationContext.getInstance().getRectifContext().setToutOk(false);
				}
			} else {
//				ApplicationContext.getInstance().getRectifContext().setToutOk(false);
				/* omega
				 *        case resultat of
				 *          1      : smesg('Liaison CTI momentanément interrompue') ;
				 *          2      : smesg('Mode dégradé') ;
				 *          3      : smesg('Base GD inaccessible') ;
				 *          4      : smesg('Arguments incorrects') ;
				 *          5      : smesg('Contrôles non satisfaits') ;
				 *          12     : smesg('Client inconnu') ;
				 *          17     : smesg('Compte inconnu') ;
				 *          23     : smesg('Contrat inconnu dans la base') ;
				 *          27     : smesg('Accés refusé , autorisation insuffisante') ;
				 *          28     : smesg('Exécution refusée , autorisation insuffisante') ;
				 *          29     : smesg('Reprise impossible') ;
				 *          32     : smesg('Contrat existant') ;
				 *        end */
				switch (resultat) {	
					case TBcRetour.LIAISON_INTERROMPUE: 
						Bf.smesg("Liaison CTI momentanément interrompue");
						break;				
					case TBcRetour.MODE_DEGRADE: 
						Bf.smesg("Mode dégradé");
						break;				
					case TBcRetour.GD_INACCESSIBLE: 
						Bf.smesg("Base GD inaccessible");
						break;				
					case TBcRetour.ARGUMENTS_INCORRECTS: 
						Bf.smesg("Arguments incorrects");
						break;				
					case TBcRetour.CONTROLES_NON_SATISFAITS: 
						Bf.smesg("Contrôles non satisfaits");
						break;				
					case TBcRetour.CLIENT_INCONNU: 
						Bf.smesg("Client inconnu");
						break;				
					case TBcRetour.COMPTE_INCONNU: 
						Bf.smesg("Compte inconnu");
						break;				
					case TBcRetour.CONTRAT_INCONNU: 
						Bf.smesg("Contrat inconnu dans la base");
						break;				
					case TBcRetour.ACCES_REFUSE: 
						Bf.smesg("Accés refusé , autorisation insuffisante");
						break;				
					case TBcRetour.EXECUTION_REFUSEE: 
						Bf.smesg("Exécution refusée , autorisation insuffisante");
						break;				
					case TBcRetour.REPRISE_IMPOSSIBLE: 
						Bf.smesg("Reprise impossible");
						break;				
					case TBcRetour.CONTRAT_EXISTE: 
						Bf.smesg("Contrat existant");
						break;				
					default : 
						break;				
				}
			}
			if (cloture && SessionContext.getInstance().getContext().getAgence() != 2101 && 
					SessionContext.getInstance().getContext().getAgence() != 2073 && SessionContext.getInstance().getContext().getAgence() != 2398) {
//				ApplicationContext.getInstance().getRectifContext().setAbandon(true);
//				ApplicationContext.getInstance().getRectifContext().getMessages().add("contacter le DTB Titres");
			}
			clientOk_Mutable.setValue(clientOk);
			nomClient_Mutable.setValue(nomClient);
			return nomClient;
		}
}
