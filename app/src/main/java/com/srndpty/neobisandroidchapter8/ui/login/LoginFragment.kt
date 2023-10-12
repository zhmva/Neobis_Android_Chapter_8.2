package com.srndpty.neobisandroidchapter8.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.srndpty.neobisandroidchapter8.R
import com.srndpty.neobisandroidchapter8.databinding.FragmentLoginBinding
import com.srndpty.neobisandroidchapter8.model.Login
import com.srndpty.neobisandroidchapter8.ui.main.MainActivity
import com.srndpty.neobisandroidchapter8.utils.Resource
import com.srndpty.neobisandroidchapter8.viewmodel.AuthViewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    var viewModel = AuthViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.enterButton.setOnClickListener {
            val name = binding.usernameEt.text.toString()
            val password = binding.passwordEt.text.toString()
            if(viewModel.loginField(name, password) == null){
                val loginForm = Login(name, password)
                viewModel.login(loginForm)
            }else{
                Toast.makeText(requireContext(), viewModel.loginField(name, password), Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.login.observe(viewLifecycleOwner, Observer{response ->
            if (response is Resource.Success){
                var intent = Intent(this.activity, MainActivity::class.java)
                startActivity(intent)
                activity?.finish()
            }else if(response is Resource.Error){
                Toast.makeText(requireContext(), response.message, Toast.LENGTH_SHORT).show()
            }
        })

        binding.registerTv.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }
    }
}