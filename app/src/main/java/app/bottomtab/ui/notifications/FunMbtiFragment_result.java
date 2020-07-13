package app.bottomtab.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import app.bottomtab.R;

public class FunMbtiFragment_result extends Fragment {
    private View view;
    private ImageView imageView;

    private String type;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        type = getArguments().getString("fromFrag4");

        view = inflater.inflate(R.layout.fragment_mbti_result, container, false);

        imageView = (ImageView) view.findViewById(R.id.imageView);
        show_type();
        return view;
    }



    private void show_type() {
        if (type.equals( "enfj")) {
            imageView.setImageResource(R.drawable.enfj);
        }
        else if (type.equals( "enfp")) {
            imageView.setImageResource(R.drawable.enfp);
        }
        else if (type.equals( "entj")) {
            imageView.setImageResource(R.drawable.entj);
        }
        else if (type.equals("entp")) {
            imageView.setImageResource(R.drawable.entp);
        }
        else if (type.equals( "esfj")) {
            imageView.setImageResource(R.drawable.esfj);
        }
        else if (type.equals( "estj")) {
            imageView.setImageResource(R.drawable.estj);
        }
        else if (type.equals( "infj")) {
            imageView.setImageResource(R.drawable.infj);
        }
        else if (type.equals( "infp")) {
            imageView.setImageResource(R.drawable.infp);
        }
        else if (type.equals( "intj")) {
            imageView.setImageResource(R.drawable.intj);
        }
        else if (type.equals( "intp")) {
            imageView.setImageResource(R.drawable.intp);
        }
        else if (type.equals( "isfj")) {
            imageView.setImageResource(R.drawable.isfj);
        }
        else if (type.equals( "istj")) {
            imageView.setImageResource(R.drawable.istj);
        }
        else if (type.equals( "istp")) {
            imageView.setImageResource(R.drawable.istp);
        }
        else if (type.equals( "isfp")) {
            imageView.setImageResource(R.drawable.isfp);
        }
        else if (type.equals( "estp")) {
            imageView.setImageResource(R.drawable.estp);
        }
        else if (type.equals( "esfp")) {
            imageView.setImageResource(R.drawable.esfp);
        }
    }


}