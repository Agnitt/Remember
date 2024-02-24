@file:OptIn(ExperimentalMaterial3Api::class)

package com.agnitt.remember.presentation.screens

import androidx.activity.compose.BackHandler
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.agnitt.remember.R
import com.agnitt.remember.presentation.components.ActionButton
import com.agnitt.remember.presentation.viewmodels.MainViewModel

@Composable
fun TestScreen(viewModel: MainViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.Start
    ) {

        var isItemsShow by remember { mutableStateOf(true) }
        var addItem by remember { mutableStateOf(false) }
        var isCatsShow by remember { mutableStateOf(true) }
        var addCat by remember { mutableStateOf(false) }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {

            ActionButton(viewModel.isDarkTheme)


            IconButton(onClick = {
                viewModel.clear()
                isItemsShow = false
                isCatsShow = false
            }) {
                Icon(
                    Icons.Default.Delete,
                    "",
                    tint = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
        }


        Column(
            modifier = Modifier.padding(10.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                ToggleButton(
                    state = viewModel.showItemsList,
                    iconOn = R.drawable.visibility_off,
                    iconOff = R.drawable.visibility,
                    modifier = Modifier
                        .weight(1.5f)
                )
                Text(
                    modifier = Modifier.weight(7f),
                    text = "Items",
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    textAlign = TextAlign.Center
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        tint = MaterialTheme.colorScheme.onSecondaryContainer,
                        contentDescription = ""
                    )
                }
            }

            AnimatedVisibility(addItem) {
                InputText("New item") { text -> viewModel.addItem(text) }
            }

            AnimatedVisibility(viewModel.showItemsList.value) {
                ElementsList(
                    viewModel.items.value.associate { item ->
                        item.title to { viewModel.openItemCard(item.title) }
                    }
                )
            }
        }


        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                ToggleButton(
                    state = viewModel.showCatsList,
                    iconOn = R.drawable.visibility_off,
                    iconOff = R.drawable.visibility,
                    modifier = Modifier.weight(1.5f)
                )
                TextButton(
                    modifier = Modifier.weight(7f),
                    onClick = { }) {
                    Text(
                        "Categories",
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
                IconToggleButton(
                    modifier = Modifier.weight(1.5f),
                    checked = addCat,
                    onCheckedChange = { addCat = !addCat }) {
                    Icon(
                        imageVector = if (addCat) Icons.Default.Close else Icons.Default.Add,
                        tint = MaterialTheme.colorScheme.onSecondaryContainer,
                        contentDescription = ""
                    )
                }
            }

            AnimatedVisibility(addCat) {
                InputText("New category") { text -> viewModel.addCategoryName(text) }
            }

            AnimatedVisibility(viewModel.showCatsList.value) {
                ElementsList(
                    viewModel.categories.value.associate { cat ->
                        cat.title to { viewModel.openCatCard(cat.innerID) }
                    }
                )
            }
        }
    }
}


@Composable
fun ElementsList(content: Map<String, () -> Unit>) {
    LazyColumn {
        content.forEach {
            item {
                ElevatedButton(
                    onClick = it.value,
                    modifier = Modifier
                        .padding(30.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = it.key,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }
        }
    }
}

@Composable
fun ToggleButton(
    state: MutableState<Boolean>,
    @DrawableRes iconOn: Int,
    @DrawableRes iconOff: Int,
    modifier: Modifier = Modifier
) {
    IconToggleButton(
        modifier = modifier,
        checked = state.value,
        onCheckedChange = { state.value = !state.value }) {
        Icon(
            painter = if (state.value) {
                painterResource(id = iconOn)
            } else {
                painterResource(id = iconOff)
            },
            tint = MaterialTheme.colorScheme.onSecondaryContainer,
            contentDescription = ""
        )
    }

}


@Composable
fun ToggleButton(
    state: MutableState<Boolean>,
    iconOn: ImageVector,
    iconOff: ImageVector,
    modifier: Modifier = Modifier
) {
    IconToggleButton(
        modifier = modifier,
        checked = state.value,
        onCheckedChange = { state.value = !state.value }) {
        Icon(
            imageVector = if (state.value) iconOn else iconOff,
            tint = MaterialTheme.colorScheme.onSecondaryContainer,
            contentDescription = ""
        )
    }

}

@Composable
fun InputText(label: String, onTextChanged: (String) -> Unit) {
    var text by rememberSaveable { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .focusRequester(focusRequester)
            .padding(5.dp),
        value = text,
        onValueChange = { text = it },
        label = { Text(label) },
        trailingIcon = {
            IconButton(onClick = {
                onTextChanged.invoke(text)
                focusManager.clearFocus()
                text = ""
            }) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
        },
        singleLine = true,
        maxLines = 1
    )

    BackHandler(true) { focusManager.clearFocus() }
}

