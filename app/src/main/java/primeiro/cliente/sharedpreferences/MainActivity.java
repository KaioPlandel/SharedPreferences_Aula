package primeiro.cliente.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "App_aulaSP";
    private static final String Nome_Pref = "App_aulaSP_pref";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String nomeProduto;
    int codigoProduto;
    float precoProduto;
    boolean estoque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "App rodando");

        //Criar tabela
        sharedPreferences = getSharedPreferences(Nome_Pref, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        nomeProduto = "Notebook";
        codigoProduto = 12345;
        precoProduto = 1253.00f;
        estoque = true;

        //Adicionar os dados
        editor.putString("nomeProduto",nomeProduto);
        editor.putInt("codigoProduto",codigoProduto);
        editor.putFloat("precoProduto",precoProduto);
        editor.putBoolean("estoque",estoque);

        //Salvar os dados
        editor.apply();

        //Limpar dados
        editor.clear();
        editor.apply();

        //Remover um item específico
        editor.remove("estoque");
        editor.apply();

        //Buscar os dados to banco
        String nome = sharedPreferences.getString("nome","fora de estoque"); //o primeiro arg é a chave o segundo é um valor padrao caso não encontre nada;
        int codigo = sharedPreferences.getInt("codigoProduto",-1);

        Log.i(TAG, "onCreate: " + nome);
    }
}