//Ceci importe la classe Scanner du package java.util
import java.util.Scanner; 
//Ceci importe toutes les classes du package java.util
import java.util.*;
import java.lang.*;
import java.lang.System.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Scanner.*;
import java.io.FileReader;
import java.io.FileReader.*;
import java.io.*;

public class main {
       public static void main(String[] args){
       
		
            ABR A = new ABR();
            TABR T = new TABR();
			Scanner sch = new Scanner(System.in);
	        System.out.println("Entrer le nom du fichier");
	        String nom = sch.nextLine();
			File f = new File(nom);
			T.parseF(f);
             
/*			 System.out.print("Quel est la valeur maximal ?");
              int n = sc.nextInt();
              System.out.print("Combien de valeur ?");
              int p = sc.nextInt();
              ABR A = new ABR();
              ABR B = new ABR();
              creeABRentier(A,p,n);
              A.parcourP(A);
              System.out.print("\n");
              A.insertion(A,12);
              System.out.print("valeur ?");
              int d = sc.nextInt();
			  A.suppression(A,d);
              A.parcourP(A);
			  */
			  
			  
              
              
      //~ FileInputStream fis = null;
      //~ FileOutputStream fos = null;
      //~ byte[] sfichier = null;
      //~ int y = 0;
      //~ try {

         //~ fis = new FileInputStream(new File("texte.txt"));
         //~ fos = new FileOutputStream(new File("test2.txt"));
         //~ byte[] buf = new byte[8];
         //~ int n = 0;

         //~ while ((n = fis.read(buf)) >= 0) {
            //~ fos.write(buf);
            //~ for (byte bit : buf) {
               //~ System.out.print((char) bit);

            //~ }
            //~ System.out.println("");
            //~ buf = new byte[8];
         //~ }
      //~ } catch (FileNotFoundException e) {
         //~ e.printStackTrace();
      //~ } catch (IOException e) {
         //~ e.printStackTrace();

      //~ } finally {
         //~ try {
            //~ if (fis != null)
               //~ fis.close();

         //~ } catch (IOException e) {
            //~ e.printStackTrace();
         //~ }
         //~ try {
            //~ if (fos != null)
               //~ fos.close();
         //~ } catch (IOException e) {
            //~ e.printStackTrace();
         //~ }
      //~ }
      
       //~ System.out.print("ggggggggggggggggggggggggggggggg");
       //~ for(int j=0;j<y;j++){
              //~ System.out.print(sfichier[j]);
       //~ }
      
       }
       
       public static void creeABRentier(ABR A, int p, int n){
              
              for(int i=0;i<p;i++){
                     int val = (int)(Math.random()*((n - 1) + 1)) + 1;
                            A.val = val;
                            ABR.insertion(A,val);
              }
       }
       

}


class ABR {
       int val;
       ABR sag,sad;
	   boolean vide;

       public ABR(ABR gauche,int valeur,ABR droit){
              
              this.sag = gauche;
              this.val = valeur;
              this.sad = droit;
			  this.vide = false;
       }
       
	   	public ABR () {
			
			this.val=0;
			this.vide=true;
			this.sag = null;
			this.sad = null;
		}
		
		public static void parcourP(ABR A){
			
			if (A.vide != true){	
				System.out.print(A.val+":");
				parcourP(A.sag);
				parcourP(A.sad);
			}       
		}
	   
       public static void insertion(ABR A, int elem){
            
		if (A.vide == true){
			A.sag = new ABR();
			A.sad = new ABR();
			A.val = elem;
			A.vide = false;
		}else{
		   if (A.val < elem){
			   insertion(A.sad,elem);
		   }else{
			   insertion(A.sag,elem);
		   }
	   }	  
       }
       
       public ABR recherche(ABR A, int elem, ABR pere){
              
              ABR B = new ABR(null,0,null);
              if(A.val == elem){
                     return A;
              }
              if(A.sad == null && A.sag == null){
                     return B;
              }else{
                     if(elem > A.val){
                            return recherche(A.sad,elem,A);
                     }else if(elem < A.val){
                            return recherche(A.sag,elem,A);
                     }
              }
              return null;
       }
	   
	   public int maxElem(){
		   
		   if(this.sad.vide == false){
			   return this.sad.maxElem();
		   }else{
			   int resultat=this.val;
			   dupliquer(sag);
			   return resultat;
		   }
	   }
	   
	   
	   
	   
	   public void dupliquer(ABR A) {
			this.vide = A.vide;
			this.val = A.val;
			this.sad = A.sad;
			this.sag = A.sag;
	   }
       
       public void suppression(ABR A, int elem){
              
			if(A.vide == false){
				if (elem < A.val){
					suppression(A.sag,elem);
				}else{
					if(elem > A.val){
						suppression(A.sad,elem);
					}else{
						if(A.sag.vide == true){
							dupliquer(A.sad);
							System.out.print("Valeur numéro "+elem+" supprimee \n");
						}else{
							if(A.sad.vide == true){
								dupliquer(A.sag);
								System.out.print("Valeur numéro "+elem+" supprimee \n");
							}else{
								A.val = A.sag.maxElem();
								System.out.print("Valeur numéro "+elem+" supprimee \n");
							}
						}
					}
				}
			}else{
              System.out.print("Cette valeur n'éxiste pas dans ABR ");
			} 
		}
	}


class Tab {
	int min,max;
	ABR a;
	
	public Tab () {
		max=0;	
		min=0;
		a=new ABR();
	}
	public Tab (int min, int max, ABR a) {
		this.max = max;
		this.min = min;
		this.a = a;
	}
	
	public void afficherArbre() {
		System.out.print(min+":"+max+";");
		a.parcourP(a);
		System.out.println("");
	}
}


class TABR {
		Tab Ttab[];
		int occu;
		
       public TABR()
       {
			occu = 0;
			Ttab = new Tab[30];
			for(int i=0; i<30; i++) {
				Ttab[i]= new Tab();
			}
       }
       
	   public String lecture(File f) {
        try {
           BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
           StringWriter out = new StringWriter();
           int b;
           while ((b=in.read()) != -1)
               out.write(b);
           out.flush();
           out.close();
           in.close();
           return out.toString();
        }
        catch (IOException ie)
        {
             ie.printStackTrace(); 
        }
		return null;
    }  
	public void parseF(File f) {
		
		int n=0;
    	String r = lecture(f);
        // System.out.print(r);
		String ExploSaut = "[\n;]+";
		String Explode = "[:]+";
		String[] arbreTABR = new String[30];
    	String[] token = r.split(ExploSaut);
    	String delim[] = new String[2];
		
		for(int i=0; i<token.length;i++){
			//System.out.print("\n");
			//System.out.print(token[i]+"\n");
    		delim = token[i].split(Explode);
			int max = 0;
			int min = 9999999;
			for(int k=0; k<delim.length;k++){
				int valeurdelim = Integer.parseInt(delim[k]);
				if(valeurdelim > max){
					Ttab[n].max=valeurdelim;
					max = valeurdelim;
				}
				if(valeurdelim < min){
					Ttab[n].min=valeurdelim;
					min = valeurdelim;	
				}
			}
			System.out.print("fqef "+arbreTABR.length+"\n");
			
			for(int j=0; j<arbreTABR.length;j++) {
    			Ttab[n].a.insertion(Ttab[n].a, Integer.parseInt(arbreTABR[j]));
				Ttab[n].a.insertion(Ttab[n].a, Integer.parseInt(arbreTABR[j]));
				System.out.print(Integer.parseInt(arbreTABR[j]));	
    		} 		
			//System.out.print(delim[0]+"\n");
    		//Ttab[n].min=Integer.parseInt(delim[0]);
    		//Ttab[n].max=Integer.parseInt(delim[1]);
			System.out.print(Ttab[n].min+" "+Ttab[n].max+"\n");
			//arbreTABR = token[i].split(Explode);
			//for(int j=0; j<arbreTABR.length-1;j++) {
    		//	Ttab[n].a.insertion(Ttab[n].a, Integer.parseInt(arbreTABR[j]));
    		//} 
			occu++;
			n++;
		}
		
    	}
    }
    /*   public static void insertionTA(TABR TA, int elem)
       {
              if(elem > TA.max){
                     insertionTA(TA.suiv,elem);
              }else{
                     ABR.insertion(TA.A,elem);
              }
       }
              
       public static void parcourTA(TABR TA){
       
              if (TA != null){
                     System.out.print("Min : "+TA.min+"\n");
                     System.out.print("Max : "+TA.max+"\n");
                     ABR.parcourP(TA.A);
              }
              
       }*/

	