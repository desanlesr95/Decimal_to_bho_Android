package com.example.luis.binario;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void calcular(View view){
        RadioButton b=(RadioButton)findViewById(R.id.binario);
        RadioButton h=(RadioButton)findViewById(R.id.hexa);
        RadioButton o=(RadioButton)findViewById(R.id.radioButton);
        EditText num=(EditText)findViewById(R.id.decimal);
        TextView res=(TextView)findViewById(R.id.resultado);
        int n=Integer.parseInt(num.getText().toString());
        int d=0;
        res.setText("");
        if(b.isChecked()){
            while(n>=2){
                res.setText((n%2)+""+res.getText());
                n/=2;
            }
            res.setText(n+""+res.getText());
        }
        else if(h.isChecked()){
            while(n>=16){
                d=n%16;
                if(d>9){
                    switch (d){
                        case 10:
                            res.setText("A"+res.getText());
                            break;
                        case 11:
                            res.setText("B"+res.getText());
                            break;
                        case 12:
                            res.setText("C"+res.getText());
                            break;
                        case 13:
                            res.setText("D"+res.getText());
                            break;
                        case 14:
                            res.setText("E"+res.getText());
                            break;
                        case 15:
                            res.setText("F"+res.getText());
                            break;
                    }
                }
                else{
                    res.setText(d+""+res.getText());
                }
                n=n/16;
            }
            res.setText(n+""+res.getText());
        }

        else if(o.isChecked()){
            while(n>=8){
                res.setText((n%8)+""+res.getText());
                n/=8;
            }
            res.setText(n+""+res.getText());
        }

        else{
            Toast t=Toast.makeText(getApplicationContext(),"No ha seleccionado ningun sistema de numeracion",Toast.LENGTH_SHORT);
            t.show();
        }
    }
}
