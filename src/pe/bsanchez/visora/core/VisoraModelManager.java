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

		VisoraGeoPoi ADMINISTRATIVAS = new VisoraGeoPoi();
		ADMINISTRATIVAS.setId("0001");
		ADMINISTRATIVAS.setTitle("FACULTAD DE CS. ADMINISTRATIVAS");
		ADMINISTRATIVAS.setSubtitle("Acreditada con ACBSP");
		ADMINISTRATIVAS.setLatitude(-12.057632);
		ADMINISTRATIVAS.setLongitude(-77.081418);
		ADMINISTRATIVAS.setWeb("http://administracion.unmsm.edu.pe/");
		ADMINISTRATIVAS.getCategories().add(cultural);
		ADMINISTRATIVAS.getCategories().add(deportivo);
		newPois.add(ADMINISTRATIVAS);

		VisoraGeoPoi BIOLOGICAS = new VisoraGeoPoi();
		BIOLOGICAS.setId("0002");
		BIOLOGICAS.setTitle("FACULTAD DE CS. BIOLÓGICAS");
		BIOLOGICAS.setSubtitle("Acreditada internacionalmente");
		BIOLOGICAS.setLatitude(-12.059384);
		BIOLOGICAS.setLongitude(-77.081976);
		BIOLOGICAS.setWeb("http://biologia.unmsm.edu.pe/");
		BIOLOGICAS.getCategories().add(cultural);
		newPois.add(BIOLOGICAS);

		VisoraGeoPoi CONTABLES = new VisoraGeoPoi();
		CONTABLES.setId("0003");
		CONTABLES.setTitle("FACULTAD DE CS. CONTABLES");
		CONTABLES.setSubtitle("Rumbo a la acreditación");
		CONTABLES.setLatitude(-12.057705);
		CONTABLES.setLongitude(-77.080452);
		CONTABLES.setWeb("http://contabilidad.unmsm.edu.pe/");
		CONTABLES.getCategories().add(cultural);
		newPois.add(CONTABLES);

		VisoraGeoPoi ECONOMICAS = new VisoraGeoPoi();
		ECONOMICAS.setId("0004");
		ECONOMICAS.setTitle("FACULTAD DE CS. ECONÓMICAS");
		ECONOMICAS.setSubtitle("Económico - Empresarial");
		ECONOMICAS.setLatitude(-12.057973);
		ECONOMICAS.setLongitude(-77.081187);
		ECONOMICAS.setWeb("http://economia.unmsm.edu.pe/");
		ECONOMICAS.getCategories().add(cultural);
		newPois.add(ECONOMICAS);

		VisoraGeoPoi FISICAS = new VisoraGeoPoi();
		FISICAS.setId("0005");
		FISICAS.setTitle("FACULTAD DE CS. FÍSICAS");
		FISICAS.setSubtitle("Ciencias Básicas");
		FISICAS.setLatitude(-12.059586);
		FISICAS.setLongitude(-77.081764);
		FISICAS.setWeb("http://fisica.unmsm.edu.pe/");
		FISICAS.getCategories().add(cultural);
		newPois.add(FISICAS);

		VisoraGeoPoi MATEMATICAS = new VisoraGeoPoi();
		MATEMATICAS.setId("0006");
		MATEMATICAS.setTitle("FACULTAD DE CS. MATEMÁTICAS");
		MATEMATICAS.setSubtitle("Ciencias Básicas");
		MATEMATICAS.setLatitude(-12.060522);
		MATEMATICAS.setLongitude(-77.082287);
		MATEMATICAS.setWeb("http://matematicas.unmsm.edu.pe/");
		MATEMATICAS.getCategories().add(cultural);
		newPois.add(MATEMATICAS);

		VisoraGeoPoi SOCIALES = new VisoraGeoPoi();
		SOCIALES.setId("0007");
		SOCIALES.setTitle("FACULTAD DE CS. SOCIALES");
		SOCIALES.setSubtitle("Ciencias Sociales");
		SOCIALES.setLatitude(-12.058109);
		SOCIALES.setLongitude(-77.081670);
		SOCIALES.setWeb("http://sociales.unmsm.edu.pe/");
		SOCIALES.getCategories().add(cultural);
		newPois.add(SOCIALES);

		VisoraGeoPoi DERECHO = new VisoraGeoPoi();
		DERECHO.setId("0008");
		DERECHO.setTitle("FACULTAD DE DERECHO Y CS. POLÍTICAS");
		DERECHO.setSubtitle("Ciencias Sociales");
		DERECHO.setLatitude(-12.058529);
		DERECHO.setLongitude(-77.080560);
		DERECHO.setWeb("http://derecho2.unmsm.edu.pe/");
		DERECHO.getCategories().add(cultural);
		newPois.add(DERECHO);

		VisoraGeoPoi EDUCACION = new VisoraGeoPoi();
		EDUCACION.setId("0009");
		EDUCACION.setTitle("FACULTAD DE EDUCACIÓN");
		EDUCACION.setSubtitle("Acreditada internacionalmente");
		EDUCACION.setLatitude(-12.054783);
		EDUCACION.setLongitude(-77.084771);
		EDUCACION.setWeb("http://educacion.unmsm.edu.pe/");
		EDUCACION.getCategories().add(cultural);
		newPois.add(EDUCACION);

		VisoraGeoPoi SISTEMAS = new VisoraGeoPoi();
		SISTEMAS.setId("0011");
		SISTEMAS.setTitle("FACULTAD DE ING. DE SISTEMAS E INFORMÁTICA");
		SISTEMAS.setSubtitle("Ingenierías");
		SISTEMAS.setLatitude(-12.053558);
		SISTEMAS.setLongitude(-77.085787);
		SISTEMAS.setWeb("http://sistemas.edu.pe/");
		SISTEMAS.getCategories().add(deportivo);
		SISTEMAS.getCategories().add(politico);
		SISTEMAS.getCategories().add(social);
		newPois.add(SISTEMAS);

		VisoraGeoPoi ELECTRONICA = new VisoraGeoPoi();
		ELECTRONICA.setId("0012");
		ELECTRONICA.setTitle("FACULTAD DE ING. ELECTRÓNICA Y ELÉCTRICA");
		ELECTRONICA.setSubtitle("Ingenierías");
		ELECTRONICA.setLatitude(-12.056144);
		ELECTRONICA.setLongitude(-77.081389);
		ELECTRONICA.setWeb("http://aulavirtual.electronica.unmsm.edu.pe/");
		ELECTRONICA.getCategories().add(cultural);
		newPois.add(ELECTRONICA);

		VisoraGeoPoi GEOLOGICA = new VisoraGeoPoi();
		GEOLOGICA.setId("0013");
		GEOLOGICA
				.setTitle("FACULTAD DE ING. GEOLÓGICA, MINERA, METALÚRGICA Y GEOGRÁFICA");
		GEOLOGICA.setSubtitle("Ingenierías");
		GEOLOGICA.setLatitude(-12.055441);
		GEOLOGICA.setLongitude(-77.086115);
		GEOLOGICA.setWeb("http://www.figmmg.edu.pe/");
		GEOLOGICA.getCategories().add(cultural);
		newPois.add(GEOLOGICA);

		VisoraGeoPoi INDUSTRIAL = new VisoraGeoPoi();
		INDUSTRIAL.setId("0014");
		INDUSTRIAL.setTitle("FACULTAD DE ING. INDUSTRIAL");
		INDUSTRIAL.setSubtitle("Acreditada internacionalmente");
		INDUSTRIAL.setLatitude(-12.059591);
		INDUSTRIAL.setLongitude(-77.080959);
		INDUSTRIAL.setWeb("http://industrial.unmsm.edu.pe/");
		INDUSTRIAL.getCategories().add(cultural);
		newPois.add(INDUSTRIAL);

		VisoraGeoPoi LETRAS = new VisoraGeoPoi();
		LETRAS.setId("0015");
		LETRAS.setTitle("FACULTAD DE LETRAS Y CS. HUMANAS");
		LETRAS.setSubtitle("Humanidades");
		LETRAS.setLatitude(-12.057388);
		LETRAS.setLongitude(-77.081517);
		LETRAS.setWeb("http://letras.unmsm.edu.pe/");
		LETRAS.getCategories().add(cultural);
		newPois.add(LETRAS);

		VisoraGeoPoi ODONTOLOGIA = new VisoraGeoPoi();
		ODONTOLOGIA.setId("0018");
		ODONTOLOGIA.setTitle("FACULTAD DE ODONTOLOGÍA");
		ODONTOLOGIA.setSubtitle("Ciencias de la Salud");
		ODONTOLOGIA.setLatitude(-12.054754);
		ODONTOLOGIA.setLongitude(-77.085980);
		ODONTOLOGIA.setWeb("http://odontologia-unmsm.edu.pe/");
		ODONTOLOGIA.getCategories().add(cultural);
		newPois.add(ODONTOLOGIA);

		VisoraGeoPoi PSICOLOGIA = new VisoraGeoPoi();
		PSICOLOGIA.setId("0019");
		PSICOLOGIA.setTitle("FACULTAD DE PSICOLOGÍA");
		PSICOLOGIA.setSubtitle("Ciencias de la Salud");
		PSICOLOGIA.setLatitude(-12.053712);
		PSICOLOGIA.setLongitude(-77.087077);
		PSICOLOGIA.setWeb("http://psicologia.unmsm.edu.pe/");
		PSICOLOGIA.getCategories().add(cultural);
		newPois.add(PSICOLOGIA);

		VisoraGeoPoi QUIMICA = new VisoraGeoPoi();
		QUIMICA.setId("0020");
		QUIMICA.setTitle("FACULTAD DE QUÍIMICA E ING. QUÍMICA");
		QUIMICA.setSubtitle("Ciencias Básicas");
		QUIMICA.setLatitude(-12.060078);
		QUIMICA.setLongitude(-77.083697);
		QUIMICA.setWeb("http://quimica.unmsm.edu.pe/");
		QUIMICA.getCategories().add(cultural);
		newPois.add(QUIMICA);

		pois = newPois;
	}

}
