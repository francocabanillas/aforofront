package com.upc.aforofront.ui.home;

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
import com.upc.aforofront.view.Marca;
import com.upc.aforofront.view.MarcaAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private List<Marca> MarcaList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MarcaAdapter mAdapter;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });

        recyclerView = (RecyclerView) root.findViewById(R.id.marcarecycler);

        mAdapter = new MarcaAdapter(MarcaList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(root.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addItemDecoration(new DividerItemDecoration(this.getContext(), LinearLayoutManager.VERTICAL));


        recyclerView.setAdapter(mAdapter);

        prepareMarcaData();

        return root;
    }

    private void prepareMarcaData() {
        Marca Marca = new Marca();

        Marca = new Marca("1","Metro","URL");
        MarcaList.add(Marca);

        Marca = new Marca("2","Plaza Vea","URL");
        MarcaList.add(Marca);

        Marca = new Marca("3","Precio Uno","URL");
        MarcaList.add(Marca);

        Marca = new Marca("4","Tottus","URL");
        MarcaList.add(Marca);

        Marca = new Marca("5","Vivanda","URL");
        MarcaList.add(Marca);Marca = new Marca("1","Metro","URL");

        Marca = new Marca("6","Wong","URL");
        MarcaList.add(Marca);

        mAdapter.notifyDataSetChanged();
    }
    
}