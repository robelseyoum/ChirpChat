package com.roba.chat.persentaion.chatDetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.ui.tooling.preview.Preview
import com.roba.core.designsystem.theme.ChirpTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import chirp.feature.chat.persentaion.generated.resources.Res
import chirp.feature.chat.persentaion.generated.resources.check_icon
import chirp.feature.chat.persentaion.generated.resources.failed
import chirp.feature.chat.persentaion.generated.resources.loading_icon
import chirp.feature.chat.persentaion.generated.resources.sending
import com.roba.chat.domain.models.ChatMessageDeliveryStatus
import com.roba.core.designsystem.theme.extended
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import chirp.feature.chat.persentaion.generated.resources.sent
import com.roba.core.designsystem.theme.labelXSmall

@Composable
fun MessageStatus(
    status: ChatMessageDeliveryStatus,
    modifier: Modifier = Modifier
) {
    val (text, icon, color) = when (status) {
        ChatMessageDeliveryStatus.SENDING -> Triple(
            stringResource(Res.string.sending),
            vectorResource(Res.drawable.loading_icon),
            MaterialTheme.colorScheme.extended.textDisabled
        )

        ChatMessageDeliveryStatus.SENT -> Triple(
            stringResource(Res.string.sent),
            vectorResource(Res.drawable.check_icon),
            MaterialTheme.colorScheme.extended.textTertiary
        )

        ChatMessageDeliveryStatus.FAILED -> Triple(
            stringResource(Res.string.failed),
            Icons.Default.Close,
            MaterialTheme.colorScheme.error
        )
    }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = color,
            modifier = Modifier.size(14.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            color = color,
            style = MaterialTheme.typography.labelXSmall
        )
    }
}

@Preview(name = "Message status - Light")
@Composable
private fun MessageStatusLightPreview() {
    MessageStatusPreviewContent(darkTheme = false)
}

@Preview(name = "Message status - Dark")
@Composable
private fun MessageStatusDarkPreview() {
    MessageStatusPreviewContent(darkTheme = true)
}

@Composable
private fun MessageStatusPreviewContent(darkTheme: Boolean) {
    ChirpTheme(darkTheme = darkTheme) {
        Surface(color = MaterialTheme.colorScheme.surface) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                MessageStatus(status = ChatMessageDeliveryStatus.SENDING)
                MessageStatus(status = ChatMessageDeliveryStatus.SENT)
                MessageStatus(status = ChatMessageDeliveryStatus.FAILED)
            }
        }
    }
}