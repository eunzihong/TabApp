package app.bottomtab.ui.contact;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContactViewModel extends ViewModel {

    private MutableLiveData<String> Contacts;

    public ContactViewModel() {
        Contacts = new MutableLiveData<>();
        Contacts.setValue("hello");
    }

    public LiveData<String> getContact() {
        return Contacts;
    }


}