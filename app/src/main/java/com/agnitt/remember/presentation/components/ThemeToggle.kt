package com.agnitt.remember.presentation.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.agnitt.remember.R


@Composable
fun ThemeToggle(isDarkTheme: MutableState<Boolean>, modifier:Modifier = Modifier) =
IconToggleButton(modifier = modifier,
checked = isDarkTheme.value,
onCheckedChange = { isDarkTheme.value = it }) {
    if (isDarkTheme.value) Icon(
        painter = painterResource(id = R.drawable.dark_mode),
        contentDescription = stringResource(id = R.string.dark_mode)
    ) else Icon(
        painter = painterResource(id = R.drawable.light_mode),
        contentDescription = stringResource(id = R.string.light_mode)
    )
}