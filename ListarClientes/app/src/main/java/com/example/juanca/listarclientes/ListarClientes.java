package com.example.juanca.listarclientes;

import android.app.ListActivity;
import android.os.Bundle;

/**
 * Created by Juanca on 28/08/2016.
 */
public class ListarClientes extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.listar_clientes);
    }
}
