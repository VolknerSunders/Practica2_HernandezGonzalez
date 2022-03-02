package mx.tecnm.tepic.practica2_hernandezgonzalez.ui.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.tecnm.tepic.practica2_hernandezgonzalez.R

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    var nombres = GalleryFragment().arregloNombres()
    var cantidades = GalleryFragment().arregloCantidades()


    /*
    var nombres = arrayOf("Brian","Fernando","Hernandez","Gonzalez","asda","adssada","adsasd","asdfasdasd","adsasd","afadsf")
    var cantidades = arrayOf("1","2","3","4","","","","","","")
    */




    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup,false)
        return ViewHolder(v)

    }



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