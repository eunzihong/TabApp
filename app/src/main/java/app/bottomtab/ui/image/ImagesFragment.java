package app.bottomtab.ui.image;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import app.bottomtab.R;

public class ImagesFragment extends Fragment {

    private ImagesViewModel ImagesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ImagesViewModel =
                ViewModelProviders.of(this).get(ImagesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_image, container, false);
        final TextView textView = root.findViewById(R.id.text_image);
        ImagesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}