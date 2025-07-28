package com.adriandeseta.cv.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.adriandeseta.cv.data.local.database.Adriandeseta
import com.adriandeseta.cv.data.local.database.AdriandesetaDao
import javax.inject.Inject

interface AdriandesetaRepository {
    val adriandesetas: Flow<List<String>>

    suspend fun add(name: String)
}

class DefaultAdriandesetaRepository @Inject constructor(
    private val adriandesetaDao: AdriandesetaDao
) : AdriandesetaRepository {

    override val adriandesetas: Flow<List<String>> =
        adriandesetaDao.getAdriandesetas().map { items -> items.map { it.name } }

    override suspend fun add(name: String) {
        adriandesetaDao.insertAdriandeseta(Adriandeseta(name = name))
    }
}
