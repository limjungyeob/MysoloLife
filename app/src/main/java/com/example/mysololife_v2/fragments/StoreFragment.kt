package com.example.mysololife_v2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.mysololife_v2.R
import com.example.mysololife_v2.databinding.FragmentStoreBinding
import com.example.mysololife_v2.databinding.FragmentTalkBinding

/**
 * A simple [Fragment] subclass.
 * Use the [StoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StoreFragment : Fragment() {
    private lateinit var binding : FragmentStoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_store, container, false)
//
//        binding.homeTap.setOnClickListener {
//            it.findNavController().navigate(R.id.action_storeFragment_to_homeFragment)
//        }
//
//        binding.tipTap.setOnClickListener {
//            it.findNavController().navigate(R.id.action_storeFragment_to_tipFragment)
//        }
//
//        binding.bookmarkTap.setOnClickListener {
//            it.findNavController().navigate(R.id.action_storeFragment_to_bookmarkFragment)
//        }
//
//        binding.talkTap.setOnClickListener {
//            it.findNavController().navigate(R.id.action_storeFragment_to_talkFragment)
//        }
        // Inflate the layout for this fragment
        return binding.root
    }

}