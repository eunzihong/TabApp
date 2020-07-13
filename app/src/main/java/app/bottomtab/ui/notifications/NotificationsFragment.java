package app.bottomtab.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import app.bottomtab.R;

public class NotificationsFragment extends Fragment {

    private Button btn_previous, btn_next;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        btn_previous = root.findViewById(R.id.btn_previous);
        btn_next = root.findViewById(R.id.btn_next);

        View.OnClickListener pagebtn_listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_previous:
                        Toast.makeText(getActivity(), "Back to the previous page", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.btn_next:
                        Toast.makeText(getActivity(), "Go to the next page", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        btn_previous.setOnClickListener(pagebtn_listener);
        btn_next.setOnClickListener(pagebtn_listener);

        return root;
    }
}