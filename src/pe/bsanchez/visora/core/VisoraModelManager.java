package pe.bsanchez.visora.core;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.geomobile.arcore.VisionCore;
import com.geomobile.arcore.model.VisionCategory;
import com.geomobile.arcore.model.VisionGeoPoi;
import com.geomobile.arcore.model.VisionImage;
import com.geomobile.arcore.model.VisionModelManager;

public class VisoraModelManager extends VisionModelManager {

	VisionCategory cultural;
	VisionCategory deportivo;
	VisionCategory politico;
	VisionCategory social;

	@Override
	public void loadCategories(Context ctx, String url) {
		VisionImage iconCat1 = new VisionImage();
		// iconCat1.setImageURL("visora_vision_icon_cat");
		VisionImage iconCat2 = new VisionImage();
		// iconCat2.setImageURL("visora_vision_icon_mapa");
		VisionImage iconCat3 = new VisionImage();
		// iconCat3.setImageURL("visora_vision_icon_mapa_no_sel");

		cultural = new VisionCategory();
		cultural.setTitle("Cultural");
		iconCat1 = new VisionImage();
		iconCat1.setImageURL("visora_cat_cultural");
		cultural.setIcon(iconCat1);
		iconCat2 = new VisionImage();
		iconCat2.setImageURL("visora_cat_cultural");
		cultural.setSelectedIcon(iconCat2);
		iconCat3 = new VisionImage();
		iconCat3.setImageURL("visora_cat_cultural");
		cultural.setNoSelectedIcon(iconCat3);
		VisionCore.getCategories().add(cultural);

		deportivo = new VisionCategory();
		deportivo.setTitle("Deportivo");
		iconCat1 = new VisionImage();
		iconCat1.setImageURL("visora_cat_deportivo");
		deportivo.setIcon(iconCat1);
		iconCat2 = new VisionImage();
		iconCat2.setImageURL("visora_cat_deportivo");
		deportivo.setSelectedIcon(iconCat2);
		iconCat3 = new VisionImage();
		iconCat3.setImageURL("visora_cat_deportivo");
		deportivo.setNoSelectedIcon(iconCat3);
		VisionCore.getCategories().add(deportivo);

		politico = new VisionCategory();
		politico.setTitle("Pol\u00edtico");
		iconCat1 = new VisionImage();
		iconCat1.setImageURL("visora_cat_politico");
		politico.setIcon(iconCat1);
		iconCat2.setImageURL("visora_cat_politico");
		iconCat2 = new VisionImage();
		politico.setSelectedIcon(iconCat2);
		iconCat3.setImageURL("visora_cat_politico");
		iconCat3 = new VisionImage();
		politico.setNoSelectedIcon(iconCat3);
		VisionCore.getCategories().add(politico);

		social = new VisionCategory();
		social.setTitle("Social");
		iconCat1 = new VisionImage();
		iconCat1.setImageURL("visora_cat_social");
		social.setIcon(iconCat1);
		iconCat2 = new VisionImage();
		iconCat2.setImageURL("visora_cat_social");
		social.setSelectedIcon(iconCat2);
		iconCat3 = new VisionImage();
		iconCat3.setImageURL("visora_cat_social");
		social.setNoSelectedIcon(iconCat3);
		VisionCore.getCategories().add(social);

	}

	@Override
	public void loadPois(Context ctx, String url, boolean update) {
		try {
			loadingPois = true;
			preLoadData();
			if (update) {
				updateNearestPois(ctx);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			loadingPois = false;
		}
	}

	private void preLoadData() {
		List<VisionGeoPoi> newPois = new ArrayList<VisionGeoPoi>();

//		 VisoraGeoPoi ADMINISTRATIVAS = new VisoraGeoPoi();
//		 ADMINISTRATIVAS.setId("0001");
//		 ADMINISTRATIVAS.setTitle("FACULTAD DE CS. ADMINISTRATIVAS");
//		 ADMINISTRATIVAS.setSubtitle("Puerta del Sol 1, Madrid");
//		 ADMINISTRATIVAS.setLatitude(-12.057618);
//		 ADMINISTRATIVAS.setLongitude(-77.081413);
//		 ADMINISTRATIVAS.setWeb("http://en.wikipedia.org/wiki/Puerta_del_Sol");
//		 ADMINISTRATIVAS.getCategories().add(cultural);
//		 ADMINISTRATIVAS.getCategories().add(deportivo);
//		 newPois.add(ADMINISTRATIVAS);

//		 VisoraGeoPoi BIOLOGICAS = new VisoraGeoPoi();
//		 BIOLOGICAS.setId("0002");
//		 BIOLOGICAS.setTitle("FACULTAD DE CS. BIOLÓGICAS");
//		 BIOLOGICAS.setSubtitle("Puerta del Sol 1, Madrid");
//		 BIOLOGICAS.setLatitude(-12.059412);
//		 BIOLOGICAS.setLongitude(-77.082008);
//		 BIOLOGICAS.setWeb("http://en.wikipedia.org/wiki/Puerta_del_Sol");
//		 BIOLOGICAS.getCategories().add(cultural);
//		 newPois.add(BIOLOGICAS);

//		 VisoraGeoPoi CONTABLES = new VisoraGeoPoi();
//		 CONTABLES.setId("0003");
//		 CONTABLES.setTitle("FACULTAD DE CS. CONTABLES");
//		 CONTABLES.setSubtitle("Puerta del Sol 1, Madrid");
//		 CONTABLES.setLatitude(-12.057697);
//		 CONTABLES.setLongitude(-77.080458);
//		 CONTABLES.setWeb("http://en.wikipedia.org/wiki/Puerta_del_Sol");
//		 CONTABLES.getCategories().add(cultural);
//		 newPois.add(CONTABLES);

//		 VisoraGeoPoi ECONOMICAS = new VisoraGeoPoi();
//		 ECONOMICAS.setId("0004");
//		 ECONOMICAS.setTitle("FACULTAD DE CS. ECONÓMICAS");
//		 ECONOMICAS.setSubtitle("Puerta del Sol 1, Madrid");
//		 ECONOMICAS.setLatitude(-12.057938);
//		 ECONOMICAS.setLongitude(-77.080785);
//		 ECONOMICAS.setWeb("http://en.wikipedia.org/wiki/Puerta_del_Sol");
//		 ECONOMICAS.getCategories().add(cultural);
//		 newPois.add(ECONOMICAS);

//		 VisoraGeoPoi FISICAS = new VisoraGeoPoi();
//		 FISICAS.setId("0005");
//		 FISICAS.setTitle("FACULTAD DE CS. FÍSICAS");
//		 FISICAS.setSubtitle("Puerta del Sol 1, Madrid");
//		 FISICAS.setLatitude(-12.059596);
//		 FISICAS.setLongitude(-77.081778);
//		 FISICAS.setWeb("http://en.wikipedia.org/wiki/Puerta_del_Sol");
//		 FISICAS.getCategories().add(cultural);
//		 newPois.add(FISICAS);

//		 VisoraGeoPoi MATEMATICAS = new VisoraGeoPoi();
//		 MATEMATICAS.setId("0006");
//		 MATEMATICAS.setTitle("FACULTAD DE CS. MATEMÁTICAS");
//		 MATEMATICAS.setSubtitle("Puerta del Sol 1, Madrid");
//		 MATEMATICAS.setLatitude(-12.060440);
//		 MATEMATICAS.setLongitude(-77.082218);
//		 MATEMATICAS.setWeb("http://en.wikipedia.org/wiki/Puerta_del_Sol");
//		 MATEMATICAS.getCategories().add(cultural);
//		 newPois.add(MATEMATICAS);

//		 VisoraGeoPoi SOCIALES = new VisoraGeoPoi();
//		 SOCIALES.setId("0007");
//		 SOCIALES.setTitle("FACULTAD DE CS. SOCIALES");
//		 SOCIALES.setSubtitle("Puerta del Sol 1, Madrid");
//		 SOCIALES.setLatitude(-12.058074);
//		 SOCIALES.setLongitude(-77.081687);
//		 SOCIALES.setWeb("http://en.wikipedia.org/wiki/Puerta_del_Sol");
//		 SOCIALES.getCategories().add(cultural);
//		 newPois.add(SOCIALES);

//		 VisoraGeoPoi DERECHO = new VisoraGeoPoi();
//		 DERECHO.setId("0008");
//		 DERECHO.setTitle("FACULTAD DE DERECHO Y CS. POLÍTICAS");
//		 DERECHO.setSubtitle("Puerta del Sol 1, Madrid");
//		 DERECHO.setLatitude(-12.058505);
//		 DERECHO.setLongitude(-77.080453);
//		 DERECHO.setWeb("http://en.wikipedia.org/wiki/Puerta_del_Sol");
//		 DERECHO.getCategories().add(cultural);
//		 newPois.add(DERECHO);

//		 VisoraGeoPoi EDUCACION = new VisoraGeoPoi();
//		 EDUCACION.setId("0009");
//		 EDUCACION.setTitle("FACULTAD DE EDUCACIÓN");
//		 EDUCACION.setSubtitle("Puerta del Sol 1, Madrid");
//		 EDUCACION.setLatitude(-12.054696);
//		 EDUCACION.setLongitude(-77.084873);
//		 EDUCACION.setWeb("http://en.wikipedia.org/wiki/Puerta_del_Sol");
//		 EDUCACION.getCategories().add(cultural);
//		 newPois.add(EDUCACION);

		VisoraGeoPoi SISTEMAS = new VisoraGeoPoi();
		SISTEMAS.setId("0011");
		SISTEMAS.setTitle("FACULTAD DE ING. DE SISTEMAS E INFORMÁTICA");
		SISTEMAS.setSubtitle("Puerta del Sol 1, Madrid");
		SISTEMAS.setLatitude(-12.053400);
		SISTEMAS.setLongitude(-77.085517);
		SISTEMAS.setWeb("http://en.wikipedia.org/wiki/Puerta_del_Sol");
		// SISTEMAS.getCategories().add(cultural);
		SISTEMAS.getCategories().add(deportivo);
		SISTEMAS.getCategories().add(politico);
		SISTEMAS.getCategories().add(social);
		newPois.add(SISTEMAS);

//		 VisoraGeoPoi ELECTRONICA = new VisoraGeoPoi();
//		 ELECTRONICA.setId("0012");
//		 ELECTRONICA.setTitle("FACULTAD DE ING. ELECTRÓNICA Y ELÉCTRICA");
//		 ELECTRONICA.setSubtitle("Puerta del Sol 1, Madrid");
//		 ELECTRONICA.setLatitude(-12.055493);
//		 ELECTRONICA.setLongitude(-77.086123);
//		 ELECTRONICA.setWeb("http://en.wikipedia.org/wiki/Puerta_del_Sol");
//		 ELECTRONICA.getCategories().add(cultural);
//		 newPois.add(ELECTRONICA);

		 VisoraGeoPoi GEOLOGICA = new VisoraGeoPoi();
		 GEOLOGICA.setId("0013");
		 GEOLOGICA.setTitle("FACULTAD DE ING. GEOLÓGICA, MINERA, METALÚRGICA Y GEOGRÁFICA");
		 GEOLOGICA.setSubtitle("Puerta del Sol 1, Madrid");
		 GEOLOGICA.setLatitude(-12.055425);
		 GEOLOGICA.setLongitude(-77.086166);
		 GEOLOGICA.setWeb("http://en.wikipedia.org/wiki/Puerta_del_Sol");
		 GEOLOGICA.getCategories().add(cultural);
		 newPois.add(GEOLOGICA);

//		 VisoraGeoPoi INDUSTRIAL = new VisoraGeoPoi();
//		 INDUSTRIAL.setId("0014");
//		 INDUSTRIAL.setTitle("FACULTAD DE ING. INDUSTRIAL");
//		 INDUSTRIAL.setSubtitle("Puerta del Sol 1, Madrid");
//		 INDUSTRIAL.setLatitude(-12.059559);
//		 INDUSTRIAL.setLongitude(-77.080941);
//		 INDUSTRIAL.setWeb("http://en.wikipedia.org/wiki/Puerta_del_Sol");
//		 INDUSTRIAL.getCategories().add(cultural);
//		 newPois.add(INDUSTRIAL);

//		 VisoraGeoPoi LETRAS = new VisoraGeoPoi();
//		 LETRAS.setId("0015");
//		 LETRAS.setTitle("FACULTAD DE LETRAS Y CS. HUMANAS");
//		 LETRAS.setSubtitle("Puerta del Sol 1, Madrid");
//		 LETRAS.setLatitude(-12.057382);
//		 LETRAS.setLongitude(-77.081450);
//		 LETRAS.setWeb("http://en.wikipedia.org/wiki/Puerta_del_Sol");
//		 LETRAS.getCategories().add(cultural);
//		 newPois.add(LETRAS);

//		 VisoraGeoPoi ODONTOLOGIA = new VisoraGeoPoi();
//		 ODONTOLOGIA.setId("0018");
//		 ODONTOLOGIA.setTitle("FACULTAD DE ODONTOLOGÍA");
//		 ODONTOLOGIA.setSubtitle("Puerta del Sol 1, Madrid");
//		 ODONTOLOGIA.setLatitude(-12.054129);
//		 ODONTOLOGIA.setLongitude(-77.085640);
//		 ODONTOLOGIA.setWeb("http://en.wikipedia.org/wiki/Puerta_del_Sol");
//		 ODONTOLOGIA.getCategories().add(cultural);
//		 newPois.add(ODONTOLOGIA);

//		 VisoraGeoPoi PSICOLOGIA = new VisoraGeoPoi();
//		 PSICOLOGIA.setId("0019");
//		 PSICOLOGIA.setTitle("FACULTAD DE PSICOLOGÍA");
//		 PSICOLOGIA.setSubtitle("Puerta del Sol 1, Madrid");
//		 PSICOLOGIA.setLatitude(-12.053683);
//		 PSICOLOGIA.setLongitude(-77.087056);
//		 PSICOLOGIA.setWeb("http://en.wikipedia.org/wiki/Puerta_del_Sol");
//		 PSICOLOGIA.getCategories().add(cultural);
//		 newPois.add(PSICOLOGIA);

//		VisoraGeoPoi QUIMICA = new VisoraGeoPoi();
//		QUIMICA.setId("0020");
//		QUIMICA.setTitle("FACULTAD DE QUÍIMICA E ING. QUÍMICA");
//		QUIMICA.setSubtitle("Puerta del Sol 1, Madrid");
//		QUIMICA.setLatitude(-12.060126);
//		QUIMICA.setLongitude(-77.083805);
//		QUIMICA.setWeb("http://en.wikipedia.org/wiki/Puerta_del_Sol");
//		QUIMICA.getCategories().add(cultural);
//		newPois.add(QUIMICA);

		pois = newPois;
	}

}
