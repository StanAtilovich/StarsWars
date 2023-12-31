package ru.stan.starswars.presentation.shipFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.stan.starswars.databinding.FragmentShipBinding
import javax.inject.Inject

@AndroidEntryPoint
class ShipFragment : Fragment() {

    @Inject
    lateinit var VMFactory: ShipViewModelFactory
    private val viewModel: ShipViewModel by viewModels{
        VMFactory
    }

    private var _binding: FragmentShipBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShipBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvAdapter = ShipAdapter(viewModel)
        binding.rvShips.adapter = rvAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.item.collectLatest {
                    rvAdapter.submitData(it)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                rvAdapter.loadStateFlow.collect {
                    binding.appendProgress.isVisible =
                        it.source.append is LoadState.Loading
                    binding.prependProgress.isVisible =
                        it.source.prepend is LoadState.Loading
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = ShipFragment()
    }

}