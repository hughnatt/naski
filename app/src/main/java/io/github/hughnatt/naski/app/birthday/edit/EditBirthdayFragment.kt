package io.github.hughnatt.naski.app.birthday.edit

import io.github.hughnatt.core.entity.Birthday
import io.github.hughnatt.naski.R
import io.github.hughnatt.naski.app.common.SharedFragment
import io.github.hughnatt.naski.app.common.datepicker.DatePickerViewModel
import io.github.hughnatt.naski.app.common.viewBinding
import io.github.hughnatt.naski.databinding.FragmentEditBirthdayBinding
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class EditBirthdayFragment: SharedFragment<EditBirthdayViewModel>(
        R.layout.fragment_edit_birthday
) {
    override val model: EditBirthdayViewModel by viewModel()
    private val binding by viewBinding(FragmentEditBirthdayBinding::bind)
    private val datePickerViewModel: DatePickerViewModel by sharedViewModel()

    // MARK - Lifecycle

    override fun onStart() {
        super.onStart()
        prepareView()
        setupModel()
    }

    // MARK - Private

    private fun prepareView() {
        binding.editTextDate.setOnClickListener {
            model.action(ShowDatePicker)
        }
        binding.saveButton.setOnClickListener {
            val date = datePickerViewModel.date.value
            date?.let {
                val birthday = Birthday(
                    name = binding.editTextName.text.toString(),
                    date = date,
                )
                model.action(SaveBirthday(birthday))
            }
        }
    }

    private fun setupModel() {
        datePickerViewModel.date.observe(viewLifecycleOwner) {
            binding.editTextDate.setText(it.toString())
        }
    }
}