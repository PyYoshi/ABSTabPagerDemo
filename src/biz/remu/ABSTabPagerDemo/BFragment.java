package biz.remu.ABSTabPagerDemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockFragment;

public class BFragment extends SherlockFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_layout, container, false);
        View tv = v.findViewById(R.id.fragment_text);
        ((TextView)tv).setText("Fragment #" + "B");

        Button button = new Button(getSherlockActivity());
        button.setText("Change!");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new BChildFragment();
                Fragment oldFragment = ((MyActivity)getActivity()).getCurrentFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.remove(oldFragment);
                ft.replace(android.R.id.tabcontent,fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        ((LinearLayout)v).addView(button);

        return v;
    }
}
