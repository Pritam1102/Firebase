package com.example.firebase;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.firebase.databinding.ActivityVectorOperationsBinding;

public class VectorOperations extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ActivityVectorOperationsBinding vBinding;


    String[] ops = {"Addition", "Subtraction","Dot Product","Cross Product"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        vBinding = DataBindingUtil.setContentView(this,R.layout.activity_vector_operations);

        ArrayAdapter aa = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,ops);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vBinding.spinner.setAdapter(aa);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
            case 1:
                if(vBinding.ed1.getText()!=null && vBinding.ed2.getText()!=null && vBinding.ed3.getText()!=null && vBinding.ed4.getText()!=null &&
                        vBinding.ed5.getText()!=null && vBinding.ed6.getText()!=null){
                    double x1 = Double.parseDouble(vBinding.ed1.getText().toString());
                    double y1=  Double.parseDouble(vBinding.ed2.getText().toString());
                    double z1=  Double.parseDouble(vBinding.ed3.getText().toString());
                    double x2=  Double.parseDouble(vBinding.ed4.getText().toString());
                    double y2=  Double.parseDouble(vBinding.ed5.getText().toString());
                    double z2=  Double.parseDouble(vBinding.ed6.getText().toString());

                    vBinding.result.setOnClickListener(v -> {
                        vBinding.LL5.setVisibility(View.VISIBLE);
                        double x = x1+x2;
                        double y = y1+y2;
                        double z = z1+z2;
                        vBinding.tv1.setText(String.valueOf(x));
                        vBinding.tv2.setText(String.valueOf(y));
                        vBinding.tv3.setText(String.valueOf(z));
                    });
                }

                break;

            case 2:
                if(vBinding.ed1.getText()!=null && vBinding.ed2.getText()!=null && vBinding.ed3.getText()!=null && vBinding.ed4.getText()!=null &&
                        vBinding.ed5.getText()!=null && vBinding.ed6.getText()!=null) {
                    double x1 = Double.parseDouble(vBinding.ed1.getText().toString());
                    double y1 = Double.parseDouble(vBinding.ed2.getText().toString());
                    double z1 = Double.parseDouble(vBinding.ed3.getText().toString());
                    double x2 = Double.parseDouble(vBinding.ed4.getText().toString());
                    double y2 = Double.parseDouble(vBinding.ed5.getText().toString());
                    double z2 = Double.parseDouble(vBinding.ed6.getText().toString());

                    vBinding.result.setOnClickListener(v -> {
                        vBinding.dotProduct.setVisibility(View.VISIBLE);
                        double a = x1 * x2;
                        double b = y1 * y2;
                        double c = z1 * z2;
                        vBinding.tv1.setText(String.valueOf(a));
                        vBinding.tv2.setText(String.valueOf(b));
                        vBinding.tv3.setText(String.valueOf(c));
                    });
                }
                break;

            case 3:

                if(vBinding.ed1.getText()!=null && vBinding.ed2.getText()!=null && vBinding.ed3.getText()!=null && vBinding.ed4.getText()!=null &&
                        vBinding.ed5.getText()!=null && vBinding.ed6.getText()!=null) {
                    double x1 = Double.parseDouble(vBinding.ed1.getText().toString());
                    double y1 = Double.parseDouble(vBinding.ed2.getText().toString());
                    double z1 = Double.parseDouble(vBinding.ed3.getText().toString());
                    double x2 = Double.parseDouble(vBinding.ed4.getText().toString());
                    double y2 = Double.parseDouble(vBinding.ed5.getText().toString());
                    double z2 = Double.parseDouble(vBinding.ed6.getText().toString());

                    vBinding.result.setOnClickListener(v -> {
                        vBinding.LL5.setVisibility(View.VISIBLE);
                        double p = y1 * z2 - z1 * y2;
                        double q = z1 * x2 - x1 * z2;
                        double r = x1 * y2 - x2 * y1;
                        vBinding.tv1.setText(String.valueOf(p));
                        vBinding.tv2.setText(String.valueOf(q));
                        vBinding.tv3.setText(String.valueOf(r));
                    });
                }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}