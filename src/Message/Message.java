/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Message;

/**
 *
 * @author beguind
 */
public class Message {

    public TypeMessages type;
    private int nbJ;

    public Message() {

    }

    public Message(TypeMessages type) {
        this.type = type;
    }

    public Message(TypeMessages type, int nbJ) {
        this.type = type;
        this.nbJ = nbJ;
    }

    public TypeMessages getType() {
        return type;
    }
    
    public int getNbJoueurs(){
        return nbJ;
    }

    public void setNbJoueurs(int nbj){
        this.nbJ = nbj;
    }
}
