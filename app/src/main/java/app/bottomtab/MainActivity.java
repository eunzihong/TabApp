package app.bottomtab;

import android.Manifest;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;

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

    public PermissionHandler permissionHandler = new PermissionHandler();

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

    private void getPermission(String permissionId){
        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(MainActivity.this,
                        "Permission Granted", Toast.LENGTH_SHORT).show();
                permissionHandler.sendEmptyMessage(MESSAGE_PERMISSION_GRANTED);
            }
            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                Toast.makeText(MainActivity.this,
                        "Permission Denied: "+deniedPermissions.get(0),
                        Toast.LENGTH_SHORT).show();
                permissionHandler.sendEmptyMessage(MESSAGE_PERMISSION_DENIED);
            }
        };
        new TedPermission(MainActivity.this)
                .setPermissionListener(permissionListener)
                .setRationaleMessage("READ CONTACTS permission required")
                .setPermissions(permissionId)
                .check();
    }

    private class PermissionHandler extends app.bottomtab.PermissionHandler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case MESSAGE_PERMISSION_GRANTED:
                    break;
                case MESSAGE_PERMISSION_DENIED:
                    finish();
                    break;
                default:
                    super.handleMessage(msg);
                    break;
            }
        }
    }

}