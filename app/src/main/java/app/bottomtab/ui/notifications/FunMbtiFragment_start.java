package app.bottomtab.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import app.bottomtab.R;

public class FunMbtiFragment_start extends Fragment {

    private Button btn_start;
    private View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mbti_start, container, false);
        btn_start = view.findViewById(R.id.btn_start);

        btn_start.setOnClickListener(new View.OnClickListener() { // fragment 2로 이동한다.
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                FunMbtiFragment1 funMbtiFragment1 = new FunMbtiFragment1();

                transaction.replace(R.id.main_frame, funMbtiFragment1);

                transaction.commit(); // 저장!
            }
        });


        return view;
    }
}