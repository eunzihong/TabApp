package app.bottomtab;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import app.bottomtab.ui.contact.ContactFragment;
import app.bottomtab.ui.image.ImagesFragment;
import app.bottomtab.ui.notifications.FunMbtiFragment_start;


public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private ContactFragment frag1;
    private ImagesFragment frag2;
    private FunMbtiFragment_start frag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.nav_view); //navigation bar
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_contacts:
                        setFrag(0);
                        break;
                    case R.id.navigation_images:
                        setFrag(1);
                        break;
                    case R.id.navigation_notifications:
                        setFrag(2);
                        break;
                }
                return false;
            }
        });
        frag1 = new ContactFragment();
        frag2 = new ImagesFragment();
        frag3 = new FunMbtiFragment_start();
//        setFrag(0);

    }
    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        //fragment 교체행위
        switch (n) {
            case 0:
                ft.replace(R.id.main_frame, frag1);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame, frag2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, frag3);
                ft.commit();
                break;
        }
    }

}