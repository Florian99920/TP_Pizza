package org.arobase.pizza.vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
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
		this.setAlignment(Pos.BASELINE_LEFT);
		}

	@Override
	public void actualiser(Sujet s) {
		ModeleCommande m = (ModeleCommande) s;
		this.getChildren().clear();
		int pizzaCourante = m.getNumPizzaCourante();
		for (int i = 0; i < m.getListePizza().size(); i++) {
			MyImage image = m.getListePizza().get(i).getPizzaIm();
			this.add(image.getSp(),i,1);
			if (i == pizzaCourante) {
				Rectangle rect= new Rectangle(200,200, Color.rgb(255,255,255,0.2)); // création d'un rectangle entourant l'image
				rect.setStroke(Color.BLACK);
				image.getSp().getChildren().add(rect);
			}
		}
	}
}
