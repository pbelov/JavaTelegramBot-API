package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */

@RequiredArgsConstructor
public class SendableStickerMessage implements SendableMessage, ReplyingOptions, NotificationOptions {

	@NonNull
	@Getter
	private final InputFile sticker;
	@Getter
	private final int replyTo;
	@Getter
	private final ReplyMarkup replyMarkup;
    @Getter
    private final boolean disableNotification;

    public SendableStickerMessage(InputFile sticker, Message replyTo, ReplyMarkup replyMarkup, boolean disableNotification) {

        this(sticker, replyTo != null ? replyTo.getMessageId() : 0, replyMarkup, disableNotification);
    }

    public static SendableStickerMessageBuilder builder() {
        return new SendableStickerMessageBuilder();
    }

    @Override
	public MessageType getType() {
		return MessageType.STICKER;
	}

    public static class SendableStickerMessageBuilder {

        private InputFile sticker;
        private int replyTo;
        private ReplyMarkup replyMarkup;
        private boolean disableNotification;

        SendableStickerMessageBuilder() {
        }

        public SendableStickerMessage.SendableStickerMessageBuilder sticker(InputFile sticker) {
            this.sticker = sticker;
            return this;
        }

        public SendableStickerMessage.SendableStickerMessageBuilder replyTo(Message replyTo) {
            this.replyTo = replyTo != null ? replyTo.getMessageId() : 0;
            return this;
        }

        public SendableStickerMessage.SendableStickerMessageBuilder replyTo(int replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        public SendableStickerMessage.SendableStickerMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        public SendableStickerMessage.SendableStickerMessageBuilder disableNotification(boolean disableNotification) {

            this.disableNotification = disableNotification;
            return this;
        }

        public SendableStickerMessage build() {
            return new SendableStickerMessage(sticker, replyTo, replyMarkup, disableNotification);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.message.send.SendableStickerMessage.SendableStickerMessageBuilder(sticker=" + this.sticker + ", replyTo=" + this.replyTo + ", replyMarkup=" + this.replyMarkup + ")";
        }
    }
}