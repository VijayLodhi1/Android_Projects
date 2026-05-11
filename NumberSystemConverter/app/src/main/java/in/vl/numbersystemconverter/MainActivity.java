package in.vl.numbersystemconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerFrom;
    Spinner spinnerTo;
    EditText etEnteredNumber;
    Button btnConvert;
    TextView tvConvertedNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinnerFrom = findViewById(R.id.spinner_from);
        spinnerTo = findViewById(R.id.spinner_to);
        etEnteredNumber = findViewById(R.id.et_entered_number);
        btnConvert = findViewById(R.id.btn_convert);
        tvConvertedNumber = findViewById(R.id.tv_converted_number);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getBase(spinnerFrom.getSelectedItem().toString()) == -1 || getBase(spinnerTo.getSelectedItem().toString()) == -1)
                {
                    Toast.makeText(MainActivity.this, "Select valid number system conversion !", Toast.LENGTH_SHORT).show();
                }
                else if(etEnteredNumber.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Enter valid number for conversion !", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(getBase(spinnerTo.getSelectedItem().toString()) == 0)
                    {
                        if(sbToAll(getBase(spinnerFrom.getSelectedItem().toString()) , etEnteredNumber.getText().toString()) == "InvalidInput")
                        {
                            tvConvertedNumber.setText("");
                        }
                        else
                        {
                            tvConvertedNumber.setText(sbToAll(getBase(spinnerFrom.getSelectedItem().toString()) , etEnteredNumber.getText().toString()));
                            Toast.makeText(MainActivity.this, "Number converted successfully....", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        if(decimalToAny(getBase(spinnerFrom.getSelectedItem().toString()) , getBase(spinnerTo.getSelectedItem().toString()) , etEnteredNumber.getText().toString()) == "InvalidInput")
                        {
                            tvConvertedNumber.setText("");
                        }
                        else
                        {
                            tvConvertedNumber.setText(decimalToAny(getBase(spinnerFrom.getSelectedItem().toString()) ,
                                    getBase(spinnerTo.getSelectedItem().toString()) , etEnteredNumber.getText().toString()));
                            Toast.makeText(MainActivity.this, "Number converted successfully....", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

    }

    private int getBase(String strBase)
    {
        switch(strBase)
        {
            case "All":
                return 0;
            case "Binary":
                return 2;
            case "Octal":
                return 8;
            case "Decimal":
                return 10;
            case "Hexadecimal":
                return 16;
            default:
                return -1;
        }
    }

    private String decimalToAny(int sb , int db , String number)
    {
        int decimalNumber = anyToDecimal(sb , number);
        StringBuilder ans = new StringBuilder();

        if(decimalNumber == 0)
        {
            return "0";
        }

        if(decimalNumber == -1)
        {
            return "InvalidInput";
        }

        while(decimalNumber > 0)
        {
            ans.insert(0 , Character.forDigit(decimalNumber%db , db));
            decimalNumber /= db;
        }

        return ans.toString().toUpperCase();
    }

    private int anyToDecimal(int sb , String number)
    {
        int ans = 0;
        int mul = 1;

        for(int i = number.length()-1 ; i >= 0 ; i--)
        {
            char ch = number.charAt(i);
            int digit = Character.digit(ch , sb);
            if(digit == -1)
            {
                Toast.makeText(this, "Invalid digit " + ch + " for base " + sb, Toast.LENGTH_SHORT).show();
                return -1;
            }
            ans += digit*mul;
            mul *= sb;
        }

        return ans;
    }

    private String sbToAll(int sb , String number)
    {
        StringBuilder ans = new StringBuilder();

        if(anyToDecimal(sb , number) == -1)
        {
            return "InvalidInput";
        }

        if(sb != 2)
        {
            ans.append("Binary : " + decimalToAny(sb , 2 , number) + "\n");
        }

        if(sb != 8)
        {
            ans.append("Octal : " + decimalToAny(sb , 8 , number) + "\n");
        }

        if(sb != 10)
        {
            ans.append("Decimal : " + decimalToAny(sb , 10 , number) + "\n");
        }

        if(sb != 16)
        {
            ans.append("Hexadecimal : " + decimalToAny(sb , 16 , number) + "\n");
        }

        return ans.toString();
    }

}