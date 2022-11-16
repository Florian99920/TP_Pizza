package org.arobase.pizza.vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.arobase.pizza.MyImage;
import org.arobase.pizza.model.ModeleCommande;
import org.arobase.pizza.model.Sujet;


/**
 * A modifier
 *
 */
public class VueCommIm extends GridPane implements Observateur {

	public VueCommIm(ModeleCommande m){
		super();
		m.enregistrerObservateur(this);
		this.setPadding(new Insets(15));
		this.setHgap(25);
		this.setAlignment(Pos.CENTER);
		Image mim= new Image("file:src/main/resources/org/arobase/pizza/fond_creme.png",true);
		Image ing= new Image("file:src/main/resources/org/arobase/pizza/ing_fromage.png",true);
		for(int i=0 ; i<4 ; i++){//Affiche 4 fois la meme pizza de base dans le JPanel courant
			MyImage myIm= new MyImage("file:src/main/resources/org/arobase/pizza/fond_creme.png", null);
			//myIm.superposer("/ing_fromage.png"); //Permet de superposer un ingrédient
			this.add(myIm.getSp(),i,1);
			Rectangle rect= new Rectangle(200,200, Color.rgb(255,255,255,0.2)); // création d'un rectangle entourant l'image
			rect.setStroke(Color.BLACK);
			myIm.getSp().getChildren().add(rect);
		}
	}

	@Override
	public void actualiser(Sujet s) {
		// TODO Auto-generated method stub
	}
}
