package com.agnitt.remember.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agnitt.remember.domain.CategoryInteractor
import com.agnitt.remember.domain.CommonInteractor
import com.agnitt.remember.domain.ItemInteractor
import com.agnitt.remember.models.domain.Category
import com.agnitt.remember.models.domain.Item
import com.agnitt.remember.models.presentation.AdditionalWindow
import com.agnitt.remember.models.presentation.Dialog
import com.agnitt.remember.models.presentation.MainScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class MainViewModel @Inject constructor(
    private val itemInteractor: ItemInteractor,
    private val categoryInteractor: CategoryInteractor,
    private val commonInteractor: CommonInteractor
) : ViewModel() {

    private val _state: MutableState<MainScreenState> = mutableStateOf(MainScreenState.Idle)
    private val _dialog: MutableState<Dialog> = mutableStateOf(Dialog.Nothing)
    private val _window: MutableState<AdditionalWindow> = mutableStateOf(AdditionalWindow.Nothing)

    /** Состояние отрисовки экрана */
    val state: State<MainScreenState>
        get() = _state

    /** Диалоги */
    val dialog: State<Dialog>
        get() = _dialog

    /** Дополнительные окна поверх основного */
    val window: State<AdditionalWindow>
        get() = _window

    val isDarkTheme = mutableStateOf(false) // add dynamic
    val items: MutableState<List<Item>> = mutableStateOf(listOf<Item>())
    val categories: MutableState<List<Category>> = mutableStateOf(listOf<Category>())

    val showItemsList = mutableStateOf(false)
    val showCatsList = mutableStateOf(false)

    private val _showItemCard = MutableLiveData<String>()
    private val _showCatCard = MutableLiveData<Long>()
    val showItemCard: LiveData<String>
        get() = _showItemCard
    val showCatCard: LiveData<Long>
        get() = _showCatCard

    fun initialize() {
        viewModelScope.launch {
            updateData()
            _state.value = MainScreenState.Complete(this@MainViewModel)
        }
    }

    fun openItemCard(title: String) = _showItemCard.postValue(title)
    fun openCatCard(catID: Long) = _showCatCard.postValue(catID)

    fun clear() {
        viewModelScope.launch {
            itemInteractor.deleteAll()
            categoryInteractor.deleteAll()
            updateData()
        }
    }

    private suspend fun updateData() {
        items.value = itemInteractor.getAll()
        categories.value = categoryInteractor.getAll()
    }

    fun addItem(
        title: String,
        category: Category? = null,
        currentQuantity: Int = 0,
        perTimeQuantity: Int = 0,
        perDayQuantity: Int = 0,
        dailyFactor: Int = 1
    ) {
        if (title.isNotBlank())
            viewModelScope.launch {
                itemInteractor.add(
                    Item(
                        title = title,
                        currentQuantity = 378,
                        perTimeQuantity = 378,
                        perDayQuantity = 378,
                        dailyFactor = 378,
                        dateFrom = LocalDateTime.MIN,
                        dateTo = LocalDateTime.MAX,
                        archived = false
                    )
                )
                updateData()
            }
    }

    fun addCategoryName(categoryName: String) {
        if (categoryName.isNotBlank())
            viewModelScope.launch {
                categoryInteractor.add(Category(id, categoryName))
                updateData()
            }
    }


    private val id: Long
        get() = Random.nextLong()
}