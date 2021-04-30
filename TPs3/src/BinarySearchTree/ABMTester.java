package BinarySearchTree;

import org.junit.Assert;
import  org.junit.Assert.*;
import org.junit.Test;

public class ABMTester<T> {
    ABM<T> abm = new ABM<T>();
    BinarySearchTree<T> tree = new BinarySearchTree<T>();
    Organism porcineCircovirusType1 = new Organism("pCvT1","Virus","Los virus más pequeños se replican de forma autónoma en las células eucariotas.",1.8);
    Organism genliseaTuberosa = new Organism("genTu","Planta","El genoma de la planta floreciente más pequeño registrado, 2014.",6100.0);
    Organism carsonellaRuddii = new Organism("carRu","Bacteria","Tiene el segundo genoma más pequeño de todas las bacterias caracterizadas",160.0);
    Organism homoSapiens = new Organism("hSapi","Mamifero","Homo sapiens estima el tamaño del genoma 3,2 billones bp Secuenciación inicial y análisis del genoma humano.", 3289000.0);
    Organism solenopsisInvicta = new Organism("fiAnt","Insect"," una de las más de doscientas ochenta especies del extenso género de hormigas Solenopsis.",48000.0);
    Organism parisJaponica = new Organism("paJap","Planta","El genoma vegetal más grande conocido",150000.0);
    Organism caenorhabditisElegans = new Organism("caEle","Nematodo","Primer genoma animal multicelular secuenciado",100000.0);
    Organism physcomitrellaPatens = new Organism("phyPa","Planta(Musgo)", "Primer genoma de un briófito secuenciado",480000.0);

    @Test
    public void organismAddedCorrectly(){
        abm.addOrganism(porcineCircovirusType1,tree);
        boolean inserted = tree.search((Comparable<T>) porcineCircovirusType1).equals(porcineCircovirusType1);
        Assert.assertTrue(inserted);
    }
}