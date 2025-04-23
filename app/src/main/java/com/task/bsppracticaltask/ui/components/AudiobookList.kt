package com.task.bsppracticaltask.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.task.bsppracticaltask.R
import com.task.bsppracticaltask.model.Element
import com.task.bsppracticaltask.ui.theme.Gray

@Composable
fun AudiobookList(element: Element?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Gray).
            clip(RoundedCornerShape(12.dp)).padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(element?.header ?: "New Audiobooks",
                style = MaterialTheme.typography.titleMedium.copy(
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium,
                ))
            Text(
                "See all",
                style = MaterialTheme.typography.labelLarge.copy(color = Color(0xFF00897B)),
                modifier = Modifier.clickable {  }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        val audiobooks = listOf(
            Triple("Dragonwatch: Return of the Dragon Slayers", "Brandon Mull", R.drawable.book1),
            Triple("The Divine Gift of Forgiveness", "Neil L. Andersen", R.drawable.book2),
            Triple("Fablehaven", "Brandon Mull", R.drawable.book3)
        )

        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            audiobooks.forEach { (title, author, imageRes) ->
                AudiobookItem(title, author, imageRes)
            }
        }
    }
}

@Composable
fun AudiobookItem(title: String, author: String, imageRes: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(
            model = imageRes,
            contentDescription = title,
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(title, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
            Text(author, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        }
    }
}