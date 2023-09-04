package com.example.miproyectojavierheredia

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.miproyectojavierheredia.View.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class MainViewModelUnitTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()
    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        viewModel = MainViewModel()
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_TextosIguales() = runBlocking {
        viewModel.compararTextos("Hola", "Hola")
        assert(viewModel.resultado.value?.sonIguales== true)
    }

    @Test
    fun mainViewModel_TextosDiferentes() = runBlocking {
        viewModel.compararTextos("Que tal?", "Como estas?")
        assert(viewModel.resultado.value?.sonIguales == false)
    }
}
