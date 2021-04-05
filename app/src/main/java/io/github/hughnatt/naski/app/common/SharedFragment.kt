package io.github.hughnatt.naski.app.common

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

abstract class SharedFragment<ViewModelT: SharedViewModel<*>>(
    @LayoutRes contentLayoutId: Int
): Fragment(contentLayoutId) {

    protected abstract val model: ViewModelT

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.navLiveData.observe(viewLifecycleOwner) { navigationOrder ->
            when (navigationOrder) {
                is NavigateTo -> findNavController().navigate(navigationOrder.navDirections)
                is PopBackStack -> {
                    val popped = findNavController().popBackStack()
                    if (!popped) { requireActivity().finish() }
                }
                is StartActivity -> {
                    ContextCompat.startActivity(
                        requireContext(),
                        navigationOrder.intent,
                        null
                    )
                }
            }
        }
    }
}
