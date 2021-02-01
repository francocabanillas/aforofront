package com.upc.aforofront.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.upc.aforofront.R;
import com.upc.aforofront.recycler.Listado;
import com.upc.aforofront.recycler.ListadoAdapter;
import com.upc.aforofront.recycler.SedeAforo;
import com.upc.aforofront.recycler.SedeAforoAdapter;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private List<SedeAforo> sedeAforoList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SedeAforoAdapter mAdapter;

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        recyclerView = (RecyclerView) root.findViewById(R.id.sedeaforoRecycler);

        mAdapter = new SedeAforoAdapter(sedeAforoList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(root.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addItemDecoration(new DividerItemDecoration(this.getContext(), LinearLayoutManager.VERTICAL));


        recyclerView.setAdapter(mAdapter);

        prepareSedeAforoData();

        return root;
    }

    private void prepareSedeAforoData() {
        SedeAforo sedeAforo = new SedeAforo();

        sedeAforo = new SedeAforo("1","Metro La Marina","Av. La Marina 351","","","","1");
        sedeAforoList.add(sedeAforo);

        sedeAforo = new SedeAforo("2","Metro Minka","Av. Av. Faucett 655","","","","1");
        sedeAforoList.add(sedeAforo);

        sedeAforo = new SedeAforo("3","Metro Emancipacion","Av. La Marina 351","","","","1");
        sedeAforoList.add(sedeAforo);

        sedeAforo = new SedeAforo("4","Metro España","Av. La Marina 351","","","","1");
        sedeAforoList.add(sedeAforo);

        sedeAforo = new SedeAforo("5","Metro Chorrillos","Av. La Marina 351","","","","1");
        sedeAforoList.add(sedeAforo);


        mAdapter.notifyDataSetChanged();
    }
}