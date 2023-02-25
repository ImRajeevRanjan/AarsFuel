package com.example.aarsfuel;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Objects;


public class Home_Page extends Fragment implements RadioGroup.OnCheckedChangeListener {



//    static String TYPE="";
//    String[] spinner_choice = {"Petrol","Diesel"};
    TextView density_01;
    TextView density_02;
    TextView density_03;
    TextView density_04;

    TextView petrol_short;
    TextView diesel_short;
    Button calculate_table;
    float PETROL_SHORT =0F;
    float DIESEL_SHORT =0F;



    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    RadioGroup radioGroup3;
    RadioGroup radioGroup4;


    static String TYPE_1;
    @Nullable
    EditText litres_01;
    @Nullable
    EditText challan_01;
    @Nullable
    EditText caught_01;


    static String TYPE_2;
    @Nullable
    EditText litres_02;
    @Nullable
    EditText challan_02;
    @Nullable
    EditText caught_02;



   static String TYPE_3;
    EditText litres_03;
    @Nullable
    EditText challan_03;
    @Nullable
    EditText caught_03;


   static String TYPE_4;
    @Nullable
    EditText litres_04;
    @Nullable
    EditText challan_04;
    @Nullable
    EditText caught_04;



    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_home__page, container, false);

        litres_01 = view.findViewById(R.id.litre01);
        challan_01 = view.findViewById(R.id.Challan01);
        caught_01 = view.findViewById(R.id.Caugth01);
        EditText base_01 = view.findViewById(R.id.Base01);
        EditText temp_01 = view.findViewById(R.id.Temp01);
        density_01 = view.findViewById(R.id.Density01);

         litres_02 = view.findViewById(R.id.litre02);
         challan_02 = view.findViewById(R.id.Challan02);
         caught_02 = view.findViewById(R.id.Caugth02);
        EditText base_02 = view.findViewById(R.id.Base02);
        EditText temp_02 = view.findViewById(R.id.Temp02);
        density_02 = view.findViewById(R.id.Density02);

         litres_03 = view.findViewById(R.id.litre03);
         challan_03 = view.findViewById(R.id.Challan03);
         caught_03 = view.findViewById(R.id.Caugth03);
        EditText base_03 = view.findViewById(R.id.Base03);
        EditText temp_03 = view.findViewById(R.id.Temp03);
        density_03 = view.findViewById(R.id.Density03);

         litres_04 = view.findViewById(R.id.litre04);
         challan_04 = view.findViewById(R.id.Challan04);
         caught_04 = view.findViewById(R.id.Caugth04);
        EditText base_04 = view.findViewById(R.id.Base04);
        EditText temp_04 = view.findViewById(R.id.Temp04);
        density_04= view.findViewById(R.id.Density04);
        
        
        calculate_table = view.findViewById(R.id.calculate_table);





// click listener for getting the density
        density_01.setOnClickListener(view1 ->
        {
            aars_cal(base_01, temp_01, density_01);

        });

        // density 02 click listener

        density_02.setOnClickListener(view1 -> {

            aars_cal(base_02, temp_02, density_02);

        });

        // density 03 click listener

        density_03.setOnClickListener(view1 -> {

            aars_cal(base_03, temp_03, density_03);

        });

        // density 04 click listener

        density_04.setOnClickListener(view1 -> {

            aars_cal(base_04, temp_04, density_04);

        });


        radioGroup1 = view.findViewById(R.id.radioGroup01);
        radioGroup1.setOnCheckedChangeListener(this);

        radioGroup2 = view.findViewById(R.id.radioGroup02);
        radioGroup2.setOnCheckedChangeListener(this);

        radioGroup3 = view.findViewById(R.id.radioGroup03);
        radioGroup3.setOnCheckedChangeListener(this);

        radioGroup4 = view.findViewById(R.id.radioGroup04);
        radioGroup4.setOnCheckedChangeListener(this);
        // Calculate button set on click listener
        calculate_table.setOnClickListener(view1 -> {

            calculate_aars_table();
        });


        PETROL_underground( view);

        DIESEL_underground(view);





        return view;
    }

    private void DIESEL_underground(View view) {
        TextView diesel_underground_short = view.findViewById(R.id.undergroung_diesel_do);

        EditText diesel_start_dip = view.findViewById(R.id.starting_dip_diesel);
        EditText diesel_close_dip = view.findViewById(R.id.closing_dip_diesel);

        EditText diesel_closing01 = view.findViewById(R.id.closing_diesel_01);
        EditText diesel_closing02 = view.findViewById(R.id.closing_diesel_02);
        EditText diesel_closing03 = view.findViewById(R.id.closing_diesel_03);
        EditText diesel_closing04 = view.findViewById(R.id.closing_diesel_04);

        EditText diesel_starting01 = view.findViewById(R.id.starting_diesel_01);
        EditText diesel_starting02 = view.findViewById(R.id.starting_diesel_02);
        EditText diesel_starting03 = view.findViewById(R.id.starting_diesel_03);
        EditText diesel_starting04 = view.findViewById(R.id.starting_diesel_04);

        TextView diesel_sale01 = view.findViewById(R.id.sale_diesel_01);
        TextView diesel_sale02 = view.findViewById(R.id.sale_diesel_02);
        TextView diesel_sale03 = view.findViewById(R.id.sale_diesel_03);
        TextView diesel_sale04 = view.findViewById(R.id.sale_diesel_04);



        diesel_sale01.setOnClickListener(view1 -> {
            diesel_sale01.setText(Float.toString(getFloatFrom(diesel_closing01)-getFloatFrom(diesel_starting01)));
        });

        diesel_sale02.setOnClickListener(view1 -> {
            diesel_sale02.setText(Float.toString(getFloatFrom(diesel_closing02)-getFloatFrom(diesel_starting02)));
        });

        diesel_sale03.setOnClickListener(view1 -> {
            diesel_sale03.setText(Float.toString(getFloatFrom(diesel_closing03)-getFloatFrom(diesel_starting03)));
        });

        diesel_sale04.setOnClickListener(view1 -> {
            diesel_sale04.setText(Float.toString(getFloatFrom(diesel_closing04)-getFloatFrom(diesel_starting04)));
        });



        diesel_underground_short.setOnClickListener(view1 -> {
            diesel_underground_short.setText(Float.toString((
                    getFloatFrom(diesel_start_dip) +
                            (TYPE_1=="Diesel"?getFloatFrom(litres_01):0F)+
                            (TYPE_2=="Diesel"?getFloatFrom(litres_02):0F) +
                            (TYPE_3=="Diesel"?getFloatFrom(litres_03):0F) +
                            (TYPE_4=="Diesel"?getFloatFrom(litres_04):0F) -
                            getFloatFrom(diesel_close_dip) -
                            (getFloatFrom(diesel_closing01)-getFloatFrom(diesel_starting01))-
                            (getFloatFrom(diesel_closing02)-getFloatFrom(diesel_starting02))-
                            (getFloatFrom(diesel_closing03)-getFloatFrom(diesel_starting03))-
                            (getFloatFrom(diesel_closing04)-getFloatFrom(diesel_starting04))


            )));
        });
    }

    private void PETROL_underground(View view) {
        TextView petrol_underground_short = view.findViewById(R.id.undergroung_petrol_do);

        EditText petrol_start_dip = view.findViewById(R.id.starting_dip_petrol);
        EditText petrol_close_dip = view.findViewById(R.id.closing_dip_petrol);

        EditText petrol_closing01 = view.findViewById(R.id.closing_petrol_01);
        EditText petrol_closing02 = view.findViewById(R.id.closing_petrol_02);
        EditText petrol_closing03 = view.findViewById(R.id.closing_petrol_03);
        EditText petrol_closing04 = view.findViewById(R.id.closing_petrol_04);

        EditText petrol_starting01 = view.findViewById(R.id.starting_petrol_01);
        EditText petrol_starting02 = view.findViewById(R.id.starting_petrol_02);
        EditText petrol_starting03 = view.findViewById(R.id.starting_petrol_03);
        EditText petrol_starting04 = view.findViewById(R.id.starting_petrol_04);

        TextView petrol_sale01 = view.findViewById(R.id.sale_petrol_01);
        TextView petrol_sale02 = view.findViewById(R.id.sale_petrol_02);
        TextView petrol_sale03 = view.findViewById(R.id.sale_petrol_03);
        TextView petrol_sale04 = view.findViewById(R.id.sale_petrol_04);





        petrol_sale01.setOnClickListener(view1 -> {
            petrol_sale01.setText(Float.toString(getFloatFrom(petrol_closing01)-getFloatFrom(petrol_starting01)));
        });

        petrol_sale02.setOnClickListener(view1 -> {
            petrol_sale02.setText(Float.toString(getFloatFrom(petrol_closing02)-getFloatFrom(petrol_starting02)));
        });

        petrol_sale03.setOnClickListener(view1 -> {
            petrol_sale03.setText(Float.toString(getFloatFrom(petrol_closing03)-getFloatFrom(petrol_starting03)));
        });

        petrol_sale04.setOnClickListener(view1 -> {
            petrol_sale04.setText(Float.toString(getFloatFrom(petrol_closing04)-getFloatFrom(petrol_starting04)));
        });


        petrol_underground_short.setOnClickListener(view1 -> {
            petrol_underground_short.setText(Float.toString((
                    getFloatFrom(petrol_start_dip) +
                            (TYPE_1=="Petrol"?getFloatFrom(litres_01):0F)+
                            (TYPE_2=="Petrol"?getFloatFrom(litres_02):0F) +
                            (TYPE_3=="Petrol"?getFloatFrom(litres_03):0F) +
                            (TYPE_4=="Petrol"?getFloatFrom(litres_04):0F) -
                    getFloatFrom(petrol_close_dip) -
                            (getFloatFrom(petrol_closing01)-getFloatFrom(petrol_starting01))-
                            (getFloatFrom(petrol_closing02)-getFloatFrom(petrol_starting02))-
                            (getFloatFrom(petrol_closing03)-getFloatFrom(petrol_starting03))-
                            (getFloatFrom(petrol_closing04)-getFloatFrom(petrol_starting04))


                    )));
        });


    }


    private void calculate_aars_table() {

        PETROL_SHORT = 0F;
        DIESEL_SHORT = 0F;



        Float short_1 = calculate_short(litres_01,challan_01,caught_01);
        Float short_2 = calculate_short(litres_02,challan_02,caught_02);
        Float short_3 = calculate_short(litres_03,challan_03,caught_03);
        Float short_4 = calculate_short(litres_04,challan_04,caught_04);

        if(TYPE_1 == "Petrol"){
            PETROL_SHORT = PETROL_SHORT + short_1;
        }
        else DIESEL_SHORT = DIESEL_SHORT + short_1;

        if(TYPE_2 == "Petrol"){
            PETROL_SHORT = PETROL_SHORT + short_2;
        }
        else DIESEL_SHORT = DIESEL_SHORT + short_2;

        if(TYPE_3 == "Petrol"){
            PETROL_SHORT = PETROL_SHORT + short_3;
        }
        else DIESEL_SHORT = DIESEL_SHORT + short_3;

        if(TYPE_4 == "Petrol"){
            PETROL_SHORT = PETROL_SHORT + short_4;
        }
        else DIESEL_SHORT = DIESEL_SHORT + short_4;


        TextView petrol_short_text = getView().findViewById(R.id.petrol_short_text);
        TextView diesel_short_text = getView().findViewById(R.id.diesel_short_text);

        DecimalFormat dfrmt = new DecimalFormat();
        dfrmt.setMaximumFractionDigits(2);



        petrol_short_text.setText(Float.toString(Float.parseFloat(dfrmt.format(PETROL_SHORT))));
        diesel_short_text.setText(Float.toString(Float.parseFloat(dfrmt.format(DIESEL_SHORT))));


    }
    // _____________________________________________

    private Float calculate_short(EditText litres_01, EditText challan_01, EditText caught_01) {
        String str_litres = litres_01.getText().toString();
        String str_challan = challan_01.getText().toString();
        String str_caught = caught_01.getText().toString();

        if(str_litres.matches("")) str_litres="1";
        if(str_challan.matches("")) str_challan="1";
        if(str_caught.matches("")) str_caught="1";



        float litres_u =0;
        float challan_u = 0;
        float caught_u = 0;

        try{
            litres_u = new Float(str_litres);
            challan_u = new Float(str_challan);
            caught_u = new Float(str_caught);
        }catch (NumberFormatException e){
            str_litres ="1";
            str_challan = "1";
            str_caught = "1";
        }

        try {
            return ((litres_u/challan_u)*(challan_u - caught_u));

        }catch (Exception e){
            return 1F;
        }

    }


    private void aars_cal(EditText base, EditText temp, TextView density) {

        String str_base = base.getText().toString();
        String str_temp = temp.getText().toString();
        float temp_u = 0;  // universal value fetching converting into the float vaue
        float base_u = 0;
        try {
            base_u =  new Float(str_base);
            temp_u = new Float(str_temp);

        } catch (NumberFormatException e) {
            str_base = "0";
            str_temp = "0";
        }
        if((int)base_u >700 && (int)base_u<800){

            Density_Petrol(base_u,temp_u,density);
        }

        if((int)base_u >800 && (int)base_u<900){

            Density_Diesel(base_u,temp_u,density);
        }


    }

    // name has been taken in 01 row and nt been editted for common please find
    private void Density_Diesel(float base01, float temp01, TextView density_00) {
        float density = (840.0F + (base01 - 840.0F)) + ((temp01 -15.0F)*0.7F);
        density_00.setText(Float.toString(density));
    }

    private void Density_Petrol(float base01, float temp01, TextView density_00) {

        float density = (740.0F + (base01 - 740.0F)) + ((temp01 -15.0F)*0.9F);
        DecimalFormat dfrmt = new DecimalFormat();
        dfrmt.setMaximumFractionDigits(1);
        density_00.setText(Float.toString(Float.parseFloat(dfrmt.format(density))));

    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        switch (i)
        {
            case R.id.radioPetrol_01:
                    TYPE_1 = "Petrol";

                break;
            case R.id.radioDiesel_01:
                   TYPE_1 = "Diesel";
                break;
            case R.id.radioPetrol_02:
                TYPE_2 = "Petrol";
                break;
            case R.id.radioDiesel_02:
                TYPE_2 = "Diesel";
                break;
            case R.id.radioPetrol_03:
                    TYPE_3="Petrol";
                break;
            case R.id.radioDiesel_03:
                TYPE_3="Diesel";

                break;
            case R.id.radioPetrol_04:
                TYPE_4 = "Petrol";

                break;
            case R.id.radioDiesel_04:
                TYPE_4 ="Diesel";
                break;

            default:
                TYPE_1 = "";
        }

    }







    float getFloatFrom(EditText txt) {
        try {

            return Float.valueOf(txt.getText().toString());
        } catch (Exception e) {
            return 0.0f;
        }
    }
}