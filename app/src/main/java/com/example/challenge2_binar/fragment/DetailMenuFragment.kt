package com.example.challenge2_binar.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.challenge2_binar.R
import com.example.challenge2_binar.databinding.FragmentDetailMenuBinding
import com.example.challenge2_binar.produk.MenuList
import com.google.android.material.bottomnavigation.BottomNavigationView


class DetailMenuFragment : Fragment() {
    private var _binding: FragmentDetailMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        _binding =  FragmentDetailMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val dataDetail = arguments?.getParcelable<MenuList>("pickItem")
        binding.tvMenuu.text = dataDetail?.namaMenu.toString()
        binding.tvNamaToko.text = dataDetail?.namaToko.toString()
        binding.tvHarga.text = dataDetail?.hargaMenu.toString()
        binding.tvDescription.text = dataDetail?.description.toString()
        binding.buttonKeranjang.text = ("Tambah ke Keranjang - ${dataDetail?.hargaMenu}")
        dataDetail?.let { binding.imgDetail.setImageResource(it.imgMenu)
        binding.tvAlamat.text = dataDetail.location.toString()
        binding.tvAlamat.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(dataDetail.maps))
            startActivity(intent)
        }
        }

        buttonUpBack()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val bottomNavigationView : BottomNavigationView? = activity?.findViewById(R.id.navBarBottom)
        bottomNavigationView?.visibility = View.GONE
    }

    override fun onDetach() {
        super.onDetach()
        val bottomNavigationView : BottomNavigationView? = activity?.findViewById(R.id.navBarBottom)
        bottomNavigationView?.visibility = View.VISIBLE
    }

    private fun buttonUpBack() {
        binding.icBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null

    }
}