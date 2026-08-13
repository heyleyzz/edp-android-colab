package com.example.myapplication

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()


    fun updateName(value: String) = _uiState.update { it.copy(name = value) }
    fun updateEmail(value: String) = _uiState.update { it.copy(email = value) }
    fun updateContact(value: String) = _uiState.update { it.copy(contactNumber = value) }
    fun updateAddress(value: String) = _uiState.update { it.copy(address = value) }
    fun updateUsername(value: String) = _uiState.update { it.copy(username = value) }
    fun updateNewSkillInput(value: String) = _uiState.update { it.copy(newSkill = value) }


    fun addSkill() {
        val skill = _uiState.value.newSkill.trim()
        if (skill.isNotEmpty()) {
            _uiState.update { current ->
                current.copy(
                    skills = current.skills + skill,
                    newSkill = ""
                )
            }
        }
    }

    fun removeSkill(skill: String) {
        _uiState.update { current ->
            current.copy(skills = current.skills - skill)
        }
    }


    fun openPreview() = _uiState.update { it.copy(isPreview = true) }
    fun returnToEdit() = _uiState.update { it.copy(isPreview = false) }
}