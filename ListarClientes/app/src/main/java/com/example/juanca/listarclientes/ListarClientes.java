package com.example.juanca.listarclientes;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.juanca.entidades.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juanca on 28/08/2016.
 */
public class ListarClientes extends ListActivity {

    private ClienteAdapter clienteAdapter;
    private List<Cliente> listado = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.listar_clientes);

        AsyncCallWS async=new AsyncCallWS();
        async.execute();
        clienteAdapter=new ClienteAdapter(this);
    }

    private class AsyncCallWS extends AsyncTask<String, Void, Void>{
            @Override
            protected Void doInBackground(String... params){

                listado=WebService.ListarClientes("listarClientes");
                return null;
            }
            @Override
            protected void onPostExecute(Void result){
                clienteAdapter.setLista(listado);
                setListAdapter(clienteAdapter);

            }

            @Override
            protected void  onPreExecute(){


            }
            @Override
            protected void onProgressUpdate(Void... values){


            }





    }


}
