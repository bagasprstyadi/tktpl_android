package id.ac.ui.cs.mobileprogramming.bagas_prasetya_adi.ainfo;


import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class BatteryFragment extends Fragment {

    ImageView iv_battery;
    TextView tv_battery;

    public BatteryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_battery, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        tv_battery = (TextView) getActivity().findViewById(R.id.tv_battery);
        iv_battery = (ImageView) getActivity().findViewById(R.id.iv_battery);

        int level = (int) batteryLevel();
        tv_battery.setText("" + level);

        if(level > 75) {
            iv_battery.setImageResource(R.drawable.ic_004_battery_3);
        } else if(level > 50 && level <= 75) {
            iv_battery.setImageResource(R.drawable.ic_003_battery_2);
        } else if(level > 25 && level <= 50) {
            iv_battery.setImageResource(R.drawable.ic_002_battery_1);
        } else if(level > 0 && level <= 25){
            iv_battery.setImageResource(R.drawable.ic_001_battery);
        }

        setare();
    }

    public void setare() {
        tv_battery.setText("" + (int) batteryLevel());
    }

    public float batteryLevel() {
        Intent batteryIntent = getActivity().registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        int level = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        if(level == -1 || scale == -1) {
            return 50.0f;
        }

        return ((float) level / (float) scale) * 100.0f;
    }

}
