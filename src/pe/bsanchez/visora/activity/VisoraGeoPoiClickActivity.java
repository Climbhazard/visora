package pe.bsanchez.visora.activity;

import pe.bsanchez.visora.R;
import pe.bsanchez.visora.core.VisoraGeoPoi;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.geomobile.arcore.VisionCore;
import com.geomobile.arcore.utils.VisionUtils;

public class VisoraGeoPoiClickActivity extends Activity implements OnClickListener {

	private LinearLayout b_back;
	private VisoraGeoPoi poi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.visora_activity_poi_click);

		poi = (VisoraGeoPoi) VisionCore.core.model.getSelectedPoi();

		b_back = (LinearLayout) this.findViewById(R.id.buttonBack);
		b_back.setBackgroundDrawable(VisionUtils
				.getStateListDrawable("vision_button_topleftcorner"));
		b_back.setOnClickListener(this);

		TextView title = (TextView) this.findViewById(R.id.title);
		title.setText(poi.getTitle());
	}

	@Override
	public void onClick(View v) {
		if (v == b_back) {
			finish();
		}
	}
}
