package ontology;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.OWLXMLDocumentFormat;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.DefaultPrefixManager;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by ManojPrabhakar on 7/22/2016.
 */
public class disease {
    public static void main(String args[])throws Exception {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager(); //creating ontology manager
        OWLDataFactory df = manager.getOWLDataFactory(); //In order to create objects that represent entities we need a



        OWLOntology ontology = manager.createOntology(IRI.create("https://www.kdm.com/OWL/", "Disease"));
        PrefixManager pm = new DefaultPrefixManager(null, null,
                "https://www.kdm.com/OWL/Disease#");

        OWLClass Disease = df.getOWLClass(":Disease", pm);
        OWLDeclarationAxiom declarationAxiomDisease = df.getOWLDeclarationAxiom(Disease);
        manager.addAxiom(ontology, declarationAxiomDisease);

        //************************************

        //Creating Subclasses for Cancer class
        OWLClass Cancer = df.getOWLClass(":Cancer", pm);
        OWLClass Virulinfection  = df.getOWLClass(":Virulinfection", pm);
       // OWLClass Brain = df.getOWLClass(":Brain", pm);

        OWLSubClassOfAxiom declarationAxiomCancer = df.getOWLSubClassOfAxiom(Cancer, Disease);
        OWLSubClassOfAxiom declarationAxiomVirulinfection = df.getOWLSubClassOfAxiom(Virulinfection,Disease);
       // OWLSubClassOfAxiom declarationAxiomBrain = df.getOWLSubClassOfAxiom(Brain, Cancer);

        manager.addAxiom(ontology, declarationAxiomCancer);
        manager.addAxiom(ontology, declarationAxiomVirulinfection);
       // manager.addAxiom(ontology, declarationAxiomBrain);

        //**************************************

        //Creating Subclasses for Cancer class
        OWLClass Skin = df.getOWLClass(":Skin", pm);
        OWLClass Lung  = df.getOWLClass(":Lung", pm);
        OWLClass Brain = df.getOWLClass(":Brain", pm);

        OWLSubClassOfAxiom declarationAxiomSkin = df.getOWLSubClassOfAxiom(Skin, Cancer);
        OWLSubClassOfAxiom declarationAxiomLung = df.getOWLSubClassOfAxiom(Lung,Cancer);
        OWLSubClassOfAxiom declarationAxiomBrain = df.getOWLSubClassOfAxiom(Brain, Cancer);

        manager.addAxiom(ontology, declarationAxiomSkin);
        manager.addAxiom(ontology, declarationAxiomLung);
        manager.addAxiom(ontology, declarationAxiomBrain);

        //Making all classes Disjoint to each other
       // OWLDisjointClassesAxiom disjointClassesAxiom = df.getOWLDisjointClassesAxiom(Skin, Lung, Brain);
       // manager.addAxiom(ontology, disjointClassesAxiom);

        //Creating Subclasses for Skin class
        OWLClass SkinCancerSymptoms = df.getOWLClass(":SkinCancerSymptoms", pm);
        OWLClass SkinCancerBodyparts  = df.getOWLClass(":SkinCancerBodyparts", pm);
        OWLClass SkinCancerPrevention = df.getOWLClass(":SkinCancerPrevention", pm);

        OWLSubClassOfAxiom declarationAxiomSkinCancerSymptoms = df.getOWLSubClassOfAxiom(SkinCancerSymptoms, Skin);
        OWLSubClassOfAxiom declarationAxiomSkinCancerBodyparts = df.getOWLSubClassOfAxiom(SkinCancerBodyparts,Skin);
        OWLSubClassOfAxiom declarationAxiomSkinCancerPrevention = df.getOWLSubClassOfAxiom(SkinCancerPrevention, Skin);

        manager.addAxiom(ontology, declarationAxiomSkinCancerSymptoms);
        manager.addAxiom(ontology, declarationAxiomSkinCancerBodyparts);
        manager.addAxiom(ontology, declarationAxiomSkinCancerPrevention);


//        //Creating Subclasses for SkinCancerSymptoms class
//        OWLClass chestpain = df.getOWLClass(":chestpain", pm);
//        OWLClass fatigue  = df.getOWLClass(":fatigue", pm);
//        OWLClass wheezing = df.getOWLClass(":wheezing", pm);
//
//        OWLSubClassOfAxiom declarationAxiomchestpain = df.getOWLSubClassOfAxiom(chestpain, SkinCancerSymptoms);
//        OWLSubClassOfAxiom declarationAxiomfatigue = df.getOWLSubClassOfAxiom(fatigue, SkinCancerSymptoms);
//        OWLSubClassOfAxiom declarationAxiomwheezing = df.getOWLSubClassOfAxiom(wheezing, SkinCancerSymptoms);
//
//        manager.addAxiom(ontology, declarationAxiomchestpain);
//        manager.addAxiom(ontology, declarationAxiomfatigue);
//        manager.addAxiom(ontology, declarationAxiomwheezing);



        //Creating Subclasses for SkinCancerSymptoms class
        OWLClass lumps = df.getOWLClass(":lumps", pm);
        OWLClass ulcer  = df.getOWLClass(":ulcer", pm);
        OWLClass scalypatch = df.getOWLClass(":scalypatch", pm);

        OWLSubClassOfAxiom declarationAxiomlumps = df.getOWLSubClassOfAxiom(lumps, SkinCancerSymptoms);
        OWLSubClassOfAxiom declarationAxiomulcer = df.getOWLSubClassOfAxiom(ulcer, SkinCancerSymptoms);
        OWLSubClassOfAxiom declarationAxiomscalypatch = df.getOWLSubClassOfAxiom(scalypatch, SkinCancerSymptoms);

        manager.addAxiom(ontology, declarationAxiomlumps);
        manager.addAxiom(ontology, declarationAxiomulcer);
        manager.addAxiom(ontology, declarationAxiomscalypatch);


        //Creating Subclasses for SkinCancerBodyparts class
        OWLClass brain = df.getOWLClass(":brain", pm);
        OWLClass liver  = df.getOWLClass(":liver", pm);
        OWLClass pancreas = df.getOWLClass(":pancreas", pm);

        OWLSubClassOfAxiom declarationAxiombrain = df.getOWLSubClassOfAxiom(brain, SkinCancerBodyparts);
        OWLSubClassOfAxiom declarationAxioliver = df.getOWLSubClassOfAxiom(liver, SkinCancerBodyparts);
        OWLSubClassOfAxiom declarationAxiompancreas = df.getOWLSubClassOfAxiom(pancreas, SkinCancerBodyparts);

        manager.addAxiom(ontology, declarationAxiombrain);
        manager.addAxiom(ontology, declarationAxioliver);
        manager.addAxiom(ontology, declarationAxiompancreas);


        //Creating Subclasses for SkinCancerPrevention class
        OWLClass burns = df.getOWLClass(":burns", pm);
        OWLClass tanning  = df.getOWLClass(":tanning", pm);
        OWLClass UVradiation = df.getOWLClass(":UVradiation", pm);

        OWLSubClassOfAxiom declarationAxiomburns = df.getOWLSubClassOfAxiom(burns, SkinCancerPrevention);
        OWLSubClassOfAxiom declarationAxiomtanning = df.getOWLSubClassOfAxiom(tanning, SkinCancerPrevention);
        OWLSubClassOfAxiom declarationAxiomUVradiation = df.getOWLSubClassOfAxiom(UVradiation, SkinCancerPrevention);

        manager.addAxiom(ontology, declarationAxiomburns);
        manager.addAxiom(ontology, declarationAxiomtanning);
        manager.addAxiom(ontology, declarationAxiomUVradiation);


        //***********************************************************************************************************************


        //Creating Subclasses for Lungclass
        OWLClass LungCancerSymptoms = df.getOWLClass(":LungCancerSymptoms", pm);
        OWLClass LungCancerBodyparts  = df.getOWLClass(":LungCancerBodyparts", pm);
        OWLClass LungCancerPrevention = df.getOWLClass(":LungCancerPrevention", pm);

        OWLSubClassOfAxiom declarationAxiomLungCancerSymtoms = df.getOWLSubClassOfAxiom(LungCancerSymptoms, Lung);
        OWLSubClassOfAxiom declarationAxiomLungCancerBodyparts = df.getOWLSubClassOfAxiom(LungCancerBodyparts,Lung);
        OWLSubClassOfAxiom declarationAxiomLungCancerPrevention = df.getOWLSubClassOfAxiom(LungCancerPrevention, Lung);

        manager.addAxiom(ontology, declarationAxiomLungCancerSymtoms);
        manager.addAxiom(ontology, declarationAxiomLungCancerBodyparts);
        manager.addAxiom(ontology, declarationAxiomLungCancerPrevention);


//        //Creating Subclasses for LungCancerSymptoms class
        OWLClass chestpain = df.getOWLClass(":chestpain", pm);
        OWLClass fatigue  = df.getOWLClass(":fatigue", pm);
        OWLClass wheezing = df.getOWLClass(":wheezing", pm);

        OWLSubClassOfAxiom declarationAxiomchestpain = df.getOWLSubClassOfAxiom(chestpain, LungCancerSymptoms);
        OWLSubClassOfAxiom declarationAxiomfatigue = df.getOWLSubClassOfAxiom(fatigue, LungCancerSymptoms);
        OWLSubClassOfAxiom declarationAxiomwheezing = df.getOWLSubClassOfAxiom(wheezing, LungCancerSymptoms);

        manager.addAxiom(ontology, declarationAxiomchestpain);
        manager.addAxiom(ontology, declarationAxiomfatigue);
        manager.addAxiom(ontology, declarationAxiomwheezing);



        //Creating Subclasses for LungCancerBodyparts class
        OWLClass lungs = df.getOWLClass(":lungs", pm);
        OWLClass lymphnodes  = df.getOWLClass(":lymphnodes", pm);

        OWLSubClassOfAxiom declarationAxiomlungs = df.getOWLSubClassOfAxiom(lungs, LungCancerBodyparts);
        OWLSubClassOfAxiom declarationAxiomlymphnodes = df.getOWLSubClassOfAxiom(lymphnodes, LungCancerBodyparts);

        manager.addAxiom(ontology, declarationAxiomlungs);
        manager.addAxiom(ontology, declarationAxiomlymphnodes);


        //Creating Subclasses for LungCancerPrevention class
        OWLClass Smoking = df.getOWLClass(":Smoking", pm);
        OWLClass Carcinogens  = df.getOWLClass(":Carcinogens", pm);

        OWLSubClassOfAxiom declarationAxiomSmoking = df.getOWLSubClassOfAxiom(Smoking, LungCancerPrevention);
        OWLSubClassOfAxiom declarationAxiomCarcinogens = df.getOWLSubClassOfAxiom(Carcinogens, LungCancerPrevention);

        manager.addAxiom(ontology, declarationAxiomSmoking);
        manager.addAxiom(ontology, declarationAxiomCarcinogens);


        /**************************************************************************************************************************************

*/

        //Creating Subclasses for brainclass
        OWLClass BrainCancerSymptoms = df.getOWLClass(":BrainCancerSymptoms", pm);
        OWLClass BrainCancerBodyparts  = df.getOWLClass(":BrainCancerBodyparts", pm);
        OWLClass BrainCancerPrevention = df.getOWLClass(":BrainCancerPrevention", pm);

        OWLSubClassOfAxiom declarationAxiomBrainCancerSymtoms = df.getOWLSubClassOfAxiom(BrainCancerSymptoms, Brain);
        OWLSubClassOfAxiom declarationAxiomBrainCancerBodyparts = df.getOWLSubClassOfAxiom(BrainCancerBodyparts,Brain);
        OWLSubClassOfAxiom declarationAxiomBrainCancerPrevention = df.getOWLSubClassOfAxiom(BrainCancerPrevention, Brain);

        manager.addAxiom(ontology, declarationAxiomBrainCancerSymtoms);
        manager.addAxiom(ontology, declarationAxiomBrainCancerBodyparts);
        manager.addAxiom(ontology, declarationAxiomBrainCancerPrevention);


//        //Creating Subclasses for BrainCancerSymptoms class
        OWLClass headache = df.getOWLClass(":headache", pm);
        OWLClass nausea  = df.getOWLClass(":nausea", pm);
        OWLClass dizziness = df.getOWLClass(":dizziness", pm);

        OWLSubClassOfAxiom declarationAxiomheadache = df.getOWLSubClassOfAxiom(headache, BrainCancerSymptoms);
        OWLSubClassOfAxiom declarationAxiomnausea = df.getOWLSubClassOfAxiom(nausea, BrainCancerSymptoms);
        OWLSubClassOfAxiom declarationAxiomdizziness = df.getOWLSubClassOfAxiom(dizziness, BrainCancerSymptoms);

        manager.addAxiom(ontology, declarationAxiomheadache);
        manager.addAxiom(ontology, declarationAxiomnausea);
        manager.addAxiom(ontology, declarationAxiomdizziness);



        //Creating Subclasses for BrainCancerBodyparts class
        OWLClass eyes = df.getOWLClass(":eyes", pm);
        OWLClass ears  = df.getOWLClass(":ears", pm);

        OWLSubClassOfAxiom declarationAxiomeyes = df.getOWLSubClassOfAxiom(eyes, BrainCancerBodyparts);
        OWLSubClassOfAxiom declarationAxiomears = df.getOWLSubClassOfAxiom(ears, BrainCancerBodyparts);

        manager.addAxiom(ontology, declarationAxiomeyes);
        manager.addAxiom(ontology, declarationAxiomears);


        //Creating Subclasses for BrainCancerPrevention class
        OWLClass toxicchemicals = df.getOWLClass(":toxicchemicals", pm);
        OWLClass radiation  = df.getOWLClass(":radiation", pm);
        OWLClass HIVinfection = df.getOWLClass(":HIVinfection", pm);

        OWLSubClassOfAxiom declarationAxiomtoxicchemicals = df.getOWLSubClassOfAxiom(toxicchemicals, BrainCancerPrevention);
        OWLSubClassOfAxiom declarationAxiomradiation = df.getOWLSubClassOfAxiom(radiation, BrainCancerPrevention);
        OWLSubClassOfAxiom declarationAxiomHIVinfection = df.getOWLSubClassOfAxiom(HIVinfection, BrainCancerPrevention);

        manager.addAxiom(ontology, declarationAxiomtoxicchemicals);
        manager.addAxiom(ontology, declarationAxiomradiation);
        manager.addAxiom(ontology, declarationAxiomHIVinfection);

/*******************************************************************
 *
 *
 *
 */


        //Creating isSymptomOf, isBaseOf Properties
        OWLObjectProperty isSymptomof = df.getOWLObjectProperty(":isSymptomof", pm);
        OWLObjectPropertyDomainAxiom domainAxiomisSymptomof = df.getOWLObjectPropertyDomainAxiom(isSymptomof, SkinCancerSymptoms);
        OWLObjectPropertyRangeAxiom rangeAxiomisSymptomof = df.getOWLObjectPropertyRangeAxiom(isSymptomof, Skin);
        manager.addAxiom(ontology, domainAxiomisSymptomof);
        manager.addAxiom(ontology, rangeAxiomisSymptomof);
      //  manager.addAxiom(ontology, df.getOWLSubObjectPropertyOfAxiom(isToppingOf, isIngredientOf));

        OWLObjectProperty affectedpartof = df.getOWLObjectProperty(":affectedpartof", pm);
        OWLObjectPropertyDomainAxiom domainAxiomisaffectedpartof = df.getOWLObjectPropertyDomainAxiom(affectedpartof, SkinCancerBodyparts);
        OWLObjectPropertyRangeAxiom rangeAxiomisaffectedpartof = df.getOWLObjectPropertyRangeAxiom(affectedpartof, Skin);
        manager.addAxiom(ontology, domainAxiomisaffectedpartof);
        manager.addAxiom(ontology, rangeAxiomisaffectedpartof);
     //   manager.addAxiom(ontology, df.getOWLSubObjectPropertyOfAxiom(isBaseOf, isIngredientOf));


        OWLObjectProperty causes = df.getOWLObjectProperty(":causes", pm);
        OWLObjectPropertyDomainAxiom domainAxiomcauses = df.getOWLObjectPropertyDomainAxiom(causes, SkinCancerPrevention);
        OWLObjectPropertyRangeAxiom rangeAxiomcauses = df.getOWLObjectPropertyRangeAxiom(causes, Skin);
        manager.addAxiom(ontology, domainAxiomcauses);
        manager.addAxiom(ontology, rangeAxiomcauses);
        //   manager.addAxiom(ontology, df.getOWLSubObjectPropertyOfAxiom(isBaseOf, isIngredientOf));

        //**************************




        //Creating isSymptomOf, isBaseOf Properties
        OWLObjectProperty SymptomofLungCancer = df.getOWLObjectProperty(":SymptomofLungCancer", pm);
        OWLObjectPropertyDomainAxiom domainAxiomSymptomofLungCancer = df.getOWLObjectPropertyDomainAxiom(SymptomofLungCancer, LungCancerSymptoms);
        OWLObjectPropertyRangeAxiom rangeAxiomSymptomofLungCancer = df.getOWLObjectPropertyRangeAxiom(SymptomofLungCancer, Lung);
        manager.addAxiom(ontology, domainAxiomSymptomofLungCancer);
        manager.addAxiom(ontology, rangeAxiomSymptomofLungCancer);
        //  manager.addAxiom(ontology, df.getOWLSubObjectPropertyOfAxiom(isToppingOf, isIngredientOf));

        OWLObjectProperty affectedLungCancer = df.getOWLObjectProperty(":affectedLungCancer", pm);
        OWLObjectPropertyDomainAxiom domainAxiomaffectedLungCancer = df.getOWLObjectPropertyDomainAxiom(affectedLungCancer, LungCancerBodyparts);
        OWLObjectPropertyRangeAxiom rangeAxiomaffectedLungCancer = df.getOWLObjectPropertyRangeAxiom(affectedLungCancer, Lung);
        manager.addAxiom(ontology, domainAxiomaffectedLungCancer);
        manager.addAxiom(ontology, rangeAxiomaffectedLungCancer);
        //   manager.addAxiom(ontology, df.getOWLSubObjectPropertyOfAxiom(isBaseOf, isIngredientOf));


        OWLObjectProperty causesLungcancer = df.getOWLObjectProperty(":causesLungcancer", pm);
        OWLObjectPropertyDomainAxiom domainAxiomcausesLungcancer = df.getOWLObjectPropertyDomainAxiom(causesLungcancer, LungCancerPrevention);
        OWLObjectPropertyRangeAxiom rangeAxiomcausesLungcancer = df.getOWLObjectPropertyRangeAxiom(causesLungcancer, Lung);
        manager.addAxiom(ontology, domainAxiomcausesLungcancer);
        manager.addAxiom(ontology, rangeAxiomcausesLungcancer);
        //   manager.addAxiom(ontology, df.getOWLSubObjectPropertyOfAxiom(isBaseOf, isIngredientOf));


        //****************************************************************


        //Creating isSymptomOf, isBaseOf Properties
        OWLObjectProperty SymptomofBrainCancer = df.getOWLObjectProperty(":SymptomofBrainCancer", pm);
        OWLObjectPropertyDomainAxiom domainAxiomSymptomofBrainCancer = df.getOWLObjectPropertyDomainAxiom(SymptomofBrainCancer, BrainCancerSymptoms);
        OWLObjectPropertyRangeAxiom rangeAxiomSymptomofBrainCancer = df.getOWLObjectPropertyRangeAxiom(SymptomofBrainCancer, Brain);
        manager.addAxiom(ontology, domainAxiomSymptomofBrainCancer);
        manager.addAxiom(ontology, rangeAxiomSymptomofBrainCancer);
        //  manager.addAxiom(ontology, df.getOWLSubObjectPropertyOfAxiom(isToppingOf, isIngredientOf));

        OWLObjectProperty affectedBrainCancer = df.getOWLObjectProperty(":affectedBrainCancer", pm);
        OWLObjectPropertyDomainAxiom domainAxiomaffectedBrainCancer = df.getOWLObjectPropertyDomainAxiom(affectedBrainCancer, BrainCancerBodyparts);
        OWLObjectPropertyRangeAxiom rangeAxiomaffectedBrainCancer = df.getOWLObjectPropertyRangeAxiom(affectedBrainCancer, Brain);
        manager.addAxiom(ontology, domainAxiomaffectedBrainCancer);
        manager.addAxiom(ontology, rangeAxiomaffectedBrainCancer);
        //   manager.addAxiom(ontology, df.getOWLSubObjectPropertyOfAxiom(isBaseOf, isIngredientOf));


        OWLObjectProperty causesBraincancer = df.getOWLObjectProperty(":causesBraincancer", pm);
        OWLObjectPropertyDomainAxiom domainAxiomcausesBraincancer = df.getOWLObjectPropertyDomainAxiom(causesBraincancer, BrainCancerPrevention);
        OWLObjectPropertyRangeAxiom rangeAxiomcausesBraincancer = df.getOWLObjectPropertyRangeAxiom(causesBraincancer, Brain);
        manager.addAxiom(ontology, domainAxiomcausesBraincancer);
        manager.addAxiom(ontology, rangeAxiomcausesBraincancer);
        //   manager.addAxiom(ontology, df.getOWLSubObjectPropertyOfAxiom(isBaseOf, isIngredientOf));
        /**********************************************************************
         *
         *
         *
         */

        //****************************************************************************************************************************
        //Creating Subclasses for Virulinfection class
        OWLClass Chickenpox = df.getOWLClass(":Chickenpox", pm);
        OWLClass Influenza = df.getOWLClass(":Influenza", pm);
        OWLClass Mumps = df.getOWLClass(":Mumps", pm);
        OWLSubClassOfAxiom declarationAxiomChickenpox = df.getOWLSubClassOfAxiom(Chickenpox, Virulinfection);
        OWLSubClassOfAxiom declarationAxiomInfluenza = df.getOWLSubClassOfAxiom(Influenza, Virulinfection);
        OWLSubClassOfAxiom declarationAxiomMumps = df.getOWLSubClassOfAxiom(Mumps, Virulinfection);
        manager.addAxiom(ontology, declarationAxiomChickenpox);
        manager.addAxiom(ontology, declarationAxiomInfluenza);
        manager.addAxiom(ontology, declarationAxiomMumps);

        //Making all classes Disjoint to each other
        OWLDisjointClassesAxiom disjointClassesAxiom = df.getOWLDisjointClassesAxiom(Skin, Lung, Brain, Chickenpox, Influenza, Mumps);
        manager.addAxiom(ontology, disjointClassesAxiom);

        //Creating Subclasses for Chickenpox class
        OWLClass ChickenpoxSymptoms = df.getOWLClass(":ChickenpoxSymptoms", pm);
        OWLClass ChickenpoxAffectedBodyparts = df.getOWLClass(":ChickenpoxAffectedBodyparts", pm);
        OWLClass Chickenpoxprevention = df.getOWLClass(":Chickenpoxprevention", pm);

        OWLSubClassOfAxiom declarationAxiomChickenpoxSymptoms = df.getOWLSubClassOfAxiom(ChickenpoxSymptoms, Chickenpox);
        OWLSubClassOfAxiom declarationAxiomChickenpoxAffectedBodyparts = df.getOWLSubClassOfAxiom(ChickenpoxAffectedBodyparts, Chickenpox);
        OWLSubClassOfAxiom declarationAxiomChickenpoxprevention = df.getOWLSubClassOfAxiom(Chickenpoxprevention, Chickenpox);

        manager.addAxiom(ontology, declarationAxiomChickenpoxSymptoms);
        manager.addAxiom(ontology, declarationAxiomChickenpoxAffectedBodyparts);
        manager.addAxiom(ontology, declarationAxiomChickenpoxprevention);


        //Creating Subclasses for ChickenpoxSymptoms class
        OWLClass blister = df.getOWLClass(":blister", pm);
        OWLClass scab = df.getOWLClass(":scab", pm);
        OWLClass itching  = df.getOWLClass(":itching", pm);

        OWLSubClassOfAxiom declarationAxiomblister = df.getOWLSubClassOfAxiom(blister, ChickenpoxSymptoms);
        OWLSubClassOfAxiom declarationAxiomscab = df.getOWLSubClassOfAxiom(scab, ChickenpoxSymptoms);
        OWLSubClassOfAxiom declarationAxiomitching= df.getOWLSubClassOfAxiom(itching, ChickenpoxSymptoms);

        manager.addAxiom(ontology, declarationAxiomblister);
        manager.addAxiom(ontology, declarationAxiomscab);
        manager.addAxiom(ontology, declarationAxiomitching);

        //Creating Subclasses for ChickenpoxAffectedBodyparts class
        OWLClass stomach = df.getOWLClass(":stomach", pm);
        OWLClass abdomen = df.getOWLClass(":abdomen", pm);
        OWLClass face  = df.getOWLClass(":face", pm);

        OWLSubClassOfAxiom declarationAxiomstomach = df.getOWLSubClassOfAxiom(stomach, ChickenpoxAffectedBodyparts);
        OWLSubClassOfAxiom declarationAxiomabdomen = df.getOWLSubClassOfAxiom(abdomen, ChickenpoxAffectedBodyparts);
        OWLSubClassOfAxiom declarationAxiomface= df.getOWLSubClassOfAxiom(face, ChickenpoxAffectedBodyparts);

        manager.addAxiom(ontology, declarationAxiomstomach);
        manager.addAxiom(ontology, declarationAxiomabdomen);
        manager.addAxiom(ontology, declarationAxiomface);

        //Creating Subclasses for Chickenpoxprevention class
        OWLClass Vaccination = df.getOWLClass(":Vaccination", pm);

        OWLSubClassOfAxiom declarationAxiomVaccination = df.getOWLSubClassOfAxiom(Vaccination, Chickenpoxprevention);

        manager.addAxiom(ontology, declarationAxiomVaccination);


        //****************************************************************************************************************************************************

        //Creating Subclasses for Influenza class
        OWLClass InfluenzaSymptoms = df.getOWLClass(":InfluenzaSymptoms", pm);
        OWLClass InfluenzaAffectedBodyparts = df.getOWLClass(":InfluenzaAffectedBodyparts", pm);
        OWLClass Influenzaprevention = df.getOWLClass(":Influenzaprevention", pm);

        OWLSubClassOfAxiom declarationAxiomInfluenzaSymptoms = df.getOWLSubClassOfAxiom(InfluenzaSymptoms, Influenza);
        OWLSubClassOfAxiom declarationAxiomInfluenzaAffectedBodyparts = df.getOWLSubClassOfAxiom(InfluenzaAffectedBodyparts, Influenza);
        OWLSubClassOfAxiom declarationAxiomInfluenzaprevention = df.getOWLSubClassOfAxiom(Influenzaprevention, Influenza);

        manager.addAxiom(ontology, declarationAxiomInfluenzaSymptoms);
        manager.addAxiom(ontology, declarationAxiomInfluenzaAffectedBodyparts);
        manager.addAxiom(ontology, declarationAxiomInfluenzaprevention);


        //Creating Subclasses for InfluenzaSymptoms class
        OWLClass Dehydration = df.getOWLClass(":Dehydration", pm);
        OWLClass fever = df.getOWLClass(":fever", pm);
        OWLClass sneezing  = df.getOWLClass(":sneezing", pm);

        OWLSubClassOfAxiom declarationAxiomDehydration = df.getOWLSubClassOfAxiom(Dehydration, InfluenzaSymptoms);
        OWLSubClassOfAxiom declarationAxiomfever= df.getOWLSubClassOfAxiom(fever, InfluenzaSymptoms);
        OWLSubClassOfAxiom declarationAxiomsneezing= df.getOWLSubClassOfAxiom(sneezing, InfluenzaSymptoms);

        manager.addAxiom(ontology, declarationAxiomDehydration);
        manager.addAxiom(ontology, declarationAxiomfever);
        manager.addAxiom(ontology, declarationAxiomsneezing);

        //Creating Subclasses for InfluenzaAffectedBodyparts class
        OWLClass Throat = df.getOWLClass(":Throat", pm);
        OWLClass Bronchialtubes = df.getOWLClass(":Bronchialtubes", pm);

        OWLSubClassOfAxiom declarationAxiomThroat = df.getOWLSubClassOfAxiom(Throat, InfluenzaAffectedBodyparts);
        OWLSubClassOfAxiom declarationAxiomBronchialtubes = df.getOWLSubClassOfAxiom(Bronchialtubes, InfluenzaAffectedBodyparts);

        manager.addAxiom(ontology, declarationAxiomThroat);
        manager.addAxiom(ontology, declarationAxiomBronchialtubes);

        //Creating Subclasses for Influenzaprevention class
        OWLClass SickPeople = df.getOWLClass(":SickPeople", pm);
        OWLClass ContaminatedWater = df.getOWLClass(":ContaminatedWater", pm);

        OWLSubClassOfAxiom declarationAxiomSickPeople = df.getOWLSubClassOfAxiom(SickPeople, Influenzaprevention);
        OWLSubClassOfAxiom declarationAxiomContaminatedWater = df.getOWLSubClassOfAxiom(ContaminatedWater, Influenzaprevention);

        manager.addAxiom(ontology, declarationAxiomSickPeople);
        manager.addAxiom(ontology, declarationAxiomContaminatedWater);

        //*****************************************************************************************************************************************************

        //Creating Subclasses for Mumps class
        OWLClass MumpsSymptoms = df.getOWLClass(":MumpsSymptoms", pm);
        OWLClass MumpsAffectedBodyparts = df.getOWLClass(":MumpsAffectedBodyparts", pm);
        OWLClass Mumpsprevention = df.getOWLClass(":Mumpsprevention", pm);

        OWLSubClassOfAxiom declarationAxiomMumpsSymptoms = df.getOWLSubClassOfAxiom(MumpsSymptoms, Mumps);
        OWLSubClassOfAxiom declarationAxiomMumpsAffectedBodyparts = df.getOWLSubClassOfAxiom(MumpsAffectedBodyparts, Mumps);
        OWLSubClassOfAxiom declarationAxiomMumpsprevention = df.getOWLSubClassOfAxiom(Mumpsprevention, Mumps);

        manager.addAxiom(ontology, declarationAxiomMumpsSymptoms);
        manager.addAxiom(ontology, declarationAxiomMumpsAffectedBodyparts);
        manager.addAxiom(ontology, declarationAxiomMumpsprevention);


        //Creating Subclasses for MumpsSymptoms class
        OWLClass Soreness = df.getOWLClass(":Soreness", pm);
        OWLClass NeckSwelling = df.getOWLClass(":NeckSwelling", pm);
        OWLClass Chills  = df.getOWLClass(":Chills", pm);

        OWLSubClassOfAxiom declarationAxiomSoreness = df.getOWLSubClassOfAxiom(Soreness, MumpsSymptoms);
        OWLSubClassOfAxiom declarationAxiomNeckSwelling= df.getOWLSubClassOfAxiom(NeckSwelling, MumpsSymptoms);
        OWLSubClassOfAxiom declarationAxiomChills= df.getOWLSubClassOfAxiom(Chills, MumpsSymptoms);

        manager.addAxiom(ontology, declarationAxiomSoreness);
        manager.addAxiom(ontology, declarationAxiomNeckSwelling);
        manager.addAxiom(ontology, declarationAxiomChills);

        //Creating Subclasses for MumpsAffectedBodyparts class
        OWLClass Neck = df.getOWLClass(":Neck", pm);
        OWLClass Testicles = df.getOWLClass(":Testicles", pm);

        OWLSubClassOfAxiom declarationAxiomNeck = df.getOWLSubClassOfAxiom(Neck, MumpsAffectedBodyparts);
        OWLSubClassOfAxiom declarationAxiomTesticles = df.getOWLSubClassOfAxiom(Testicles, MumpsAffectedBodyparts);

        manager.addAxiom(ontology, declarationAxiomNeck);
        manager.addAxiom(ontology, declarationAxiomTesticles);

        //Creating Subclasses for Mumpsprevention class
        OWLClass MMRvaccination = df.getOWLClass(":MMRvaccination", pm);

        OWLSubClassOfAxiom declarationAxiomMMRvaccination = df.getOWLSubClassOfAxiom(MMRvaccination, Mumpsprevention);

        manager.addAxiom(ontology, declarationAxiomMMRvaccination);



        //*************************************************************************************************************************************************************


        //Creating SymptomsofChickenpox Properties
        OWLObjectProperty SymptomsofChickenpox = df.getOWLObjectProperty(":SymptomsofChickenpox", pm);
        OWLObjectPropertyDomainAxiom domainAxiomSymptomsofChickenpox = df.getOWLObjectPropertyDomainAxiom(SymptomsofChickenpox, ChickenpoxSymptoms);
        OWLObjectPropertyRangeAxiom rangeAxiomSymptomsofChickenpox = df.getOWLObjectPropertyRangeAxiom(SymptomsofChickenpox, Chickenpox);
        manager.addAxiom(ontology, domainAxiomSymptomsofChickenpox);
        manager.addAxiom(ontology, rangeAxiomSymptomsofChickenpox);

        //Creating affectedpartsofChickenpox Properties
        OWLObjectProperty affectedpartsofChickenpox = df.getOWLObjectProperty(":affectedpartsofChickenpox", pm);
        OWLObjectPropertyDomainAxiom domainAxiomaffectedpartsofChickenpox = df.getOWLObjectPropertyDomainAxiom(affectedpartsofChickenpox, ChickenpoxAffectedBodyparts);
        OWLObjectPropertyRangeAxiom rangeAxiomaffectedpartsofChickenpox = df.getOWLObjectPropertyRangeAxiom(affectedpartsofChickenpox, Chickenpox);
        manager.addAxiom(ontology, domainAxiomaffectedpartsofChickenpox);
        manager.addAxiom(ontology, rangeAxiomaffectedpartsofChickenpox);

        //Creating preventsChickenpox Properties
        OWLObjectProperty preventsChickenpox = df.getOWLObjectProperty(":preventsChickenpox", pm);
        OWLObjectPropertyDomainAxiom domainAxiompreventsChickenpox = df.getOWLObjectPropertyDomainAxiom(preventsChickenpox, Chickenpoxprevention);
        OWLObjectPropertyRangeAxiom rangeAxiompreventsChickenpox = df.getOWLObjectPropertyRangeAxiom(preventsChickenpox, Chickenpox);
        manager.addAxiom(ontology, domainAxiompreventsChickenpox);
        manager.addAxiom(ontology, rangeAxiompreventsChickenpox);


        //Creating SymptomsofInfluenza Propertiess
        OWLObjectProperty SymptomsofInfluenza = df.getOWLObjectProperty(":SymptomsofInfluenza", pm);
        OWLObjectPropertyDomainAxiom domainAxiomSymptomsofInfluenza = df.getOWLObjectPropertyDomainAxiom(SymptomsofInfluenza, InfluenzaSymptoms);
        OWLObjectPropertyRangeAxiom rangeAxiomSymptomsofInfluenza = df.getOWLObjectPropertyRangeAxiom(SymptomsofInfluenza, Influenza);
        manager.addAxiom(ontology, domainAxiomSymptomsofInfluenza);
        manager.addAxiom(ontology, rangeAxiomSymptomsofInfluenza);

        //Creating affectedpartsofInfluenza Properties
        OWLObjectProperty affectedpartsofInfluenza = df.getOWLObjectProperty(":affectedpartsofInfluenza", pm);
        OWLObjectPropertyDomainAxiom domainAxiomaffectedpartsofInfluenza = df.getOWLObjectPropertyDomainAxiom(affectedpartsofInfluenza, InfluenzaAffectedBodyparts);
        OWLObjectPropertyRangeAxiom rangeAxiomaffectedpartsofInfluenza = df.getOWLObjectPropertyRangeAxiom(affectedpartsofInfluenza, Influenza);
        manager.addAxiom(ontology, domainAxiomaffectedpartsofInfluenza);
        manager.addAxiom(ontology, rangeAxiomaffectedpartsofInfluenza);

        //Creating preventsInfluenza Properties
        OWLObjectProperty preventsInfluenza = df.getOWLObjectProperty(":preventsInfluenza", pm);
        OWLObjectPropertyDomainAxiom domainAxiompreventsInfluenza = df.getOWLObjectPropertyDomainAxiom(preventsInfluenza, Influenzaprevention);
        OWLObjectPropertyRangeAxiom rangeAxiompreventsInfluenza = df.getOWLObjectPropertyRangeAxiom(preventsInfluenza, Influenza);
        manager.addAxiom(ontology, domainAxiompreventsInfluenza);
        manager.addAxiom(ontology, rangeAxiompreventsInfluenza);


        //Creating SymptomsofMumps Propertiess
        OWLObjectProperty SymptomsofMumps = df.getOWLObjectProperty(":SymptomsofMumps", pm);
        OWLObjectPropertyDomainAxiom domainAxiomSymptomsofMumps = df.getOWLObjectPropertyDomainAxiom(SymptomsofMumps, MumpsSymptoms);
        OWLObjectPropertyRangeAxiom rangeAxiomSymptomsofMumps = df.getOWLObjectPropertyRangeAxiom(SymptomsofMumps, Mumps);
        manager.addAxiom(ontology, domainAxiomSymptomsofMumps);
        manager.addAxiom(ontology, rangeAxiomSymptomsofMumps);

        //Creating affectedpartsofMumps Properties
        OWLObjectProperty affectedpartsofMumps = df.getOWLObjectProperty(":affectedpartsofMumps", pm);
        OWLObjectPropertyDomainAxiom domainAxiomaffectedpartsofMumps = df.getOWLObjectPropertyDomainAxiom(affectedpartsofMumps, MumpsAffectedBodyparts);
        OWLObjectPropertyRangeAxiom rangeAxiomaffectedpartsofMumps = df.getOWLObjectPropertyRangeAxiom(affectedpartsofMumps, Mumps);
        manager.addAxiom(ontology, domainAxiomaffectedpartsofMumps);
        manager.addAxiom(ontology, rangeAxiomaffectedpartsofMumps);

        //Creating preventsMumps Properties
        OWLObjectProperty preventsMumps = df.getOWLObjectProperty(":preventsMumps", pm);
        OWLObjectPropertyDomainAxiom domainAxiompreventsMumps = df.getOWLObjectPropertyDomainAxiom(preventsMumps, Mumpsprevention);
        OWLObjectPropertyRangeAxiom rangeAxiompreventsMumps = df.getOWLObjectPropertyRangeAxiom(preventsMumps, Mumps);
        manager.addAxiom(ontology, domainAxiompreventsMumps);
        manager.addAxiom(ontology, rangeAxiompreventsMumps);

        //****************************************************************************************************************************************************************



        //*******************************************************************************************************************************



        OutputStream os = new FileOutputStream("Output/disease2.owl");
        OWLXMLDocumentFormat owlxmlFormat = new OWLXMLDocumentFormat();
        manager.saveOntology(ontology, owlxmlFormat, os);
        System.out.println("Ontology Created");
    }
}
