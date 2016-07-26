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
        OWLClassAssertionAxiom classAssertionIndia = df.getOWLClassAssertionAxiom(Cancer, LungCancer);
        OWLClassAssertionAxiom classAssertionUSA = df.getOWLClassAssertionAxiom(Cancer, BrainCancer);
        OWLClassAssertionAxiom classAssertionUK = df.getOWLClassAssertionAxiom(Cancer, SkinCancer);
        manager.addAxiom(ont, classAssertionIndia);
        manager.addAxiom(ont, classAssertionUSA);
        manager.addAxiom(ont, classAssertionUK);

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

        //defining toPrevent for Lung Cancer
        OWLDataProperty toPrevent = df.getOWLDataProperty("CausesOf",pm);
        OWLDataPropertyRangeAxiom rangeAxiomtoPrevent = df.getOWLDataPropertyRangeAxiom(toPrevent, OWL2Datatype.XSD_STRING);
        OWLDataPropertyDomainAxiom domainAxiomtoPrevent = df.getOWLDataPropertyDomainAxiom(toPrevent,Cancer);
        OWLDataPropertyAssertionAxiom preLungSmoke = df.getOWLDataPropertyAssertionAxiom(toPrevent,LungCancer,"Smoking");
        OWLDataPropertyAssertionAxiom preLungCarcino = df.getOWLDataPropertyAssertionAxiom(toPrevent,LungCancer,"Intake of Carcinogens");
        OWLDataPropertyAssertionAxiom preSkinBurns = df.getOWLDataPropertyAssertionAxiom(toPrevent,SkinCancer,"Burning");
        OWLDataPropertyAssertionAxiom preSkinUV = df.getOWLDataPropertyAssertionAxiom(toPrevent,SkinCancer,"UV Radiation");
        OWLDataPropertyAssertionAxiom preSkinTanning = df.getOWLDataPropertyAssertionAxiom(toPrevent,SkinCancer,"Tanning");
        manager.addAxiom(ont,rangeAxiomhasSymptoms);
        manager.addAxiom(ont,domainAxiomhasSymptoms);
        manager.addAxiom(ont,preLungSmoke);
        manager.addAxiom(ont,preLungCarcino);
        manager.addAxiom(ont,preSkinBurns);
        manager.addAxiom(ont,preSkinUV);
        manager.addAxiom(ont,preSkinTanning);

        //defining isAffected for Lung Cancer
        OWLDataProperty isAffected = df.getOWLDataProperty("isAffected",pm);
        OWLDataPropertyRangeAxiom rangeAxiomisAffected = df.getOWLDataPropertyRangeAxiom(isAffected, OWL2Datatype.XSD_STRING);
        OWLDataPropertyDomainAxiom domainAxiomisAffected = df.getOWLDataPropertyDomainAxiom(isAffected,Cancer);
        OWLDataPropertyAssertionAxiom affectLungLung = df.getOWLDataPropertyAssertionAxiom(isAffected,LungCancer,"Lungs");
        OWLDataPropertyAssertionAxiom affectLungLymphnodes = df.getOWLDataPropertyAssertionAxiom(isAffected,LungCancer,"Lymphnodes");
        OWLDataPropertyAssertionAxiom affectSkinBrain = df.getOWLDataPropertyAssertionAxiom(isAffected,LungCancer,"Brain");
        OWLDataPropertyAssertionAxiom affectSkinLiver = df.getOWLDataPropertyAssertionAxiom(isAffected,LungCancer,"Liver");
        OWLDataPropertyAssertionAxiom affectSkinPancreas = df.getOWLDataPropertyAssertionAxiom(isAffected,LungCancer,"Pancreas");
        manager.addAxiom(ont,rangeAxiomhasSymptoms);
        manager.addAxiom(ont,domainAxiomhasSymptoms);
        manager.addAxiom(ont,affectSkinBrain);
        manager.addAxiom(ont,affectSkinLiver);
        manager.addAxiom(ont,affectSkinPancreas);
        return ont;
    }

    public void saveOntology() {
        try {
            OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
            OutputStream os = new FileOutputStream("data/OwlDiseaseUpdate.owl");
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
