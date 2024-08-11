package Drvo;

import java.util.Iterator;

public interface Tree<E> {

    //sekoj jazol moze ad ima proizvolen broj na deca.
    // Maks broj na deca so go ima eden jazol vo ramkite na toa drvo se vika stepen
    //za ssekoj jazol itreba da se znae so se cuva i negovite deca
    //decata gi cuvame vo lista, cuvame vo referenca za sledniot jazol
    //se cuva parent referenca

    public Tree.Node<E> root(); //da se zeme korenot na drvoto
    public Tree.Node<E> parent (Tree.Node<E> node); //da se najde negoviot roditel na jAzolot
    public int childCount (Tree.Node<E> node); //da izbroi kolku deca ima
    // //////////Transformers ////////////
    public void makeRoot (E elem); //zima jazol i go pravi da bide koren
    public Tree.Node<E> addChild(Tree.Node<E> node, E elem); //se dodava na jazol dete koe sto ke cuva informacija elem
    public void remove(Tree.Node<E> node); //se brise nekoj jazol , no i sve pod nego se brise vo hierarhijata. Koga se brise node-ot i toa pod nego se brise pod nego
    // //////////Iterator ////////////
    public Iterator<E> children(Tree.Node<E> node); //Iterator - izminuvanje na nekoja kolekcija na elementi. Trreba da se znae dali ima sleden element i ako ima da go izmineme
    //gi iterira site deca na toj node

    // //////Inner interface for tree nodes ////////
    interface Node<E> {
        public E getElement();
        public void setElement (E elem);
    }



}