package com.example.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProfileScreen(viewModel: ProfileViewModel = viewModel()) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    if (state.isPreview) {
        ProfilePreviewContent(
            state = state,
            onBackClicked = { viewModel.returnToEdit() }
        )
    } else {
        ProfileFormContent(
            state = state,
            viewModel = viewModel
        )
    }
}

@Composable
private fun ProfileFormContent(
    state: ProfileUiState,
    viewModel: ProfileViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = "Edit User Profile",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        OutlinedTextField(
            value = state.name,
            onValueChange = { viewModel.updateName(it) },
            label = { Text("Full Name") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = state.email,
            onValueChange = { viewModel.updateEmail(it) },
            label = { Text("Email Address") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = state.contactNumber,
            onValueChange = { viewModel.updateContact(it) },
            label = { Text("Contact Number") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = state.address,
            onValueChange = { viewModel.updateAddress(it) },
            label = { Text("Home Address") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = state.username,
            onValueChange = { viewModel.updateUsername(it) },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        Text(
            text = "User Skills",
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = state.newSkill,
                onValueChange = { viewModel.updateNewSkillInput(it) },
                label = { Text("Enter a skill") },
                modifier = Modifier.weight(1f),
                singleLine = true
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = { viewModel.addSkill() },
                enabled = state.newSkill.isNotBlank()
            ) {
                Text("Add")
            }
        }

        state.skills.forEach { skill ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "• $skill",
                        modifier = Modifier.weight(1f),
                        fontSize = 15.sp
                    )
                    TextButton(onClick = { viewModel.removeSkill(skill) }) {
                        Text("Remove", color = MaterialTheme.colorScheme.error)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { viewModel.openPreview() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Preview Profile")
        }
    }
}

@Composable
private fun ProfilePreviewContent(
    state: ProfileUiState,
    onBackClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Profile Summary Preview",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ProfileDetailRow(label = "Full Name", value = state.name)
                ProfileDetailRow(label = "Email", value = state.email)
                ProfileDetailRow(label = "Contact", value = state.contactNumber)
                ProfileDetailRow(label = "Address", value = state.address)
                ProfileDetailRow(label = "Username", value = state.username)
            }
        }

        Text(
            text = "Acquired Skills",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                if (state.skills.isEmpty()) {
                    Text(
                        text = "No skills added yet.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                } else {
                    state.skills.forEach { skill ->
                        Text(
                            text = "• $skill",
                            fontSize = 16.sp,
                            modifier = Modifier.padding(vertical = 2.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = onBackClicked,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back to Editing")
        }
    }
}

@Composable
private fun ProfileDetailRow(label: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "$label: ",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.width(100.dp)
        )
        Text(
            text = value.ifBlank { "N/A" }
        )
    }
}