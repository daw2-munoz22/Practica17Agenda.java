/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jupiter
 */
public class Select{
    private Integer id;
    private String nom;
    private String cognom1;
    private String cognom2;
    private String telefon;
    private String mail;
    
    public Select(Integer id, String nom, String cognom1, String cognom2, String telefon, String mail){
        this.id = id;
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.telefon = telefon;
        this.mail = mail;
    }
     
    public int getID(){
        return this.id;
    }
    public String getNom(){
        return this.nom;
    }
    
    public String getCognom1(){
        return this.cognom1;
    }     
    
    public String getCognom2(){
        return this.cognom2;                
    }
    
    public String getTelefon(){
        return this.telefon;        
    }
    
    public String getMail(){
        return this.mail;
    }                         
}
