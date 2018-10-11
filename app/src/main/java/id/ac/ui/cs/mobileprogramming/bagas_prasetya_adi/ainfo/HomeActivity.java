package id.ac.ui.cs.mobileprogramming.bagas_prasetya_adi.ainfo;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragment homeFragment;
    private BatteryFragment batteryFragment;
    private NetworkFragment networkFragment;

    private ImageView mBatteryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        homeFragment = new HomeFragment();
        batteryFragment = new BatteryFragment();
        networkFragment = new NetworkFragment();

        if(null == savedInstanceState) {
            setFragment(homeFragment);
        }

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.nav_home :
                        setFragment(homeFragment);
                        return true;

                    case R.id.nav_battery :
                        setFragment(batteryFragment);
                        return true;

                    case R.id.nav_network :
                        setFragment(networkFragment);
                        return true;

                    default :
                        return false;
                }
            }
        });
    }

    private void setFragment(android.support.v4.app.Fragment fragment) {

        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }
}
