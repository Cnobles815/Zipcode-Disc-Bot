import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

import java.io.FileNotFoundException;

public final class Main {



    public static void main(final String[] args) throws FileNotFoundException {


        final String token = "Placeholder+++" ;
        final DiscordClient client = DiscordClient.create(token);
        final GatewayDiscordClient gateway = client.login().block();

        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            final Message message = event.getMessage();
            if ("!ZCW".equals(message.getContent())) {
                final MessageChannel channel = message.getChannel().block();
                channel.createMessage("CODE HARDER!").block();
            }
        });

        gateway.onDisconnect().block();
    }
}
