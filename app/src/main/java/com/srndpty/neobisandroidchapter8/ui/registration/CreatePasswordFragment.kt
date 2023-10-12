package com.srndpty.neobisandroidchapter8.ui.registration

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.srndpty.neobisandroidchapter8.R
import com.srndpty.neobisandroidchapter8.databinding.FragmentCreatePasswordBinding
import com.srndpty.neobisandroidchapter8.model.RegistrationForm
import com.srndpty.neobisandroidchapter8.ui.main.MainActivity
import com.srndpty.neobisandroidchapter8.utils.Resource
import com.srndpty.neobisandroidchapter8.viewmodel.AuthViewModel

class CreatePasswordFragment : Fragment() {

    private lateinit var binding: FragmentCreatePasswordBinding
    val viewModel = AuthViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCreatePasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonNext.setOnClickListener {
            val name = arguments?.getString("password")
            val email = arguments?.getString("confirmation")

            val password1 = binding.password1.text.toString()
            val password2 = binding.password2.text.toString()
            if(viewModel.samePassword(password1, password2) !=  null){
                binding.passwordContainer2.helperText = viewModel.samePassword(password1, password2)
            }else{
                val registrationForm = RegistrationForm(name!!, email!!, password1, password2)
                viewModel.registration(registrationForm)
            }
        }
        binding.buttonBack.setOnClickListener { findNavController().navigateUp() }

        viewModel.registration.observe(viewLifecycleOwner, Observer{ response ->
            if (response is Resource.Success){
                var intent = Intent(this.activity, MainActivity::class.java)
                startActivity(intent)
                activity?.finish()
            }else if (response is Resource.Error){
                Toast.makeText(requireContext(), response.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

}

