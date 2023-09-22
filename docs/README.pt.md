For English documentation, please see the [English README](README.md).
# Biblioteca Java para Webhooks do Discord

![JitPack](https://img.shields.io/jitpack/version/com.github.eduardomcb/discord-webhook)
![GitHub](https://img.shields.io/github/license/eduardomcb/discord-webhook)

Esta é uma biblioteca Java que simplifica o processo de envio de mensagens para webhooks do Discord. Ela oferece uma maneira fácil de integrar mensagens de canal do Discord em seus projetos Java.

## Sumário

- [Instalação](#instalação)
- [Começando](#começando)
- [Uso](#uso)
- [Contribuições](#contribuições)
- [Licença](#licença)

## Instalação

Para instalar esta biblioteca, siga os passos abaixo:

### Passo 1/2: Adicione isso ao seu arquivo `pom.xml`:

```xml
<dependency>
  <groupId>com.github.eduardomcb</groupId>
  <artifactId>discord-webhook</artifactId>
  <version>1.0.0</version>
</dependency>
```

### Passo 2/2: Execute via linha de comando

Abra o terminal e execute o seguinte comando:

```bash
$ mvn install
```

## Começando

Para começar, crie uma URL de webhook do Discord que você possa usar para enviar mensagens. Você pode fazer isso seguindo estas etapas:

1. Abra o Discord e vá para o servidor ou canal onde deseja enviar mensagens.
2. Clique em "Configurações do Servidor" ou "Configurações do Canal".
3. Na barra lateral esquerda, clique em "Integrações".
4. Clique no botão "Criar Webhook" e siga as instruções para criar sua URL de webhook.

## Uso

Aqui está um exemplo básico de como usar esta biblioteca para enviar uma mensagem para um webhook do Discord:

```java
// Crie uma mensagem simples
Message message = new Message()
        .setContent("Hello, world!");

// Crie um objeto WebhookManager e configure-o
WebhookManager webhookManager = new WebhookManager()
        .setChannelUrl("SUA_URL_DE_WEBHOOK_AQUI")
        .setMessage(message);

// Envie a mensagem e lide com a resposta
webhookManager.setListener(new WebhookClient.Callback() {
@Override
public void onSuccess(String response) {
        System.out.println("Mensagem enviada com sucesso");
}

@Override
public void onFailure(int statusCode, String errorMessage) {
        System.out.println("Código: " + statusCode + " erro: " + errorMessage);
        }
});

webhookManager.exec();
```

Substitua `"SUA_URL_DE_WEBHOOK_AQUI"` pela URL de webhook real que você criou.

## Contribuições

Se você deseja contribuir para o desenvolvimento desta biblioteca, sinta-se à vontade para abrir uma [issue](https://github.com/eduardomcb/discord-webhook/issues) ou enviar um [pull request](https://github.com/eduardomcb/discord-webhook/pulls) no GitHub.

## Licença

Este projeto está licenciado sob a Licença MIT - consulte o arquivo [LICENSE](LICENSE) para obter detalhes.