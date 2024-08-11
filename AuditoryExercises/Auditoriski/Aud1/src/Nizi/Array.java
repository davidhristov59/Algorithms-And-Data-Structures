package Nizi;

import java.util.Arrays;

public class Array<E> {

    private E niza[]; //niza od elementi
    private int size; //golemina na nizata

    public Array(int capacity){
        this.niza = (E[]) new Object[capacity];
        this.size = 0;
    }

    public void resize(){ //resize the array
        //resize the array
        E[] newArray = (E[]) new Object[size*2]; //moram da kastiram vo generic

        //copy the data
        for (int i = 0; i < size; i++) {
            newArray[i] = niza[i];
        }

        this.niza = newArray;

    }

    public int find(E o){
        for (int i = 0; i < size; i++) { //prebaruva niz listata
            if(o.equals(niza[i])){ //go sporeduva objektot o so elementite vo nizata koristejki equals metodot. Ako se najde toj element , vrati go negoviot indeks
                return i;
            }
        }
        return -1; //vrati -1 ako ne go najdes indeksot
    }

    public int getSize() {
        return size;
    }

    public void insert(int position, E o){
        if(position >= 0 && position <= size){
            if(size + 1 > niza.length){
                this.resize();
            }
            //copy the data before doing the insertion

            for (int i = size; i > position ; i--) {
                niza[i] = niza[i-1];
            }
            niza[position] = o;
            size++;
        }
        else {
            System.out.println("Ne moze da se vmetne element na taa pozicija");
        }
    }

    public void insertLast(E o){
        if(size + 1 > niza.length)
            this.resize();
        niza[size++] = o;
    }

    public void set(int position, E o){
        if(position >= 0 && position < size){
            niza[position] = o;
        }
        else {
            System.out.println("Ne moze da se vmetne element na dadena pozicija");
        }
    }

    public E get(int position){ //ke go vrati elementot
        if(position >= 0 && position < size){
            //vrati go elementot
            return niza[position]; //vrakam bidejki E mi e staveno da vrati, potocno elementot
        }
        else {
            System.out.println("Ne moze da se zeme toj element");
        }
        return null;
    }


    public void delete(int position){
        if(position>=0 && position<size){

            E[] newNiza = (E[]) new Object[size-1]; //So (E[]) go kastiram da e genericki tip. [size-1] zosto ke brisam 1 element

            for (int i = 0; i < position; i++) { //gi pominuvame site elementi vo nizata
                newNiza[i] = niza[i]; //gi dodavame vo novata niza
            }

            for (int i = position+1; i < size; i++) {
                newNiza[i-1] = niza[i]; //dodadi na i-1, vrati se 1 nazad i dodadi go sledniot element od starata niza
            }
            niza = newNiza; //novata niza odi vo starata zosto e so izbrisan element
            size--; //imame 1 pomal element
        }
    }

    @Override
    public String toString() {

        return String.format("%s size:%d", Arrays.toString(niza), size);
    }

    public static void main(String[] args) {
        Array<Integer> niza = new Array<Integer>(4);

        niza.insertLast(4);
        System.out.println("Nizata po vmetnuvanje na 4 kako posleden element: ");
        System.out.println(niza.toString());

        niza.insertLast(7);
        niza.insertLast(13);
        System.out.println("Nizata po dodavanje na 7 i 13 kako elementi: ");
        System.out.println(niza.toString());

        niza.insert(1,3);
        System.out.println("Nizata po dodavanje na 3 kako element na indeks 1: ");
        System.out.println(niza.toString());

        niza.set(2,6); //na indeks 2, stavi 6ka kako element
        System.out.println("Nizata po menuvanje na vrednosta na elemento na indeks 2 so element 6: ");
        System.out.println(niza.toString());

        niza.delete(0); //brisi go elementot na pozicija 0
        System.out.println("Nizata po brisenje na elementot na indeks 0: ");
        System.out.println(niza.toString());

        System.out.println("Na indeks 3 vo nizata sega se naogja: ");
        System.out.println(niza.get(3));

        System.out.println("Brojot 3 sega se naoga vo nizata na indeks: ");
        System.out.println(niza.find(3));

        System.out.println("Na kraj, goleminata na nizata e");
        System.out.println(niza.getSize());
    }

}
