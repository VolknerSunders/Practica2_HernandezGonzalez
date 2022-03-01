package mx.tecnm.tepic.practica2_hernandezgonzalez.ui.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.tecnm.tepic.practica2_hernandezgonzalez.R
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.File
import java.io.FileInputStream

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    /*
    var nombres = arregloNombres()
    var cantidades = arregloCantidades()
    */
    var nombres = arrayOf("Brian","Fernando","Hernandez","Gonzalez")
    var cantidades = arrayOf("1","2","3","4")

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup,false)
        return ViewHolder(v)
    }
    /*
    fun arregloNombres(): Array<String> {
        var arreglo = arrayOfNulls<>()
        val filepath = "nombres.txt"
        var file = File(filepath)
        if(file.exists()){

            val archivo = InputStreamReader(openFileInput("nombres.txt"))
            var list: MutableList<String> = arreglo.toMutableList()

            archivo.forEachLine {
                list.add(it)
            }
            return list.toTypedArray()
        }else{
            val crearArchivo = OutputStreamWriter(openFileOutput("nombres.txt", MODE_PRIVATE))
            crearArchivo.flush()
            crearArchivo.close()
            val archivo = InputStreamReader(openFileInput("nombres.txt"))
            var list: MutableList<String> = arreglo.toMutableList()

            archivo.forEachLine {
                list.add(it)
            }
            return list.toTypedArray()
        }
    }

    fun arregloCantidades(): Array<String> {
        val arreglo: Array<String>
        val filepath = "cantidades.txt"
        var file = File(filepath)
        if(file.exists()){
            var archivo = InputStreamReader(openFileInput("cantidades.txt"))
            var list: MutableList<String> = arreglo.toMutableList()

            archivo.forEachLine {
                list.add(it)
            }
            return list.toTypedArray()
        }else{
            val crearArchivo = OutputStreamWriter(openFileOutput("cantidades.txt", MODE_PRIVATE))
            crearArchivo.flush()
            crearArchivo.close()
            val archivo = InputStreamReader(openFileInput("cantidades.txt"))
            var list: MutableList<String> = arreglo.toMutableList()

            archivo.forEachLine {
                list.add(it)
            }
            return list.toTypedArray()
        }
    }
    */
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.nombre.text = nombres[i]
        viewHolder.cantidad.text = cantidades[i]
        viewHolder.imagen.setImageResource(R.drawable.iconofrutas)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var imagen: ImageView
        var nombre: TextView
        var cantidad: TextView

        init {
            imagen = itemView.findViewById(R.id.imagenProd)
            nombre = itemView.findViewById(R.id.nombreProd)
            cantidad = itemView.findViewById(R.id.cantidadProd)
        }

    }

    override fun getItemCount(): Int {
        return nombres.size
    }
}