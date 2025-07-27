/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.adriandeseta.cv.ui.adriandeseta

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import com.adriandeseta.cv.data.AdriandesetaRepository
import com.adriandeseta.cv.ui.adriandeseta.AdriandesetaUiState.Error
import com.adriandeseta.cv.ui.adriandeseta.AdriandesetaUiState.Loading
import com.adriandeseta.cv.ui.adriandeseta.AdriandesetaUiState.Success
import javax.inject.Inject

@HiltViewModel
class AdriandesetaViewModel @Inject constructor(
    private val adriandesetaRepository: AdriandesetaRepository
) : ViewModel() {

    val uiState: StateFlow<AdriandesetaUiState> = adriandesetaRepository
        .adriandesetas.map<List<String>, AdriandesetaUiState>(::Success)
        .catch { emit(Error(it)) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), Loading)

    fun addAdriandeseta(name: String) {
        viewModelScope.launch {
            adriandesetaRepository.add(name)
        }
    }
}

sealed interface AdriandesetaUiState {
    object Loading : AdriandesetaUiState
    data class Error(val throwable: Throwable) : AdriandesetaUiState
    data class Success(val data: List<String>) : AdriandesetaUiState
}
