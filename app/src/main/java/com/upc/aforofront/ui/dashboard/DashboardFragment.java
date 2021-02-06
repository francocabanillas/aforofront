package com.upc.aforofront.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.upc.aforofront.R;
import com.upc.aforofront.view.Marca;
import com.upc.aforofront.view.Sede;
import com.upc.aforofront.view.SedeAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

        String str="";
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            str = bundle.getString("idmarca", "1");
        }


        prepareSedeData(str);

        return root;
    }

    private void prepareSedeData(String idmarca) {
        String url = "http://aforoactual.mypressonline.com/index.php/sedes/"+idmarca;

        StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);

                    List<String> items = new ArrayList<>();
                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject object = jsonArray.getJSONObject(i);
                        SedeList.add(new Sede(
                                object.getString("id"),
                                object.getString("nombre"),
                                object.getString("direccion"),
                                object.getString("latitud"),
                                object.getString("longitud"),
                                object.getString("aforo"),
                                object.getString("id_marca"),
                                object.getString("imagen")));
                    }

                    mAdapter.notifyDataSetChanged();


                } catch (JSONException e) {
                    Log.i("======>", e.getMessage());
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("======>", error.toString());
                    }
                }
        );
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);

        mAdapter.notifyDataSetChanged();
    }
    
}