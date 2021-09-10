package com.example.gbandroidlesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private TextView info;
    private EditText editSurname;
    private EditText editNumber;
    private Button addSubscriber;
    private TextView infoAddSubscriber;

    private TextView getTextViewInfo;
    private EditText getSurname;
    private Button getSubscriber;
    private TextView getInfoSubscriber;

    Phonebook phonebook = new Phonebook();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = findViewById(R.id.gr_text_view);
        info.setText("Добавить абонента");

        addSubscriber = findViewById(R.id.button_add_subscriber);
        editSurname = findViewById(R.id.edit_surname);
        editNumber = findViewById(R.id.edit_number);
        infoAddSubscriber = findViewById(R.id.info_add_text_view);
        //
        getTextViewInfo = findViewById(R.id.info_text_view);
        getSurname = findViewById(R.id.edit_get_surname);
        getSubscriber = findViewById(R.id.button_get_subscriber);
        getInfoSubscriber = findViewById(R.id.get_text_view);

        addSubscriber.setOnClickListener(v -> {
            String surname = editSurname.getText().toString();
            String number = editNumber.getText().toString();
            phonebook.add(surname, number);
            infoAddSubscriber.setText(Phonebook.infoAdd);
            editSurname.setText("");
            editNumber.setText("");


        });

        getSubscriber.setOnClickListener(v -> {
            String surname = getSurname.getText().toString();
            phonebook.get(surname);
            getInfoSubscriber.setText(Phonebook.getInfo);
            getSurname.setText("");
        });
    }

}


class Phonebook {
    Map<String, String> phonebook = new HashMap<>();

   static String infoAdd;
   static String getInfo;

    public Phonebook(String infoAdd) {
        this.infoAdd = infoAdd;
    }

    public Phonebook() {

    }

    public  void add(String surname, String number) {

        if (!phonebook.containsKey(number)) {
            phonebook.put(number, surname);
            infoAdd = "Абонент добавлен!!!";
            // System.out.println("добавлено " + number + surname); // использую для отладки

        } else {
            // System.out.println("ошибка"); // использую для отладки
            infoAdd = "Абонент с таким номером существует ";
        }

    }

    public void get(String name) {
        for (Map.Entry<String, String> element : phonebook.entrySet()) {
            String key = element.getKey();
            String value = element.getValue();
            if (value.equals(name)) {
                getInfo = "абонент "+ name +" номер " + key;
            }else {
                getInfo = "абонента " + name +" не существует";
            }

        }

    }

}