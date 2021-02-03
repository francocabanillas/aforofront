package com.upc.aforofront.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.upc.aforofront.R;
import com.upc.aforofront.view.Sede;
import com.upc.aforofront.view.SedeAdapter;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private List<Sede> SedeList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SedeAdapter mAdapter;

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);


        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });

        recyclerView = (RecyclerView) root.findViewById(R.id.sederecycler);
        mAdapter = new SedeAdapter(SedeList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(root.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        prepareSedeData();

        return root;
    }

    private void prepareSedeData() {
        Sede Sede = new Sede();

        Sede = new Sede("1","Metro La Marina","Av. La Marina 351","","","","1");
        SedeList.add(Sede);

        Sede = new Sede("2","Metro Minka","Av. Av. Faucett 655","","","","1");
        SedeList.add(Sede);

        Sede = new Sede("3","Metro Emancipacion","Av. La Marina 351","","","","1");
        SedeList.add(Sede);

        Sede = new Sede("4","Metro España","Av. La Marina 351","","","","1");
        SedeList.add(Sede);

        Sede = new Sede("5","Metro Chorrillos","Av. La Marina 351","","","","1");
        SedeList.add(Sede);


        mAdapter.notifyDataSetChanged();
    }
    
}