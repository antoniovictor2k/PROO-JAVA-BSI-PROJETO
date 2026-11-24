WPP.loader.onReady(() => {
    WPP.on('chat.new_message', async (message) => {
        const chat = message.id.remote;
        if (!['c.us', 'lid', 's.whatsapp.net'].includes(chat?.server)
                || message.type !== 'chat' || typeof message.body !== 'string' || !message.body.trim()) {
            return;
        }

        let stage = 'identificar a conversa';
        try {
            // O identificador do contato separa o usuário, o tipo de endereço e o aparelho.
            const ownId = chat.server === 'lid' ? WPP.conn.getMyUserLid() : WPP.conn.getMyUserWid();
            const selfChat = Boolean(ownId?.user && ownId.user === chat.user);
            const replyPrefix = 'SimulaVoz: ';
            if ((message.id.fromMe && !selfChat) || (selfChat && message.body.startsWith(replyPrefix))) {
                return;
            }
            stage = 'gerar a resposta em Java';
            const reply = await window.simulaVozReply(message.body);
            stage = 'enviar a resposta';
            await WPP.chat.sendTextMessage(chat._serialized, selfChat ? replyPrefix + reply : reply);
        } catch (error) {
            console.error(`[SimulaVoz] Falha ao ${stage} (${error.name || 'erro desconhecido'}).`);
        }
    });

    if (WPP.conn.isAuthenticated()) {
        console.info('[SimulaVoz] Bot conectado ao WhatsApp.');
    } else {
        WPP.on('conn.authenticated', () => console.info('[SimulaVoz] Bot conectado ao WhatsApp.'));
    }
});
