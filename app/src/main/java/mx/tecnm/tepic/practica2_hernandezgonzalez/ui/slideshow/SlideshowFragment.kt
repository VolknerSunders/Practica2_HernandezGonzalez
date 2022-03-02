package mx.tecnm.tepic.practica2_hernandezgonzalez.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_slideshow.*
import mx.tecnm.tepic.practica2_hernandezgonzalez.databinding.FragmentSlideshowBinding
import mx.tecnm.tepic.practica2_hernandezgonzalez.ui.gallery.GalleryFragment
import java.io.File
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null


    fun arregloNombres(): List<String> {

        var cadena = ""
        val filepath = "nombres.txt"
        var file = File(filepath)
        if(file.exists()){

            val archivo = InputStreamReader(requireContext().openFileInput("nombres.txt"))

            archivo.forEachLine {
                cadena += archivo.readText()
            }

            var arreglo = cadena.split("\n")

            return arreglo
        }else{
            val crearArchivo = OutputStreamWriter(requireContext().openFileOutput("nombres.txt", AppCompatActivity.MODE_PRIVATE))
            crearArchivo.flush()
            crearArchivo.close()
            val archivo = InputStreamReader(requireContext().openFileInput("nombres.txt"))
            archivo.forEachLine {
                cadena += archivo.readText()
            }

            var arreglo = cadena.split("\n")
            return arreglo
        }
    }

    fun arregloCantidades(): List<String> {

        var cadena = ""
        val filepath = "nombres.txt"
        var file = File(filepath)
        if(file.exists()){

            val archivo = InputStreamReader(requireContext().openFileInput("cantidades.txt"))

            archivo.forEachLine {
                cadena += archivo.readText()
            }
            var arreglo = cadena.split("\n")
            return arreglo
        }else{
            val crearArchivo = OutputStreamWriter(requireContext().openFileOutput("cantidades.txt", AppCompatActivity.MODE_PRIVATE))
            crearArchivo.flush()
            crearArchivo.close()
            val archivo = InputStreamReader(requireContext().openFileInput("cantidades.txt"))
            archivo.forEachLine {
                cadena += archivo.readText()
            }
            var arreglo = cadena.split("\n")
            return arreglo
        }
    }
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nombres = arregloNombres().toMutableList()
        val cantidades = arregloCantidades().toMutableList()
        var cadenaNombres = ""
        var cadenaCantidades = ""
        var i = 0
        var escribir = false
        nuevaFruta.setOnClickListener {
            nombres.forEach{

                if (!(nombres[i].equals("")) && !(cantidades[i].equals(""))){
                    if(escribir == false){
                        nombres[i] = nombreInsertar.toString()
                        cantidades[i] = nombreInsertar.toString()
                        escribir = true
                    }
                }
                i++
                cadenaNombres += nombres + "\n"
                cadenaCantidades += cantidades + "\n"
            }
            try {
                val archivoNombres = OutputStreamWriter(requireContext().openFileOutput("nombres.txt",AppCompatActivity.MODE_PRIVATE))
                val archivoCantidades = OutputStreamWriter(requireContext().openFileOutput("cantidades.txt",AppCompatActivity.MODE_PRIVATE))

                archivoNombres.write(cadenaNombres)
                archivoNombres.flush()
                archivoNombres.close()
                archivoCantidades.write(cadenaNombres)
                archivoCantidades.flush()
                archivoCantidades.close()
            }catch (e:Exception){

            }
        }


}

}
