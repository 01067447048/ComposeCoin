package com.jaehyeon.compose.composecoin.ui.components.coin_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.jaehyeon.compose.domain.model.coin_detail.DomainTeam

@Composable
fun TeamListItem(
    teamMember: DomainTeam,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = teamMember.name,
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = teamMember.position,
            style = MaterialTheme.typography.h6,
            fontStyle = FontStyle.Italic
        )
    }
}