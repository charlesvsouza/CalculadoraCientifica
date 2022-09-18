package com.charles.calculadoraprogramacaovisual;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bponto, bpi, bigual, bsomar, bsubtrair, bmultiplicar, bdividir, binversa, braiz, bquadrado, bfatorial, bLogaritmoNeperiano, bLogaritmo, btangente, bcoseno, bseno, bb1, bb2, bc, bac;
    TextView calculolabelview, expressaolabel;
    String pi = "3.14159265";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b0 = findViewById(R.id.b0);
        bpi = findViewById(R.id.bpi);
        bponto = findViewById(R.id.bponto);
        bigual = findViewById(R.id.bigual);
        bsomar = findViewById(R.id.bsomar);
        bsubtrair = findViewById(R.id.bsubtrair);
        bmultiplicar = findViewById(R.id.bmultiplicar);
        bdividir = findViewById(R.id.bdividir);
        binversa = findViewById(R.id.binversa);
        braiz = findViewById(R.id.braiz);
        bquadrado = findViewById(R.id.bquadrado);
        bfatorial = findViewById(R.id.bfatorial);
        bLogaritmoNeperiano = findViewById(R.id.bLogaritmoNeperiano);
        bLogaritmo = findViewById(R.id.bLogaritmo);
        btangente = findViewById(R.id.btangente);
        bseno = findViewById(R.id.bseno);
        bcoseno = findViewById(R.id.bcoseno);
        bb1 = findViewById(R.id.bb1);
        bb2 = findViewById(R.id.bb2);
        bc = findViewById(R.id.bc);
        bac = findViewById(R.id.bac);

        calculolabelview = findViewById(R.id.calculolabelview);
        expressaolabel = findViewById(R.id.expressaolabel);

        //onclick listeners
        b1.setOnClickListener(v -> calculolabelview.setText(calculolabelview.getText() + "1"));
        b2.setOnClickListener(v -> calculolabelview.setText(calculolabelview.getText() + "2"));
        b3.setOnClickListener(v -> calculolabelview.setText(calculolabelview.getText() + "3"));
        b4.setOnClickListener(v -> calculolabelview.setText(calculolabelview.getText() + "4"));
        b5.setOnClickListener(v -> calculolabelview.setText(calculolabelview.getText() + "5"));
        b6.setOnClickListener(v -> calculolabelview.setText(calculolabelview.getText() + "6"));
        b7.setOnClickListener(v -> calculolabelview.setText(calculolabelview.getText() + "7"));
        b8.setOnClickListener(v -> calculolabelview.setText(calculolabelview.getText() + "8"));
        b9.setOnClickListener(v -> calculolabelview.setText(calculolabelview.getText() + "9"));
        b0.setOnClickListener(v -> calculolabelview.setText(calculolabelview.getText() + "0"));
        bponto.setOnClickListener(v -> calculolabelview.setText(calculolabelview.getText() + "."));
        bac.setOnClickListener(v -> {
            calculolabelview.setText("");
            expressaolabel.setText("");
        });
        bc.setOnClickListener(v -> {
            String val = calculolabelview.getText().toString();
            val = val.substring(0, val.length() - 1);
            calculolabelview.setText(val);
        });
        bsomar.setOnClickListener(v -> calculolabelview.setText(calculolabelview.getText() + "+"));
        bsubtrair.setOnClickListener(v -> calculolabelview.setText(calculolabelview.getText() + "-"));
        bmultiplicar.setOnClickListener(v -> calculolabelview.setText(calculolabelview.getText() + "×"));
        bdividir.setOnClickListener(v -> calculolabelview.setText(calculolabelview.getText() + "÷"));
        braiz.setOnClickListener(v -> {
            String val = calculolabelview.getText().toString();
            double r = Math.sqrt(Double.parseDouble(val));
            calculolabelview.setText(String.valueOf(r));
        });
        bb1.setOnClickListener(v -> calculolabelview.setText(calculolabelview.getText() + "("));
        bb2.setOnClickListener(v -> calculolabelview.setText(calculolabelview.getText() + ")"));
        bpi.setOnClickListener(v -> {
            expressaolabel.setText(bpi.getText());
            calculolabelview.setText(calculolabelview.getText() + pi);
        });
        bseno.setOnClickListener(v -> calculolabelview.setText(calculolabelview.getText() + "sin"));
        bcoseno.setOnClickListener(v -> calculolabelview.setText(calculolabelview.getText() + "cos"));
        btangente.setOnClickListener(v -> calculolabelview.setText(calculolabelview.getText() + "tan"));
        binversa.setOnClickListener(v -> calculolabelview.setText(calculolabelview.getText() + "^" + "(-1)"));
        bfatorial.setOnClickListener(v -> {
            int val = Integer.parseInt(calculolabelview.getText().toString());
            int fact = factorial(val);
            calculolabelview.setText(String.valueOf(fact));
            expressaolabel.setText(val + "!");
        });
        bquadrado.setOnClickListener(v -> {
            double d = Double.parseDouble(calculolabelview.getText().toString());
            double square = d * d;
            calculolabelview.setText(String.valueOf(square));
            expressaolabel.setText(d + "²");
        });
        bLogaritmoNeperiano.setOnClickListener(v -> calculolabelview.setText(calculolabelview.getText() + "ln"));
        bLogaritmo.setOnClickListener(v -> calculolabelview.setText(calculolabelview.getText() + "log"));
        bigual.setOnClickListener(v -> {
            String val = calculolabelview.getText().toString();
            String replacedstr = val.replace('÷', '/').replace('×', '*');
            double result = eval(replacedstr);
            calculolabelview.setText(String.valueOf(result));
            expressaolabel.setText(val);
        });

    }

    //Funcao fatorial
    int factorial(int n) {
        return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);
    }


    //Funcao eval
    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }


            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    switch (func) {
                        case "sqrt":
                            x = Math.sqrt(x);
                            break;
                        case "sin":
                            x = Math.sin(Math.toRadians(x));
                            break;
                        case "cos":
                            x = Math.cos(Math.toRadians(x));
                            break;
                        case "tan":
                            x = Math.tan(Math.toRadians(x));
                            break;
                        case "log":
                            x = Math.log10(x);
                            break;
                        case "ln":
                            x = Math.log(x);
                            break;
                        default:
                            throw new RuntimeException("Funcao desconhecida: " + func);
                    }
                } else {
                    throw new RuntimeException("Inesperado: " + (char) ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}