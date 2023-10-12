package com.srndpty.neobisandroidchapter8.ui.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.srndpty.neobisandroidchapter8.R
import com.srndpty.neobisandroidchapter8.databinding.FragmentRegistrationBinding
import com.srndpty.neobisandroidchapter8.viewmodel.AuthViewModel

class RegistrationFragment : Fragment() {

   private  lateinit var binding: FragmentRegistrationBinding
    val viewModel = AuthViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonNext.setOnClickListener {
            val email = binding.email.text.toString()
            val name = binding.username.text.toString()
            if(viewModel.validEmail(email) != null){
                binding.emailContainer.helperText = viewModel.validEmail(email)
            }else if(name.isEmpty()){
                binding.usernameContainer.helperText = "Введите имя пользователя"
            }else{
                val bundle = Bundle()
                bundle.putString("name", name)
                bundle.putString("email", email)
                findNavController().navigate(R.id.action_registrationFragment_to_createPasswordFragment, bundle)
            }
        }
        binding.buttonBack.setOnClickListener { findNavController().navigateUp() }
    }
    }

