package mx.tecnm.tepic.practica2_hernandezgonzalez.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_gallery.*
import mx.tecnm.tepic.practica2_hernandezgonzalez.databinding.FragmentGalleryBinding
import java.io.File
import java.io.InputStreamReader
import java.io.OutputStreamWriter


class GalleryFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>? = null


    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)

        val root: View = binding.root


        /*
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = CustomAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        */

        return root
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        visualizar.setOnClickListener {
            binding.recyclerView.layoutManager = LinearLayoutManager(activity)
            binding.recyclerView.adapter = CustomAdapter()
            layoutManager = LinearLayoutManager(activity)
            adapter = CustomAdapter()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun arregloNombres(): Array<String> {
        var arreglo = Array(20){""}
        val filepath = "nombres.txt"
        var file = File(filepath)
        if(file.exists()){

            val archivo = InputStreamReader(requireContext().openFileInput("nombres.txt"))
            var list: MutableList<String> = arreglo.toMutableList()

            archivo.forEachLine {
                list.add(it)
            }
            return list.toTypedArray()
        }else{
            val crearArchivo = OutputStreamWriter(requireContext().openFileOutput("nombres.txt", AppCompatActivity.MODE_PRIVATE))
            crearArchivo.flush()
            crearArchivo.close()
            val archivo = InputStreamReader(requireContext().openFileInput("nombres.txt"))
            var list: MutableList<String> = arreglo.toMutableList()

            archivo.forEachLine {
                list.add(it)
            }
            return list.toTypedArray()
        }
    }

    fun arregloCantidades(): Array<String> {
        var arreglo = Array(20){""}
        val filepath = "cantidades.txt"
        var file = File(filepath)
        if(file.exists()){
            var archivo = InputStreamReader(requireContext().openFileInput("cantidades.txt"))
            var list: MutableList<String> = arreglo.toMutableList()
            archivo.forEachLine {
                list.add(it)
            }
            return list.toTypedArray()
        }else{
            val crearArchivo = OutputStreamWriter(requireContext().openFileOutput("cantidades.txt",
                AppCompatActivity.MODE_PRIVATE
            ))
            crearArchivo.flush()
            crearArchivo.close()
            val archivo = InputStreamReader(requireContext().openFileInput("cantidades.txt"))
            var list: MutableList<String> = arreglo.toMutableList()
            archivo.forEachLine {
                list.add(it)
            }
            return list.toTypedArray()
        }
    }


}