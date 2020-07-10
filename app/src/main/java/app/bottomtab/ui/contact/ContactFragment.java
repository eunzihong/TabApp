package app.bottomtab.ui.contact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import app.bottomtab.R;

public class ContactFragment extends Fragment {

    private ContactViewModel ContactViewModel;
    private RecyclerAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ContactViewModel =
                ViewModelProviders.of(this).get(ContactViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contact, container, false);

        final androidx.recyclerview.widget.RecyclerView ContactView = root.findViewById(R.id.recyclerview_contacts);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        ContactView.setLayoutManager(linearLayoutManager);

        adapter = new RecyclerAdapter();
        ContactView.setAdapter(adapter);

        String json = "";

        try {
            InputStream is = getActivity().getAssets().open("contacts.json");
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

        try{
            JSONObject jsonObject = new JSONObject(json);

            JSONArray contactArray = jsonObject.getJSONArray("Contacts");

            for(int i=0; i<contactArray.length(); i++)
            {
                JSONObject contactObject = contactArray.getJSONObject(i);

                Contact contact = new Contact();

                contact.setName(contactObject.getString("NAME"));
                contact.setPhoneNumber(contactObject.getString("PHONE"));

                adapter.addItem(contact);
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }


        adapter.notifyDataSetChanged();

        return root;
    }


}