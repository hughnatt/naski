package io.github.hughnatt.naski.app.birthday.list

import androidx.recyclerview.widget.LinearLayoutManager
import io.github.hughnatt.naski.R
import io.github.hughnatt.naski.app.common.SharedFragment
import io.github.hughnatt.naski.app.common.viewBinding
import io.github.hughnatt.naski.databinding.FragmentBirthdayListBinding
import org.koin.android.viewmodel.ext.android.viewModel

class BirthdayListFragment: SharedFragment<BirthdayListViewModel>(
    R.layout.fragment_birthday_list
), BirthdayListItemListener {
    override val model: BirthdayListViewModel by viewModel()
    private val binding by viewBinding(FragmentBirthdayListBinding::bind)
    private val adapter = BirthdayListAdapter(emptyList(), this)

    // MARK - Lifecycle

    override fun onStart() {
        super.onStart()
        prepareView()
        setupModel()
    }

    // MARK - Private

    private fun prepareView() {
        setupRecyclerView()
        val createBirthdayAction = binding.createBirthdayButton
        binding.createBirthdayButton.setOnClickListener {
            model.action(RequestCreateBirthday)
        }
    }

    private fun setupRecyclerView() {
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun setupModel() {
        model.birthdays.observe(viewLifecycleOwner) {
            adapter.dataSet = it
            adapter.notifyDataSetChanged()
            binding.recyclerView.requestLayout()
        }
        model.action(FetchBirthdays)
    }
}