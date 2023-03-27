package com.changs.theglorycharacters.base

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.changs.theglorycharacters.BR

abstract class BaseFragment<VDB : ViewDataBinding>(
    layoutResId: Int
) : Fragment(layoutResId) {
    private var _binding: VDB? = null

    protected val binding: VDB get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = DataBindingUtil.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}