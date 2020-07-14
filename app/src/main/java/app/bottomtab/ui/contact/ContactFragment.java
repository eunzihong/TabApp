package app.bottomtab.ui.contact;

import android.Manifest;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import app.bottomtab.R;

public class ContactFragment extends Fragment {

    private RecyclerAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contact, container, false);

        final androidx.recyclerview.widget.RecyclerView ContactView =
                root.findViewById(R.id.recyclerview_contacts);

        // Permission setting
        getPermission(Manifest.permission.READ_CONTACTS);

        // RecyclerView setting
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        ContactView.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerAdapter();
        ContactView.setAdapter(adapter);

        // Recycler adapter contact data setting
        setJSONcontacts(adapter, "contacts.json");  // Load contact data from contacts.json
        setDeviceContacts(adapter);     // Load the user's contact list
        adapter.notifyDataSetChanged(); // Notify the adapter data modification

        return root;
    }

    // Permission request via TedPermission
    public void getPermission(String permissionId){
        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(getActivity(), "Permission Granted", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                Toast.makeText(getActivity(), "Permission Denied: "+deniedPermissions.get(0), Toast.LENGTH_SHORT).show();
            }
        };
        new TedPermission(getActivity())
                .setPermissionListener(permissionListener)
                .setRationaleMessage("READ CONTACTS permission required")
                .setPermissions(permissionId)
                .check();
    }

    // Load contact data from json database
    public void setJSONcontacts(RecyclerAdapter adapter, String filename){
        String json = "";

        try {   // Open and load json file
            InputStream is = getActivity().getAssets().open(filename);
            int fileSize = is.available();

            byte[] buffer = new byte[fileSize];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        try{    // json data parsing
            JSONObject jsonObject = new JSONObject(json);

            JSONArray contactArray = jsonObject.getJSONArray("Contacts");

            for(int i=0; i<contactArray.length(); i++)
            {
                JSONObject contactObject = contactArray.getJSONObject(i);

                Contact contact = new Contact();

                contact.setName(contactObject.getString("NAME"));
                contact.setPhoneNumber(contactObject.getString("PHONE"));
                contact.setProfile(getResources().getIdentifier(
                        contactObject.getString("PROFILE"),"drawable",
                        getActivity().getPackageName()));

                adapter.addItem(contact);
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }

    }

    // Load the user's contact list
    public void setDeviceContacts(RecyclerAdapter adapter){
        ContactUtil contactUtil = new ContactUtil(getActivity());

        ArrayList<Contact> phoneBook;
        phoneBook = contactUtil.getContactList();

        for(int i=0; i<phoneBook.size(); i++)
        {
            adapter.addItem(phoneBook.get(i));
        }
    }

}