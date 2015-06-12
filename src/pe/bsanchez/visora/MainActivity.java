package pe.bsanchez.visora;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.geomobile.arcore.VisionConfiguration;
import com.geomobile.arcore.VisionCore;
import com.geomobile.arcore.model.VisionCategory;
import com.geomobile.arcore.model.VisionGeoPoi;
import com.geomobile.arcore.model.VisionGeoPoiClickListener;
import com.geomobile.arcore.model.VisionImage;

public class MainActivity extends Activity implements OnClickListener {

	private ProgressBar progress;

//	private Button bt_default_core;
	private Button bt_custom_core;
	public Boolean custom = false;

	private LinearLayout l_buttonsDefault;
	private Button bt_default_files;
	private Button bt_demo_files;
	private Button bt_web_files;
	private Button bt_generated_data;
	private DataSource data = DataSource.DEFAULT_FILES;
	private LinearLayout l_buttonsCustom;
	private Button bt_preload_data;
	private Button bt_continuous_load;
	private Boolean preload = true;

	private ImageView sw_map;
	private Boolean map = true;
	private ImageView sw_list;
	private Boolean list = true;
	private ImageView sw_teleport;
	private Boolean teleport = true;

	private ImageView sw_en;
	private ImageView sw_es;
	private ImageView sw_pt;
	private Language lan = Language.EN;

	private Button bt_launch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		progress = (ProgressBar) this.findViewById(R.id.progressBar);

//		bt_default_core = (Button) this.findViewById(R.id.default_core);
//		bt_default_core.setOnClickListener(this);
		bt_custom_core = (Button) this.findViewById(R.id.custom_core);
//		bt_custom_core.setOnClickListener(this);

		l_buttonsDefault = (LinearLayout) this
				.findViewById(R.id.buttonsDefault);
		bt_default_files = (Button) this.findViewById(R.id.default_files);
		bt_default_files.setOnClickListener(this);
		bt_demo_files = (Button) this.findViewById(R.id.demo_files);
		bt_demo_files.setOnClickListener(this);
		bt_web_files = (Button) this.findViewById(R.id.web_files);
		bt_web_files.setOnClickListener(this);
		bt_generated_data = (Button) this.findViewById(R.id.generated_data);
		bt_generated_data.setOnClickListener(this);
		l_buttonsCustom = (LinearLayout) this.findViewById(R.id.buttonsCustom);
		bt_preload_data = (Button) this.findViewById(R.id.preload_data);
		bt_preload_data.setOnClickListener(this);
		bt_continuous_load = (Button) this.findViewById(R.id.continuous_load);
		bt_continuous_load.setOnClickListener(this);

		sw_map = (ImageView) this.findViewById(R.id.sw_map);
		sw_map.setOnClickListener(this);
		sw_list = (ImageView) this.findViewById(R.id.sw_list);
		sw_list.setOnClickListener(this);
		sw_teleport = (ImageView) this.findViewById(R.id.sw_teleport);
		sw_teleport.setOnClickListener(this);
		sw_map.setEnabled(false);
		sw_map.setImageResource(R.drawable.switch_dis);
		sw_list.setEnabled(false);
		sw_list.setImageResource(R.drawable.switch_dis);
		sw_teleport.setEnabled(false);
		sw_teleport.setImageResource(R.drawable.switch_dis);

		sw_en = (ImageView) this.findViewById(R.id.sw_en);
		sw_en.setOnClickListener(this);
		sw_es = (ImageView) this.findViewById(R.id.sw_es);
		sw_es.setOnClickListener(this);
		sw_pt = (ImageView) this.findViewById(R.id.sw_pt);
		sw_pt.setOnClickListener(this);

		bt_launch = (Button) this.findViewById(R.id.launch);
		bt_launch.setOnClickListener(this);
	}

	@SuppressWarnings("unused")
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
//		if (v == bt_default_core) {
//			custom = false;
//			l_buttonsDefault.setVisibility(View.VISIBLE);
//			l_buttonsCustom.setVisibility(View.GONE);
//			bt_default_core.setBackgroundResource(R.drawable.bt_selected);
//			bt_custom_core.setBackgroundResource(R.drawable.bt_normal);
//			sw_map.setEnabled(false);
//			sw_map.setImageResource(R.drawable.switch_dis);
//			sw_list.setEnabled(false);
//			sw_list.setImageResource(R.drawable.switch_dis);
//			sw_teleport.setEnabled(false);
//			sw_teleport.setImageResource(R.drawable.switch_dis);
//		} else
			if (v == bt_custom_core) {
			custom = true;
			l_buttonsDefault.setVisibility(View.GONE);
			l_buttonsCustom.setVisibility(View.VISIBLE);
//			bt_default_core.setBackgroundResource(R.drawable.bt_normal);
			bt_custom_core.setBackgroundResource(R.drawable.bt_selected);
			sw_map.setEnabled(true);
			sw_map.setImageResource(R.drawable.switch_on);
			map = true;
			sw_list.setEnabled(true);
			sw_list.setImageResource(R.drawable.switch_on);
			list = true;
			sw_teleport.setEnabled(true);
			sw_teleport.setImageResource(R.drawable.switch_on);
			teleport = true;
		} else if (v == bt_generated_data) {
			data = DataSource.GENERATED_DATA;
			bt_default_files.setBackgroundResource(R.drawable.bt_normal);
			bt_demo_files.setBackgroundResource(R.drawable.bt_normal);
			bt_web_files.setBackgroundResource(R.drawable.bt_normal);
			bt_generated_data.setBackgroundResource(R.drawable.bt_selected);
		} else if (v == bt_demo_files) {
			data = DataSource.DEMO_FILES;
			bt_default_files.setBackgroundResource(R.drawable.bt_normal);
			bt_demo_files.setBackgroundResource(R.drawable.bt_selected);
			bt_web_files.setBackgroundResource(R.drawable.bt_normal);
			bt_generated_data.setBackgroundResource(R.drawable.bt_normal);
		} else if (v == bt_web_files) {
			data = DataSource.WEB_FILES;
			bt_default_files.setBackgroundResource(R.drawable.bt_normal);
			bt_demo_files.setBackgroundResource(R.drawable.bt_normal);
			bt_web_files.setBackgroundResource(R.drawable.bt_selected);
			bt_generated_data.setBackgroundResource(R.drawable.bt_normal);
		} else if (v == bt_default_files) {
			data = DataSource.DEFAULT_FILES;
			bt_default_files.setBackgroundResource(R.drawable.bt_selected);
			bt_demo_files.setBackgroundResource(R.drawable.bt_normal);
			bt_web_files.setBackgroundResource(R.drawable.bt_normal);
			bt_generated_data.setBackgroundResource(R.drawable.bt_normal);
		} else if (v == bt_preload_data) {
			preload = true;
			bt_preload_data.setBackgroundResource(R.drawable.bt_selected);
			bt_continuous_load.setBackgroundResource(R.drawable.bt_normal);
		} else if (v == bt_continuous_load) {
			preload = false;
			bt_preload_data.setBackgroundResource(R.drawable.bt_normal);
			bt_continuous_load.setBackgroundResource(R.drawable.bt_selected);
		} else if (v == sw_map) {
			if (map) {
				map = false;
				sw_map.setImageResource(R.drawable.switch_off);
			} else {
				map = true;
				sw_map.setImageResource(R.drawable.switch_on);
			}
		} else if (v == sw_list) {
			if (list) {
				list = false;
				sw_list.setImageResource(R.drawable.switch_off);
			} else {
				list = true;
				sw_list.setImageResource(R.drawable.switch_on);
			}
		} else if (v == sw_teleport) {
			if (teleport) {
				teleport = false;
				sw_teleport.setImageResource(R.drawable.switch_off);
			} else {
				teleport = true;
				sw_teleport.setImageResource(R.drawable.switch_on);
			}
		} else if (v == sw_en) {
			lan = Language.EN;
			sw_en.setImageResource(R.drawable.en_selected);
			sw_es.setImageResource(R.drawable.es_noselected);
			sw_pt.setImageResource(R.drawable.pt_noselected);
		} else if (v == sw_es) {
			lan = Language.ES;
			sw_en.setImageResource(R.drawable.en_noselected);
			sw_es.setImageResource(R.drawable.es_selected);
			sw_pt.setImageResource(R.drawable.pt_noselected);
		} else if (v == sw_pt) {
			lan = Language.PT;
			sw_en.setImageResource(R.drawable.en_noselected);
			sw_es.setImageResource(R.drawable.es_noselected);
			sw_pt.setImageResource(R.drawable.pt_selected);
		} else if (v == bt_launch) {
			if (custom) {
				VisionCore vs = new VisionCore(this.getApplicationContext(),
						false);
				VisionCore.core.ar = new MyARManager(map, list, teleport);
				VisionCore.core.ar.setPrefixForImages("demo_");
				VisionCore.core.configuration = new VisionConfiguration();
				VisionCore.core.configuration
						.setRadarPosition(VisionConfiguration.RADAR_POSITION_RIGHT);
				VisionCore.core.configuration.showAppLogo(false);
				switch (lan) {
				case EN:
					VisionCore.core.configuration.setLanguage("_en");
					break;
				case ES:
					VisionCore.core.configuration.setLanguage("_es");
					break;
				case PT:
					VisionCore.core.configuration.setLanguage("_pt");
					break;
				}
				new LoadCustomDataTask().execute();
			} else {
				VisionCore vs = new VisionCore(this.getApplicationContext(),
						true);
				VisionCore.core.ar.setPrefixForImages("");
				VisionCore.core.model
						.setVisionGeoPoiClickListener(new VisionGeoPoiClickListener() {
							@Override
							public void onVisionGeoPoiClick(VisionGeoPoi poi,
									Activity act) {
								Toast.makeText(
										act,
										"<--- POI: " + poi.getTitle() + " --->",
										Toast.LENGTH_SHORT).show();
							}
						});
				VisionCore.core.configuration
						.setRadarPosition(VisionConfiguration.RADAR_POSITION_LEFT);
				VisionCore.core.configuration.showAppLogo(true);
				switch (lan) {
				case EN:
					VisionCore.core.configuration.setLanguage("_en");
					break;
				case ES:
					VisionCore.core.configuration.setLanguage("_es");
					break;
				case PT:
					VisionCore.core.configuration.setLanguage("_pt");
					break;
				}
				new LoadDataTask().execute();
			}
		}

	}

	private class LoadDataTask extends AsyncTask<Void, Void, Void> {

		public LoadDataTask() {

		}

		protected void onPreExecute() {
			progress.setVisibility(View.VISIBLE);
		}

		@Override
		protected void onPostExecute(Void response) {
			VisionCore.startAR(MainActivity.this);
			progress.setVisibility(View.GONE);
		}

		@SuppressWarnings("static-access")
		@Override
		protected Void doInBackground(Void... params) {
			switch (data) {
			case DEFAULT_FILES:
				VisionCore.core.loadData(MainActivity.this);
				break;
			case DEMO_FILES:
				VisionCore.core.model.categoriesFrom = "file_categories";
				VisionCore.core.model.poisFrom = "file_pois";
				VisionCore.core.loadData(MainActivity.this);
				break;
			case WEB_FILES:
				VisionCore.core.model.categoriesFrom = "http://dl.dropbox.com/u/2251236/vision/file_categories";
				VisionCore.core.model.poisFrom = "https://dl.dropbox.com/u/2251236/vision/file_pois";
				VisionCore.core.loadData(MainActivity.this);
				break;
			case GENERATED_DATA:
				generateData();
				break;
			}

			return null;
		}

		private void generateData() {
			VisionImage iconCat1 = new VisionImage();
			iconCat1.setImageURL("icon2");
			VisionImage iconCat2 = new VisionImage();
			iconCat2.setImageURL("cs2003");
			VisionImage iconCat3 = new VisionImage();
			iconCat3.setImageURL("cns2003");

			VisionCategory turistCategory = new VisionCategory();
			turistCategory.setTitle("Tourist places");
			turistCategory.setIcon(iconCat1);
			turistCategory.setSelectedIcon(iconCat2);
			turistCategory.setNoSelectedIcon(iconCat3);
			VisionCore.getCategories().add(turistCategory);

			VisionGeoPoi poi = new VisionGeoPoi();
			poi.setId("0001");
			poi.setTitle("Facultad de Letras");
			poi.setSubtitle("Puerta del Sol 1, Madrid");
			poi.setLatitude(40.41687);
			poi.setLongitude(-3.703412);
			poi.setWeb("http://en.wikipedia.org/wiki/Puerta_del_Sol");
			poi.getCategories().add(turistCategory);
			VisionCore.core.model.getPois().add(poi);

			poi = new VisionGeoPoi();
			poi.setId("0002");
			poi.setTitle("Facultad de Letras");
			poi.setSubtitle("Champ de Mars, 5, Paris, France");
			poi.setLatitude(148.858391);
			poi.setLongitude(2.293739);
			poi.setWeb("http://en.wikipedia.org/wiki/Torre_Eiffel");
			poi.getCategories().add(turistCategory);
			VisionCore.core.model.getPois().add(poi);
			
			poi = new VisionGeoPoi();
			poi.setId("0003");
			poi.setTitle("Facultad de Psicología");
			poi.setSubtitle("Champ de Mars, 5, Paris, France");
			poi.setLatitude(65.858391);
			poi.setLongitude(99.293739);
			poi.setWeb("http://en.wikipedia.org/wiki/Torre_Eiffel");
			poi.getCategories().add(turistCategory);
			VisionCore.core.model.getPois().add(poi);
			
			poi = new VisionGeoPoi();
			poi.setId("0004");
			poi.setTitle("Facultad de Matemáticas");
			poi.setSubtitle("Champ de Mars, 5, Paris, France");
			poi.setLatitude(120.858391);
			poi.setLongitude(6.293739);
			poi.setWeb("http://en.wikipedia.org/wiki/Torre_Eiffel");
			poi.getCategories().add(turistCategory);
			VisionCore.core.model.getPois().add(poi);

		}

	}// LoadDataTask

	private class LoadCustomDataTask extends AsyncTask<Void, Void, Void> {

		public LoadCustomDataTask() {

		}

		protected void onPreExecute() {
			progress.setVisibility(View.VISIBLE);
		}

		@Override
		protected void onPostExecute(Void response) {
			VisionCore.startAR(MainActivity.this);
			progress.setVisibility(View.GONE);
		}

		@SuppressWarnings("static-access")
		@Override
		protected Void doInBackground(Void... params) {
			if (preload) {
				VisionCore.core.model = new MyModelManagerPreload();
				VisionCore.core.model.categoriesFrom = "my_custom_categories";
				VisionCore.core.model.poisFrom = "my_custom_pois";
				VisionCore.core.model.loadPoisContinouosly = false;
				VisionCore.core.loadData(MainActivity.this);
			} else {
				VisionCore.core.model = new MyModelManager();
				VisionCore.core.model.loadPoisContinouosly = true;
				VisionCore.core.loadData(MainActivity.this);
			}

			return null;
		}

	}// LoadCustomDataTask

}
