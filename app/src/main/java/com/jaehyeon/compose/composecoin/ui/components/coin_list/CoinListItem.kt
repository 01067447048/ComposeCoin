package com.jaehyeon.compose.composecoin.ui.components.coin_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jaehyeon.compose.composecoin.model.PresentationCoin
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow


@Composable
fun CoinListItem(
    coin: PresentationCoin,
    onClick: (PresentationCoin) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(coin) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = if (coin.isNew) "${coin.rank}. ${coin.symbol} (${coin.symbol}) (new!)" else "${coin.rank}. ${coin.symbol} (${coin.symbol})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = if (coin.isActive) "active" else "inactive",
            color = if(coin.isActive) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(CenterVertically)
        )
    }
}