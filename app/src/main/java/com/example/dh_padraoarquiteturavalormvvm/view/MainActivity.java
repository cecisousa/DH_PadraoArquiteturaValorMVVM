package com.example.dh_padraoarquiteturavalormvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.dh_padraoarquiteturavalormvvm.R;
import com.example.dh_padraoarquiteturavalormvvm.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private TextView textoValor;
    private Button btnValor;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoValor = findViewById(R.id.textViewValor);
        btnValor = findViewById(R.id.buttonValor);
//        inicializando um ViewModel
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        btnValor.setOnClickListener(v -> {

            viewModel.somaValor(5);

            viewModel.retornaValor().observe(this, valorRetornado -> {
                textoValor.setText(valorRetornado.toString());
            });
        });


    }

}
