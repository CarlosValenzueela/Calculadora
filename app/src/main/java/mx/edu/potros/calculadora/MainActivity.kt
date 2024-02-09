package mx.edu.potros.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var resultado: TextView = findViewById(R.id.tvResultado)
        var consola: TextView = findViewById(R.id.tvConsola)
        var aviso: TextView = findViewById(R.id.tvAviso)

        val btnNumero9: Button = findViewById(R.id.btnNumero9)
        val btnNumero8: Button = findViewById(R.id.btnNumero8)
        val btnNumero7: Button = findViewById(R.id.btnNumero7)
        val btnNumero6: Button = findViewById(R.id.btnNumero6)
        val btnNumero5: Button = findViewById(R.id.btnNumero5)
        val btnNumero4: Button = findViewById(R.id.btnNumero4)
        val btnNumero3: Button = findViewById(R.id.btnNumero3)
        val btnNumero2: Button = findViewById(R.id.btnNumero2)
        val btnNumero1: Button = findViewById(R.id.btnNumero1)
        val btnNumero0: Button = findViewById(R.id.btnNumero0)

        val btnSuma: Button = findViewById(R.id.btnSuma)
        val btnResta: Button = findViewById(R.id.btnResta)
        val btnMultiplicar: Button = findViewById(R.id.btnMultiplicacion)
        val btnDivision: Button = findViewById(R.id.btnDivision)
        val btnResultado: Button = findViewById(R.id.btnResultado)

        val btnLimpiar: Button = findViewById(R.id.btnLimpiar)

        var auxOperaciones = 0.0
        var auxConsola = ""
        var final = 0.0


        //Botones numericos
        btnNumero9.setOnClickListener {
            auxConsola += 9
            consola.setText(auxConsola)
        }

        btnNumero8.setOnClickListener {
            auxConsola += 8
            consola.setText(auxConsola)
        }

        btnNumero7.setOnClickListener {
            auxConsola += 7
            consola.setText(auxConsola)
        }

        btnNumero6.setOnClickListener {
            auxConsola += 6
            consola.setText(auxConsola)
        }

        btnNumero5.setOnClickListener {
            auxConsola += 5
            consola.setText(auxConsola)
        }

        btnNumero4.setOnClickListener {
            auxConsola += 4
            consola.setText(auxConsola)
        }

        btnNumero3.setOnClickListener {
            auxConsola += 3
            consola.setText(auxConsola)
        }

        btnNumero2.setOnClickListener {
            auxConsola += 2
            consola.setText(auxConsola)
        }

        btnNumero1.setOnClickListener {
            auxConsola += 1
            consola.setText(auxConsola)
        }

        btnNumero0.setOnClickListener {
            auxConsola += 0
            consola.setText(auxConsola)
        }


        fun ajustaValores(){
            try {
                auxOperaciones = auxConsola.toDouble()
                auxConsola = ""
                consola.setText(auxConsola)

            }catch (e: Exception){
            println(e.toString())
            }
        }

        btnSuma.setOnClickListener {
          ajustaValores()
            val str = "$auxOperaciones+"

            resultado.setText(str)

        }

        btnResta.setOnClickListener {
            ajustaValores()

            val str = "$auxOperaciones-"
            resultado.setText(str)
        }

        btnMultiplicar.setOnClickListener {
            ajustaValores()

            val str = "$auxOperaciones*"
            resultado.setText(str)

        }

        btnDivision.setOnClickListener {
            ajustaValores()

            val str = "$auxOperaciones÷"
            resultado.setText(str)
        }

        btnResultado.setOnClickListener {
            try {
                val digitos: Double = auxConsola.toDouble()

                if( (!resultado.text.isNullOrEmpty() || auxConsola.isEmpty())){
                    if(resultado.text.toString().last() =='+'){
                        final = auxOperaciones + digitos
                    }
                    else if(resultado.text.toString().last() =='-'){
                        final = auxOperaciones - digitos
                    }
                    else if(resultado.text.toString().last() =='*'){
                        final = auxOperaciones * digitos
                    }
                    else if(resultado.text.toString().last() =='÷'){
                        if(digitos.toString() == "0.0"){
                            val avisoMsj = "No es posible dividir ÷ 0."
                            aviso.setText(avisoMsj)
                        }else{
                            final = auxOperaciones / digitos

                        }
                    }

                    val finalMsj = final.toString()
                    resultado.setText(finalMsj)
                    auxConsola = ""
                    consola.setText(auxConsola)

                }else{
                    val avisoMsj = "Debes ingresar alguna operación."
                    aviso.setText(avisoMsj)
                }


            }catch (e: Exception){
                val avisoMsj = "Error en operación matemática."
                aviso.setText(avisoMsj)
                println(e.toString())
            }
        }

        btnLimpiar.setOnClickListener {
            resultado.setText("")
            consola.setText("")
            aviso.setText("")
            auxOperaciones = 0.0
            auxConsola = ""
            final = 0.0

        }




    }
}