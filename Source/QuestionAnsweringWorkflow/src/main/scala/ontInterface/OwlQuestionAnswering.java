package ontInterface;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.OWLXMLDocumentFormat;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.DefaultPrefixManager;
import org.semanticweb.owlapi.vocab.OWL2Datatype;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class OwlQuestionAnswering {
    OWLOntology ont;
    PrefixManager pm;
    OWLOntologyManager manager;
    OWLDataFactory df;
    String xs = "http://www.w3.org/2001/XMLSchema#string";

    public OwlQuestionAnswering() {
        try {
            pm = new DefaultPrefixManager(null, null, "https://www.mnpkdm.com/OWL/disease#");
            manager = OWLManager.createOWLOntologyManager();
            df = manager.getOWLDataFactory();
            ont = initialzation();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void createSubClass(String className, String subClassName) {
        OWLClass baseClass = df.getOWLClass(className, pm);
        OWLClass subClass = df.getOWLClass(subClassName, pm);
        OWLSubClassOfAxiom declarationSubClassAxiom = df.getOWLSubClassOfAxiom(subClass, baseClass);
        manager.addAxiom(ont, declarationSubClassAxiom);
    }

    public void createClass(String className) {

        OWLClass classN = df.getOWLClass(className, pm);
        OWLDeclarationAxiom declarationAxiom = df.getOWLDeclarationAxiom(classN);
        manager.addAxiom(ont, declarationAxiom);

    }

    public void createIndividual(String individualName, String className) {
        OWLClass classN = df.getOWLClass(className, pm);
        OWLNamedIndividual ind = df.getOWLNamedIndividual(individualName, pm);
        OWLClassAssertionAxiom classAssertion = df.getOWLClassAssertionAxiom(classN, ind);
        manager.addAxiom(ont, classAssertion);

    }

    public void createObjectProperty(String domain, String propertyName, String range) {

        OWLClass domainC = df.getOWLClass(domain, pm);
        OWLClass rangeC = df.getOWLClass(range, pm);
        OWLObjectProperty isIngredientOf = df.getOWLObjectProperty(propertyName, pm);
        OWLObjectPropertyRangeAxiom rangeAxiom = df.getOWLObjectPropertyRangeAxiom(isIngredientOf, rangeC);
        OWLObjectPropertyDomainAxiom domainAxiom = df.getOWLObjectPropertyDomainAxiom(isIngredientOf, domainC);
        manager.addAxiom(ont, rangeAxiom);
        manager.addAxiom(ont, domainAxiom);

    }

    public OWLOntology initialzation() throws Exception {
        //creating ontology manager
        //In order to create objects that represent entities we need a
        String base = "https://www.mnpkdm.com/OWL/";
        ont = manager.createOntology(IRI.create(base + "disease"));

        OWLClass Disease = df.getOWLClass(":Disease", pm);
        OWLDeclarationAxiom declarationAxiom3 = df.getOWLDeclarationAxiom(Disease);
        manager.addAxiom(ont, declarationAxiom3);


        OWLClass Cancer = df.getOWLClass(":Cancer", pm);
        OWLSubClassOfAxiom declarationAxiom1 = df.getOWLSubClassOfAxiom(Cancer,Disease);
        manager.addAxiom(ont, declarationAxiom1);

        OWLClass Viral = df.getOWLClass(":ViralInfection", pm);
        OWLSubClassOfAxiom declarationAxiom2 = df.getOWLSubClassOfAxiom(Viral,Disease);
        manager.addAxiom(ont, declarationAxiom2);

        OWLClass Physical = df.getOWLClass(":PhysicalDeformation", pm);
        OWLSubClassOfAxiom declarationAxiom4 = df.getOWLSubClassOfAxiom(Physical,Disease);
        manager.addAxiom(ont, declarationAxiom4);

        OWLDisjointClassesAxiom disjointClassesAxiom = df.getOWLDisjointClassesAxiom(Cancer, Viral, Physical);
        manager.addAxiom(ont, disjointClassesAxiom);


        OWLNamedIndividual LungCancer = df.getOWLNamedIndividual("LungCancer", pm);
        OWLNamedIndividual BrainCancer = df.getOWLNamedIndividual("BrainCancer", pm);
        OWLNamedIndividual SkinCancer = df.getOWLNamedIndividual("SkinCancer", pm);
        OWLNamedIndividual Chickenpox = df.getOWLNamedIndividual("Chickenpox", pm);
        OWLNamedIndividual Influenza = df.getOWLNamedIndividual("Influenza", pm);
        OWLNamedIndividual Mumps = df.getOWLNamedIndividual("Mumps", pm);
        OWLNamedIndividual CerebralPalsy = df.getOWLNamedIndividual("CerebralPalsy", pm);
        OWLNamedIndividual SpinaBifida = df.getOWLNamedIndividual("SpinaBifida", pm);
        OWLNamedIndividual Poliomyelitis = df.getOWLNamedIndividual("Poliomyelitis", pm);
        OWLClassAssertionAxiom classAssertionIndia = df.getOWLClassAssertionAxiom(Cancer, LungCancer);
        OWLClassAssertionAxiom classAssertionUSA = df.getOWLClassAssertionAxiom(Cancer, BrainCancer);
        OWLClassAssertionAxiom classAssertionUK = df.getOWLClassAssertionAxiom(Cancer, SkinCancer);
        OWLClassAssertionAxiom classAssertionChickenpox = df.getOWLClassAssertionAxiom(Viral, Chickenpox);
        OWLClassAssertionAxiom classAssertionInfluenza = df.getOWLClassAssertionAxiom(Viral, Influenza);
        OWLClassAssertionAxiom classAssertionMumps = df.getOWLClassAssertionAxiom(Viral, Mumps);
        OWLClassAssertionAxiom classAssertionCerebralPalsy = df.getOWLClassAssertionAxiom(Physical, CerebralPalsy);
        OWLClassAssertionAxiom classAssertionSpinaBifida = df.getOWLClassAssertionAxiom(Physical, SpinaBifida);
        OWLClassAssertionAxiom classAssertionPoliomyelitis = df.getOWLClassAssertionAxiom(Physical, Poliomyelitis);

        manager.addAxiom(ont, classAssertionIndia);
        manager.addAxiom(ont, classAssertionUSA);
        manager.addAxiom(ont, classAssertionUK);
        manager.addAxiom(ont, classAssertionChickenpox);
        manager.addAxiom(ont, classAssertionInfluenza);
        manager.addAxiom(ont, classAssertionMumps);
        manager.addAxiom(ont, classAssertionCerebralPalsy);
        manager.addAxiom(ont, classAssertionSpinaBifida);
        manager.addAxiom(ont, classAssertionPoliomyelitis);

        //defining hasSymptoms for Lung Cancer
        OWLDataProperty hasSymptomOf = df.getOWLDataProperty("hasSymptoms",pm);
        OWLDataPropertyRangeAxiom rangeAxiomhasSymptoms = df.getOWLDataPropertyRangeAxiom(hasSymptomOf, OWL2Datatype.XSD_STRING);
        OWLDataPropertyDomainAxiom domainAxiomhasSymptoms = df.getOWLDataPropertyDomainAxiom(hasSymptomOf,Cancer);
        OWLDataPropertyAssertionAxiom symLungWheez = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,LungCancer,"Wheezing");
        OWLDataPropertyAssertionAxiom symLungChest = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,LungCancer,"ChestPain");
        OWLDataPropertyAssertionAxiom symLungFatigue = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,LungCancer,"Fatigue");
        OWLDataPropertyAssertionAxiom symSkinLumps = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,SkinCancer,"Lumps");
        OWLDataPropertyAssertionAxiom symSkinScalypatch = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,SkinCancer,"Scalypatch");
        OWLDataPropertyAssertionAxiom symSkinUlcer = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,SkinCancer,"Ulcer");
        OWLDataPropertyAssertionAxiom symBrainDizz = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,BrainCancer,"Dizziness");
        OWLDataPropertyAssertionAxiom symBrainHead = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,BrainCancer,"Headache");
        OWLDataPropertyAssertionAxiom symBrainNausea = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,BrainCancer,"Nausea");

        OWLDataPropertyRangeAxiom rangeAxiomhasSymptomsof = df.getOWLDataPropertyRangeAxiom(hasSymptomOf, OWL2Datatype.XSD_STRING);
        OWLDataPropertyDomainAxiom domainAxiomhasSymptomsof = df.getOWLDataPropertyDomainAxiom(hasSymptomOf,Viral);
        OWLDataPropertyAssertionAxiom symChickenpoxBlister = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,Chickenpox,"Blister");
        OWLDataPropertyAssertionAxiom symChickenpoxscab = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,Chickenpox,"Scab");
        OWLDataPropertyAssertionAxiom symChickenpoxItching = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,Chickenpox,"Itching");
        OWLDataPropertyAssertionAxiom symInfluenzaDehydration = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,Influenza,"Dehydration");
        OWLDataPropertyAssertionAxiom symInfluenzaFever = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,Influenza,"Fever");
        OWLDataPropertyAssertionAxiom symInfluenzaSneezing = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,Influenza,"Seezing");
        OWLDataPropertyAssertionAxiom symMumpsSoreness = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,Mumps,"Soreness");
        OWLDataPropertyAssertionAxiom symMumpsNeckSwelling = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,Mumps,"NeckSwelling");
        OWLDataPropertyAssertionAxiom symMumpsChills = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,Mumps,"Chills");


        OWLDataPropertyRangeAxiom rangeAxiomhasSymptomof = df.getOWLDataPropertyRangeAxiom(hasSymptomOf, OWL2Datatype.XSD_STRING);
        OWLDataPropertyDomainAxiom domainAxiomhasSymptomof = df.getOWLDataPropertyDomainAxiom(hasSymptomOf,Viral);
        OWLDataPropertyAssertionAxiom symrigidlimbs = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,CerebralPalsy,"rigid limbs");
        OWLDataPropertyAssertionAxiom symSpeechdisorder = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,CerebralPalsy,"Speech disorder");
        OWLDataPropertyAssertionAxiom symConstipation = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,CerebralPalsy,"Constipation");
        OWLDataPropertyAssertionAxiom symhunchedback = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,SpinaBifida,"hunched back");
        OWLDataPropertyAssertionAxiom symparalysis= df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,SpinaBifida,"paralysis");
        OWLDataPropertyAssertionAxiom symnerveinjury = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,SpinaBifida,"nerve injury");
        OWLDataPropertyAssertionAxiom symmusclequiver = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,Poliomyelitis,"muscle quiver");
        OWLDataPropertyAssertionAxiom symslowgrowth = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,Poliomyelitis,"slow growth");
        OWLDataPropertyAssertionAxiom symmuscleweakness = df.getOWLDataPropertyAssertionAxiom(hasSymptomOf,Poliomyelitis,"muscle weakness");


        manager.addAxiom(ont,rangeAxiomhasSymptoms);
        manager.addAxiom(ont,domainAxiomhasSymptoms);
        manager.addAxiom(ont,symLungWheez);
        manager.addAxiom(ont,symLungChest);
        manager.addAxiom(ont,symLungFatigue);
        manager.addAxiom(ont,symSkinLumps);
        manager.addAxiom(ont,symSkinScalypatch);
        manager.addAxiom(ont,symSkinUlcer);
        manager.addAxiom(ont,symBrainDizz);
        manager.addAxiom(ont,symBrainHead);
        manager.addAxiom(ont,symBrainNausea);

        manager.addAxiom(ont,rangeAxiomhasSymptomsof);
        manager.addAxiom(ont,domainAxiomhasSymptomsof);
        manager.addAxiom(ont,symChickenpoxBlister);
        manager.addAxiom(ont,symChickenpoxscab);
        manager.addAxiom(ont,symChickenpoxItching);
        manager.addAxiom(ont,symInfluenzaDehydration);
        manager.addAxiom(ont,symInfluenzaFever);
        manager.addAxiom(ont,symInfluenzaSneezing);
        manager.addAxiom(ont,symMumpsSoreness);
        manager.addAxiom(ont,symMumpsNeckSwelling);
        manager.addAxiom(ont,symMumpsChills);


        manager.addAxiom(ont,rangeAxiomhasSymptomof);
        manager.addAxiom(ont,domainAxiomhasSymptomof);
        manager.addAxiom(ont,symrigidlimbs);
        manager.addAxiom(ont,symSpeechdisorder);
        manager.addAxiom(ont,symConstipation);
        manager.addAxiom(ont,symhunchedback);
        manager.addAxiom(ont,symparalysis);
        manager.addAxiom(ont,symnerveinjury);
        manager.addAxiom(ont,symmusclequiver);
        manager.addAxiom(ont,symslowgrowth);
        manager.addAxiom(ont,symmuscleweakness);

        //defining toPrevent for Lung Cancer
        OWLDataProperty toPrevent = df.getOWLDataProperty("CausesOf",pm);
        OWLDataPropertyRangeAxiom rangeAxiomtoPrevent = df.getOWLDataPropertyRangeAxiom(toPrevent, OWL2Datatype.XSD_STRING);
        OWLDataPropertyDomainAxiom domainAxiomtoPrevent = df.getOWLDataPropertyDomainAxiom(toPrevent,Cancer);
        OWLDataPropertyAssertionAxiom preLungSmoke = df.getOWLDataPropertyAssertionAxiom(toPrevent,LungCancer,"Smoking");
        OWLDataPropertyAssertionAxiom preLungCarcino = df.getOWLDataPropertyAssertionAxiom(toPrevent,LungCancer,"Intake of Carcinogens");
        OWLDataPropertyAssertionAxiom preSkinBurns = df.getOWLDataPropertyAssertionAxiom(toPrevent,SkinCancer,"Burning");
        OWLDataPropertyAssertionAxiom preSkinUV = df.getOWLDataPropertyAssertionAxiom(toPrevent,SkinCancer,"UV Radiation");
        OWLDataPropertyAssertionAxiom preSkinTanning = df.getOWLDataPropertyAssertionAxiom(toPrevent,SkinCancer,"Tanning");

        OWLDataPropertyRangeAxiom rangeAxiomtoPreventfrom = df.getOWLDataPropertyRangeAxiom(toPrevent, OWL2Datatype.XSD_STRING);
        OWLDataPropertyDomainAxiom domainAxiomtoPreventfrom = df.getOWLDataPropertyDomainAxiom(toPrevent,Viral);
        OWLDataPropertyAssertionAxiom preVaccination = df.getOWLDataPropertyAssertionAxiom(toPrevent,Chickenpox,"Vaccination");
        OWLDataPropertyAssertionAxiom preSickPeople = df.getOWLDataPropertyAssertionAxiom(toPrevent,Influenza,"SickPeople");
        OWLDataPropertyAssertionAxiom preContaminatedWater = df.getOWLDataPropertyAssertionAxiom(toPrevent,Influenza,"Contaminated Water");
        OWLDataPropertyAssertionAxiom preMMRvaccination = df.getOWLDataPropertyAssertionAxiom(toPrevent,Mumps,"MMRvaccination");

        OWLDataPropertyRangeAxiom rangeAxiomtoPreventfrm = df.getOWLDataPropertyRangeAxiom(toPrevent, OWL2Datatype.XSD_STRING);
        OWLDataPropertyDomainAxiom domainAxiomtoPreventfrm = df.getOWLDataPropertyDomainAxiom(toPrevent,Physical);
        OWLDataPropertyAssertionAxiom preCigarettes = df.getOWLDataPropertyAssertionAxiom(toPrevent,CerebralPalsy,"Ciggarettes");
        OWLDataPropertyAssertionAxiom preillicitdrugs = df.getOWLDataPropertyAssertionAxiom(toPrevent,CerebralPalsy,"Illicit drugs");
        OWLDataPropertyAssertionAxiom prealcohol = df.getOWLDataPropertyAssertionAxiom(toPrevent,CerebralPalsy,"Alcohol");
        OWLDataPropertyAssertionAxiom preFolicAcid = df.getOWLDataPropertyAssertionAxiom(toPrevent,SpinaBifida,"Follic Acid");
        OWLDataPropertyAssertionAxiom preextremestress = df.getOWLDataPropertyAssertionAxiom(toPrevent,Poliomyelitis,"Extreme Stress");
        OWLDataPropertyAssertionAxiom preremovedtonsels = df.getOWLDataPropertyAssertionAxiom(toPrevent,Poliomyelitis,"Removed Tonsels");


        manager.addAxiom(ont,rangeAxiomtoPrevent);
        manager.addAxiom(ont,domainAxiomtoPrevent);
        manager.addAxiom(ont,preLungSmoke);
        manager.addAxiom(ont,preLungCarcino);
        manager.addAxiom(ont,preSkinBurns);
        manager.addAxiom(ont,preSkinUV);
        manager.addAxiom(ont,preSkinTanning);

        manager.addAxiom(ont,rangeAxiomtoPreventfrom);
        manager.addAxiom(ont,domainAxiomtoPreventfrom);
        manager.addAxiom(ont,preVaccination);
        manager.addAxiom(ont,preSickPeople);
        manager.addAxiom(ont,preContaminatedWater);
        manager.addAxiom(ont,preMMRvaccination);

        manager.addAxiom(ont,rangeAxiomtoPreventfrm);
        manager.addAxiom(ont,domainAxiomtoPreventfrm);
        manager.addAxiom(ont,preCigarettes);
        manager.addAxiom(ont,preillicitdrugs);
        manager.addAxiom(ont,prealcohol);
        manager.addAxiom(ont,preFolicAcid);
        manager.addAxiom(ont,preextremestress);
        manager.addAxiom(ont,preremovedtonsels);


        //defining isAffected for Lung Cancer
        OWLDataProperty isAffected = df.getOWLDataProperty("isAffected",pm);
        OWLDataPropertyRangeAxiom rangeAxiomisAffected = df.getOWLDataPropertyRangeAxiom(isAffected, OWL2Datatype.XSD_STRING);
        OWLDataPropertyDomainAxiom domainAxiomisAffected = df.getOWLDataPropertyDomainAxiom(isAffected,Cancer);
        OWLDataPropertyAssertionAxiom affectLungLung = df.getOWLDataPropertyAssertionAxiom(isAffected,LungCancer,"Lungs");
        OWLDataPropertyAssertionAxiom affectLungLymphnodes = df.getOWLDataPropertyAssertionAxiom(isAffected,LungCancer,"Lymphnodes");
        OWLDataPropertyAssertionAxiom affectSkinBrain = df.getOWLDataPropertyAssertionAxiom(isAffected,SkinCancer,"Brain");
        OWLDataPropertyAssertionAxiom affectSkinLiver = df.getOWLDataPropertyAssertionAxiom(isAffected,SkinCancer,"Liver");
        OWLDataPropertyAssertionAxiom affectSkinPancreas = df.getOWLDataPropertyAssertionAxiom(isAffected,SkinCancer,"Pancreas");
        OWLDataPropertyAssertionAxiom affectBrainEyes = df.getOWLDataPropertyAssertionAxiom(isAffected,BrainCancer,"Lungs");
        OWLDataPropertyAssertionAxiom affectBrainEars = df.getOWLDataPropertyAssertionAxiom(isAffected,BrainCancer,"Lymphnodes");

        OWLDataPropertyRangeAxiom rangeAxiomisAffectedby = df.getOWLDataPropertyRangeAxiom(isAffected, OWL2Datatype.XSD_STRING);
        OWLDataPropertyDomainAxiom domainAxiomisAffectedby = df.getOWLDataPropertyDomainAxiom(isAffected,Viral);
        OWLDataPropertyAssertionAxiom affectThroat = df.getOWLDataPropertyAssertionAxiom(isAffected,Influenza,"Throat");
        OWLDataPropertyAssertionAxiom affectBronchialtubes = df.getOWLDataPropertyAssertionAxiom(isAffected,Influenza,"Bronchialtubes");
        OWLDataPropertyAssertionAxiom affectstomach = df.getOWLDataPropertyAssertionAxiom(isAffected,Chickenpox,"stomach");
        OWLDataPropertyAssertionAxiom affectabdomen = df.getOWLDataPropertyAssertionAxiom(isAffected,Chickenpox,"abdomen");
        OWLDataPropertyAssertionAxiom affectface = df.getOWLDataPropertyAssertionAxiom(isAffected,Chickenpox,"face");
        OWLDataPropertyAssertionAxiom affectNeck = df.getOWLDataPropertyAssertionAxiom(isAffected,Mumps,"Neck");
        OWLDataPropertyAssertionAxiom affectTesticles = df.getOWLDataPropertyAssertionAxiom(isAffected,Mumps,"Testicles");

        OWLDataPropertyRangeAxiom rangeAxiomisAffectedparts = df.getOWLDataPropertyRangeAxiom(isAffected, OWL2Datatype.XSD_STRING);
        OWLDataPropertyDomainAxiom domainAxiomisAffectedparts = df.getOWLDataPropertyDomainAxiom(isAffected,Physical);
        OWLDataPropertyAssertionAxiom affectarms = df.getOWLDataPropertyAssertionAxiom(isAffected,CerebralPalsy,"Arms");
        OWLDataPropertyAssertionAxiom affectlegs = df.getOWLDataPropertyAssertionAxiom(isAffected,CerebralPalsy,"Legs");
        OWLDataPropertyAssertionAxiom affectmouth = df.getOWLDataPropertyAssertionAxiom(isAffected,CerebralPalsy,"Mouth");
        OWLDataPropertyAssertionAxiom affectspinachord = df.getOWLDataPropertyAssertionAxiom(isAffected,SpinaBifida,"Spinal Chord");
        OWLDataPropertyAssertionAxiom affectnrevetubes = df.getOWLDataPropertyAssertionAxiom(isAffected,SpinaBifida,"Nerve tubes");
        OWLDataPropertyAssertionAxiom affecturinarytract = df.getOWLDataPropertyAssertionAxiom(isAffected,SpinaBifida,"Urinary Tract");
        OWLDataPropertyAssertionAxiom affectlimbs = df.getOWLDataPropertyAssertionAxiom(isAffected,Poliomyelitis,"affect limbs");
        OWLDataPropertyAssertionAxiom affectphysicaldeformity = df.getOWLDataPropertyAssertionAxiom(isAffected,Poliomyelitis,"Physical Deformity");


        manager.addAxiom(ont,rangeAxiomisAffected);
        manager.addAxiom(ont,domainAxiomisAffected);
        manager.addAxiom(ont,affectLungLung);
        manager.addAxiom(ont,affectLungLymphnodes);
        manager.addAxiom(ont,affectSkinBrain);
        manager.addAxiom(ont,affectSkinLiver);
        manager.addAxiom(ont,affectSkinPancreas);
        manager.addAxiom(ont,affectBrainEyes);
        manager.addAxiom(ont,affectBrainEars);

        manager.addAxiom(ont,rangeAxiomisAffectedby);
        manager.addAxiom(ont,domainAxiomisAffectedby);
        manager.addAxiom(ont,affectThroat);
        manager.addAxiom(ont,affectBronchialtubes);
        manager.addAxiom(ont,affectstomach);
        manager.addAxiom(ont,affectabdomen);
        manager.addAxiom(ont,affectface);
        manager.addAxiom(ont,affectNeck);
        manager.addAxiom(ont,affectTesticles);

        manager.addAxiom(ont,rangeAxiomisAffectedparts);
        manager.addAxiom(ont,domainAxiomisAffectedparts);
        manager.addAxiom(ont,affectlegs);
        manager.addAxiom(ont,affectarms);
        manager.addAxiom(ont,affectmouth);
        manager.addAxiom(ont,affectspinachord);
        manager.addAxiom(ont,affectnrevetubes);
        manager.addAxiom(ont,affecturinarytract);
        manager.addAxiom(ont,affectlimbs);
        manager.addAxiom(ont,affectphysicaldeformity);
        return ont;
    }

    public void saveOntology() {
        try {
            OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
            OutputStream os = new FileOutputStream("data/OwlDiseaseUpdate5.2.owl");
            OWLXMLDocumentFormat owlxmlFormat = new OWLXMLDocumentFormat();
            manager.saveOntology(ont, owlxmlFormat, os);
            System.out.println("Ontology Created");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String args[]) throws Exception {
        OwlQuestionAnswering m = new OwlQuestionAnswering();
       m.saveOntology();


    }
}
