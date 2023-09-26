package com.example.challenge2_binar.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge2_binar.R
import com.example.challenge2_binar.adapter.MenuAdapterHorizontal
import com.example.challenge2_binar.adapter.NewAdapter
import com.example.challenge2_binar.databinding.FragmentHomeBinding
import com.example.challenge2_binar.produk.Kategori
import com.example.challenge2_binar.produk.Menu


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val menuData = Menu.menu
    private val kategoriData = Kategori.kategori
    private val kategoriMenuAdapter = MenuAdapterHorizontal(kategoriData)

    private var listView = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.rvMenuKategori.setHasFixedSize(true)
        binding.rvMenuKategori.layoutManager =
        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvMenuKategori.adapter = kategoriMenuAdapter

        binding.rvMenu.setHasFixedSize(true)
        grid()

        val buttonViewList = binding.imageList
        buttonViewList.setOnClickListener {
            listView = !listView
            if (listView) {
                linear()
                sourceIcView(buttonViewList)
            } else {
                grid()
                sourceIcView(buttonViewList)
            }

        }
        return binding.root
    }

    private fun sourceIcView(imageView: ImageView) {
        if (listView) {
            imageView.setImageResource(R.drawable.ic_grid)
        } else {
            imageView.setImageResource(R.drawable.ic_linear)
        }
    }

    private fun linear() {
        binding.rvMenu.layoutManager = LinearLayoutManager(requireActivity())
        val navController = findNavController()
        val menuAdapter = NewAdapter(menuData, isGrid = false, listener = { pickItem ->
            val bundle = bundleOf("pickItem" to pickItem)
            navController.navigate(R.id.detailMenuFragment, bundle)
        })
        binding.rvMenu.adapter = menuAdapter
    }


    private fun grid() {
        binding.rvMenu.layoutManager = GridLayoutManager(requireActivity(), 2)
        val navController = findNavController()
        val menuAdapter = NewAdapter(menuData, isGrid = true, listener = { pickItem ->
            val bundle = bundleOf("pickItem" to pickItem)
            navController.navigate(R.id.detailMenuFragment, bundle)
        })
        binding.rvMenu.adapter = menuAdapter
    }


}