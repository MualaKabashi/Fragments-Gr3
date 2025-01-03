package com.cacttus.fragments_gr3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cacttus.fragments_gr3.R
import com.cacttus.fragments_gr3.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSendData.setOnClickListener {
            var profileDetailsFragment = FragmentProfileDetails()
            var data = binding.editText.text.toString()
            var bundle = Bundle()
            bundle.putString("value", data)
            profileDetailsFragment.arguments = bundle
            setCurrentFragment(profileDetailsFragment)
        }
    }


    fun setCurrentFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, fragment)
        }.commit()
    }

}