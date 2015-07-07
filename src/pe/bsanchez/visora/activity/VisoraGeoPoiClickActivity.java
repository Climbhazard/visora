package pe.bsanchez.visora.activity;

import java.util.ArrayList;

import pe.bsanchez.visora.R;
import pe.bsanchez.visora.core.VisoraGeoPoi;
import pe.bsanchez.visora.model.Evento;
import pe.bsanchez.visora.repository.AdapterEventos;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.geomobile.arcore.VisionCore;
import com.geomobile.arcore.utils.VisionUtils;

public class VisoraGeoPoiClickActivity extends Activity implements OnClickListener {

	// private ProgressBar progreso;

	private LinearLayout b_back;
	private VisoraGeoPoi poi;

	private ListView list;
	private String[] sistemas = { "Ubuntu", "Android", "iOS", "Windows", "Mac OSX",
			"Google Chrome OS", "Debian", "Mandriva", "Solaris", "Unix" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.visora_activity_poi_click);
//		setContentView(R.layout.visora_activity_poi_click2);
		setContentView(R.layout.visora_activity_poi_click3);

		poi = (VisoraGeoPoi) VisionCore.core.model.getSelectedPoi();

		b_back = (LinearLayout) this.findViewById(R.id.buttonBack);
		b_back.setBackgroundDrawable(VisionUtils
				.getStateListDrawable("vision_button_topleftcorner"));
		b_back.setOnClickListener(this);

		TextView title = (TextView) this.findViewById(R.id.title);
		title.setText(poi.getTitle());

		list = (ListView) findViewById(R.id.list_eventos);

		ArrayList<Evento> eventos = new ArrayList<Evento>();
		Evento evento;
		
		/* *
		Carga de eventos en <code>eventos</code>
		 */

		AdapterEventos adaptador = new AdapterEventos(this, eventos);

		list.setAdapter(adaptador);
	}

	@Override
	public void onClick(View v) {
		if (v == b_back) {
			finish();
		}
	}
}
