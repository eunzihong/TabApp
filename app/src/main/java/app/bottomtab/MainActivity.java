package app.bottomtab;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import app.bottomtab.ui.contact.ContactFragment;
import app.bottomtab.ui.image.ImagesFragment;
import app.bottomtab.ui.notifications.FunMbtiFragment_start;


public class MainActivity extends AppCompatActivity {
    private static final int MESSAGE_PERMISSION_GRANTED = 101;
    private static final int MESSAGE_PERMISSION_DENIED = 102;

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private ContactFragment contactFragment;
    private ImagesFragment imagesFragment;
    private FunMbtiFragment_start funMbtiFragmentStart;

    static final int READ_CONTACTS_PERMISSON = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav_view); //navigation bar
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.navigation_contacts:
                                setFragment(0);
                                break;
                            case R.id.navigation_images:
                                setFragment(1);
                                break;
                            case R.id.navigation_notifications:
                                setFragment(2);
                                break;
                        }
                        return false;
                    }
                });

        contactFragment = new ContactFragment();
        imagesFragment = new ImagesFragment();
        funMbtiFragmentStart = new FunMbtiFragment_start();
        setFragment(0);

        getPermission(Manifest.permission.READ_CONTACTS);

    }

    private void setFragment(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        //fragment replacement
        switch (n) {
            case 0:
                ft.replace(R.id.main_frame, contactFragment);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame, imagesFragment);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, funMbtiFragmentStart);
                ft.commit();
                break;
        }
    }

    public void getPermission(String permissionId){
        int permissonCheck = ContextCompat.checkSelfPermission(this, permissionId);

        if(permissonCheck == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(getApplicationContext(),
                    permissionId + " permission granted", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),
                    permissionId + " permission denied", Toast.LENGTH_SHORT).show();

            if(ActivityCompat.shouldShowRequestPermissionRationale(this, permissionId)){
                // Explanation for permission requirement
                Toast.makeText(getApplicationContext(),
                        permissionId + " 권한이 필요합니다.", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this,
                        new String[]{ Manifest.permission.READ_CONTACTS}, READ_CONTACTS_PERMISSON);
            }else{
                ActivityCompat.requestPermissions(this,
                        new String[]{ Manifest.permission.READ_CONTACTS}, READ_CONTACTS_PERMISSON);
            }
        }
    }



}