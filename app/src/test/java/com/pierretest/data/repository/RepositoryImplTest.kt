package com.pierretest.data.repository

import com.pierretest.data.testData
import com.pierretest.mygamestoreapp.data.remote.ApiCall
import com.pierretest.mygamestoreapp.data.repository.Repository
import com.pierretest.mygamestoreapp.data.repository.RepositoryImpl
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class RepositoryImplTest {

    lateinit var repository: Repository

    @Mock
    lateinit var apiCall: ApiCall

    @Before
    fun startUp() {
        MockitoAnnotations.openMocks(this)
        repository = RepositoryImpl(apiCall)
    }


    @Test
    fun whenGivenIdReturnMeal() = runTest {
        val idMeal = 123
        Mockito.`when`(apiCall.getSingleGameById(idMeal)).thenReturn(testData.game1)

        assertNotNull(repository.getSingleGameById(idMeal))
    }

    @Test
    fun whenSearchingAllGames() = runTest {
        Mockito.`when`(apiCall.getAllGames()).thenReturn(testData.allGames)

        assertTrue(repository.getAllGames().isNotEmpty())

        //No Duplicates ID
        val idList = ArrayList<Int>()
        for (item in repository.getAllGames()) {
            item.id?.let { idList.add(it) }
        }

        assertTrue(idList.size==idList.distinct().size)

    }




}